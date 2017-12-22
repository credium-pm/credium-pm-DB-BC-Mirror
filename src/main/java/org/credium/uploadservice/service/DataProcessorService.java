package org.credium.uploadservice.service;

import com.google.common.collect.Maps;
import org.credium.uploadservice.model.Action;
import org.credium.uploadservice.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DataProcessorService {

	@Autowired
	private CacheService cacheService;

	@Autowired
	private UploadService uploadService;

	private Map<Long, Loan> pendingCreateTransactions = new HashMap<>();
	private Map<Long, Loan> pendingUpdateTransactions = new HashMap<>();
	private Map<Long, Loan> pendingDeleteTransactions = new HashMap<>();

	public void process(final List<Loan> loanList, final String source) {
		final Map<Long, Loan> cachedData = this.cacheService.getLoansBySource(source);
		final Map<Long, Loan> retrievedData = loanList.stream().collect(Collectors.toMap(Loan::getUserId, Function.identity()));

		final Map<Long, Loan> pending = findAdded(cachedData, findAdded(pendingCreateTransactions, retrievedData));
		this.pendingCreateTransactions.putAll(pending);
		this.uploadService.send(source, pending, Action.CREATE);

		final Map<Long, Loan> updated = findUpdated(cachedData, retrievedData);
		this.pendingUpdateTransactions.forEach(updated::remove);
		this.pendingUpdateTransactions.putAll(updated);
		this.uploadService.send(source, updated, Action.UPDATE);

		Map<Long, Loan> deleted = findDeleted(cachedData, retrievedData);
		this.pendingDeleteTransactions.putAll(deleted);
		this.uploadService.send(source, deleted, Action.DELETE);
	}

	public void resetPendingTransactions(final Map<Long, Loan> completedTransactions, final Action action) {
		switch (action) {
			case CREATE:
				completedTransactions.forEach(this.pendingCreateTransactions::remove);
				break;
			case UPDATE:
				completedTransactions.forEach(this.pendingUpdateTransactions::remove);
				break;
			case DELETE:
				completedTransactions.forEach(this.pendingDeleteTransactions::remove);
				break;
			default:
				throw new IllegalArgumentException("Unknown action: " + action);
		}
	}

	private Map<Long, Loan> findAdded(final Map<Long, Loan> cachedData, final Map<Long, Loan> retrievedData) {
		return Maps.difference(cachedData, retrievedData).entriesOnlyOnRight();
	}

	private Map<Long, Loan> findUpdated(final Map<Long, Loan> cachedData, final Map<Long, Loan> retrievedData) {
		final Map<Long, Loan> updated = new HashMap<>();
		Maps.difference(retrievedData, cachedData).entriesDiffering().forEach((userId, loanDifference) -> updated.put(userId, loanDifference.leftValue()));
		return updated;
	}

	private Map<Long, Loan> findDeleted(final Map<Long, Loan> cachedData, final Map<Long, Loan> retrievedData) {
		return Maps.difference(cachedData, retrievedData).entriesOnlyOnLeft();
	}

}

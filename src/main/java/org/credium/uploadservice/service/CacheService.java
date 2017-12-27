package org.credium.uploadservice.service;

import org.credium.uploadservice.model.Action;
import org.credium.uploadservice.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CacheService {

	private final SheetSuService sheetSuService;

	@Autowired
	@Lazy
	private Logger logger;

	public CacheService(final SheetSuService sheetSuService) {
		this.sheetSuService = sheetSuService;
	}

	private final Map<String, Map<Long, Loan>> bankToLoanMap = new HashMap<>();

	public final Map<Long, Loan> getLoansBySource(final String source) {
		return this.bankToLoanMap.getOrDefault(source, Collections.emptyMap());
	}

	public void updateCache(final String source, final Map<Long, Loan> loans, final Action action) {
		if (Objects.nonNull(source) && Objects.nonNull(loans)) {
			if (action == Action.DELETE) {
				loans.forEach(this.bankToLoanMap.get(source)::remove);
			} else {
				this.bankToLoanMap.merge(source, loans, (map1, map2) -> {
					map1.putAll(map2);
					return map1;
				});
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void loadProjections() {
		this.logger.log(Level.INFO, "Loading projections...");

		final Map<String, Map<Long, Loan>> stringLoanMap = this.sheetSuService.loadProjections();

		stringLoanMap.forEach((partner, loans) -> {
			this.logger.log(Level.INFO, "Projections successfully loaded, partner{0} count={1}", new Object[]{partner, loans.keySet().size()});
		});

		stringLoanMap.forEach((source, loans) -> this.updateCache(source, loans, Action.CREATE));
	}

}

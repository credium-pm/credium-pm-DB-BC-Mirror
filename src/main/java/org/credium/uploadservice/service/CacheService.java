package org.credium.uploadservice.service;

import org.credium.uploadservice.model.Loan;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class CacheService {

	private SheetSuService sheetSuService;

	public CacheService(final SheetSuService sheetSuService) {
		this.sheetSuService = sheetSuService;
	}

	private final Map<String, Map<Long, Loan>> bankToLoanMap = new HashMap<>();

	public final Map<Long, Loan> getLoansBySource(final String source) {
		return this.bankToLoanMap.getOrDefault(source, Collections.emptyMap());
	}

	public void updateWholeCache(final String source, final Map<Long, Loan> loans) {
		if (Objects.nonNull(source) && Objects.nonNull(loans)) {
			this.bankToLoanMap.merge(source, loans, (map1, map2) -> {
				map1.putAll(map2);
				return map1;
			});
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void removeFromCache(final String source, final Map<Long, Loan> loans) {
		loans.forEach(this.bankToLoanMap.get(source)::remove);
	}

	public void loadProjections() {
		final Map<String, Map<Long, Loan>> stringLoanMap = this.sheetSuService.loadProjections();
		stringLoanMap.forEach(this::updateWholeCache);
	}

}

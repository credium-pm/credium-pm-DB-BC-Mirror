package org.credium.uploadservice.service;

import org.credium.uploadservice.model.Action;
import org.credium.uploadservice.model.Loan;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UploadService {

	private final SheetSuService sheetSuService;
	private final CacheService cacheService;
	private final DataProcessorService dataProcessorService;

	public UploadService(final SheetSuService sheetSuService, final CacheService cacheService, final DataProcessorService dataProcessorService) {
		this.sheetSuService = sheetSuService;
		this.cacheService = cacheService;
		this.dataProcessorService = dataProcessorService;
	}

	public void send(final String source, final Map<Long, Loan> loans, final Action action) {
		this.sheetSuService.updateLoans(source, loans, action);
		this.dataProcessorService.resetPendingTransactions(loans, action);
		this.cacheService.updateCache(source, loans, action);
	}

}

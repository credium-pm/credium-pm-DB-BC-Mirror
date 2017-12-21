package org.credium.uploadservice.service;

import org.credium.uploadservice.model.Action;
import org.credium.uploadservice.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
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

	public void upload(final String source, final Map<Long, Loan> loans, final Action action) {
		this.sheetSuService.updateLoans(source, loans, action).thenRun(() -> {
			this.dataProcessorService.resetPendingTransactions(loans, action, source);
			this.cacheService.updateWholeCache(source, loans);
		});
	}
}

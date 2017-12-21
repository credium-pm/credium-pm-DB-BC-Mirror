package org.credium.uploadservice.service;

import org.credium.uploadservice.model.Loan;
import org.credium.uploadservice.util.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PollingService {

	@Value("#{'${sources}'.split(':')}")
	private List<String> sourcesList;

	private final SheetSuService sheetSuService;
	private final DataProcessorService dataProcessorService;

	public PollingService(final SheetSuService sheetSuService, final DataProcessorService dataProcessorService) {
		this.sheetSuService = sheetSuService;
		this.dataProcessorService = dataProcessorService;
	}

	@Scheduled(fixedRate = 100000, initialDelay = 15000)
	public void poll() {
		this.sourcesList.forEach(source -> CompletableFuture.runAsync(()
						-> this.sheetSuService.getData(source).thenAccept(list
						-> this.dataProcessorService.process(JsonUtils.jsonToObject(list, Loan.class), source))));
	}

}

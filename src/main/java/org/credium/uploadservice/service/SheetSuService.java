package org.credium.uploadservice.service;

import org.credium.uploadservice.event.DbEvent;
import org.credium.uploadservice.model.Action;
import org.credium.uploadservice.model.Loan;
import org.credium.uploadservice.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SheetSuService {

	private static final String EVENT_STORE_URL = "https://sheetsu.com/apis/v1.0bu/a0731848532e/sheets/CentralDBLog";
	private static final String PARTNER_SERVICE_URL = "https://sheetsu.com/apis/v1.0bu/a0731848532e/sheets/Partner";
	private static final String AGGREGATE_CREATE_URL = "https://sheetsu.com/apis/v1.0bu/a0731848532e/sheets/CentralDB";
	private static final String AGGREGATE_UPDATE_URL = "https://sheetsu.com/apis/v1.0bu/a0731848532e/sheets/CentralDB/userId/";

	@Autowired
	private EthereumService ethereumService;

	@Lazy
	@Autowired
	private RestTemplate restTemplate;

	public CompletableFuture<String> getData(final String source) {
		return CompletableFuture.supplyAsync(() -> {
			final ResponseEntity<String> forEntity = this.restTemplate.getForEntity(PARTNER_SERVICE_URL + source, String.class);
			return forEntity.getBody();
		});
	}

	public CompletableFuture<Void> updateLoans(final String source, final Map<Long, Loan> loans, final Action action) {
		return CompletableFuture.runAsync(() -> loans.values().forEach(loan ->
						this.ethereumService.storeDataAPI(loan.toString())
										.ifPresent(txReceipt -> storeEvent(txReceipt.getTransactionHash(), loan, action, source))));
	}

	private void storeEvent(final String transactionHash, final Loan loan, final Action action, final String source) {
		loan.setPartnerId(source);
		post(DbEvent.createDbEvent(transactionHash, action, loan, source), EVENT_STORE_URL, DbEvent.class)
						.thenAccept(rb -> updateAggregate(loan, transactionHash, action));
	}

	private void updateAggregate(final Loan loan, final String transactionHash, final Action action) {
		loan.setLatestTx(transactionHash);
		if (action == Action.CREATE) {
			post(loan, AGGREGATE_CREATE_URL, Loan.class);
		} else if (action == Action.UPDATE) {
			put(loan);
		} else if (action == Action.DELETE) {
			delete(loan.getUserId());
		} else {
			throw new IllegalArgumentException();
		}
	}

	private <T> CompletableFuture<ResponseEntity> post(final Object loan, final String url, final Class<T> clazz) {
		return CompletableFuture.supplyAsync(
						() -> this.restTemplate.postForEntity(url, loan, clazz));
	}

	private CompletableFuture<Void> put(final Loan updatedLoan) {
		return CompletableFuture.runAsync(() -> this.restTemplate.put(AGGREGATE_UPDATE_URL + updatedLoan.getUserId(), updatedLoan));
	}

	private CompletableFuture<Void> delete(final Long userId) {
		return CompletableFuture.runAsync(() -> this.restTemplate.delete(AGGREGATE_UPDATE_URL + userId));
	}

	public Map<String, Map<Long, Loan>> loadProjections() {
		return JsonUtils
						.jsonToObject(this.restTemplate.getForObject(AGGREGATE_CREATE_URL, String.class), Loan.class).stream()
						.collect(Collectors.groupingBy(Loan::getPartnerId, Collectors.toMap(Loan::getUserId, Function.identity())));
	}

}

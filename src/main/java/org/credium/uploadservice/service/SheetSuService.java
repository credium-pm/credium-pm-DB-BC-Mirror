package org.credium.uploadservice.service;

import org.credium.uploadservice.event.DbEvent;
import org.credium.uploadservice.model.Action;
import org.credium.uploadservice.model.Loan;
import org.credium.uploadservice.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class SheetSuService {

	@Value("${event.store.url}")
	private String eventStoreUrl;

	@Value("${partner.service.url}")
	private String partnerServiceUrl;

	@Value("${create.aggregate.url}")
	private String createAggregateUrl;

	@Value("${update.aggregate.url}")
	private String updateAggregateUrl;

	@Autowired
	@Lazy
	private RestTemplate restTemplate;

	private final EthereumService ethereumService;

	@Autowired
	@Lazy
	private Logger logger;

	public SheetSuService(final EthereumService ethereumService) {
		this.ethereumService = ethereumService;
	}

	public CompletableFuture<String> getData(final String source) {
		return CompletableFuture.supplyAsync(() -> {
			this.logger.log(Level.INFO, "Sent GET request to the partner {0}", source);
			final ResponseEntity<String> forEntity = this.restTemplate.getForEntity(this.partnerServiceUrl + source, String.class);
			this.logger.log(Level.INFO, "Request result: {0}", forEntity.getStatusCode());
			return forEntity.getBody();
		});
	}

	// TODO Should be an asynchronous request, but web3j cannot handle multiple requests
	public void updateLoans(final String source, final Map<Long, Loan> loans, final Action action) {
		loans.values().forEach(loan ->
						this.ethereumService.sendTransaction(loan.toString(), source, action, BigInteger.valueOf(loan.getUserId()))
										.ifPresent(txReceipt -> {
											this.logger.log(Level.INFO, "Transaction confirmed: txReceipt={0}, action={1}, source={2}",
															new Object[]{txReceipt, action, source});
											storeEvent(txReceipt.getTransactionHash(), loan, action, source);
										}));
	}

	private void storeEvent(final String transactionHash, final Loan loan, final Action action, final String source) {
		loan.setPartnerId(source);
		this.logger.log(Level.INFO, "Preparing a store event, txHash={0}, loanId={1}, action={2}, source={3}",
						new Object[]{transactionHash, loan, action, source});
		post(DbEvent.createDbEvent(transactionHash, action, loan, source), this.eventStoreUrl, DbEvent.class)
						.exceptionally(error -> {
							this.logger.log(Level.INFO, "Unable to save the event, error={0}, userId={1}, action={2}, source={3}",
											new Object[]{error.getMessage(), loan.getUserId(), action, source});
							return null;
						})
						.thenAccept(rb -> updateAggregate(loan, transactionHash, action));
	}

	private void updateAggregate(final Loan loan, final String transactionHash, final Action action) {
		loan.setLatestTx(transactionHash);
		if (action == Action.CREATE) {
			post(loan, this.createAggregateUrl, Loan.class)
							.whenComplete((responseEntity, throwable) -> this.log(throwable, action, transactionHash, loan.getUserId()));
		} else if (action == Action.UPDATE) {
			put(loan)
							.whenComplete((responseEntity, throwable) -> this.log(throwable, action, transactionHash, loan.getUserId()));
		} else if (action == Action.DELETE) {
			delete(loan.getUserId())
							.whenComplete((responseEntity, throwable) -> this.log(throwable, action, transactionHash, loan.getUserId()));
		} else {
			throw new IllegalArgumentException();
		}
	}

	private <T> CompletableFuture<ResponseEntity> post(final Object loan, final String url, final Class<T> clazz) {
		return CompletableFuture.supplyAsync(
						() -> this.restTemplate.postForEntity(url, loan, clazz));
	}

	private CompletableFuture<Void> put(final Loan updatedLoan) {
		return CompletableFuture.runAsync(() -> this.restTemplate.put(this.updateAggregateUrl + updatedLoan.getUserId(), updatedLoan));
	}

	private CompletableFuture<Void> delete(final Long userId) {
		return CompletableFuture.runAsync(() -> this.restTemplate.delete(this.updateAggregateUrl + userId));
	}

	public Map<String, Map<Long, Loan>> loadProjections() {
		return JsonUtils
						.jsonToObject(this.restTemplate.getForObject(this.createAggregateUrl, String.class), Loan.class).stream()
						.collect(Collectors.groupingBy(Loan::getPartnerId, Collectors.toMap(Loan::getUserId, Function.identity())));
	}

	private void log(final Throwable exception, final Action action, final String txHash, final Long userId) {
		if (Objects.nonNull(exception)) {
			this.logger.log(Level.SEVERE, "Unable to {0} the aggregate, txHash={1}, userId={2}, error={3}",
							new Object[]{action, txHash, userId, exception.getMessage()});
		} else {
			this.logger.log(Level.INFO, "Request successfully sent, txHash={0}, userId={1}", new Object[]{txHash, userId});
		}
	}

}

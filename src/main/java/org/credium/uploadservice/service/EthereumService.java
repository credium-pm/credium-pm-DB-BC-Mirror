package org.credium.uploadservice.service;

import org.credium.uploadservice.contract.LoanContract;
import org.credium.uploadservice.model.Action;
import org.credium.uploadservice.util.PropertiesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

import java.math.BigInteger;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@DependsOn("propertiesBean")
public class EthereumService {

	private LoanContract contract;

	private final PropertiesBean propertiesBean;

	@Autowired
	@Lazy
	private Logger logger;

	public EthereumService(final PropertiesBean propertiesBean) {
		this.propertiesBean = propertiesBean;
		final Web3j web3j = Web3j.build(new HttpService(this.propertiesBean.getTestnetUrl()));
		final Credentials credentials = Credentials.create(this.propertiesBean.getEthPrivateKey());
		this.contract = LoanContract.load(this.propertiesBean.getEthContractAddress(), web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT);
	}

	public Optional<TransactionReceipt> sendTransaction(final String data, final String source, final Action action, final BigInteger userId) {
		this.logger.log(Level.INFO, "Sending the transaction, source={0}, action={1}, userId={2}", new Object[]{source, action.name(), userId.toString()});
		try {
			if (action == Action.DELETE) {
				return Optional.of(this.contract.deleteLoan(source, userId, data).send());
			} else if (action == Action.CREATE || action == Action.UPDATE) {
				return Optional.of(this.contract.saveLoan(data, source, userId).send());
			} else {
				this.logger.log(Level.WARNING, "Unknown action, action={0}", action);
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			this.logger.log(Level.SEVERE, "Unable to send transaction. Error msg: {0}", e.getMessage());
			return Optional.empty();
		}
	}

}
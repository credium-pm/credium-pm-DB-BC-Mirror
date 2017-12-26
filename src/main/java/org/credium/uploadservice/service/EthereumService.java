package org.credium.uploadservice.service;

import org.credium.uploadservice.contract.LoanContract;
import org.credium.uploadservice.model.Action;
import org.credium.uploadservice.util.PropertiesBean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

@Component
@DependsOn("propertiesBean")
public class EthereumService {

	private LoanContract contract;

	private final PropertiesBean propertiesBean;

	public EthereumService(final PropertiesBean propertiesBean) {
		this.propertiesBean = propertiesBean;
		final Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/" + this.propertiesBean.getInfuraToken()));
		final Credentials credentials = Credentials.create(this.propertiesBean.getEthPrivateKey());
		this.contract = LoanContract.load(this.propertiesBean.getEthContractAddress(), web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT);
	}

	public Optional<TransactionReceipt> sendTransaction(final String data, final String source, final Action action, final BigInteger userId) {
		try {
			if (action == Action.DELETE) {
				return Optional.of(this.contract.deleteLoan(source, userId, data).send());
			} else if (action == Action.CREATE || action == Action.UPDATE) {
				return Optional.of(this.contract.saveLoan(data, source, userId).send());
			} else {
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			return Optional.empty();
		}
	}

}
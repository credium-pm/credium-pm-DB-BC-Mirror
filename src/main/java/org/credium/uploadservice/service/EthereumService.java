package org.credium.uploadservice.service;

import org.credium.uploadservice.contract.TestContract;
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

	private TestContract contract;

	private final PropertiesBean propertiesBean;

	public EthereumService(final PropertiesBean propertiesBean) {
		this.propertiesBean = propertiesBean;
		final Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/" + this.propertiesBean.getInfuraToken()));
		final Credentials credentials = Credentials.create(this.propertiesBean.getEthPrivateKey());
		this.contract = TestContract.load(this.propertiesBean.getEthContractAddress(), web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT);
	}

	public Optional<TransactionReceipt> storeDataAPI(final String data) {
		try {
			return Optional.of(this.contract.storeAPIData(data, BigInteger.valueOf(new Date().getTime())).send());
		} catch (Exception e) {
			return Optional.empty();
		}
	}

}
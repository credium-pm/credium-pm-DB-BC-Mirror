package org.credium.uploadservice.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesBean {

	@Value("${eth.testnet.url}")
	private String testnetUrl;

	@Value("${eth.private.key}")
	private String ethPrivateKey;

	@Value("${eth.contract.address}")
	private String ethContractAddress;

	public String getTestnetUrl() {
		return testnetUrl;
	}

	public String getEthPrivateKey() {
		return ethPrivateKey;
	}

	public String getEthContractAddress() {
		return ethContractAddress;
	}
}

package org.credium.uploadservice.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesBean {

	@Value("${infura.token}")
	private String infuraToken;

	@Value("${eth.private.key}")
	private String ethPrivateKey;

	@Value("${eth.contract.address}")
	private String ethContractAddress;

	public String getInfuraToken() {
		return infuraToken;
	}

	public String getEthPrivateKey() {
		return ethPrivateKey;
	}

	public String getEthContractAddress() {
		return ethContractAddress;
	}
}

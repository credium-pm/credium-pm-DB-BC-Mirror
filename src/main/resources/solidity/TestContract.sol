pragma solidity ^0.4.2;

contract TestContract {
	mapping (address => mapping(uint256 => string)) dummyStorage;

	struct Data {
		string key;
		string value;
	}

	event TestContractEvent(address indexed _from, string _data);

	function storeHardCodedData(string data, uint256 timestamp) {
		dummyStorage[msg.sender][timestamp] = data;
		TestContractEvent(msg.sender, data);
	}

	function storeAPIData(string data, uint256 timestamp) {
		dummyStorage[msg.sender][timestamp] = data;
	}

}
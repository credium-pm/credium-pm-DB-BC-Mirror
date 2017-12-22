pragma solidity ^0.4.2;

contract LoanContract {

	mapping (string => mapping(uint256 => string)) currentLoans;

	mapping (string => mapping(uint256 => string)) deletedLoans;

	event LoanSaveEvent(address indexed _from, string _source, uint256 _userId);
	event LoanDeleteEvent(address indexed _from, string _source, uint256 _userId);

	function saveLoan(string _data, string _source, uint256 _timestamp) {
		currentLoans[_source][_timestamp] = _data;
        LoanSaveEvent(msg.sender, _source, _timestamp);
	}

    function deleteLoan(string _source, uint256 _userId, string _data) {
        deletedLoans[_source][_userId] = _data;
        LoanDeleteEvent(msg.sender, _source, _userId);
    }

    function getLoan(uint256 _timestamp, string _source) constant returns (string) {
        return currentLoans[_source][_timestamp];
    }

}
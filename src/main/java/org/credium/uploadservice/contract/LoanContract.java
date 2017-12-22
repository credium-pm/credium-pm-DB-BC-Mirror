package org.credium.uploadservice.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.1.1.
 */
public final class LoanContract extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b61069e8061001e6000396000f3006060604052600436106100565763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631c9f85b3811461005b5780639a81ba1114610128578063c0d5952b146101bf575b600080fd5b341561006657600080fd5b6100b1600480359060446024803590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061025b95505050505050565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156100ed5780820151838201526020016100d5565b50505050905090810190601f16801561011a5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561013357600080fd5b6101bd60046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528181529291906020840183838082843750949650509335935061037a92505050565b005b34156101ca57600080fd5b6101bd60046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001909190803590602001908201803590602001908080601f0160208091040260200160405190810160405281815292919060208401838380828437509496506104c095505050505050565b6102636105c5565b6000826040518082805190602001908083835b602083106102955780518252601f199092019160209182019101610276565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060008481526020019081526020016000208054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561036d5780601f106103425761010080835404028352916020019161036d565b820191906000526020600020905b81548152906001019060200180831161035057829003601f168201915b5050505050905092915050565b826000836040518082805190602001908083835b602083106103ad5780518252601f19909201916020918201910161038e565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060008381526020019081526020016000209080516104029291602001906105d7565b503373ffffffffffffffffffffffffffffffffffffffff167fbc859a60efd8889a614375d73a1875ff1e7c70262b4d39cb3079ed0cf5d8191d83836040518080602001838152602001828103825284818151815260200191508051906020019080838360005b83811015610480578082015183820152602001610468565b50505050905090810190601f1680156104ad5780820380516001836020036101000a031916815260200191505b50935050505060405180910390a2505050565b806001846040518082805190602001908083835b602083106104f35780518252601f1990920191602091820191016104d4565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060008481526020019081526020016000209080516105489291602001906105d7565b503373ffffffffffffffffffffffffffffffffffffffff167f4f1ba37cbe2d5e7cb8bf45e7678b63de43634db4410be1c99a075c7431320c13848460405180806020018381526020018281038252848181518152602001915080519060200190808383600083811015610480578082015183820152602001610468565b60206040519081016040526000815290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061061857805160ff1916838001178555610645565b82800160010185558215610645579182015b8281111561064557825182559160200191906001019061062a565b50610651929150610655565b5090565b61066f91905b80821115610651576000815560010161065b565b905600a165627a7a723058204ce2dace622bda71a4e862c8494d57a0d77691ccd0d37630cde30992ea5fa35e0029";

    private LoanContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private LoanContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<LoanSaveEventEventResponse> getLoanSaveEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LoanSaveEvent", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LoanSaveEventEventResponse> responses = new ArrayList<LoanSaveEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LoanSaveEventEventResponse typedResponse = new LoanSaveEventEventResponse();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._source = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._userId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LoanSaveEventEventResponse> loanSaveEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LoanSaveEvent", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LoanSaveEventEventResponse>() {
            @Override
            public LoanSaveEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LoanSaveEventEventResponse typedResponse = new LoanSaveEventEventResponse();
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._source = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._userId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<LoanDeleteEventEventResponse> getLoanDeleteEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LoanDeleteEvent", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LoanDeleteEventEventResponse> responses = new ArrayList<LoanDeleteEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LoanDeleteEventEventResponse typedResponse = new LoanDeleteEventEventResponse();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._source = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._userId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LoanDeleteEventEventResponse> loanDeleteEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LoanDeleteEvent", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LoanDeleteEventEventResponse>() {
            @Override
            public LoanDeleteEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LoanDeleteEventEventResponse typedResponse = new LoanDeleteEventEventResponse();
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._source = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._userId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<String> getLoan(BigInteger _timestamp, String _source) {
        Function function = new Function("getLoan", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_timestamp), 
                new org.web3j.abi.datatypes.Utf8String(_source)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> saveLoan(String _data, String _source, BigInteger _timestamp) {
        Function function = new Function(
                "saveLoan", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_data), 
                new org.web3j.abi.datatypes.Utf8String(_source), 
                new org.web3j.abi.datatypes.generated.Uint256(_timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> deleteLoan(String _source, BigInteger _userId, String _data) {
        Function function = new Function(
                "deleteLoan", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_source), 
                new org.web3j.abi.datatypes.generated.Uint256(_userId), 
                new org.web3j.abi.datatypes.Utf8String(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<LoanContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LoanContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<LoanContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LoanContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static LoanContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LoanContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static LoanContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LoanContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class LoanSaveEventEventResponse {
        public String _from;

        public String _source;

        public BigInteger _userId;
    }

    public static class LoanDeleteEventEventResponse {
        public String _from;

        public String _source;

        public BigInteger _userId;
    }
}
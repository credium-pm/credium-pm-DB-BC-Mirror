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
    private static final String BINARY = "6060604052341561000f57600080fd5b6104958061001e6000396000f30060606040526004361061004b5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416639a81ba118114610050578063c0d5952b146100e7575b600080fd5b341561005b57600080fd5b6100e560046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528181529291906020840183838082843750949650509335935061018392505050565b005b34156100f257600080fd5b6100e560046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001909190803590602001908201803590602001908080601f0160208091040260200160405190810160405281815292919060208401838380828437509496506102c995505050505050565b826000836040518082805190602001908083835b602083106101b65780518252601f199092019160209182019101610197565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600083815260200190815260200160002090805161020b9291602001906103ce565b503373ffffffffffffffffffffffffffffffffffffffff167fbc859a60efd8889a614375d73a1875ff1e7c70262b4d39cb3079ed0cf5d8191d83836040518080602001838152602001828103825284818151815260200191508051906020019080838360005b83811015610289578082015183820152602001610271565b50505050905090810190601f1680156102b65780820380516001836020036101000a031916815260200191505b50935050505060405180910390a2505050565b806001846040518082805190602001908083835b602083106102fc5780518252601f1990920191602091820191016102dd565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060008481526020019081526020016000209080516103519291602001906103ce565b503373ffffffffffffffffffffffffffffffffffffffff167f4f1ba37cbe2d5e7cb8bf45e7678b63de43634db4410be1c99a075c7431320c13848460405180806020018381526020018281038252848181518152602001915080519060200190808383600083811015610289578082015183820152602001610271565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061040f57805160ff191683800117855561043c565b8280016001018555821561043c579182015b8281111561043c578251825591602001919060010190610421565b5061044892915061044c565b5090565b61046691905b808211156104485760008155600101610452565b905600a165627a7a723058203cd0c764b073363054dce8c77a318c666128a58cf7e0925add2c081b8c6115da0029";

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

    public RemoteCall<TransactionReceipt> saveLoan(String _data, String _source, BigInteger _userId) {
        Function function = new Function(
                "saveLoan", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_data), 
                new org.web3j.abi.datatypes.Utf8String(_source), 
                new org.web3j.abi.datatypes.generated.Uint256(_userId)), 
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

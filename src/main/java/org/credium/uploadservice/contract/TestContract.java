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
public final class TestContract extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6102f68061001e6000396000f30060606040526004361061004b5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663117fe693811461005057806333cc15b3146100a5575b600080fd5b341561005b57600080fd5b6100a360046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965050933593506100f892505050565b005b34156100b057600080fd5b6100a360046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965050933593506101eb92505050565b73ffffffffffffffffffffffffffffffffffffffff3316600090815260208181526040808320848452909152902082805161013792916020019061022f565b503373ffffffffffffffffffffffffffffffffffffffff167f429468cba2cb3a3a2c970f677044e0f8f1dc23ef9d46e232f767eff1df5e62608360405160208082528190810183818151815260200191508051906020019080838360005b838110156101ad578082015183820152602001610195565b50505050905090810190601f1680156101da5780820380516001836020036101000a031916815260200191505b509250505060405180910390a25050565b73ffffffffffffffffffffffffffffffffffffffff3316600090815260208181526040808320848452909152902082805161022a92916020019061022f565b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061027057805160ff191683800117855561029d565b8280016001018555821561029d579182015b8281111561029d578251825591602001919060010190610282565b506102a99291506102ad565b5090565b6102c791905b808211156102a957600081556001016102b3565b905600a165627a7a72305820189b99f7c505a2c964f16a4b7571d242139734c5ac242d4f4b6ef68c2462004f0029";

    private TestContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private TestContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<TestContractEventEventResponse> getTestContractEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("TestContractEvent", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<TestContractEventEventResponse> responses = new ArrayList<TestContractEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            TestContractEventEventResponse typedResponse = new TestContractEventEventResponse();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._data = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TestContractEventEventResponse> testContractEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("TestContractEvent", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TestContractEventEventResponse>() {
            @Override
            public TestContractEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                TestContractEventEventResponse typedResponse = new TestContractEventEventResponse();
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._data = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> storeHardCodedData(String data, BigInteger timestamp) {
        Function function = new Function(
                "storeHardCodedData", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(data), 
                new org.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> storeAPIData(String data, BigInteger timestamp) {
        Function function = new Function(
                "storeAPIData", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(data), 
                new org.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<TestContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TestContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<TestContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TestContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static TestContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static TestContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class TestContractEventEventResponse {
        public String _from;

        public String _data;
    }
}

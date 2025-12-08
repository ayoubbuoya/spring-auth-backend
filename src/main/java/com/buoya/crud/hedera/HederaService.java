package com.buoya.crud.hedera;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hedera.hashgraph.sdk.AccountId;
import com.hedera.hashgraph.sdk.Client;
import com.hedera.hashgraph.sdk.PrivateKey;

@Service
public class HederaService {
    private final Client operatorClient;

    public HederaService(
            @Value("${hedera.operator.account-id}") String operatorId,
            @Value("${hedera.operator.private-key}") String operatorKey) {

        AccountId operatorAccountId = AccountId.fromString(operatorId);
        PrivateKey operatorPrivateKey = PrivateKey.fromStringECDSA(operatorKey);

        // Setup Hedera client (Testnet or Mainnet)
        operatorClient = Client.forTestnet();
        operatorClient.setOperator(operatorAccountId, operatorPrivateKey);
    }

  

}
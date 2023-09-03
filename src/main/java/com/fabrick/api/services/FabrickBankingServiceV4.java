package com.fabrick.api.services;

import com.fabrick.api.dto.requests.DtoMoneyTransferFabrickRequest;
import com.fabrick.api.dto.responses.DtoAccountBalanceFabrickResponse;
import com.fabrick.api.dto.responses.DtoAccountTransactionsFabrickResponse;
import com.fabrick.api.dto.responses.DtoMoneyTransferFabrickResponse;
import com.fabrick.api.helpers.HttpClientHelper;
import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class FabrickBankingServiceV4 {
    HttpClientHelper httpClientHelper;
    @Value("${fabrick.banking.v4.api.key}")
    private String fabrickBankingApiKey;

    @Value("${fabrick.banking.v4.base.url}")
    private String fabrickBankingBaseUrl;

    @Value("${fabrick.banking.v4.auth.schema}")
    private String fabrickBankingAuthSchema;

    @PostConstruct
    private void init() {
        this.httpClientHelper = new HttpClientHelper(fabrickBankingApiKey, fabrickBankingBaseUrl, fabrickBankingAuthSchema);
    }

    public DtoAccountBalanceFabrickResponse getBalanceAccount(String accountId) throws IOException {
        String url = httpClientHelper.getEndpointUrl(accountId + "/balance").build().toString();

        Request request = httpClientHelper.getBaseRequest(url).build();

        return new Gson().fromJson(httpClientHelper.getResponseBody(request), DtoAccountBalanceFabrickResponse.class);
    }

    public DtoAccountTransactionsFabrickResponse getAccountTransactions(String accountId, String fromAccountingDate, String toAccountingDate) throws IOException {
        String url = httpClientHelper.getEndpointUrl(accountId + "/transactions")
                .addQueryParameter("fromAccountingDate", fromAccountingDate)
                .addQueryParameter("toAccountingDate", toAccountingDate)
                .build()
                .toString();

        Request request = httpClientHelper.getBaseRequest(url).build();

        return new Gson().fromJson(httpClientHelper.getResponseBody(request), DtoAccountTransactionsFabrickResponse.class);
    }

    public DtoMoneyTransferFabrickResponse createMoneyTransfer(String accountId, DtoMoneyTransferFabrickRequest objectRequest) throws IOException {
        String url = httpClientHelper.getEndpointUrl(accountId + "/payments/money-transfers").build().toString();

        RequestBody requestBody = RequestBody.create(
                new Gson().toJson(objectRequest, DtoMoneyTransferFabrickRequest.class),
                MediaType.parse("application/json")
        );

        Request request = httpClientHelper.getBaseRequest(url).post(requestBody).build();

        return new Gson().fromJson(httpClientHelper.getResponseBody(request), DtoMoneyTransferFabrickResponse.class);
    }
}
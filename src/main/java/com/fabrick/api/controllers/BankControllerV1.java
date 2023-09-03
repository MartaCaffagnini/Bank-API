package com.fabrick.api.controllers;

import com.fabrick.api.dto.requests.DtoMoneyTransferFabrickRequest;
import com.fabrick.api.dto.responses.DtoAccountBalanceFabrickResponse;
import com.fabrick.api.dto.responses.DtoAccountTransactionsFabrickResponse;
import com.fabrick.api.dto.responses.DtoMoneyTransferFabrickResponse;
import com.fabrick.api.handlers.BankHandlerV1;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;

@Tag(name = "Bank API", description = "API that performs banking operations")
@RequestMapping(path = "api/bank/v1")
@RestController
public class BankControllerV1 {
    @Autowired
    private BankHandlerV1 bankHandlerV1;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "500", description = "internal general error"),
            @ApiResponse(responseCode = "502", description = "external api error")
    })
    @GetMapping(path = "/{accountId}/balance", produces = MediaType.APPLICATION_JSON_VALUE)
    public DtoAccountBalanceFabrickResponse getBalanceAccount(@PathVariable(value = "accountId") String accountId) {
        try {
            DtoAccountBalanceFabrickResponse response = bankHandlerV1.getBalanceAccount(accountId);

            if (Arrays.asList("KO", "500").contains(response.getStatus())) response.setStatus("502");

            return response;
        } catch (Exception e) {
            return new DtoAccountBalanceFabrickResponse("500", null, null);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "500", description = "internal general error"),
            @ApiResponse(responseCode = "502", description = "external api error")
    })
    @GetMapping(path = "/{accountId}/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public DtoAccountTransactionsFabrickResponse getAccountTransactions(@PathVariable(value = "accountId") String accountId,
                                                                        @RequestParam(value = "fromAccountingDate") String fromAccountingDate,
                                                                        @RequestParam(value = "toAccountingDate") String toAccountingDate) {
        try {
            DtoAccountTransactionsFabrickResponse response = bankHandlerV1.getAccountTransactions(accountId, fromAccountingDate, toAccountingDate);

            if (Arrays.asList("KO", "500").contains(response.getStatus())) response.setStatus("502");

            return response;
        } catch (Exception e) {
            return new DtoAccountTransactionsFabrickResponse("500", null, null);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "500", description = "internal general error"),
            @ApiResponse(responseCode = "502", description = "external api error")
    })
    @PostMapping(path = "/{accountId}/money-transfers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public DtoMoneyTransferFabrickResponse createMoneyTransfer(@PathVariable(value = "accountId") String accountId, @RequestBody DtoMoneyTransferFabrickRequest body) throws IOException {
        try {
            DtoMoneyTransferFabrickResponse response = bankHandlerV1.createMoneyTransfer(accountId, body);

            if (Arrays.asList("KO", "500").contains(response.getStatus())) response.setStatus("502");

            return response;
        } catch (Exception e) {
            return new DtoMoneyTransferFabrickResponse("500", null, null);
        }
    }
}
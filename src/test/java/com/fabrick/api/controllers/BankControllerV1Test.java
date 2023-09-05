package com.fabrick.api.controllers;

import com.fabrick.api.dto.requests.DtoMoneyTransferFabrickRequest;
import com.fabrick.api.dto.responses.DtoAccountBalanceFabrickResponse;
import com.fabrick.api.dto.responses.DtoAccountTransactionsFabrickResponse;
import com.fabrick.api.dto.responses.DtoMoneyTransferFabrickResponse;
import com.fabrick.api.dto.shared.*;
import com.fabrick.api.model.repositories.TransactionsRepository;
import com.fabrick.api.services.FabrickBankingServiceV4;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
class BankControllerV1Test {

    @Autowired
    private BankControllerV1 bankControllerV1;

    @MockBean
    private FabrickBankingServiceV4 fabrickBankingServiceV4;

    @MockBean
    private TransactionsRepository transactionsRepository;

    @Test
    void givenTheBalanceEndpoint_ThenItShouldCallTheFabrickBalanceEndpoint() throws IOException {
        bankControllerV1.getBalanceAccount("123454");
        verify(fabrickBankingServiceV4).getBalanceAccount("123454");
    }

    @Test
    void givenTheBalanceEndpoint_ThenItShouldCallTheFabrickBalanceEndpointAndReturnTheSameResponse() throws IOException {
        DtoAccountBalanceFabrickResponse response = new DtoAccountBalanceFabrickResponse(
                "OK",
                new DtoError[]{},
                new DtoAccountBalance("23-01-12", (float) 234.22, (float) 144.25, "EUR")
        );

        when(fabrickBankingServiceV4.getBalanceAccount("123454")).thenReturn(response);
        assertEquals(bankControllerV1.getBalanceAccount("123454"), response);
    }

    @Test
    void givenTheTransactionEndpoint_ThenItShouldCallTheFabrickTransactionEndpoint() throws IOException {
        bankControllerV1.getAccountTransactions("123454", "23-01-12", "01-07-12");
        verify(fabrickBankingServiceV4).getAccountTransactions("123454", "23-01-12", "01-07-12");
    }

    @Test
    void givenTheTransactionEndpoint_ThenItShouldCallTheFabrickTransactionEndpointAndReturnTheSameResponse() throws IOException {
        DtoTransaction dtoTransaction = new DtoTransaction(
                "123",
                "345",
                new Date(),
                new Date(),
                new DtoType("type", "1"),
                234.32,
                "EUR",
                "a description");

        ArrayList<DtoTransaction> accountTransactions = new ArrayList<DtoTransaction>();
        accountTransactions.add(dtoTransaction);
        accountTransactions.add(dtoTransaction);

        DtoAccountTransactionsFabrickResponse response = new DtoAccountTransactionsFabrickResponse(
                "OK",
                new DtoError[]{},
                new DtoAccountTransactions(accountTransactions)
        );

        when(fabrickBankingServiceV4.getAccountTransactions("123454", "23-01-12", "01-07-12")).thenReturn(response);
        assertEquals(bankControllerV1.getAccountTransactions("123454", "23-01-12", "01-07-12"), response);
    }

    @Test
    void givenTheMoneyTransferEndpoint_ThenItShouldCallTheFabrickMoneyTransferEndpointAndReturnTheSameResponse() throws IOException {
        DtoTransaction dtoTransaction = new DtoTransaction(
                "123",
                "345",
                new Date(),
                new Date(),
                new DtoType("type", "1"),
                234.32,
                "EUR",
                "a description");

        ArrayList<DtoTransaction> accountTransactions = new ArrayList<>();
        accountTransactions.add(dtoTransaction);
        accountTransactions.add(dtoTransaction);

        DtoCreditor dtoCreditor = new DtoCreditor("Luca",
                new DtoAccount("234rdwer", "serfgdewer"),
                new DtoAddress("sdfdesd", "Biella", "IT")
        );

        DtoDebtor dtoDebtor = new DtoDebtor("Mario",
                new DtoAccount("234rdwer", "serfgdewer")
        );

        DtoAmount dtoAmount = new DtoAmount(234.234, "EUR", 14.23, "EUR", new Date(), 10);

        DtoFee[] dtoFees = new DtoFee[]{
                new DtoFee("A", "a description", "EUR", 1234.3, "EUR"),
                new DtoFee("B", "a description", "USD", 124.3, "USD"),
        };

        DtoMoneyTransferFabrickResponse response = new DtoMoneyTransferFabrickResponse(
                "OK",
                new DtoError[]{},
                new DtoMoneyTransfer(
                        "123",
                        "OK",
                        "A",
                        dtoCreditor,
                        dtoDebtor,
                        "GTY54334",
                        "34RE",
                        "www.W345",
                        "a description",
                        new Date(),
                        new Date(),
                        new Date(),
                        new Date(),
                        dtoAmount,
                        true,
                        true,
                        "A",
                        "234567",
                        dtoFees,
                        false
                )
        );

        when(fabrickBankingServiceV4.createMoneyTransfer("123454", new DtoMoneyTransferFabrickRequest())).thenReturn(response);
        assertEquals(bankControllerV1.createMoneyTransfer("123454", new DtoMoneyTransferFabrickRequest()), response);
    }
}

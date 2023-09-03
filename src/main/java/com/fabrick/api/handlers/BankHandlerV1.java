package com.fabrick.api.handlers;


import com.fabrick.api.dto.requests.DtoMoneyTransferFabrickRequest;
import com.fabrick.api.dto.responses.DtoAccountBalanceFabrickResponse;
import com.fabrick.api.dto.responses.DtoAccountTransactionsFabrickResponse;
import com.fabrick.api.dto.responses.DtoMoneyTransferFabrickResponse;
import com.fabrick.api.model.entities.TransactionEntity;
import com.fabrick.api.model.repositories.TransactionsRepository;
import com.fabrick.api.services.FabrickBankingServiceV4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BankHandlerV1 {
	@Autowired
	private FabrickBankingServiceV4 fabrickBankingServiceV4;

	@Autowired
	private TransactionsRepository transactionsRepository;

	public DtoAccountBalanceFabrickResponse getBalanceAccount(String accountId) throws IOException {
		return fabrickBankingServiceV4.getBalanceAccount(accountId);
	}
	
	public DtoAccountTransactionsFabrickResponse getAccountTransactions(String accountId, String fromAccountingDate, String toAccountingDate ) throws IOException {
		return fabrickBankingServiceV4.getAccountTransactions(accountId, fromAccountingDate, toAccountingDate);
	}
	
	public DtoMoneyTransferFabrickResponse createMoneyTransfer(String accountId, DtoMoneyTransferFabrickRequest body) throws IOException {
		DtoMoneyTransferFabrickResponse response = fabrickBankingServiceV4.createMoneyTransfer(accountId, body);
		transactionsRepository.save(new TransactionEntity(Integer.parseInt(accountId), response.getStatus()));
		return response;
	}
}
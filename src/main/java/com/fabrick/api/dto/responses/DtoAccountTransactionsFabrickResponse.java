package com.fabrick.api.dto.responses;

import com.fabrick.api.dto.shared.DtoAccountTransactions;
import com.fabrick.api.dto.shared.DtoError;
import lombok.Data;

@Data
public class DtoAccountTransactionsFabrickResponse {

	public DtoAccountTransactionsFabrickResponse(String status, DtoError[] errors, DtoAccountTransactions payload) {
		this.status = status;
		this.errors = errors;
		this.payload = payload;
	}

	String status;
	
	DtoError[] errors;
	
	DtoAccountTransactions payload;
}

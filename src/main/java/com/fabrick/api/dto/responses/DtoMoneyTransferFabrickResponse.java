package com.fabrick.api.dto.responses;

import com.fabrick.api.dto.shared.DtoError;
import com.fabrick.api.dto.shared.DtoMoneyTransfer;
import lombok.Data;

@Data
public class  DtoMoneyTransferFabrickResponse{
	public DtoMoneyTransferFabrickResponse(String status, DtoError[] errors, DtoMoneyTransfer payload) {
		this.status = status;
		this.errors = errors;
		this.payload = payload;
	}

	String status;
	
	DtoError[] errors;
	
	DtoMoneyTransfer payload;
}
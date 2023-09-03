package com.fabrick.api.dto.shared;

import lombok.Data;

@Data
public class DtoFee{
	public DtoFee(String feeCode, String description, String creditorCurrency, Number amount, String currency) {
		this.feeCode = feeCode;
		this.description = description;
		this.creditorCurrency = creditorCurrency;
		this.amount = amount;
		this.currency = currency;
	}

	String feeCode;
	
	String description;
	
	String creditorCurrency;
	
	Number amount;
	
	String currency;
	
}

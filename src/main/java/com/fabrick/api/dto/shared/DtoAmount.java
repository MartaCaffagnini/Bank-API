package com.fabrick.api.dto.shared;

import lombok.Data;

import java.util.Date;

@Data
public class DtoAmount{
	public DtoAmount(Number debtorAmount, String debtorCurrency, Number creditorAmount, String creditorCurrency, Date creditorCurrencyDate, Number exchangeRate) {
		this.debtorAmount = debtorAmount;
		this.debtorCurrency = debtorCurrency;
		this.creditorAmount = creditorAmount;
		this.creditorCurrency = creditorCurrency;
		this.creditorCurrencyDate = creditorCurrencyDate;
		this.exchangeRate = exchangeRate;
	}

	Number debtorAmount;
	
	String debtorCurrency;
	
	Number creditorAmount;
	
	String creditorCurrency;
	
	Date creditorCurrencyDate;
	
	Number exchangeRate;
	
}

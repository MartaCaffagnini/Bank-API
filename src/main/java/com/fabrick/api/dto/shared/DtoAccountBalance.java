package com.fabrick.api.dto.shared;

import lombok.Data;

@Data
public class DtoAccountBalance {

	public DtoAccountBalance(String date, Float balance, Float availableBalance, String currency) {
		this.date = date;
		this.balance = balance;
		this.availableBalance = availableBalance;
		this.currency = currency;
	}

	String date;
	
	Float balance;
	
	Float availableBalance;
	
	String currency;
}

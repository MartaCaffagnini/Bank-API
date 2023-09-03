package com.fabrick.api.dto.shared;


import lombok.Data;

@Data
public class DtoAccount{
	public DtoAccount(String accountCode, String bicCode) {
		this.accountCode = accountCode;
		this.bicCode = bicCode;
	}

	String accountCode;
	
	String bicCode;
}

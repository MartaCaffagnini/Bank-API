package com.fabrick.api.dto.shared;

import lombok.Data;

import java.util.List;

@Data
public class DtoAccountTransactions {
	public DtoAccountTransactions(List<DtoTransaction> list) {
		this.list = list;
	}

	List<DtoTransaction> list;
}

package com.fabrick.api.dto.shared;

import lombok.Data;

@Data
public class DtoType {
	public DtoType(String enumeration, String value) {
		this.enumeration = enumeration;
		this.value = value;
	}

	String enumeration;
	
	String value;
}

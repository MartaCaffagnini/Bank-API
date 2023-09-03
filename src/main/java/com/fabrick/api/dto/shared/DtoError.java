package com.fabrick.api.dto.shared;

import lombok.Data;

@Data
public class DtoError{
	
	String code;
	
	String description;
	
	String params;
}
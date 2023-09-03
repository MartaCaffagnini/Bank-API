package com.fabrick.api.dto.shared;

import lombok.Data;

@Data
public class DtoAddress {
	public DtoAddress(String address, String city, String countryCode) {
		this.address = address;
		this.city = city;
		this.countryCode = countryCode;
	}

	String address;
	
	String city;
	
	String countryCode;
}

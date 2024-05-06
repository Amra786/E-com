package com.codeWithprojects.ecom.dto;

import lombok.Data;

@Data
public class PlaceOrderDto {
	
	private long userId;

	private String address;
	
	private String orderDescription;
}

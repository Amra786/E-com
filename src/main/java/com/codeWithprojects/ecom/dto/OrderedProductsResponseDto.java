package com.codeWithprojects.ecom.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderedProductsResponseDto {

	private List<ProductDto> productDtoList;
	
	private Long orderAmount;
}

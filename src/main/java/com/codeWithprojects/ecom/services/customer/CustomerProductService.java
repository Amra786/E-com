package com.codeWithprojects.ecom.services.customer;

import java.util.List;

import com.codeWithprojects.ecom.dto.ProductDetailDto;
import com.codeWithprojects.ecom.dto.ProductDto;

public interface CustomerProductService {
	
	List<ProductDto> searchProductByTitle(String title);
	
	List<ProductDto> getAllProducts();
	
	ProductDetailDto getProductDtoById(Long productId);

}

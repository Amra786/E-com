package com.codeWithprojects.ecom.services.customer.review;

import java.io.IOException;

import com.codeWithprojects.ecom.dto.OrderedProductsResponseDto;
import com.codeWithprojects.ecom.dto.ReviewDto;

public interface ReviewService {

	OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);
	
	ReviewDto giveReview(ReviewDto reviewDto) throws IOException;
}

package com.codeWithprojects.ecom.services.customer.cart;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.codeWithprojects.ecom.dto.AddProductInCartDto;
import com.codeWithprojects.ecom.dto.OrderDto;
import com.codeWithprojects.ecom.dto.PlaceOrderDto;

public interface CartService {

	ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);
	
	OrderDto getCartByUserId(Long userId);
	
	OrderDto applyCoupon(Long userId, String code);
	
	OrderDto increaseProductQuantity(AddProductInCartDto addProductInCartDto);
	
	OrderDto searchOrderByTrackingId(UUID trackingId);
	
	OrderDto decreaseProductQuantity(AddProductInCartDto addProductInCartDto);
	
	List<OrderDto> getMyPlacedOrders(Long userId);
	
	OrderDto placeOrder(PlaceOrderDto placeOrderDto);
	
}

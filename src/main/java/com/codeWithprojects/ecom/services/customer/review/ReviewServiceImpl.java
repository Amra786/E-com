package com.codeWithprojects.ecom.services.customer.review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codeWithprojects.ecom.dto.OrderedProductsResponseDto;
import com.codeWithprojects.ecom.dto.ProductDto;
import com.codeWithprojects.ecom.dto.ReviewDto;
import com.codeWithprojects.ecom.entity.CartItems;
import com.codeWithprojects.ecom.entity.Order;
import com.codeWithprojects.ecom.entity.Product;
import com.codeWithprojects.ecom.entity.Review;
import com.codeWithprojects.ecom.entity.User;
import com.codeWithprojects.ecom.repository.OrderRepository;
import com.codeWithprojects.ecom.repository.ProductRepository;
import com.codeWithprojects.ecom.repository.ReviewRepository;
import com.codeWithprojects.ecom.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	private final OrderRepository orderRepository;
	
	private final ProductRepository productRepository;
	
	private final UserRepository  userRepository;
	
	private final ReviewRepository reviewRepository;
	
	
	
	public OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId) {
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		OrderedProductsResponseDto orderedProductsResponseDto = new OrderedProductsResponseDto();
		if(optionalOrder.isPresent()) {
			orderedProductsResponseDto.setOrderAmount(optionalOrder.get().getAmount());
			
			List<ProductDto> productDtoList = new ArrayList<>();
			for (CartItems cartItems: optionalOrder.get().getCartItems()) {
				ProductDto productDto = new ProductDto();
				
				productDto.setId(cartItems.getProduct().getId());
				productDto.setName(cartItems.getProduct().getName());
				productDto.setPrice(cartItems.getPrice());
				productDto.setQuantity(cartItems.getQuantity());
				
				productDto.setByteImg(cartItems.getProduct().getImg());
				
				productDtoList.add(productDto);
			}
			orderedProductsResponseDto.setProductDtoList(productDtoList);
		}
		return orderedProductsResponseDto;
	}
	
	public ReviewDto giveReview(ReviewDto reviewDto) throws IOException {
		Optional<Product> optionalProduct = productRepository.findById(reviewDto.getProductId());
		Optional<User> optionalUser = userRepository.findById(reviewDto.getUserId());
		
		if(optionalProduct.isPresent() && optionalUser.isPresent()) {
			Review review = new Review();
			
			review.setRating(reviewDto.getRating());
			review.setDescription(reviewDto.getDescription());
			review.setUser(optionalUser.get());
			review.setProduct(optionalProduct.get());
			review.setImg(reviewDto.getImg().getBytes());
			
			return reviewRepository.save(review).getDto();
		}
		return null;
	}
}

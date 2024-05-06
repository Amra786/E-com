package com.codeWithprojects.ecom.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.codeWithprojects.ecom.dto.CartItemsDto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItems {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long price;
	
	private Long quantity;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Order order;
	
	public CartItemsDto getCartDto() {
		CartItemsDto cartItemsDto = new CartItemsDto();
		cartItemsDto.setId(id);
		cartItemsDto.setPrice(price);
		cartItemsDto.setProductId(product.getId());
		cartItemsDto.getQuantity();
		cartItemsDto.setProductName(product.getName());
		cartItemsDto.setReturnedImg(product.getImg());
		
		return cartItemsDto;


	}
}

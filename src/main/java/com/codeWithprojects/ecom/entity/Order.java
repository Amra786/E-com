package com.codeWithprojects.ecom.entity;

import java.util.*;

import com.codeWithprojects.ecom.dto.OrderDto;
import com.codeWithprojects.ecom.enums.OrderStatus;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String  orderDescription;
	
	private Date date;
	
	private Long amount;
	
	private String address;
	
	private String payment;
	
	private OrderStatus orderStatus;
	
	private Long totalAmount;
	
	private Long discount;
	
	private UUID trackingId;
	
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "coupon_id", referencedColumnName = "id")
	private Coupon coupon;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	private List<CartItems> cartItems;
	
	public OrderDto getOrderDto() {
		OrderDto orderDto = new OrderDto();
		
		orderDto.setId(id);
		orderDto.setOrderDescription(orderDescription);
		orderDto.setAddress(address);
		orderDto.setTrackingId(trackingId);
		orderDto.setAmount(amount);
		orderDto.setDate(date);
		orderDto.setOrderStatus(orderStatus);
		orderDto.setUserName(user.getName());
			if(coupon !=null) {
				orderDto.setCouponName(coupon.getName());
			}
			return orderDto;
	}
}

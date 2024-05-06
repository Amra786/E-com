package com.codeWithprojects.ecom.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.codeWithprojects.ecom.dto.ReviewDto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private Long rating;
	
	@Lob
	private String description;
	
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] img;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	@ManyToOne(fetch =  FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;
	
	public ReviewDto getDto() {
		ReviewDto reviewDto = new ReviewDto();
		
		reviewDto.setId(Id);
		reviewDto.setRating(rating);
		reviewDto.setDescription(description);
		reviewDto.setReturnedImg(img);
		reviewDto.setProductId(product.getId());
		reviewDto.setUserId(user.getId());
		reviewDto.setUserName(user.getName());
		
		return reviewDto;
	}
	
}

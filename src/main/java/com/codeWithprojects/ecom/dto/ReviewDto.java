package com.codeWithprojects.ecom.dto;



import org.springframework.web.multipart.MultipartFile;


import lombok.Data;

@Data
public class ReviewDto {

	
	private Long Id;
	
	private Long rating;
	
	private String description;
	
	private MultipartFile img;
	
	private byte[] returnedImg;
	
	private Long userId;
	
	private Long productId;
	
	private String userName;
}

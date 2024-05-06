package com.codeWithprojects.ecom.dto;

import com.codeWithprojects.ecom.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {
	
	private Long Id;
	
	private String Email;

	private String name;
	
	private UserRole userRole;

	

}

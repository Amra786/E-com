package com.codeWithprojects.ecom.entity;

import jakarta.persistence.Entity;

import com.codeWithprojects.ecom.enums.UserRole;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private String email;
	
	private String password;
	
	private String name;
	
	private UserRole role;
	
	@Lob
	@Column(columnDefinition="longblob")
	private byte[] img;

}

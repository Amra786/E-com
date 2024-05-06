package com.codeWithprojects.ecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeWithprojects.ecom.entity.User;
import com.codeWithprojects.ecom.enums.UserRole;

public interface UserRepository extends JpaRepository<User, Long> {
	
	   Optional <User> findFirstByEmail(String email);
	   
	   User findByRole(UserRole userRole);
}

package com.codeWithprojects.ecom.services.auth;

import com.codeWithprojects.ecom.dto.SignupRequest;
import com.codeWithprojects.ecom.dto.UserDto;

public interface AuthService {
	
	UserDto createUser(SignupRequest signupRequest);
	boolean hasUserWithEmail(String email);
}

package com.example.calendarbackend.Services.auth;

import com.example.calendarbackend.dtos.SignupRequest;
import com.example.calendarbackend.dtos.UserDto;

public interface AuthService {

	UserDto createUser(SignupRequest signupRequest);
	
}


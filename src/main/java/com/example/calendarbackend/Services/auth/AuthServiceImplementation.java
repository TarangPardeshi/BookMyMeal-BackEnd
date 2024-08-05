package com.example.calendarbackend.Services.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.calendarbackend.Repositories.UserRepository;
import com.example.calendarbackend.dtos.SignupRequest;
import com.example.calendarbackend.dtos.UserDto;
import com.example.calendarbackend.entity.User;
import com.example.calendarbackend.enums.UserRole;



@Service
public class AuthServiceImplementation implements AuthService{

	private final UserRepository userRepository;
	
	
	public AuthServiceImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDto createUser(SignupRequest signupRequest) {

		User user = new User();
		user.setFirstName(signupRequest.getFirstName());
		user.setLastName(signupRequest.getLastName());
		user.setEmail(signupRequest.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
		user.setUserRole(UserRole.CUSTOMER);
		User createdUser = userRepository.save(user);
		UserDto createdUserDto = new UserDto();
		createdUserDto.setId(createdUser.getId());
		createdUserDto.setFirstName(createdUser.getFirstName());
		createdUserDto.setLastName(createdUser.getLastName());
		createdUserDto.setEmail(createdUser.getEmail());
		createdUserDto.setUserRole(createdUser.getUserRole());
		return createdUserDto;
	}

}


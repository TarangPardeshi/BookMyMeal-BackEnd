package com.example.calendarbackend.Services.auth.jwt;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.calendarbackend.Repositories.UserRepository;
import com.example.calendarbackend.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// Writing logic to get user from database
		Optional<User> optionalUser = userRepository.findFirstByEmail(email);
		if(optionalUser.isEmpty()) throw new UsernameNotFoundException("User Not Found", null);
		return new org.springframework.security.core.userdetails.User(optionalUser.get().getEmail(), optionalUser.get().getPassword(), new ArrayList<>());
	}

}

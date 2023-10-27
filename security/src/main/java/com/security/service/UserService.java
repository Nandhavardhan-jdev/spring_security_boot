package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.dao.UserDao;
import com.security.dto.UserDto;
import com.security.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public String addUser(UserDto userDto) {
		UserDao user = new UserDao();
		user.setUsername(userDto.getUsername());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userRepo.save(user);
		return "user account created successfully";
	}

}

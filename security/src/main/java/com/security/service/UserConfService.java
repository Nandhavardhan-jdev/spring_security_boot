package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.security.dao.UserDao;
import com.security.dto.UserDto;
import com.security.repo.UserRepo;

@Component
public class UserConfService implements UserDetailsService {

	@Autowired UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username){
		UserDao user = userRepo.findByUsername(username);
		if (user != null) {
			return new UserDetails1(user);
		}else {
			throw new UsernameNotFoundException("username not found: "+username);
		}
	}

}

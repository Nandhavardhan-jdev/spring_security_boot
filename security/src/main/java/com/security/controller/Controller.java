package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.dao.UserDao;
import com.security.dto.UserDto;
import com.security.service.UserService;

@RestController
public class Controller {
	
	@Autowired
	UserService userService;

	@GetMapping("/user/login")
	public String userLogin() {
		return "welcome user";
	}
	@GetMapping("/home")
	public String home() {
		return "Hi Welcome";
	}
	@PostMapping("/add/user")
	public String addUser(@RequestBody UserDto userDto) {
		return userService.addUser(userDto);
	}
}

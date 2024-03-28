package com.nt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.AuthRequest;
import com.nt.dto.UserDTO;
import com.nt.service.IUserMgmtService;

@RestController
@RequestMapping("/user")
public class AuthAPI {
	@Autowired
	private IUserMgmtService userService;
	

	@PostMapping("/signup")
	public UserDTO registerUser(@RequestBody UserDTO user) {
		return userService.addUser(user);
	}
	
	public AuthRequest authenticateUser(@RequestBody  AuthRequest auth) {
		
		
		return auth;
		
	}
}

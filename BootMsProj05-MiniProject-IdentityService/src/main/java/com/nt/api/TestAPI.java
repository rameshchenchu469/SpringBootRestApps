package com.nt.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestAPI {
	
	@GetMapping("/welcome")
	public String welcome() {
		return"welcome to the spring secirity ouath2 resource server";
	}
	@GetMapping("/test1")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public void userAPI() {
		System.out.println("all users can access");
	}
	
	@GetMapping("/test2")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public void adminAPI() {
		System.out.println("Only admin can access");
	}

}

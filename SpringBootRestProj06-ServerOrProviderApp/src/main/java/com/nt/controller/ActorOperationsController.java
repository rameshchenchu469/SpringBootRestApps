package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/display")
public class ActorOperationsController {

	@GetMapping("/message")
	public ResponseEntity<String> dispalyWishMessage(){
		
		return new ResponseEntity<String>("Welcome to RestTemplate", HttpStatus.OK);
	}
}

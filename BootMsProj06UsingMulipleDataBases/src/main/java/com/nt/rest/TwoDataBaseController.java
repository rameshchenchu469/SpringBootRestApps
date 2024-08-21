package com.nt.rest;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity1.UserEntity;
import com.nt.entity2.BookEntity;
import com.nt.repo1.UserRepository;
import com.nt.repo2.BookRepository;

@RestController
public class TwoDataBaseController {
    
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BookRepository bookRepo;
	
	@PostMapping("/addData")
	public String addDatato2db() {
		
		userRepo.saveAll(List.of(new UserEntity(123,"ram","ram@gmail.com"),new UserEntity(345,"sam","sam@gmail.com")));
		bookRepo.saveAll(List.of(new BookEntity(101,"abc","xyz"),new BookEntity(123,"xyz","abc")));
		return "data added successfully";
	}
}

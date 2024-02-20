package com.nt.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BillingServiceConsumer;

@RestController
@RequestMapping("/shopping")
public class ShoppingServiceController {
	@Autowired
	private BillingServiceConsumer consumer;
	
	
	@GetMapping("/details")
	public ResponseEntity<String> showBillingDetails(){
		
		String resultBody=consumer.getBillingInfo();
		String billingInfo="Billing Amount Rs."+new Random().nextInt(100000);
		return new ResponseEntity<String>(billingInfo+" "+resultBody,HttpStatus.OK);
	}

}

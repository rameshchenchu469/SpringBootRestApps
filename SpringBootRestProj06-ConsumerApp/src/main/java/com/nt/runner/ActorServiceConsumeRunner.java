package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumeRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		RestTemplate template=new RestTemplate();
		
		String serviceUrl= "http://localhost:4041/display/message";
		
		ResponseEntity<String> result=template.getForEntity(serviceUrl,String.class);
		System.out.println("response body(output):"+" "+result.getBody());
		System.out.println("response StatusCode value:"+" "+result.getStatusCodeValue());
		System.out.println("response status code:"+" "+result.getStatusCode());
	}
	

}

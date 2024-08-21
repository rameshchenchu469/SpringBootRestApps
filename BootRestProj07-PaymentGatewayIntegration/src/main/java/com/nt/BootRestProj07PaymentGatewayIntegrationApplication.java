package com.nt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.razorpay.RazorpayClient;

@SpringBootApplication
public class BootRestProj07PaymentGatewayIntegrationApplication {
	
	@Value("${razorpay.key.id}")
	private String razorPayKey;
	
	@Value("${razorpay.key.secret}")
	private String razorPaySecret;
	
	 @Bean
	    public RazorpayClient razorpayClient() throws Exception {
	        return new RazorpayClient("razorPayKey", "razorPaySecret");
	    }

	public static void main(String[] args) {
		SpringApplication.run(BootRestProj07PaymentGatewayIntegrationApplication.class, args);
	}

}

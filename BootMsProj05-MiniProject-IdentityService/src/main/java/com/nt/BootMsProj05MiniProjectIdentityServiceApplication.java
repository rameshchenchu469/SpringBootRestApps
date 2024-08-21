package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import com.nt.dto.RsaKeyConfigurationProperties;

@SpringBootApplication
//@EnableMethodSecurity
@EnableConfigurationProperties(RsaKeyConfigurationProperties.class)
public class BootMsProj05MiniProjectIdentityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj05MiniProjectIdentityServiceApplication.class, args);
	}

}

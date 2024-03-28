package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj05MiniProjectIplTeamServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj05MiniProjectIplTeamServiceApplication.class, args);
	}

}

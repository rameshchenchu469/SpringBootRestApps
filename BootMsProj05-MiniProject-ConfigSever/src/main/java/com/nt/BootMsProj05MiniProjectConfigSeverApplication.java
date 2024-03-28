package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BootMsProj05MiniProjectConfigSeverApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj05MiniProjectConfigSeverApplication.class, args);
	}

}

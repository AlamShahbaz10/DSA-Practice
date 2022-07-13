package com.example.serviceregistrynew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryNewApplication.class, args);
	}

}

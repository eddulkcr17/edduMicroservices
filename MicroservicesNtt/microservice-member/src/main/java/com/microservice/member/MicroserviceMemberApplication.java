package com.microservice.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceMemberApplication.class, args);
	}

}

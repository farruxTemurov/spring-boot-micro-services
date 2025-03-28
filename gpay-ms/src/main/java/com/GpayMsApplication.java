package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.bean")
@EnableJpaRepositories(basePackages = "com.repository")
@EnableDiscoveryClient
public class GpayMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpayMsApplication.class, args);
	}

	@Bean // if we use @LoadBalance annotation, we can call other micro services by name
			
	@LoadBalanced 
	public RestTemplate restTemplate() {
		System.out.println("Rest Template object created..");
		return new RestTemplate();
	}
}

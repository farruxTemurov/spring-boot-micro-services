package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class FirstMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstMicroServiceApplication.class, args);
		System.err.println("first micro service project is running on port 8080");
	}

}

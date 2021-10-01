package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {
		SecurityAutoConfiguration.class,
		SecurityFilterAutoConfiguration.class
})
public class WebDemoProjectApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WebDemoProjectApplication.class, args);
	}

}

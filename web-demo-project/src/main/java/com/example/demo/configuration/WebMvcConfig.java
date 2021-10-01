package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//인증서버에 크로스 도메인 접근 가능하도록 설정
		registry.addMapping("/**")
		.allowedOriginPatterns("*")
		.allowedMethods("GET","POST","PUT","DELETE")
		.allowCredentials(true)
		.allowedHeaders("*")
		.maxAge(3600);
	}
}

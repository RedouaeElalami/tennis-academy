package com.zenika.academy.tennisacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan({"com.zenika.*emy.tennisacademy.*"})
@EntityScan("com.zenika.academy.tennisacademy.domain")
@SpringBootApplication
public class TennisAcademyApplication {

	public static void main(String[] args) {
		//-Dspring.profiles.active=dev
		String property = System.getProperty("spring.profiles.active");
		System.out.println("property= " + property);
		SpringApplication.run(TennisAcademyApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}


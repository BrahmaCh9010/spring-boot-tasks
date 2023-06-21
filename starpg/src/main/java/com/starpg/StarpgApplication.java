package com.starpg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring Boot Training",version = "1.0",description = "Person Info"))
public class StarpgApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarpgApplication.class, args);
	}

}

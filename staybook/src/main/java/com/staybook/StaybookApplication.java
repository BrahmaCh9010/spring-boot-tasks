package com.staybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@SpringBootApplication
@OpenAPIDefinition
public class StaybookApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaybookApplication.class, args);
	}

}

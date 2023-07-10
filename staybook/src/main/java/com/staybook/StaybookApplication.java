package com.staybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Staybook API ",version = "1.0",description = "Person Controller"))
@EnableAuthorizationServer
@EnableResourceServer
public class StaybookApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaybookApplication.class, args);
	}

}

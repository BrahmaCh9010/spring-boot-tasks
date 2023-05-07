package com.springtasks.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringBootTasksApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootTasksApplication.class, args);
		ApplicationContext context =
				 new ClassPathXmlApplicationContext("Beans.xml");
				 HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
				 obj.getMessage();

		System.out.println("application run ssucess");
	}
	

}

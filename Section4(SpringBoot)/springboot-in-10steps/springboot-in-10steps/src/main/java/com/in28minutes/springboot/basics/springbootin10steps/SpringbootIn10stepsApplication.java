package com.in28minutes.springboot.basics.springbootin10steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
// The Spring Boot Application annotation takes care of the following three things:
// (1) Notifies that this is a Spring Context
// (2) Enables Auto Configuration
// (3) Enables a component scan to identify beans
public class SpringbootIn10stepsApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				SpringApplication.run(SpringbootIn10stepsApplication.class, args);
	
		for (String name: applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}
}

package com.in28minutes.spring.basics.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.spring.basics.componentscan.ComponentDAO;
import com.in28minutes.spring.basics.demo.basic.BinarySearchImpl;
import com.in28minutes.spring.basics.demo.scope.PersonDAO;

// Whenever we initialize the Spring Boot Application, it initializes a component scan on the 
// current package that the application is under. However, since the component scan package is
// not being picked up, we need to specify a component scan on that specific package
@Configuration
@ComponentScan("com.in28minutes.spring.basics.componentscan")
public class DemoComponentScanApplication {
	
	private static Logger LOGGER = 
			LoggerFactory.getLogger(DemoComponentScanApplication.class);
	
	// The main class for the DemoBasicScope Application
	public static void main(String[] args) {
		// ApplicationContext applicationContext = 
		// SpringApplication.run(DemoComponentScanApplication.class, args);
		
		try (AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(
				DemoComponentScanApplication.class)) {
		
		ComponentDAO componentDAO = 
				applicationContext.getBean(ComponentDAO.class);

		LOGGER.info("{}", componentDAO);
	
		}
	}
}

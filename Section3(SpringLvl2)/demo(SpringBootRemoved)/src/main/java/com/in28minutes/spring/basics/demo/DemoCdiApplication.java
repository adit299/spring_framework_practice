package com.in28minutes.spring.basics.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.spring.basics.demo.basic.BinarySearchImpl;
import com.in28minutes.spring.basics.demo.cdi.SomeCDIBusiness;
import com.in28minutes.spring.basics.demo.scope.PersonDAO;

@Configuration
@ComponentScan
public class DemoCdiApplication {
	
	private static Logger LOGGER = 
			LoggerFactory.getLogger(DemoCdiApplication.class);
	
	
	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(
				DemoCdiApplication.class)) {
			// ApplicationContext applicationContext = 
					// SpringApplication.run(DemoCdiApplication.class, args);
			
			SomeCDIBusiness business = applicationContext.getBean(SomeCDIBusiness.class);
			
			// We are invoking the getter function from our SomeCDIBusiness class to see if 
			// indeed Spring is managing our dependencies and injecting the dependency into the class
			// correctly
			LOGGER.info("{} dao-{}", business, business.getSomeCDIDAO());		
		}
	}
}

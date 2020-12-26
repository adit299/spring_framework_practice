package com.in28minutes.spring.basics.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.in28minutes.spring.basics.demo.basic.BinarySearchImpl;
import com.in28minutes.spring.basics.demo.scope.PersonDAO;

@Configuration
@ComponentScan
public class DemoScopeApplication {
	
	private static Logger LOGGER = 
			LoggerFactory.getLogger(DemoScopeApplication.class);
	
	// The main class for the DemoBasicScope Application
	public static void main(String[] args) {
		
//		ApplicationContext applicationContext = 
//				SpringApplication.run(DemoScopeApplication.class, args);
		
		try (AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(
				DemoScopeApplication.class)) {
		
			PersonDAO personDao = applicationContext.getBean(PersonDAO.class);
	
			PersonDAO personDao2 = applicationContext.getBean(PersonDAO.class);
			
			// These lines of code simply replace whatever is between the parentheses with
			// the second argument passed into the Logger.info, and prints it out.
			LOGGER.info("{}", personDao);
			LOGGER.info("{}", personDao.getJdbcConnection());
			LOGGER.info("{}", personDao.getJdbcConnection());
			
			LOGGER.info("{}", personDao2);
			LOGGER.info("{}", personDao.getJdbcConnection());
		}
	}
}

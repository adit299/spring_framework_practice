package com.in28minutes.spring.basics.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.in28minutes.spring.basics.demo.basic.BinarySearchImpl;
import com.in28minutes.spring.basics.demo.scope.PersonDAO;

@SpringBootApplication
public class DemoScopeApplication {
	
	private static Logger LOGGER = 
			LoggerFactory.getLogger(DemoScopeApplication.class);
	
	// The main class for the DemoBasicScope Application
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				SpringApplication.run(DemoScopeApplication.class, args);
		
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

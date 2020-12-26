package com.in28minutes.spring.basics.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28minutes.spring.basics.demo.xml.XMLPersonDAO;

public class DemoXMLContextApplication {
	
	private static Logger LOGGER = LoggerFactory.getLogger(DemoXMLContextApplication.class);

	public static void main(String[] args) {
		// Over here we are initializing a ApplicationContext object using XML, and the XML files
		// we created before are utilized in that process (as opposed to a Java Object)
		try (ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml")) {
			
			// We want to see all the beans that have been loaded up to the application context
			// However, note that an array is returned, which means we must typecast to an object
			// in order for it to be printed and displayed properly.
			LOGGER.info("Beans Loaded -> {}", 
			(Object)applicationContext.getBeanDefinitionNames());
			
			XMLPersonDAO personDao = applicationContext.getBean(XMLPersonDAO.class);	
			
			LOGGER.info("{} {}", personDao, personDao.getXMLJdbcConnection());
		}
	}
}

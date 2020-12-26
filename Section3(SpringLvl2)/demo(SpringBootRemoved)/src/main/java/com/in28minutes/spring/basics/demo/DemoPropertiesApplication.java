package com.in28minutes.spring.basics.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.in28minutes.spring.basics.demo.basic.BinarySearchImpl;
import com.in28minutes.spring.basics.demo.properties.SomeExternalService;

@Configuration
@ComponentScan("com.in28minutes.spring.basics.demo")
// To load our url from the app.properties file
@PropertySource("classpath:app.properties")
public class DemoPropertiesApplication {

	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(
				DemoPropertiesApplication.class)) {
			
			SomeExternalService service = applicationContext.getBean(SomeExternalService.class);
			System.out.println(service.returnServiceURL());
			
		}
	}
}

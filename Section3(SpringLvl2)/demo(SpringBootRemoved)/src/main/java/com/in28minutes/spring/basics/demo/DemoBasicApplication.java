package com.in28minutes.spring.basics.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.spring.basics.demo.basic.BinarySearchImpl;

@Configuration
// Spring Boot used to do the component scan by default, but now we have to do it by hand with 
// Spring core
@ComponentScan("com.in28minutes.spring.basics.demo")
public class DemoBasicApplication {

	public static void main(String[] args) {
		
		// In Spring Core we need to close the application context after its use, which we 
		// can do by either explicitly calling applicationContext.close(), or by using a try catch
		// block. try catch will explicitly close the applicationContext whether it encounters an 
		// exception or not.
		try (AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(
				DemoBasicApplication.class)) {
			
			// SpringApplication.run(DemoBasicApplication.class, args);
			
			// This line of code is equivalent to us writing  
			// BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
			
			BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
			
			BinarySearchImpl binarySearch1 = applicationContext.getBean(BinarySearchImpl.class);
			
			int result = binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);
			
			System.out.println(binarySearch);
			System.out.println(binarySearch1);
		}
		
		// System.out.println(result);
		
		// com.in28minutes.spring.basics.demo.BubbleSortAlgorithm@51133c06
		// 3
		// Interesting thing to note is that we see the BubbleSortAlgorithm by name here, which
		// reflects the fact that we made our BinarySearchImpl class manage the BubbleSortAlgorithm
	}
}

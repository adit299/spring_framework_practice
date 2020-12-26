package com.in28minutes.spring.basics.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.in28minutes.spring.basics.demo.basic.BinarySearchImpl;

@SpringBootApplication
public class DemoBasicApplication {
	// Steps to setting up Spring within an application
	// What are the beans? => We completed by labeling them with @Component
	// What are the dependencies for the bean? => We completed by labeling them with @Autowired
	// Where to search for the beans? => This was automatically completed for us, the @SpringBootApplcation
	// annotation means that we search for the dependencies and beans within the current package and 
	// subpackages	

	public static void main(String[] args) {
		
		// Note that although BinarySearchImpl and the BubbleSortAlgorithm is loosely coupled,
		// we still have to create instances of each in order for the sorting algorithm to work.
		// This is where Spring comes into play
		// BinarySearchImpl  binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
		
		// Application Context - This is where all our beans will be managed. By default,
		// SpringApplication.run will return an ApplicationContext object 
		
		ApplicationContext applicationContext = 
				SpringApplication.run(DemoBasicApplication.class, args);
		
		// This line of code is equivalent to us writing  
		// BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
		
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		
		BinarySearchImpl binarySearch1 = applicationContext.getBean(BinarySearchImpl.class);
		
		int result = binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);
		
		System.out.println(binarySearch);
		System.out.println(binarySearch1);
		
		
		
		// System.out.println(result);
		
		// com.in28minutes.spring.basics.demo.BubbleSortAlgorithm@51133c06
		// 3
		// Interesting thing to note is that we see the BubbleSortAlgorithm by name here, which
		// reflects the fact that we made our BinarySearchImpl class manage the BubbleSortAlgorithm
		
		
	}

}

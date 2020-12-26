package com.in28minutes.spring.basics.demo.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// The @Component annotation tells Spring that we want it to manage this particular class
@Component
// By using the prototype bean scope, we are telling Spring to create two seperate beans for the
// same application context 
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImpl {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// The @Autowired annotation tells Spring that is a dependency of this particular class
	
	
	// We have now renamed the SortAlgorithm to line up with one of the class names that we already
	// have, so Spring is able to initialize BinarySearchImpl correctly with the Bubble Sort Algorithm class
	// @Autowired
	// private SortAlgorithm bubbleSortAlgorithm;
	
	// Example of Qualifier dependency injections
	@Autowired
	@Qualifier("quick")
	private SortAlgorithm sortAlgorithm;
	
	
// Constructor Injection	
//	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
//		super();
//		this.sortAlgorithm = sortAlgorithm;
//	}

// Setter Injection
//	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	}

// Note that after setting up our application to use @Component and @Autowired, the code for the 
// and constructor and the getter and setter is not needed, Spring automatically handles the
// required dependencies 

	public int binarySearch(int[] numbers, int numberToSearchFor) {
		// Implementing Sorting Logic
		// Remember that in order for binary search to work properly, the array must
		// be sorted. So we will first use bubble sort to sort the array before using binary 
		// search. However, let's say we wanted to change the sorting algorithm to be something else.
		// The bubble sort algorithm is tightly coupled with the BinarySearchImpl class 		
		
		// BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
		// int[] sortedNumbers = bubbleSortAlgorithm.sort(numbers);
		
		// In order to solve the coupling issue, we make both of the algorithms implement an interface
		// so that we can dynamically change the sorting algorithm on the fly. The sorting algorithm is 
		// now loosely coupled 		
		
		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		
		// Search the array
		
		return 3;
	}
	
	// A post construct method will be called as soon as the bean is created above 
	// (the dependencies are resolved)
	@PostConstruct
	public void postConstruct() {
		logger.info("postConstruct");
	}
	
	// This will be called right before the bean is removed from the context 
	@PreDestroy
	public void preDestroy() {
		logger.info("predestroy");
	}
	

}

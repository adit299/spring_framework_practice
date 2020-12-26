package com.in28minutes.spring.basics.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// The @Component annotation tells Spring that we want it to manage this particular class
@Component
public class BinarySearchImpl {
	
	// The @Autowired annotation tells Spring that is a dependency of this particular class
	@Autowired
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

}

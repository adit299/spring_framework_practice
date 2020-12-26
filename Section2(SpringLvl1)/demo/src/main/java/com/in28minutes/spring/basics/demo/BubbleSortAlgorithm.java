package com.in28minutes.spring.basics.demo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Since we have two components that could be used as dependencies for BinarySearchImpl,
// Primary allows us to mark the one that should get priority out of the two
@Component
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm {
	// When we have more than one component, we can use @Primary to mark
	// one of them as more important than the other
	public int[] sort(int[] numbers) {
		// Logic for Bubble Sort (here)
		return numbers;
	}
	
}

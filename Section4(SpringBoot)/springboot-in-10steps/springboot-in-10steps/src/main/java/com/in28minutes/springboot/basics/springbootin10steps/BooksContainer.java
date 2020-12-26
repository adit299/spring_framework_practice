package com.in28minutes.springboot.basics.springbootin10steps;



import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Creating a simple Spring Rest service
@RestController
public class BooksContainer {
	// Represents a Get request when we go to this particular URL path	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return Arrays.asList(
				new Book(1l, "Diary of a Wimpy Kid: Rodrick Rules", "Jeff Kinney"));
	}
	
}

package com.in28minutes.database.databasedemo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

// We could've used the component annotation here, however, since this class talks to the database,
// the correct annotation to use would be repository
@Repository
public class PersonJdbcDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// We want to make a query to our database to retrieve all the persons we have intialized within
	// the database
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", 
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	// Bean Property Row Mapper is a built-in method from Spring JDBC that allows us to map values from
	// a SQL query to a particular class (as long as the column names from the database matches with the 
	// parameter names in the class)
	
	
	
	// We can use this method to query for a specific user by ID (note that query for object has 
	// been deprecated), so we need to find another alternative. We can use this same type of method 
	// to query for other characteristics such as name and location	
	public Person findById(int id) {
		return jdbcTemplate.queryForObject
				("select * from person where id=?", 
				new Object[] {id},
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	// We can use this query to delete specific entries from the database, we are returned the 
	// number of rows that are modified	
	public int deleteById(int id) {
		return jdbcTemplate.update
		("delete from person where id=?", new Object[] { id });
	}
	
	public int insert(Person person) {
		return jdbcTemplate.update
				("insert into person (id, name, location, birth_date) "
				+ "values(?, ?, ?, ?)",
				new Object[] {
						person.
				})
	}
	
	
	

}

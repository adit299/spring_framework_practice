package com.in28minutes.spring.basics.demo.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class PersonDAO {
	
	// Note that even though we set the scope of the JDBC connection to be prototype, 
	// it will not initialize two different instances of the JDBC connection, because
	// when PersonDAO is retrieving the JDBC object, it is content with one instance of it,
	// not realizing that it has a scope of Prototype
	
	@Autowired
	JdbcConnection jdbcConnection;

	public JdbcConnection getJdbcConnection() {
		return jdbcConnection;
	}

	public void setJdbcConnection(JdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}
	
	
}

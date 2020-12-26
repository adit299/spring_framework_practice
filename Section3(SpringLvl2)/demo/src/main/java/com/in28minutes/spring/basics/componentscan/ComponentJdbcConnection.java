package com.in28minutes.spring.basics.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
// If we want JDBC connection to have a prototype scope, we have to utilize a proxy, which
// is what will be invoked anytime we want an instance of the JDBC connection (autowire it), 
// and will correctly provide us with the prototype behaviour we are looking for
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ComponentJdbcConnection {
	
	@Autowired
	public ComponentJdbcConnection() {
		System.out.println("JDBC Connection");
	}
	
	
	
	
	
}

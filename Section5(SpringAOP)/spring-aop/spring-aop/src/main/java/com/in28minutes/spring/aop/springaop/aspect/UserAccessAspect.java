package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class UserAccessAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//What kind of method calls I would Intercept
	
	// This notation controls exactly which methods from classes we want
	// to intercept
	// The first *: controls the return type (* means all of them)
	// The second *: controls the specific class (* means all of them)
	// The third *: controls the specific method (* means all of them)
	// PACKAGE: the package from which we want to intercept calls
	// (..): intercept all method calls irrespective of their arguments
	//execution(* PACKAGE.*.*(..))
	
	// The before notation intercepts the method before it is called	
	//@Before("execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))")
	// @Before("execution(* com.in28minutes.spring.aop.springaop..*.*(..))")
	
	// Instead of using an absolute pointcut path, we have it refactored into another file  
	@Before("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.dataLayerExecution()")
	public void before(JoinPoint joinPoint) {
		//What to do?
		//logger.info(" Intercepted Method Calls - {}", joinPoint);
		
		// This is a practical application for the before method, we can use it to verify
		// user access lets say, since we know through the use of Spring AOP, this will be called
		// before any method call
		
		
		logger.info(" Check for user access ");
		logger.info(" Allowed execution for {}", joinPoint);
	}

}

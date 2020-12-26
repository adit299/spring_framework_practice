package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	// We can use the around annotation to calculate how long a method takes to execute 	
	@Around("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		// We get the time that the application starts its execution		
		long startTime = System.currentTimeMillis();
		
		// We proceed with the method call		
		joinPoint.proceed();
		
		// We calculate the endTime - startTime to pinpoint how long the execution of the 
		// application took
		long timeTaken = System.currentTimeMillis() - startTime;
		
		// We print out this information
		logger.info("Time taken by {} is {}", joinPoint, timeTaken);
	}

}

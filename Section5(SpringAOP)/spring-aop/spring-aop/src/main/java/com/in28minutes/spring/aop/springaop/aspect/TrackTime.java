package com.in28minutes.spring.aop.springaop.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// We want to define tracktime so that if we place this
// annotation over any method, it would track the time needed
// to execute it

// With these two annotations we are defining what type this 
// annotation will intercept (method) and when it will intercept
// this method call (runtime)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {
	
}

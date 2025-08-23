package com.learning.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * This class is an Aspect that contains advice to be executed at specific points in the application.
 * The @Component annotation makes it a Spring-managed bean.
 */
@Component
@Aspect
public class LoggingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class); 
	
	
	/*
	 * // Match all method calls in the application, just for reference(default)
	 * * @Before("execution(* *.*(..))") public void logMethodCall() {
	 * logger.info("Method called"); }
	 */
	
	
	/**
	 * This is a @Before advice. It executes BEFORE the method call
	 * defined by the pointcut expression.
	 *
	 * Pointcut: "execution(* com.learning.springbootrest.service.JobService.getJob(..))"
	 * The JoinPoint object `jp` gives details about the method being called.
	 */
	@Before("execution(* com.learning.springbootrest.service.JobService.getJob(..))")
	public void logMethodCall(JoinPoint jp) {
		logger.info("Method called: " + jp.getSignature().getName());
	}
	
	/**
	 * This is an @After advice. It executes AFTER the method completes,
	 * regardless of whether it returned successfully or threw an exception.
	 *
	 * Pointcut: "execution(* com.learning.springbootrest.service.JobService.getJob(..))"
	 */
	@After("execution(* com.learning.springbootrest.service.JobService.getJob(..))")
	public void logMethodExecuted(JoinPoint jp) {
		logger.info("Method Executed: " + jp.getSignature().getName());
	}
	
	/**
	 * This is an @AfterThrowing advice. It executes only if the method
	 * defined by the pointcut throws an exception.
	 *
	 * Pointcut: "execution(* com.learning.springbootrest.service.JobService.getJob(..))"
	 */
	@AfterThrowing("execution(* com.learning.springbootrest.service.JobService.getJob(..))")
	public void logMethodErrors(JoinPoint jp) {
		logger.info("Method facing some errors: " + jp.getSignature().getName());
	}
	
	/**
	 * This is an @AfterReturning advice. It executes only if the method
	 * completes successfully and returns a value without throwing an exception.
	 *
	 * Pointcut: "execution(* com.learning.springbootrest.service.JobService.getJob(..))"
	 */
	@AfterReturning("execution(* com.learning.springbootrest.service.JobService.getJob(..))")
	public void logMethodSuccess(JoinPoint jp) {
		logger.info("Method executed successfully: " + jp.getSignature().getName());
	}
}
package com.learning.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(PerformanceMonitorAspect.class);
	
	/**
	 * This is an @Around advice. It wraps around the method call, allowing
	 * it to execute code both before and after the targeted method.
	 * * The Pointcut: "execution(* com.learning.springbootrest.service.JobService.getJob(..))"
	 * This targets the 'getJob' method in the 'JobService' class.
	 * * The `ProceedingJoinPoint` is a special type of JoinPoint used only with @Around advice.
	 * It provides the `proceed()` method, which is used to execute the original method.
	 *
	 * This aspect is used to monitor the performance of a method by measuring
	 * the time taken for its execution.
	 */
	@Around("execution(* com.learning.springbootrest.service.JobService.getJob(..))")
	public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
		
		// 1. Code to run BEFORE the original method
		long start = System.currentTimeMillis();
		
		// 2. This executes the original method (JobService.getJob())
		Object obj = jp.proceed();
		
		// 3. Code to run AFTER the original method completes
		long end = System.currentTimeMillis();
		
		logger.info("Time taken by: " + jp.getSignature().getName() + " " + (end - start) + " ms");
		
		// 4. Returns the value that the original method returned
		return obj;
	}
}
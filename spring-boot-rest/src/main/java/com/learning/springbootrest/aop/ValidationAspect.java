package com.learning.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * This Aspect performs validation on method arguments before the method is executed.
 * It uses @Around advice to intercept the method call, modify its arguments if needed,
 * and then proceed with the updated arguments.
 */
@Component
@Aspect
public class ValidationAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(ValidationAspect.class);

	/**
	 * This is an @Around advice that intercepts the 'getJob' method in JobService.
	 * * The Pointcut: "execution(* com.learning.springbootrest.service.JobService.getJob(..)) && args(postId)"
	 * - `execution(...)`: The standard pointcut to match the 'getJob' method.
	 * - `&& args(postId)`: This is an argument binding expression. It tells Spring to bind
	 * the first argument of the matched method to the `postId` parameter of this advice method.
	 * This allows you to access and modify the argument directly.
	 *
	 * The `ProceedingJoinPoint` object is used to control the execution of the original method.
	 */
	@Around("execution(* com.learning.springbootrest.service.JobService.getJob(..)) && args(postId)")
	public Object updateAndValidate(ProceedingJoinPoint jp, int postId) throws Throwable {
		
		// Logic to run BEFORE the original method
		// In this case, we validate and modify the incoming `postId` argument.
		if (postId < 0) {
			logger.info("Post ID is negative: " + postId);
			postId = Math.abs(postId); // Use Math.abs for clarity
			logger.info("Updated Post ID to: " + postId);
		}
		
		// Execute the original method with the (potentially) modified argument.
		// `jp.proceed(new Object[] {postId})` passes the updated 'postId'
		// back into the original method.
		Object obj = jp.proceed(new Object[] {postId});
		
		// Logic to run AFTER the original method
		// ... (can be added here if needed)
		
		// Return the result of the original method
		return obj;
	}
}
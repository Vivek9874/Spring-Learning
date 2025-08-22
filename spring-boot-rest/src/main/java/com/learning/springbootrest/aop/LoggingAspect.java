package com.learning.springbootrest.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {
	
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class) ; 
	public void logMethodCall() {
		logger.info("Method called");
	}

}

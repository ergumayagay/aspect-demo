package com.emil.demo;

import javax.persistence.EntityNotFoundException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

@Component
@Aspect
public class EmployeeAspect {

	
	private static Logger log = (Logger) LoggerFactory.getLogger("employee");
	
	/*
	 * Execute after each method included in Employee Service class
	 */
	@Before(value="this(com.emil.demo.EmployeeService)")
	public void logBeforeEmployeeService(JoinPoint joinPoint ) {
		log.info("Called: "+joinPoint.getSignature());
	}
	
	
	/*
	 * Execute after each method inlcuded in EmployeeService class
	 */
	@AfterReturning(value="this(com.emil.demo.EmployeeService)",returning="returnValue")
	public void logAfterEmployeTransaction(JoinPoint joinPoint,Object returnValue) {
		log.info(joinPoint.getSignature()+"returned "+returnValue.toString());
	}
	
	/*
	 * Executed after EntityNotFoundException
	 */
	@AfterThrowing(pointcut="execution(* com.emil.demo.EmployeeService.getEmployee(..))", throwing="e")
	public void logAfterException(EntityNotFoundException e) {
		log.error(e.getMessage());
	}
	
}

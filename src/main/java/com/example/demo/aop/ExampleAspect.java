package com.example.demo.aop;

import java.util.LinkedHashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.FundUserLogService;
import com.example.demo.LogDto;

@Aspect
@Component
public class ExampleAspect {
	@Autowired
	FundUserLogService fundUserLogService;
//	@Around("@annotation(LogCreator)")
//	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//		long start = System.currentTimeMillis();
//	    Object proceed = joinPoint.proceed();
//	    long executionTime = System.currentTimeMillis() - start;
//	    System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
//	    return proceed;
//	}
//	@After("@annotation(LogCreator)&& args(req,..)")
//	public void logExecutionTime(JoinPoint joinPoint,Object req) throws Throwable {
//		long start = System.currentTimeMillis();
//	    long executionTime = System.currentTimeMillis() - start;
//	    LinkedHashMap<String, Object> req1=(LinkedHashMap<String, Object>) req;
//	    LogDto log=new LogDto();
//		log.setScreenType(req1.get("screenType").toString());
//		log.setAction(req1.get("action").toString());
//		log.setSno(req1.get("sno").toString());
//		log.setUuid(req1.get("uuid").toString());
//		log.setLog(req1.get("log").toString());
//	    fundUserLogService.save(log);
//	    System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
//	}
	
	@AfterReturning("@annotation(LogCreator)&& args(req,..)")
	public void logExecutionTime(JoinPoint joinPoint,Object req) throws Throwable {
		long start = System.currentTimeMillis();
	    long executionTime = System.currentTimeMillis() - start;
	    @SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> req1=(LinkedHashMap<String, Object>) req;
	    LogDto log=new LogDto();
		log.setScreenType(req1.get("screenType").toString());
		log.setAction(req1.get("action").toString());
		log.setSno(req1.get("sno").toString());
		log.setUuid(req1.get("uuid").toString());
		log.setLog(req1.get("log").toString());
	    fundUserLogService.save(log);
	    System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
	}
}
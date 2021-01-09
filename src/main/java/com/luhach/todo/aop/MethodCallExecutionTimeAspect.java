package com.luhach.todo.aop;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodCallExecutionTimeAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    //Defines a new annotation that can be used to calculate the time taken a method
    @Around("@annotation(com.luhach.todo.aop.TrackTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();

        Object returnValue = joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time taken by {} is {}.", joinPoint, timeTaken);
        return returnValue;
    } 
}

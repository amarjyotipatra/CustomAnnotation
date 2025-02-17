package com.example.customannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(TimeMonitor)")
    public void logtime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis(); //start time of code
        //execute join point

        long endTime = System.currentTimeMillis();
        long totalExecutionTime = endTime - startTime;
        System.out.println("Total execution time: " + totalExecutionTime + "ms.");
    }
}

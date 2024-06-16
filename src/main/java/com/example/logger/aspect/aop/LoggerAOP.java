package com.example.logger.aspect.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggerAOP {

    @Before("execution(* com.example..*(..))")
    public void logMethodInputs(JoinPoint joinPoint) {
        log.info("Logging method inputs for class: " + joinPoint.getTarget().getClass().getName() +
                ", method: " + joinPoint.getSignature().getName() + " with args: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "execution(* com.example..*(..))", returning = "result")
    public void logMethodOutputs(JoinPoint joinPoint, Object result) {
        log.info("Logging method outputs for class: " + joinPoint.getTarget().getClass().getName() +
                ", method: " + joinPoint.getSignature().getName() + " with result: " + result);
    }
}
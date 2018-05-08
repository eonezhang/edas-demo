package com.haiker.services.spring.poc;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author eonezhang 04/05/2018
 */
@Aspect
@Component
public class AopAspect {
    @Around("@annotation(org.springframework.transaction.annotation.Transactional)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }
}

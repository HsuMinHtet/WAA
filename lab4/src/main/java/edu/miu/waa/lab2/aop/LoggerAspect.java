package edu.miu.waa.lab2.aop;
import edu.miu.waa.lab2.service.LoggerService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;


@Aspect
@Component
@RequiredArgsConstructor
public class LoggerAspect {

    private final LoggerService loggerService;

     //This point cut will execute where ever the annotation is placed
    @Pointcut("@annotation(edu.miu.waa.lab2.aop.annotation.LogMe)")
    public void logMeAnnotation(){}

    // This point cut will execute according to the given designations
    @Pointcut("execution( * edu.miu.waa.lab2.controller.*.*(..))")
    public void logMe() {
    }

    @After("logMe()")
    public void logAfter(JoinPoint joinPoint) {
        loggerService.logOperation("Admin", joinPoint.getSignature().getName(), LocalDate.now(), LocalTime.now());
    }

    @AfterThrowing(pointcut ="execution( * edu.miu.waa.lab2.service.impl.*.*(..))", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Exception e) {
        loggerService.logException("Admin", joinPoint.getSignature().getName(),e.getClass().getSimpleName(), LocalDate.now(), LocalTime.now());
    }

}

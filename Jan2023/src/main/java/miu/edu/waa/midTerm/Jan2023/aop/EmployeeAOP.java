package miu.edu.waa.midTerm.Jan2023.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAOP {
    @Pointcut("@annotation(miu.edu.waa.midTerm.Jan2023.aop.annotation.Alert)")
    public void alertAnnotation(){}

    @After("alertAnnotation()")
    public void sendAlert(JoinPoint joinPoint){
        System.out.println("Here from AOP"+joinPoint.getSignature().getName());
    }

}

package miu.edu.waa.Jun_2023.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CoordinatorAOP {
    @Pointcut("@annotation(miu.edu.waa.Jun_2023.aop.annotation.Confirm)")
    public void confirmAnnotation(){}

    @After("confirmAnnotation()")
    public void confirmation(JoinPoint joinPoint){
        System.out.println("JoinPoint"+ joinPoint.getSignature().getName());
    }
}

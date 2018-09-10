package com.xuele.net.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by GaoQingming on 2018/9/10 0010.
 */
@Component
@Aspect
public class MyAopTest2 {

    @Pointcut("execution(* com.xuele.net.service.TempService.*(..))")
    public void pointCut(){}

    /**
     *
     * IllegalArgumentException: ProceedingJoinPoint is only supported for around advice
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "pointCut()")
    public Object handleAop(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("myAOPTest222222222 around come");
        Object object = joinPoint.proceed(joinPoint.getArgs());
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        if (object == null) return object;

        if (method != null && method.getAnnotation(MyAnnotationTest.class) != null) {
        }
        return object;
    }

}

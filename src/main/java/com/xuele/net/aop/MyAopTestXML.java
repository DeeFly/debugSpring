package com.xuele.net.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * Created by GaoQingming on 2018/9/10 0010.
 */
public class MyAopTestXML {
    public Object handleAop(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("myAOPTestXMLXMLXML around come");
        Object object = joinPoint.proceed(joinPoint.getArgs());
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        if (object == null) return object;

        if (method != null && method.getAnnotation(MyAnnotationTest.class) != null) {
        }
        System.out.println("myAOPTestXMLXMLXML around end");
        return object;
    }
}

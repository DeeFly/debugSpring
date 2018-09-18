package com.xuele.net.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by GaoQingming on 2017/9/8 0008.
 */
@Component
@Aspect
public class MyAopTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(* com.xuele.net.service..get*(..))")
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
        logger.info("myAOPTest around come");
        Object object = joinPoint.proceed(joinPoint.getArgs());
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        if (object == null) return object;

        if (method != null && method.getAnnotation(MyAnnotationTest.class) != null) {
            object = (Integer) object + new Integer(2);
        }
        logger.info("myAOPTest around end");
        return object;
    }

    @Before(value = "pointCut()")
    public Object beforeInvoke(JoinPoint point) throws Throwable {
        logger.info("myAOPTest come before invoke");
        return null;
    }

    @After(value = "pointCut()")
    public Object afterInvoke(JoinPoint point) throws Throwable {
        logger.info("myAOPTest come after invoke");
        return null;
    }

    @AfterReturning(value = "pointCut()",returning="returnValue")
    public Object afterReturning(JoinPoint point, Object returnValue) throws Throwable {
        logger.info("myAOPTest come afterReturning invoke");
        return returnValue;
    }
}

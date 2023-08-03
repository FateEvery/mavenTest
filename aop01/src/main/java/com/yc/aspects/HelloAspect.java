package com.yc.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-01 11:48
 */
@Component
@Aspect
@Order(value = 1)
public class HelloAspect {
    @Pointcut("execution(* com.yc.biz.*.findPid(..))")
    private void a() {
    }

    @Around("a()")
    public Object show(ProceedingJoinPoint pjp) {
        System.out.println(" HelloAspect 的show 的前面");
        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(" HelloAspect 的 show 的后面");
        return obj;
    }
}

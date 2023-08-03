package com.yc.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-01 11:52
 */
@Component
@Aspect
//@Order(1)
public class ByeAspect implements Ordered {
    @Pointcut("execution(* com.yc.biz.*.findPid(..))")
    private void a() {
    }

    @Around("a()")
    public Object show(ProceedingJoinPoint pjp) {
        System.out.println(" ByeAspect 的show 的前面");
        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(" ByeAspect 的 show 的后面");
        return obj;
    }


    @Override
    public int getOrder() {
        return 100;
    }
}

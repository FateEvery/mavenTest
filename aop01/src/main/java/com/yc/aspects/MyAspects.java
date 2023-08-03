package com.yc.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-01 09:08
 */
//@Component
//@Aspect
public class MyAspects {

    //切入点表达式  : 正则表达式  筛选 目标类中哪些方法加增强
    //* :
    // .. : 代表 0 或 n
    @Pointcut("execution(* com.yc.biz.*.make*(..))")
    private void a() {
    }

    //    @Before("execution(* com.yc.biz.*.make*(..))")  与下面的方法是一样的
    @Before("a()")
    public void recordTime() {
        Date d = new Date();
        System.out.println("=============下单的时间:" + d);
    }

    @AfterReturning("a()")
    public void sendEmail() {
        System.out.println("调用数据库查询此下单用户的Email，包装信息 ，发送消息中间件 kafa/mq .");
    }

    @AfterReturning("a()")
    public void recordParams(JoinPoint jp) {  //记录连接点 make*() 中的参数信息  make*() 就称为 JoinPoint
        //从 jp 中可以取出 一些 信息 make*() 方法的信息
        System.out.println("增强的方法为:" + jp.getSignature());
        System.out.println("增强的目标类为:" + jp.getTarget());
        System.out.println("参数:");
        Object[] obj = jp.getArgs();
        for (Object ob : obj) {
            System.out.println(ob);
        }
    }


    @Pointcut("execution(* com.yc.biz.*.findORderId(String))")
    private void b() {
    }

    private Map<String, Long> map = new ConcurrentHashMap<>();

    @AfterReturning("b()")
    //统计每个商品被查询的次数
    public void recordPnameCount(JoinPoint jp) {
        Object[] objs = jp.getArgs();
        String pname = (String) objs[0];
        Long num = 1L;
        if (map.containsKey(pname)) {
            num = map.get(pname);
            num++;
        }
        map.put(pname, num);
        System.out.println("统计结果:" + map);
    }


    @Pointcut("execution(* com.yc.biz.*.findPid(String))")
    private void c() {
    }

    private Map<String, Long> map2 = new ConcurrentHashMap<>();

    @AfterReturning(pointcut = "c()", returning = "retVal")
    //统计每个 商品名 对 编号 被查询的次数
    public void recordPnameCount2(JoinPoint jp, int retVal) {
        Object[] objs = jp.getArgs();
        String pname = (String) objs[0];
        Long num = 1L;
        if (map2.containsKey(pname)) {
            num = map2.get(pname);
            num++;
        }
        map2.put(pname + ":" + retVal, num);
        System.out.println("统计结果:" + map2);
    }

    @AfterThrowing(value = "a()", throwing = "ex")
    public void recordException(JoinPoint jp, RuntimeException ex) { //由 spring 容器 将捕捉到的异常传入
        System.out.println("***************");
        System.out.println(ex.getMessage());
        System.out.println(jp.getArgs()[0] + "\t" + jp.getArgs()[1]);
        System.out.println("***************");

    }

    @Pointcut("execution(* com.yc.biz.*.find*(String))")
    private void d() {
    }

    @Around("d()")
    public Object doBasicProFiling(ProceedingJoinPoint pjp) throws Throwable { //pjp 就是被调用的 find*()
        long start = System.currentTimeMillis();
        Object retVal = pjp.proceed(); // 返回值 find*()
//        Thread.sleep(1);
        long end = System.currentTimeMillis();
        System.out.println("方法执行时间长为 :" + (end - start));
        return retVal;
    }

}

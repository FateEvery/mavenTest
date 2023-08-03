package com.yc.spring.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 10:22
 */
public class TestMain {
    public static void main(String[] args) {
        //AnnotationConfigApplicationContext基于注解@Configuration的配置类
        //IOC完成 DI完成
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Apple apple = (Apple) ac.getBean("a");
        System.out.println(apple);
    }
}

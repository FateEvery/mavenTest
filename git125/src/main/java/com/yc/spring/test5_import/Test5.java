package com.yc.spring.test5_import;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 15:24
 */
public class Test5 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig_Test5.class);
        String[] bname = ac.getBeanDefinitionNames();
        for (String bn : bname) {
            System.out.println(bn);
        }

        Banana b1 = (Banana) ac.getBean("com.yc.spring.test5_import.Banana");
        System.out.println(b1);

        //beanid 的名字太长 不好取
        //解决方案一： 根据反射创建对象获取
        Banana b2 = (Banana) ac.getBean(Banana.class);
        System.out.println(b2);
    }
}

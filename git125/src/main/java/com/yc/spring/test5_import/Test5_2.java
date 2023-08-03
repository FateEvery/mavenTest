package com.yc.spring.test5_import;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 15:41
 */
public class Test5_2 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig2.class);
        String[] bnames = ac.getBeanDefinitionNames();
        for (String bn : bnames) {
            System.out.println(bn);
        }
    }
}

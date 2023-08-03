package com.yc.spring.test5_import;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 16:03
 */
@Configuration
//                      Pear类                       Grape 类 （只有Pear类托管了 Grape才会被托管）
@Import({Banana.class, FruitImportSelector.class, FruitNameImportBeanDefinitionRegistar.class})
public class AppConfig3 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig3.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String bn : names) {
            System.out.println(bn);
        }
    }
}

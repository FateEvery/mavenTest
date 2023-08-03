package com.yc.spring.test4_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 14:47
 */
public class Test4 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig_Test4.class);

        ProductBiz pb = (ProductBiz) ac.getBean("productBizImpl");  //beanid的规定 类名的首字母小写
        pb.takein();
    }
}

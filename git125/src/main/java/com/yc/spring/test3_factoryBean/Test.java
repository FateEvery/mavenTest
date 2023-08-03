package com.yc.spring.test3_factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: mavenProject
 * @description: 测试FactoryBean 的使用
 * @author: Joker
 * @create: 2023-07-26 11:13
 */
public class Test {
    public static void main(String[] args) {
        //1.创建容器
        //容器启动 FruitFactorBean pear
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigTest3.class);
        Object obj = ac.getBean("ffb"); // beanid ffb -> Pear 产品对象
        System.out.println(obj.hashCode());

        Object obj2 = ac.getBean("&ffb"); // beanid: &ffb -> 工厂 bean
        System.out.println(obj2);

        //2.pear是单例还是多例
        //根据 FruitFactorBean 里的 isSingleton 决定 false -》多例 ture->单例
        obj = ac.getBean("ffb"); // beanid ffb -> Pear 产品对象
        System.out.println(obj.hashCode());

        //3.获取 spring 容器中所有被托管的bean
        String[] beanNames = ac.getBeanDefinitionNames();
        for (String bn : beanNames) {
            System.out.println(bn);
        }
    }
}

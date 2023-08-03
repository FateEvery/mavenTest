package com.yc.spring.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: mavenProject
 * @description: 测试什么是IOC
 * @author: Joker
 * @create: 2023-07-25 20:05
 */
public class Test01 {
    public static void main(String[] args) {
        //1.早期的程序
//        Student s = new Student();
//        s.setId(1);
//        s.setName("张三");
//        System.out.println(s.toString());

        //小结  这是控制不反转 程序来创建对象 
        //缺点 Test1依赖 与 Student 类

        //2.引入Spring 的 IOC机制
        //IOC 控制反转 由spring 来创建 Student 对象
        //ClassPathXmlApplicationContext 类路径下
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //上面这句代码：启动容器 读取类路径下的beans.xml文件 并 获取bean 配置的实例化对象存到容器中
        //FileSystemXmlApplicationContext 需要指定全路径
        //ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");

        //3.
//        Resource res = new ClassPathResource("beans.xml");
//        BeanFactory factory = new XmlBeanFactory(res);


        Student ss = (Student) context.getBean("s");
        System.out.println(ss);


        //容器的好处 ：容器来管理bean 比如单例
//        Student s1 = (Student) context.getBean("s");
//        Student s2 = (Student) context.getBean("s");
//        System.out.println(s1.hashCode() + "\t" + s2.hashCode());

        //TODO 让属性有值 -> DI ->Dependency injection 依赖注入

    }
}

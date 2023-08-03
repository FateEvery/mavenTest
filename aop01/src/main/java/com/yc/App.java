package com.yc;

import com.yc.biz.OrderBiz;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-01 08:56
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        OrderBiz ob = ac.getBean(OrderBiz.class);
//        ob.makeOrder(1, 99);
//        ob.findOrderId("apple");
//        ob.findOrderId("apple");
//        ob.findOrderId("banana");

        ob.findPid("apple");
//        ob.findPid("apple");
//        ob.findPid("pear");


    }
}

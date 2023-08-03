package com.yc.staticproxy;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-01 18:54
 */
public class Test {
    public static void main(String[] args) {
        OrderBiz orderBiz = new StaticProxy(new OrderBizImpl());
        orderBiz.addOrder(1, 10);
    }
}

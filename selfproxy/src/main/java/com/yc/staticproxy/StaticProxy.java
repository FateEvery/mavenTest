package com.yc.staticproxy;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-01 18:53
 */
public class StaticProxy implements OrderBiz {

    private OrderBiz orderBiz;

    public StaticProxy(OrderBiz orderBiz) {
        this.orderBiz = orderBiz;
    }

    @Override
    public void addOrder(int pid, int num) {
        //前置增强
        showHello();
        this.orderBiz.addOrder(pid, num);
        //后置增强
        showBye();
    }

    @Override
    public void findOrder() {

    }

    //增强
    public void showHello() {
        System.out.println("hello");
    }

    //增强
    public void showBye() {
        System.out.println("bye");
    }


}

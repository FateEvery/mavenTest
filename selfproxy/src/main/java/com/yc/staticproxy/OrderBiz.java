package com.yc.staticproxy;

/**
 * @program: mavenProject
 * @description: 抽象主题
 * @author: Joker
 * @create: 2023-08-01 18:53
 */
public interface OrderBiz {
    void addOrder(int pid, int num);

    void findOrder();
}

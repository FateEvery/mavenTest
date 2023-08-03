package com.yc.biz;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-01 08:52
 */
public interface OrderBiz {
    public void makeOrder(int pid, int num);

    public int findOrderId(String pname);

    public int findPid(String pname);


}

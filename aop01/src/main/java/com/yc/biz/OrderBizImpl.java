package com.yc.biz;

import org.springframework.stereotype.Service;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-01 08:53
 */
@Service
public class OrderBizImpl implements OrderBiz {
    @Override
    public void makeOrder(int pid, int num) {
        if (num > 5) {
            throw new RuntimeException("库存数量不足.......");
        }
        System.out.println("makeOrder 的调用: 下订:" + pid + "\t" + num);
    }

    @Override
    public int findOrderId(String pname) {
        System.out.println("findOrderId 根据商品名:" + pname + "\t" + "查找商品对应的订单号:");
        return 2;
    }

    @Override
    public int findPid(String pname) {
        System.out.println("findPid 根据商品名:" + pname + "\t" + "查找商品对应的商品号:");
        return (int) (Math.random() * 10);
    }
}

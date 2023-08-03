package com.yc.jdkproxy;

import com.yc.staticproxy.OrderBiz;
import com.yc.staticproxy.OrderBizImpl;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-01 19:24
 */
public class Test2 {
    public static void main(String[] args) {
        //设置代理生成的字节码 保存到当前目录
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        JdkProxyTool jpt = new JdkProxyTool(new OrderBizImpl());
        OrderBiz ob = (OrderBiz) jpt.createProxy();
//        System.out.println("生成代理类对象:" + ob.toString());  //com.yc.staticproxy.OrderBizImpl@49476842

        ob.findOrder();
        ob.addOrder(1, 99);
    }
}

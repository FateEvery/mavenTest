package com.yc.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-01 19:18
 */
public class JdkProxyTool implements InvocationHandler {
    //目标类
    private Object target;

    public JdkProxyTool(Object target) {
        this.target = target;
    }

    //生成代理对象的方法
    public Object createProxy() {
        Object proxy = Proxy.newProxyInstance(JdkProxyTool.class.getClassLoader(),
                target.getClass().getInterfaces(),
                this);
        return proxy;
    }

    //当在主程序中调用生成的Proxy中的方法 会自动回调 invoke() 在这个invoke() 加入增强 切面这些功能
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //以反射的方式读取下面的 @Pointcut 中的 切入点表达式  => 在spring 底层 用 aspectj 来读取其表达式
        if (method.getName().startsWith("add")) {
            showHello(); //加入前置增强
        }
        Object returnValue = method.invoke(target, args);//调用目标类的方法
        return returnValue;
    }

    public void showHello() {
        System.out.println("hello");
    }
}

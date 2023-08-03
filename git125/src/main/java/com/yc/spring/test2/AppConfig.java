package com.yc.spring.test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 10:18
 */
@Configuration  //此注解表示一个配置类  相当于beans.xml
public class AppConfig {
    @Bean // <bean id="a" class="com.yc.spring.test2.Apple">
    public Apple a() {
        Apple apple = new Apple();
        apple.setId(100);
        return apple;
    }

    //apple 对象 以 a为键名 存到 ApplicationContext容器中
}

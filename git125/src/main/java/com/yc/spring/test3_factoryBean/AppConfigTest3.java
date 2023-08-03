package com.yc.spring.test3_factoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 11:12
 */
@Configuration //配置类
public class AppConfigTest3 {

    @Bean
    public FruitFactorBean ffb() {
        return new FruitFactorBean();
    }
}

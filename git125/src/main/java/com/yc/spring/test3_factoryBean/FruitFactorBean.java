package com.yc.spring.test3_factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 11:06
 */
public class FruitFactorBean implements FactoryBean<Pear> {

    public FruitFactorBean() {
        System.out.println("FruitFactorBean 构造");
    }

    @Override
    public Pear getObject() throws Exception {
        return new Pear();
    }

    @Override
    public Class<?> getObjectType() {
        return Pear.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

package com.yc.spring.test4_annotation;

import org.springframework.stereotype.Repository;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 14:23
 */
@Repository  //表明这个类被spring托管 这个类是一个dao层的类 s.pring 会把 异常 转为 RuntimeException
public class ProductMybatisDaoImpl implements ProductDao {

    public ProductMybatisDaoImpl() {
        System.out.println("ProductMybatisDaoImpl 的 构造方法");
    }

    @Override
    public void add() {
        System.out.println("ProductMybatisDaoImpl 的add()");
    }

    @Override
    public void find() {
        System.out.println("ProductMybatisDaoImpl 的find()");

    }

    @Override
    public void update() {
        System.out.println("ProductMybatisDaoImpl 的update()");
    }
}

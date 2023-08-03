package com.yc.dao;

import org.ycframework.annotation.YcRepository;
import org.ycframework.annotation.YcScope;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-27 15:54
 */
@YcRepository
//@YcLazy
@YcScope(value = "prototype")
public class UserDaoImpl implements UserDao {
    @Override
    public void add(String uname) {
        System.out.println("dao添加了:" + uname);
    }
}

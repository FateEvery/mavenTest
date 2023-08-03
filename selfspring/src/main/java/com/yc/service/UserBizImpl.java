package com.yc.service;

import com.yc.dao.UserDao;
import org.ycframework.annotation.YcResource;
import org.ycframework.annotation.YcService;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-27 15:56
 */
@YcService("ub")
//@YcLazy
public class UserBizImpl implements UserBiz {

    @YcResource(name = "userDaoImpl")
    private UserDao userDao;

    @Override
    public void add(String uname) {
        userDao.add(uname);
    }
}

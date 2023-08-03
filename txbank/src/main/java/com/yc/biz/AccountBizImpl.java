package com.yc.biz;

import org.springframework.stereotype.Service;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-02 14:15
 */
@Service
public class AccountBizImpl implements AccountBiz {


    @Override
    public void addAccount(int accountid, double money) {
        System.out.println("添加账户:" + accountid);
    }
}

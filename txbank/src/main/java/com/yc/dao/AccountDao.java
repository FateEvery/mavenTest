package com.yc.dao;

import com.yc.bean.Account;

import java.util.List;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-03 11:18
 */
public interface AccountDao {

    public int insert(double money);

    public void update(int accountid,double money);

    public void delete(int accountid);

    public int findCount();

    public List<Account> findAll();


    public Account findById(int accountid);
}

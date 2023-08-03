package com.yc;

import com.yc.biz.AccountBiz;
import com.yc.configs.Config;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-02 14:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
@Log4j2
public class Test01 {

    @Autowired
    private AccountBiz accountBiz;

    @Test
    public void testAddAccount() {
        log.info("hello");
        accountBiz.addAccount(1, 99);
    }
}

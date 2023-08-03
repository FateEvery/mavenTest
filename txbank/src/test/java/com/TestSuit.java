package com;

import com.yc.Test01;
import com.yc.Test02_DataSourceConfig;
import com.yc.dao.AccountDaoJdbcTemplateImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)  //测试套件
@Suite.SuiteClasses({Test01.class, Test02_DataSourceConfig.class, AccountDaoJdbcTemplateImplTest.class})
public class TestSuit {
}

package com.yc;

import com.alibaba.druid.pool.DruidDataSource;
import com.yc.configs.Config;
import com.yc.configs.DataSourceConfig;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-02 18:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class, DataSourceConfig.class})
@Log4j2
public class Test02_DataSourceConfig {

    @Autowired
    private DataSourceConfig dsc;
    @Autowired
    private Environment env;

    @Autowired
    @Qualifier("dataSource")
    private DataSource ds;

    @Autowired
    @Qualifier("dbcpDataSource")
    private DataSource dbcpDataSource;

    @Autowired
    @Qualifier("druidDataSource")
    private DataSource druidDataSource;

    @Test
    public void testDruidDataSource() throws SQLException {
        Assert.assertNotNull(druidDataSource.getConnection());
        Connection con = druidDataSource.getConnection();
        log.info(con + "\t" + ((DruidDataSource) druidDataSource).getInitialSize());
    }

    @Test
    public void testDsConnection() throws SQLException {
        Assert.assertNotNull(ds.getConnection());
        Connection con = ds.getConnection();
        log.info(con);
    }

    @Test
    public void testDbcpDataSource() throws SQLException {
        Assert.assertNotNull(dbcpDataSource.getConnection());
        Connection con = dbcpDataSource.getConnection();
        log.info(con);
    }

    @Test
    public void testPropertySource() {
        Assert.assertEquals("root", dsc.getUsername());
        log.info(dsc.getUsername());
    }

    @Test
    public void testEnvironment() {
        log.info(env.getProperty("jdbc.password") + "\t" + env.getProperty("user.home"));
    }

}

package com.yc.configs;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-02 15:23
 */
@Configuration
@PropertySource("classpath:db.properties")
@Log4j2
@Data //lombok 创建 get/set
public class DataSourceConfig {
    //利用 DI 注入 值
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driverclass}")
    private String driverclass;
    //以上属性从db.properties 中取出后 存到了 spring 容器的 Environment 的变量 （系统环境变量也存储在这）

    @Value("#{ T(Runtime).getRuntime().availableProcessors()*2}")
    private int cpuCount;

    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource druidDataSource() {
        DruidDataSource dds = new DruidDataSource();
        dds.setUrl(url);
        dds.setUsername(username);
        dds.setPassword(password);
        dds.setDriverClassName(driverclass);
        //以上只是设置了参数 并没有创建连接池 在这个init() 中完成了连接池的创建
        //当前主机的CPU * 2
//        int cpuCount = Runtime.getRuntime().availableProcessors() * 2;
        log.info("配置druid的连接池大小 :" + cpuCount);
        dds.setInitialSize(cpuCount);
        dds.setMaxActive(cpuCount * 2);
        return dds;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverclass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DataSource dbcpDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverclass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}



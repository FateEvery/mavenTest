package com.yc.spring.test4_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.yc.spring.test4_annotation") //指定spring容器扫描类的路径
public class AppConfig_Test4 {
}

package com.yc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-01 08:55
 */
@Configuration
@ComponentScan(basePackages = "com.yc")
@EnableAspectJAutoProxy //表示启用 Aspectj支持
public class Config {
}

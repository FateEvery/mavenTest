package com.yc.spring.test5_import;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 15:24
 */
@Configuration
@Import(Banana.class)
public class AppConfig_Test5 {
}

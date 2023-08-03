package com.yc.spring.test6_conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 16:14
 */
@Component
@Conditional({SystemCondition.class})
public class NetConnection {
}

package com.yc.spring.test6_conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 16:15
 */
public class SystemCondition implements Condition {
    /**
     * 匹配方法 ：看操作系统  <-  Environment    <-spring 容器
     * 回调方法 <-容器
     *
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();

        //系统变量 ：os.name=Windows
        //命令参数 ：os.name= Linux
        //程序  后一级会覆盖前一级
        String osname = env.getProperty("os.name");
        System.out.println(env.getProperty("user.dir"));
        System.out.println(env.getProperty("user.home"));
        if (osname.contains("Linux")) {
            return true;
        }
        return false;
    }
}

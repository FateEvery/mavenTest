package com.yc.spring.test5_import;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 15:50
 */

/**
 * 需求 :根据条件（是否已经加载好了Pear 判断是否加载 Grape 容器 且指定 beanid）
 */
public class FruitNameImportBeanDefinitionRegistar implements ImportBeanDefinitionRegistrar {
    /**
     * @param annotationMetadata     当前扫描的注解
     * @param beanDefinitionRegistry 已经注册好的bean的容器
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //先判断是否已经有了 类 加载到容器
        boolean bean = beanDefinitionRegistry.containsBeanDefinition("com.yc.spring.test3_factoryBean.Pear");
        //如果有 则在创建 Grape Bean加载到容器
        if (bean) {
            RootBeanDefinition d = new RootBeanDefinition(Grape.class);
            //并指定 键为 grape
            beanDefinitionRegistry.registerBeanDefinition("grape", d);
        }
    }
}

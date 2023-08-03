package com.yc.spring.test5_import;

import com.yc.spring.test3_factoryBean.Pear;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 15:39
 */
public class FruitImportSelector implements ImportSelector {
    @Override //回调
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Pear.class.getName()};
    }
}

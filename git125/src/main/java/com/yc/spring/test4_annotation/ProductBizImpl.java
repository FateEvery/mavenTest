package com.yc.spring.test4_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 14:33
 */
@Service  //此注解表明此类为业务层的类
public class ProductBizImpl implements ProductBiz {

    @Autowired //由spring自动从容器中取出一个Productdao的实现类的对象注入
    private ProductDao productDao; //业务层依赖dao层 但最好是依赖接口

    public ProductBizImpl() {
        System.out.println("ProductBizImpl 的构造方法");
    }

    @Override
    public void takein() {
        productDao.find();
        int i = 1;
        if (i == 1) {
            productDao.update();
        } else {
            productDao.add();
        }
    }
}

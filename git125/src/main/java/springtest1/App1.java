package springtest1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springtest1.biz.UserBiz;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 19:05
 */
public class App1 {
    public static void main(String[] args) {
        //首先创建容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        //容器中已经创建好这个类 键:"userDaoImpl" 值 :对象
//        UserDao ud = (UserDao) ac.getBean("userDaoImpl");
//        ud.add("张三");
        //取业务层的类
        UserBiz ub = (UserBiz) ac.getBean("userBizImpl");
        ub.add("李四");

    }
}

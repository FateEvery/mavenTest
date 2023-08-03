package springtest1.dao;

import org.springframework.stereotype.Repository;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-25 16:38
 */
@Repository
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("UserDaoImpl 的构造方法");
    }

    @Override
    public void add(String uname) {
        System.out.println("添加了:" + uname);
    }
}

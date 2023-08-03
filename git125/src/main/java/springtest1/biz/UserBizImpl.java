package springtest1.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springtest1.dao.UserDao;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 18:58
 */
@Service
public class UserBizImpl implements UserBiz {
    //将dao层对象注入到biz DI依赖注入  （将spring容器中托管的userDao对象传到此处）
//    @Resource(name = "usreDaoImpl") //由spring容器根据 id 名为 userDaoImpl到 容器中找到这个实例 并注入
    @Autowired  //根据类型完成注入 在spring 容器中  根据类型 UserDao 接口寻找实例
    @Qualifier("userDaoImpl")
    private UserDao userDao;

    public UserBizImpl() {
        System.out.println("UserBizImpl的构造方法");
    }

    @Override
    public void add(String uname) {
        userDao.add(uname);
    }
}

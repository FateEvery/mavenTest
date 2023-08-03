package springtest3.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import springtest3.system.ContainerFilter;

/**
 * @program: mavenProject
 * @description: bmi筛选器
 * @author: Joker
 * @create: 2023-07-26 09:39
 */
@Component("bmiFilter") // "bimFilter" 对象
public class StudentBmiFilter implements ContainerFilter {
    private Logger logger = LoggerFactory.getLogger(StudentBmiFilter.class);

    @Override
    public boolean doFilter(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        Student s = (Student) obj;
        if (s.getName() == null || "".equalsIgnoreCase(s.getName())) {
            return false;
        }
        if (s.getHeight() < 1 || s.getHeight() > 2.7) {
            logger.error("身高数据异常 " + obj.toString());
            return false;
        }
        if (s.getWeight() < 30 || s.getWeight() > 500) {
            logger.error("体重数据异常 " + obj.toString());
            return false;
        }
        return true;
    }
}

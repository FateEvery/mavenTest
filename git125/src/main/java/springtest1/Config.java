package springtest1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-25 16:40
 */
@Configuration  //此类是一个配置类 声明容器运行时的一些配置信息 (1.扫描的路径，这个路径所有带有@Component)
//sping 托管
@ComponentScan(basePackages = {"springtest1"})
public class Config {
}

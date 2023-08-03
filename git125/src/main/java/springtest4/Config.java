package springtest4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 18:14
 */
@Configuration
@ComponentScan
@PropertySource(value = "classpath:db.properties") //spring启动时 PropertySource 类扫描  classpath:db.properties
//以键值对存
public class Config {
}

package springtest4.user;

import lombok.Data;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 20:48
 */
@Data // lombok 注解需要安装插件
public class BankAccount {
    private int id;
    private double balance;
}

package com.yc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-03 11:09
 */
@Data
@AllArgsConstructor  //带有所有参数的构造方法
@NoArgsConstructor //无参数的构造方法
@ToString          // 生成tostring()
public class Account implements Serializable {
    private int accountid;
    private double money;
}

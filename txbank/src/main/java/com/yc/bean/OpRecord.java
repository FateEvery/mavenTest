package com.yc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-08-03 11:15
 */
@Data
@AllArgsConstructor  //带有所有参数的构造方法
@NoArgsConstructor //无参数的构造方法
@ToString
public class OpRecord {
    private int id;
    private int accountid;
    private double opmoney;
    private String optime;   //数据库是datetime 类型   在java中转为 String
    private OpType opType;  // Optype 类型
    private Integer transferid;
}

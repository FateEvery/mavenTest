package com.yc.spring.test3_factoryBean;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 11:06
 */
public class Pear {
    private int id;

    public Pear() {
        System.out.println("Pear 的构造");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pear{" +
                "id=" + id +
                '}';
    }
}

package com.yc.spring.test2;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 09:27
 */
public class Apple {
    private int id;

    public Apple() {
        System.out.println("Apple 的构造");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                '}';
    }
}

package com.yc.spring.test5_import;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 15:23
 */
public class Banana {
    private int id;

    public Banana() {
        System.out.println("Banana 的构造");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Banana{" +
                "id=" + id +
                '}';
    }
}

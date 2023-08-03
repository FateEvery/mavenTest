package com.yc.spring.test1;

/**
 * @program: mavenProject
 * @description: 地址类
 * @author: Joker
 * @create: 2023-07-25 20:47
 */
public class Address {
    private String province;
    private String city;

    public Address() {
        System.out.println("地址无参构造");
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

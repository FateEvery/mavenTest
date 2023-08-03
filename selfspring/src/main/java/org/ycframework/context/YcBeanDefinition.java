package org.ycframework.context;

/**
 * @program: mavenProject
 * @description: 对一个Bean的特征 的包装的类
 * 特征: scope(singleton/prototype/....)
 * lazy(true/false) 懒加载
 * priary : 主实例
 * @author: Joker
 * @create: 2023-07-27 17:08
 */
public class YcBeanDefinition {
    private boolean isLazy;
    private String scope = "singleton";
    private boolean isPrimary;

    private String classInfo; // 类的实例信息

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }
}

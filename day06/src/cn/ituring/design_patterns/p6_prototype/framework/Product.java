package cn.ituring.design_patterns.p6_prototype.framework;

/**
 * Prototype  原型
 * 负责定义用于复制现有的实例来生成新实例的方法
 */
public interface Product extends Cloneable{
    public abstract void use(String s);
    public abstract Product createClone();
}

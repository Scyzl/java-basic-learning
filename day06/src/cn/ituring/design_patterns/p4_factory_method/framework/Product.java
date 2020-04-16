package cn.ituring.design_patterns.p4_factory_method.framework;

/**
 * Product 产品
 * 属于框架一方，是一个抽象类，定义了在Factory Method模式中生成的那些实例所持有的接口(API)，
 * 但具体的处理由子类ConcreteProduct角色决定。
 */
public abstract class Product {
    public abstract void use();
}

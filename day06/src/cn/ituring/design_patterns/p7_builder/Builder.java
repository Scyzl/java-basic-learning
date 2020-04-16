package cn.ituring.design_patterns.p7_builder;

/**
 * Builder 建造者
 * 负责定义用于生成实例的接口(API)。
 */
public abstract class Builder {
    public abstract void makeTitle(String title);
    public abstract void makeString(String string);
    public abstract void makeItems(String[] items);
    public abstract void close();   // 完成文档编写
}

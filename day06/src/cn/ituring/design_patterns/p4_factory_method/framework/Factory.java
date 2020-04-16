package cn.ituring.design_patterns.p4_factory_method.framework;

/**
 * Creator 创建者
 * 属于框架一方，负责生成Product角色，但具体的处理由子类ConcreteCreator角色决定。
 */
public abstract class Factory {
    /**
     * 生成实例的方法。
     * @param owner IDCard的所有人
     * @return Product实例
     */
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);

    public final Product create(String owner) {
        // 不用 new 关键字来生成实例，而是调用生成实例的专用方法来生成实例，可以防止父类与其他具体类的耦合。
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }
}

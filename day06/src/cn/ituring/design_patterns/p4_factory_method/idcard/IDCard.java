package cn.ituring.design_patterns.p4_factory_method.idcard;

import cn.ituring.design_patterns.p4_factory_method.framework.Product;


/**
 * ConcreteProduct 具体的产品
 * 属于具体加工一方，决定了具体的产品。
 */
public class IDCard extends Product {
    private String owner;
    private String id;

    IDCard(String owner) {
        System.out.println("制作" + owner + "的ID卡。");
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public String getId() {
        return id;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "的ID卡。");
    }
}

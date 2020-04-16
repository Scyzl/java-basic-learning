package cn.ituring.design_patterns.p4_factory_method.idcard;

import cn.ituring.design_patterns.p4_factory_method.framework.Product;

public class IDCard2 extends Product {
    private String owner;
    private int id;

    IDCard2(String owner, int id) {
        System.out.println("制作" + owner + "(" + id + ")的ID卡。");
        this.owner = owner;
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public int getId() {
        return id;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "(" + id + ")的ID卡。");
    }
}

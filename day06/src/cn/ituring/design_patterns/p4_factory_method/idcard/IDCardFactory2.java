package cn.ituring.design_patterns.p4_factory_method.idcard;

import cn.ituring.design_patterns.p4_factory_method.framework.Factory;
import cn.ituring.design_patterns.p4_factory_method.framework.Product;

import java.util.HashMap;

public class IDCardFactory2 extends Factory {
    private HashMap database = new HashMap();
    private int id = 100;

    @Override
    protected synchronized Product createProduct(String owner) {
        return new IDCard2(owner, id++);
    }

    @Override
    protected void registerProduct(Product product) {
        IDCard2 card = (IDCard2) product;
        database.put(card.getId(), card.getOwner());
    }

    public HashMap getDatabase() {
        return database;
    }
}

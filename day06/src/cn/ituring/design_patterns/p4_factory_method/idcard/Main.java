package cn.ituring.design_patterns.p4_factory_method.idcard;

import cn.ituring.design_patterns.p4_factory_method.framework.Factory;
import cn.ituring.design_patterns.p4_factory_method.framework.Product;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory2();
        Product card1 = factory.create("小明");
        Product card2 = factory.create("小红");
        Product card3 = factory.create("小刚");

        card1.use();
        card2.use();
        card3.use();

    }
}

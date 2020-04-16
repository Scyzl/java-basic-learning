package cn.ituring.design_patterns.p6_prototype.instance;

import cn.ituring.design_patterns.p6_prototype.framework.Manager;
import cn.ituring.design_patterns.p6_prototype.framework.Product;

public class Main {
    public static void main(String[] args) {
        // 准备
        Manager manager = new Manager();
        UnderlinePen uPen = new UnderlinePen('~');
        MessageBox mBox = new MessageBox('*');
        MessageBox sBox = new MessageBox('/');
        manager.register("strong message", uPen);
        manager.register("warning box", mBox);
        manager.register("slash box", sBox);

        // 生成
        Product p1 = manager.create("strong message");
        p1.use("Hello Java!");
        Product p2 = manager.create("warning box");
        p2.use("Hello Python!");
        Product p3 = manager.create("slash box");
        p3.use("Hello World!");
    }
}

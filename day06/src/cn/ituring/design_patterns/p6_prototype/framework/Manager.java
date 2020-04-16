package cn.ituring.design_patterns.p6_prototype.framework;

import java.util.HashMap;

/**
 * Client  使用者
 * 负责使用复制实例的方法生成新的实例
 */
public class Manager {
    private HashMap showcase = new HashMap();

    public void register(String name, Product proto) {
        // 向hashMap中添加键值对
        showcase.put(name, proto);
    }

    /**
     * 根据ProtoName返回复制该实例得到的新实例
     * @param protoName 该实例（原型）的name
     * @return 复制该实例得到的新实例
     */
    public Product create(String protoName) {
        Product p = (Product) showcase.get(protoName);  // 从hashMap中获得实例
        return p.createClone();         // 返回通过实例复制得到的新实例
    }
}

/**
 *     在Product接口和Manager类中完全没有出现MessageBox类和UnderlinePen类的名字，
 * 这意味着我们可以独立的修改Product和Manager，不受MessageBox类和UnderlinePen类的影响。
 *     这是非常重要的，因为一旦在类中使用了别的类名，就意味着该类与其他类紧密地耦合在了一起。
 * 在Manager类中，并没有写明具体的类名，仅仅使用了Product这个接口名，也就是说，Product接口
 * 成为了连接Manager类与其他具体类之间的桥梁。
 */

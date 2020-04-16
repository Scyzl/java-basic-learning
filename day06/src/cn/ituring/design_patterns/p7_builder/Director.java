package cn.ituring.design_patterns.p7_builder;

/**
 * Director  监工
 * 负责使用Builder角色的接口来生成实例，
 * 它不依赖于ConcreteBuilder角色，只调用在Builder角色中定义的方法。
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("Greeting");
        builder.makeString("从早上至下午");
        builder.makeItems(new String[] {
                "早上好",
                "下午好",
        });
        builder.makeString("晚上");
        builder.makeItems(new String[] {
                "晚上好",
                "晚安",
                "再见",
        });

        builder.close();
    }
}

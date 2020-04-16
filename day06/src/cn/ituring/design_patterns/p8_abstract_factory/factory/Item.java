package cn.ituring.design_patterns.p8_abstract_factory.factory;

public abstract class Item {
    protected String caption;       // 项目的标题

    public Item(String caption) {
        this.caption = caption;
    }

    public abstract String makeHTML();
}

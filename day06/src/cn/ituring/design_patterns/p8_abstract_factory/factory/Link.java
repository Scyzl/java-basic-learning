package cn.ituring.design_patterns.p8_abstract_factory.factory;

import java.util.List;

public abstract class Link extends Item {
    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}

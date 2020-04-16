package cn.ituring.design_patterns.p8_abstract_factory.listfactory;

import cn.ituring.design_patterns.p8_abstract_factory.factory.Factory;
import cn.ituring.design_patterns.p8_abstract_factory.factory.Link;
import cn.ituring.design_patterns.p8_abstract_factory.factory.Page;
import cn.ituring.design_patterns.p8_abstract_factory.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link creatLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}

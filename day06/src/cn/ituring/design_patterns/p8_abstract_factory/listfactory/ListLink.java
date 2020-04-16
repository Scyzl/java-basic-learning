package cn.ituring.design_patterns.p8_abstract_factory.listfactory;

import cn.ituring.design_patterns.p8_abstract_factory.factory.Link;

public class ListLink extends Link {
    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "    <li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}

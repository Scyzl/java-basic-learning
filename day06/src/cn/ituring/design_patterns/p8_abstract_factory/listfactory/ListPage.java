package cn.ituring.design_patterns.p8_abstract_factory.listfactory;

import cn.ituring.design_patterns.p8_abstract_factory.factory.Item;
import cn.ituring.design_patterns.p8_abstract_factory.factory.Page;

import java.util.Iterator;

public class ListPage extends Page {
    public ListPage(String title, String name) {
        super(title, name);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head><title>" + title + "</title></head>\n");
        buffer.append("<body>\n");
        buffer.append("<h1>" + title + "</h1>\n");
        buffer.append("<u1>\n");
        Iterator it = content.iterator();
        while (it.hasNext()) {
            Item item = (Item) it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("<hr><address>" + author + "</address>");
        buffer.append("</body></html>\n");

        return buffer.toString();
    }
}

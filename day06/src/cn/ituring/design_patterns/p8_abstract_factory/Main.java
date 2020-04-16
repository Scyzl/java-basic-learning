package cn.ituring.design_patterns.p8_abstract_factory;

import cn.ituring.design_patterns.p8_abstract_factory.factory.Factory;
import cn.ituring.design_patterns.p8_abstract_factory.factory.Link;
import cn.ituring.design_patterns.p8_abstract_factory.factory.Page;
import cn.ituring.design_patterns.p8_abstract_factory.factory.Tray;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main listfactory.ListFactory");
            System.out.println("Example 2: java Main tablefactory.TableFactory");
            System.exit(0);
        }

//        Factory factory = Factory.getFactory("listfactory.ListFactory");
        Factory factory = Factory.getFactory(args[0]);

        Link people = factory.creatLink("人民日报", "http://www.people.com.cn/");
        Link gmw = factory.creatLink("光明日报", "http://www.gmw.cn/");

        Link us_yahoo = factory.creatLink("Yahoo", "http://www.yahoo.com/");
        Link jp_yahoo = factory.creatLink("Yahoo!Janpan", "http://www.yahoo.co/jp/");
        Link excite = factory.creatLink("Excite", "http://www.excite.com/");
        Link google = factory.creatLink("Google", "http://www.google.com/");

        Tray traynews = factory.createTray("日报");
        traynews.add(people);
        traynews.add(gmw);

        Tray trayYahoo = factory.createTray("Yahoo!");
        trayYahoo.add(us_yahoo);
        trayYahoo.add(jp_yahoo);

        Tray traySearch = factory.createTray("检索引擎");
        traySearch.add(trayYahoo);
        traySearch.add(excite);
        traySearch.add(google);

        Page page = factory.createPage("LinkPage", "Scy");
        page.add(traynews);
        page.add(traySearch);
        page.output();
    }
}

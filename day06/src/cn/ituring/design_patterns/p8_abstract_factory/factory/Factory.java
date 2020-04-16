package cn.ituring.design_patterns.p8_abstract_factory.factory;

public abstract class Factory {
    public static Factory getFactory(String classname) {
        Factory factory = null;

        try {
            factory = (Factory) Class.forName(classname).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return factory;
    }

    public abstract Link creatLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);
}

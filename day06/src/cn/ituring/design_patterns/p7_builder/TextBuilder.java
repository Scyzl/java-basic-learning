package cn.ituring.design_patterns.p7_builder;

/**
 * ConcreteBuilder 具体的建造者
 * 负责实现builder角色的接口的类，定义了在生成实例时实际被调用的方法。
 */
public class TextBuilder extends Builder {
    private StringBuffer buffer = new StringBuffer();   // 文档内容保存在该字段中

    @Override
    public void makeTitle(String title) {
        buffer.append("===========================\n");
        buffer.append("[" + title + "]\n");
        buffer.append('\n');
    }

    @Override
    public void makeString(String string) {
        buffer.append('$' + string + "\n");
        buffer.append('\n');
    }

    @Override
    public void makeItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            buffer.append("  ·" + items[i] + "\n");
        }
        buffer.append('\n');
    }

    @Override
    public void close() {
        buffer.append("=======================================\n");
    }

    public String getResult() {
        return buffer.toString();
    }
}

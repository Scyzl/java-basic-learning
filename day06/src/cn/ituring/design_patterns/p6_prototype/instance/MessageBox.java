package cn.ituring.design_patterns.p6_prototype.instance;

import cn.ituring.design_patterns.p6_prototype.framework.Product;

public class MessageBox implements Product {
    private char decoChar;

    public MessageBox(char decoChar) {
        this.decoChar = decoChar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decoChar);
        }
        System.out.println("");
        System.out.println(decoChar + " " + s + " " + decoChar);
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decoChar);
        }
        System.out.println("");
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}

/**
 * java.lang.Object.clone()
 *
 * 1、要想调用clone()方法，被复制的对象的类必须实现java.lang.Clonable接口；注意： 在Clonable接口中
 * 并没有声明任何方法，他只是被用来标记"可以使用clone方法进行复制"的。这样的接口称为标记接口。
 * 2、返回值是复制出的新的实例（clone方法内部所进行的处理是：分配与要复制的实例同样大小的内存空间，
 * 接着将要复制的实例中的字段的值复制到所分配的内存空间中去）
 * 3、clone方法的复制，只是将被复制实例的字段值直接复制到新的实例中（浅复制），换言之，
 * 它并没有考虑字段中所保存的实例的内容。例如，当字段中保存的是数组时，如果使用clone方法进行复制，
 * 则只会复制该数组的引用，并不会一一复制数组中的元素。
 */

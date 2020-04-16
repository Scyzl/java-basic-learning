package cn.itcast.day03.demo01;

public class Test implements TestInterface, TestInterface_1 {

    @Override
    public void test() {
        System.out.println(TestInterface.ID);
        System.out.println(TestInterface_1.ID);
    }

    @Override
    public void test1() {
        System.out.println("This is test1()");
    }

    public static void main(String[] args) {
        var t = new Test();
        t.test();
        t.test1();
    }
}

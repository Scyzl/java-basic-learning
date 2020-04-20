package cn.itcast.demo;

import cn.itcast.annotation.Check;

public class Calculator {
    private int a = 1;
    private int b = 0;

    @Check
    public void add() {
        int result = a + b;
        System.out.println("a + b = " + result);
        String name = null;
        System.out.println(name.toUpperCase());
    }

    @Check
    public void devide() {
        System.out.println("a / b = " + (a / b));
    }
}

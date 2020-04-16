package cn.itcast.day03.stackTrace;

import java.util.Scanner;

public class StackTraceTest {

    /**
     * @param n 求n的阶乘
     * @return  n！
     */
    public static int factorial(int n) {
        System.out.println("factorial(" + n + ") : " );
        var walker = StackWalker.getInstance();     // 得到一个StackWalker实例
        walker.forEach(System.out::println);        // 在每个栈帧上完成给定的动作，从最近调用的方法开始

        int r;
        if (n <= 1) {
            r = 1;
        } else {
            r = n * factorial(n - 1);
        }

        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args) {
        try (var in = new Scanner(System.in)){
            System.out.println("Enter n: ");
            int n = in.nextInt();
            factorial(n);
        }
    }
}

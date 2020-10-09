package com.scy.multithread.demo01;

/**
 * 创建线程方式2
 * @Author Scy
 * @Date 2020/10/8 9:43
 * @Version 1.0
 */
public class TestThread3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            System.out.println("szl，我爱你！");
        }
    }

    public static void main(String[] args) {
        TestThread3 thread3 = new TestThread3();
        new Thread(thread3).start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("I Love U");
        }
    }
}

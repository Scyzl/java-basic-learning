package com.scy.multithread.state;

/**
 * @Author Scy
 * @Date 2020/10/9 9:22
 * @Version 1.0
 */
public class TestYield {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();
    }

}

class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "-->停止执行");
    }
}

package com.scy.multithread.demo01;

/**
 * @Author Scy
 * @Date 2020/10/7 20:42
 * @Version 1.0
 */
public class TestThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看书--" + i);
        }
    }

    public static void main(String[] args) {
        // 创建一个线程对象
        TestThread testThread = new TestThread();
        // 调用start()方法开启线程
        testThread.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("我在学习多线程--" + i);
        }
    }
}

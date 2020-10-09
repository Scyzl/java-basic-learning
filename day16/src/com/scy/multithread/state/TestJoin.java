package com.scy.multithread.state;

/**
 * @Author Scy
 * @Date 2020/10/9 9:31
 * @Version 1.0
 */
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了。。。。。。。。。。");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        System.out.println(thread.getState());

        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                // 线程插队
                thread.join();
            }
            System.out.println("main  " + i);
        }
    }
}

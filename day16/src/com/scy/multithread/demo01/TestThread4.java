package com.scy.multithread.demo01;

/**
 * @Author Scy
 * @Date 2020/10/8 9:53
 * @Version 1.0
 */
public class TestThread4 implements Runnable{

    private int ticketsNum = 10;

    @Override
    public void run() {
        while (ticketsNum > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了第" + ticketsNum-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 thread4 = new TestThread4();

        new Thread(thread4, "scy").start();
        new Thread(thread4, "小明").start();
        new Thread(thread4, "黄牛").start();
    }
}

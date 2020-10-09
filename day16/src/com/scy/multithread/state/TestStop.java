package com.scy.multithread.state;

/**
 * @Author Scy
 * @Date 2020/10/9 8:47
 * @Version 1.0
 */
public class TestStop implements Runnable{

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run()正在执行  " + ++i);
        }
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            if (i == 900) {
                testStop.stop();
                System.out.println("==================end======================");
            }
            System.out.println("main()正在执行  " + i);
        }
    }

    private void stop() {
        this.flag = false;
    }
}

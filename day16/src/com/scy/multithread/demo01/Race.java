package com.scy.multithread.demo01;

/**
 * @Author Scy
 * @Date 2020/10/8 10:20
 * @Version 1.0
 */
public class Race implements Runnable {

    // 胜利者
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            // 判断比赛是否结束
            Boolean end = gameOver(i);
            // 比赛结束，终止程序
            if (end) {
                break;
            }

            if (Thread.currentThread().getName().equals("兔子") && i % 80 == 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "==>跑了" + i + "米");
        }
    }

    /**
     * 判断比赛是否结束
     * @param m 当前选手跑了多少米
     * @return boolean
     */
    private Boolean gameOver(int m) {
        if (winner != null) {
            return true;
        } else if (m >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("Winner is " + winner);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}

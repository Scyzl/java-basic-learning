package com.scy.multithread.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Scy
 * @Date 2020/10/9 9:00
 * @Version 1.0
 */
public class TestSleep {

    /**
     * 模拟倒计时
     * @param time 倒计时时长
     */
    public static void timeDown(int time) {
        while (time > 0) {
            try {
                Thread.sleep(1000);
                System.out.println(time--);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void currentTime() {
        // 获取当前系统时间
        Date startTime = new Date(System.currentTimeMillis());

        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        timeDown(10);
        currentTime();
    }
}


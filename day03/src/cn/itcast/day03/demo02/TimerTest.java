package cn.itcast.day03.demo02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;

public class TimerTest {
    public static void main(String[] args) {
        var listener = new TimerPrint();

        // construct a timer that calls the listener
        // once every second
        // 构造一个定时器，每经过delay ms 通知listener一次
        var timer = new Timer(1000, listener);
        timer.start();

        // keep program running until the user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit");
        System.exit(0);
    }

}

class TimerPrint implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
        // getDefaultToolkit() 获得默认工具箱； beep() 发出一声铃响
        Toolkit.getDefaultToolkit().beep();
    }
}

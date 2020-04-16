package cn.itcast.day05.simpleframe;

import javax.swing.*;
import java.awt.*;

public class SimpleFrameTest {
    public static void main(String[] args) {
        /**
         * 所有的Swing组件必须由事件分派线程(event dispatch thead)配置，这是控制线程，
         * 它将鼠标点击和按键的时间传递给用户接口组件。
         */
        EventQueue.invokeLater(() ->
                {
                    var frame = new SimpleFrame();
                    // 定义用户关闭窗体时的响应动作
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLocation(1000, 300);
                    frame.setTitle("SimpleFrameTest");
                    frame.setResizable(true);
                    // 仅仅只是构造窗体，窗体是不会显示出来的，需要调用setVisible方法
                    frame.setVisible(true);
                }
        );

        System.out.println("end...");
    }   // 初始化语句结束后，main方法退出，但退出main并没有终止程序，终止的只是主线程。
    // 事件分派线程会保持程序处于激活状态，直到关闭窗体或调用System.exit方法终止程序
}

class SimpleFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}

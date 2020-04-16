package cn.itcast.day05.showInfo;

import javax.swing.*;
import java.awt.*;

public class ShowInfo {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            var frame = new ShowInfoFrame();
            frame.setTitle("ShowInfo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocation(1000, 300);
            frame.setResizable(false);
            frame.setVisible(true);
        });
    }
}

class ShowInfoFrame extends JFrame {
    public ShowInfoFrame() {
        add(new ShowInfoComponent());
        pack();     // 在窗体中填入一个或多个组件时，如果只想使用他们的首选大小，可以调用pack方法，而不是setSize方法
//        setSize(500, 500);
    }
}

class ShowInfoComponent extends JComponent {
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g) {
        g.drawString("Not a Hello world program", MESSAGE_X, MESSAGE_Y);
    }

    /**
     * 组件要告诉用户它有多大
     * @return 返回一个有首选宽度和高度的Dimension类对象
     */
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}

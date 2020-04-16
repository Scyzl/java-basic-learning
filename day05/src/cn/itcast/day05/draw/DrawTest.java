package cn.itcast.day05.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Collections;

public class DrawTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            var frame = new DrawFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("DrawTest");
            frame.setVisible(true);
        });
    }
}

class DrawFrame extends JFrame {
    public DrawFrame() {
        add(new DrawComponent());
        pack();
//        setSize(800, 800);
    }

}

class DrawComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 500;

    // 画组件
    public void paintComponent(Graphics g) {
        var g2 = (Graphics2D) g;
        g2.setPaint(Color.red);
        g2.drawString("Warning", 100, 100);

        // draw a rectangle
        float leftX = 100;
        float topY = 100;
        float width = 200;
        float height = 150;

        var rect = new Rectangle2D.Float(leftX, topY, width, height);
        g2.draw(rect);
        g2.fill(rect);

        // draw the enclosed ellipse
        var ellipse = new Ellipse2D.Float();
        ellipse.setFrame(rect);
        g2.draw(ellipse);
        g2.setPaint(Color.BLUE);
        g2.fill(ellipse);

        // draw a diagonal line
        g2.draw(new Line2D.Float(leftX, topY, leftX + width, topY + height));

        // draw a circle with the same center
        float centerX = (float) rect.getCenterX();
        float centerY = (float) rect.getCenterY();
        float radius = 150;

        var circle = new Ellipse2D.Float();
        // cornerX, cornerY: coordinate of the specified corner point;即指定角点(圆上一点)的坐标
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        g2.draw(circle);
    }

    /**
     * 组件要告诉用户它有多大
     * @return 返回一个有首选宽度和高度的Dimension类对象
     */
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}

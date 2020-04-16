package cn.itcast.day05.font;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class FontTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            var frame = new FontFrame();
            frame.setTitle("FontFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class FontFrame extends JFrame {
    public FontFrame() {
        add(new FontComponent());
        pack();
    }
}

class FontComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 500;

    public void paintComponent(Graphics g) {
        var g2 = (Graphics2D) g;

        var message = "Szl, 你怎么这么好看！";

        var f = new Font("Serif", Font.BOLD, 36);
        g2.setFont(f);

        /**
         *如果要在PaintComponent方法外部计算布局大小，不能从Graphics2D对象得到字体绘制上下文。
         * 应该换作调用JComponent类的getFontMetrics方法，然后调用getFontRenderContext：
         * FontRenderContext context = getFontMetrics(f).getFontRenderContext();
         */
        // measure the size of the message
        // 得到表示屏幕设备字体属性的对象，可以直接将这个对象传递给Font类的getStringBounds方法
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(message, context);   // 返回包围字符串的矩形

        // set(x, y) = top left corner of text
        float x = (float) (getWidth() - bounds.getWidth()) / 2;
        float y = (float) (getHeight() - bounds.getHeight()) / 2;

        // add ascent to y to reach the baseline
        float ascent = (float) -bounds.getY();      // 字符串的上坡度
        float baseY = y + ascent;

        // draw the message
        g2.drawString(message, (int) x, (int) baseY);
        g2.setPaint(Color.RED);

        // draw the base line
        g2.draw(new Line2D.Float(x, baseY, x + (float) bounds.getWidth(), baseY));

        // draw the enclosed rectangle
        g2.draw(new Rectangle2D.Float(x, y, (float) bounds.getWidth(), (float) bounds.getHeight()));
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
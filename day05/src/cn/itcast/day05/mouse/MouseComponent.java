package cn.itcast.day05.mouse;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class MouseComponent extends JComponent {
    private static final int DEFAULT_WIDTH =  300;
    private static final int DEFAULT_HEIGHT = 200;

    private static final int SIDELENGTH = 10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current;    // the square containing the mouse cursor

    public MouseComponent() {
        squares = new ArrayList<>();
        current = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // draw squares
        for (Rectangle2D rect : squares)
            g2.draw(rect);
    }

    /**
     * Finds the first square containing a point
     * @param p a point
     * @return the first square that contains p
     */
    public Rectangle2D find(Point2D p) {
        for (Rectangle2D r : squares) {
            if (r.contains(p))
                return r;
        }
        return null;
    }

    /**
     * Adds a square to the collection
     * @param p the center of the square
     */
    public void add(Point2D p) {
        float x = (float) p.getX();
        float y = (float) p.getY();

        current = new Rectangle2D.Float(
                x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
        squares.add(current);
        repaint();
    }

    public void remove(Rectangle2D s) {
        if (s == null)
            return;
        if (s == current)
            current = null;
        squares.remove(s);
        repaint();
    }

    private class MouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent event) {
            // add a new square if the cursor is not inside a square
            current = find(event.getPoint());
            if (current == null)
                add(event.getPoint());
        }

        public void mouseClicked(MouseEvent event) {
            current = find(event.getPoint());
            if (current == null && event.getClickCount() >= 2)
                remove(current);
        }
    }

    private class MouseMotionHandler implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            if (current != null) {
                int x = e.getX();
                int y = e.getY();

                // drag the current rectangle to center it at (x, y)
                current.setFrame(
                        x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // set the mouse cursor to cross hairs if it is inside a rectangle
            if (find(e.getPoint()) == null)
                setCursor(Cursor.getDefaultCursor());
            else
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
    }
}

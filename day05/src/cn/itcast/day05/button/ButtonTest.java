package cn.itcast.day05.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ButtonTest {
    public static void main(String[] args) {
        ButtonFrame2 frame = new ButtonFrame2();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class ButtonFrame2 extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame2() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // create buttons
        var yellowButton = new Button("Yellow");
        var blueButton = new Button("Blue");
        var redButton = new Button("Red");

        buttonPanel = new JPanel();

        // add buttons to panel
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        // 输入映射，分别将KeyStroke对象映射到关联的动作
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_FOCUSED);
        imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

        // add panel to frame
        add(buttonPanel);

        // create button actions
        var yellowAction = new ColorAction(
                "Yellow", new ImageIcon("yellow-ball.gif"), Color.yellow);
        var blueAction = new ColorAction(
                "Blue", new ImageIcon("blue-ball.gif"), Color.BLUE);
        var redAction = new ColorAction(
                "Red", new ImageIcon("red-ball.gif"), Color.red);

        // associate actions with buttons
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);

        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.blue", blueAction);
        amap.put("panel.red", redAction);
    }

    // inner class
    class ColorAction extends AbstractAction {
        public ColorAction(String name, Icon icon, Color color) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue("color", color);
            putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}



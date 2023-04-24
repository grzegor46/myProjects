package Swing.hangmanUI.mainWindow;

import javax.swing.*;

public class StartScreenPanel extends JPanel {

    public StartScreenPanel(int WIDTH, int HEIGHT, ImageIcon backgroundImg) {
        JLabel startScreenBg = new JLabel(backgroundImg);
        this.add(startScreenBg);
    }
}

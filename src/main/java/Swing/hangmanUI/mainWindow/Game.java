package Swing.hangmanUI.mainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game extends JPanel implements ActionListener {

    final ImageIcon backgroundImg1 = new ImageIcon("src/main/java/Swing/hangmanUI/images/h1.png");

    public Game() {
//        this.setLayout(null);  causes that background image doesnt show
        JLabel startScreenBg = new JLabel(backgroundImg1);
        this.add(startScreenBg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}






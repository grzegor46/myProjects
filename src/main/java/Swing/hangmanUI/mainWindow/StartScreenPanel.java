package Swing.hangmanUI.mainWindow;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreenPanel extends JPanel implements ActionListener {

    private Button playButton;
    private Button exitButton;

    public StartScreenPanel(int WIDTH, int HEIGHT, ImageIcon backgroundImg) {
        JLabel startScreenBg = new JLabel(backgroundImg);
        this.add(startScreenBg);

        playButton = new Button("PLAY");
        exitButton = new Button("EXIT");

        this.add(playButton);
        this.add(exitButton);

        this.playButton.addActionListener(this);
        this.exitButton.addActionListener(this);

//    TODO utwoprzyc dwie klasy z dwoma przyciskamio play i exit wewnatrz
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.exitButton) {
            System.exit(0);
        }
    }
}

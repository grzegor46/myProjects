package Swing.hangmanUI.mainWindow;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreenPanel extends JPanel implements ActionListener {

    private Button playButton;
    private Button exitButton;

    public StartScreenPanel(ImageIcon backgroundImg) {
        JLabel startScreenBg = new JLabel(backgroundImg);
        this.add(startScreenBg);

        playButton = new Button("PLAY");
        exitButton = new Button("EXIT");

        this.add(playButton);
        this.add(exitButton);

        playButton.addActionListener(this);
        exitButton.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.exitButton) {
            System.exit(0);
        }
    }
}

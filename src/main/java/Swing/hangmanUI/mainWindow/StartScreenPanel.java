package Swing.hangmanUI.mainWindow;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreenPanel extends JPanel implements ActionListener {

    private Button playButton;
    private Button exitButton;

    public StartScreenPanel(int WIDTH, int HEIGHT, ImageIcon backgroundImg, JPanel container, CardLayout cardLayout) {

        JLabel startScreenBg = new JLabel(backgroundImg);

        int buttonWidth = 100;
        int buttonHeight = 50;
        int buttonY = HEIGHT - (buttonHeight * 3);

        this.playButton = new PlayButton("PLAY", container, cardLayout);
        this.exitButton = new Button("EXIT");

        int playButtonX = (WIDTH / 2) - (buttonWidth + 20);
        this.playButton.setBounds(playButtonX,buttonY,buttonWidth,buttonHeight);

        int exitButtonX = (WIDTH / 2) + 10;
        this.exitButton.setBounds(exitButtonX,buttonY,buttonWidth,buttonHeight);

        playButton.addActionListener(this);
        exitButton.addActionListener(this);

        this.setLayout(new BorderLayout());
        this.add(startScreenBg);


        startScreenBg.add(playButton);
        startScreenBg.add(exitButton);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.exitButton) {
            System.exit(0);
        }
        if (e.getSource() == this.playButton) {
            this.playButton.swapCard("2");
        }
    }
}

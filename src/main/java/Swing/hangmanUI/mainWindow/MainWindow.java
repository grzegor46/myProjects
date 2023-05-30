package Swing.hangmanUI.mainWindow;

import javax.swing.*;
import java.awt.*;

public class MainWindow {


    public static void main(String[] args) {

        final int WIDTH = 800;
        final int HEIGHT = 600;
        final String TITLE = "Hangman";
        final ImageIcon backgroundImg = new ImageIcon("src/main/java/Swing/hangmanUI/welcomeImage.png");


        JFrame screen = new JFrame();
        CardLayout cardLayout = new CardLayout();
        screen.setSize(new Dimension(WIDTH, HEIGHT));
        screen.setTitle(TITLE);
        screen.setLocationRelativeTo(null);
        screen.setResizable(false);
        screen.setDefaultCloseOperation(screen.EXIT_ON_CLOSE);

        JPanel container = new JPanel();
        container.setLayout(cardLayout);

        StartScreenPanel startScreenPanel = new StartScreenPanel(WIDTH, HEIGHT, backgroundImg, container, cardLayout);
        Game game = new Game(container, cardLayout);
        TestClass testClass = new TestClass(container, cardLayout);
        container.add(startScreenPanel, "1");
        container.add(game, "2");
        container.add(testClass, "3");
        screen.add(container);


        screen.setVisible(true);
    }
}

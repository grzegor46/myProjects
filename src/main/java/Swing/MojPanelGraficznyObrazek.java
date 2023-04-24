package Swing;

import javax.swing.*;
import java.awt.*;

public class MojPanelGraficznyObrazek extends JPanel {

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Image obrazek = new ImageIcon("src/main/java/Swing/java1a.PNG").getImage();
        g2d.drawImage(obrazek,0,0,this);


    }

}


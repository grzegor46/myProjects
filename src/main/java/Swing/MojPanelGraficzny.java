package Swing;

import javax.swing.*;
import java.awt.*;

public class MojPanelGraficzny extends JPanel {

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int czerwony = (int) (Math.random() * 256);
        int zielony = (int) (Math.random() * 256);
        int niebieski = (int) (Math.random() * 256);
        Color kolorPoczatku = new Color(czerwony,zielony,niebieski);
        czerwony = (int) (Math.random() * 256);
        zielony = (int) (Math.random() * 256);
        niebieski = (int) (Math.random() * 256);
        Color kolorKonca = new Color(czerwony,zielony,niebieski);
        GradientPaint gradient = new GradientPaint(70,70,kolorPoczatku, 150,150, kolorKonca);
        g2d.setPaint(gradient);
        g2d.fillOval(70,70,100,100);

//        Image obrazek = new ImageIcon("src/main/java/Swing/java1a.PNG").getImage();
//        g.drawImage(obrazek,80,80,this);


    }

}


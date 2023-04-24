package Swing;

import javax.swing.*;
import java.awt.*;

public class Panel1 {
    public static void main(String[] args) {
        Panel1 gui = new Panel1();
        gui.doRoboty();
    }
    public void doRoboty() {
        JFrame ramka = new JFrame();
        JPanel panel = new JPanel();
        JTextField pole = new JTextField(1);
//        JTextField pole = new JTextField("Podaj nazwisko");

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.darkGray);
        JButton przycisk = new JButton("To szok!");
        JButton przycisk2 = new JButton("Trach!");
        panel.add(przycisk);
        panel.add(przycisk2);
        ramka.getContentPane().add(BorderLayout.EAST, panel);
        ramka.setSize(200,200);
        ramka.setVisible(true);
    }
}

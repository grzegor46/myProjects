package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProstyGUI1b implements ActionListener {
    JFrame ramka;

    public static void main(String[] args) {
        ProstyGUI1b apGUI = new ProstyGUI1b();
        apGUI.doDziela();
    }
    public void doDziela() {
        ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton przycisk;
        przycisk = new JButton("Zmiana koloru");
//        jeżeli dodamy więcej niż jednego odbiorcę w "przycisk.addActionListener(this, odbiorca2, odbiorca3); i nastpi zdarzenie
//        to zostanie wykonana metoda actionPerformed u kazdego odbiorcy ktory zarejestrowal sie w przycisku
        przycisk.addActionListener(this);
        MojPanelGraficzny mojPanelGraficzny = new MojPanelGraficzny();
        MojPanelGraficznyObrazek mojPanelGraficznyObrazek = new MojPanelGraficznyObrazek();
        ramka.getContentPane().add(BorderLayout.SOUTH, przycisk);
        ramka.getContentPane().add(BorderLayout.CENTER, mojPanelGraficzny);
//        ramka.getContentPane().add(BorderLayout.NORTH, mojPanelGraficznyObrazek);


        ramka.setSize(500,500);
        ramka.setVisible(true);
    }
    public void actionPerformed(ActionEvent zdarzenie) {
        ramka.repaint();
    }
}

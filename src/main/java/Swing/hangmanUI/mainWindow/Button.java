package Swing.hangmanUI.mainWindow;

import javax.swing.*;

public class Button extends JButton {

    private String text;


    public Button(String text) {
        this.text = text;
        this.setText(this.text);


    }
}

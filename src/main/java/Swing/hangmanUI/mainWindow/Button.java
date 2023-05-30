package Swing.hangmanUI.mainWindow;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    private String text;


    public Button(String text) {
        this.text = text;
        this.setText(this.text);
        this.setFocusable(false);
    }


    public void swapCard(String s) {
    }
}
class PlayButton extends Button {

    private JPanel container;
    private CardLayout cardLayout;

    public PlayButton(String text, JPanel container, CardLayout cardLayout) {
        super(text);
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public void swapCard(String cardNum) {
        this.cardLayout.show(this.container, cardNum);
    }
}
class NewGameButton extends Button {

    private JPanel container;
    private CardLayout cardLayout;

    public NewGameButton(String text, JPanel container, CardLayout cardLayout) {
        super(text);
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public void swapCard(String cardNum) {
        this.cardLayout.show(this.container, cardNum);
    }
}


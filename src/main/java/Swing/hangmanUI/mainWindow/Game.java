package Swing.hangmanUI.mainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;


public class Game extends JPanel implements ActionListener {

    final ImageIcon backgroundImg1 = new ImageIcon("src/main/java/Swing/hangmanUI/images/h0.png");
    private JPanel keyboard;
    private int numOfGuesses;
    private String hiddenWord;


    public Game() {

        JLabel startScreenBg = new JLabel(backgroundImg1);
        this.add(startScreenBg);

        keyboard = new JPanel();
        keyboard.setLayout(new GridLayout(4,0));
        keyboard.setBackground(Color.GRAY);
        createButtons(keyboard);
        this.add(keyboard, BorderLayout.SOUTH);

        numOfGuesses = 6;

    }
    public void createButtons(JPanel keyboard) {

        JButton[] buttons = new JButton[26];
        String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z" };

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(letters[i]);
            buttons[i].setSize(60, 60);
            buttons[i].setActionCommand(letters[i]);
            buttons[i].addActionListener(this);

            keyboard.add(buttons[i]);
        }

    }

    private ArrayList<String> generateWord(){
        // TODO  add function to seek word from file.txt
        String[] listOfWords = {"car", "school", "alcohol", "music", "cookies"};
        int numberOfword = (int)(Math.random() * listOfWords.length);
        String choosedWord = listOfWords[numberOfword];
        String[] array = choosedWord.split("");

        return new ArrayList<>(Arrays.asList(array));
    }

    private ArrayList<String> hideWord(ArrayList<String> generatedWord){
        generatedWord.replaceAll(e -> e.replaceAll("[a-z]", "_"));
        return generatedWord;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Let's Play Hang Man!!!", 150,25);

        hiddenWord = hideWord(generateWord()).toString();
        g.drawString(hiddenWord, 450, 175 );
        g.drawString("Typed wrong char:", 450, 275 );
//        g.drawString(listOfWrongChar, 450, 275 );
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand()); // it gets string from button
    }

}






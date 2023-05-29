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
    private boolean isGameOver;
    private String hiddenWordString;
    private ArrayList<String> hiddenWordArray;
    private ArrayList<String> storedWord;

    public Game() {

        JLabel startScreenBg = new JLabel(backgroundImg1);
        this.add(startScreenBg);

        keyboard = new JPanel();
        keyboard.setLayout(new GridLayout(4, 0));
        keyboard.setBackground(Color.GRAY);
        createButtons(keyboard);
        this.add(keyboard, BorderLayout.SOUTH);

        numOfGuesses = 6;
        this.storedWord = generateWord();
        this.hiddenWordArray = hideWord(storedWord);
    }

    public void createButtons(JPanel keyboard) {

        JButton[] buttons = new JButton[26];
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z"};

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(letters[i]);
            buttons[i].setSize(60, 60);
            buttons[i].setActionCommand(letters[i]);
            buttons[i].addActionListener(this);

            keyboard.add(buttons[i]);
        }

    }

    private ArrayList<String> generateWord() {
        // TODO  add function to seek word from file.txt
//        String[] listOfWords = {"car", "school", "alcohol", "music", "cookies"};
        String[] listOfWords = {"mom", "school"};
        int numberOfword = (int) (Math.random() * listOfWords.length);
        String choosedWord = listOfWords[numberOfword];
        String[] array = choosedWord.split("");

        return new ArrayList<>(Arrays.asList(array));
    }

    private ArrayList<String> hideWord(ArrayList<String> generatedWord) {
        ArrayList<String> hiddenWord = new ArrayList<>(generatedWord);
        for (int i = 0; i < generatedWord.size(); i++) {
            hiddenWord.set(i, "_");
        }

        return hiddenWord;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Let's Play Hang Man!!!", 150, 25);

        hiddenWordString = hiddenWordArray.toString(); // userChoice
        g.drawString(hiddenWordString, 450, 175);
        g.drawString("Typed wrong char:", 450, 275);
//        g.drawString(listOfWrongChar, 450, 275 );
    }

    private ArrayList<String> userChoice(String command, ArrayList<String> storedWord, ArrayList<String> hiddenWordArray) {
        String selectedCharacter = command.toLowerCase();
        int positionTypedChar = storedWord.indexOf(selectedCharacter);

        if (positionTypedChar >= 0) {
            String charList = storedWord.get(positionTypedChar); // example "s"
            hiddenWordArray.set(positionTypedChar, charList);
            storedWord.set(positionTypedChar, "$");
            return hiddenWordArray;

        } else {
            numOfGuesses++;
            // shows wrong selected letter
        }
        return null;
    }


    private boolean isWon(ArrayList<String> storedGeneratedWord) {
        int count = 0;        // it counts '$' in array

        for (String s : storedGeneratedWord) {
            if (s.equals("$")) {
                count++;
            }
        }
        return count == storedGeneratedWord.size();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand()); // it gets string from button
        System.out.println(this.storedWord);
        String command = e.getActionCommand();

        ArrayList<String> temp = userChoice(command, this.storedWord, this.hiddenWordArray);
        hiddenWordString = temp.toString();
        repaint();
        if (isGameOver) {
            System.exit(0);
        }
    }

}






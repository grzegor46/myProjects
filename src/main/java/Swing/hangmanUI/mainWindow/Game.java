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
    private String listOfWrongCharString;
    private ArrayList<String> hiddenWordArray;
    private ArrayList<String> storedWord;
    private ArrayList<String> listOfWrongChar;
    private JPanel gameOverScreen;
    JLabel startScreenBg;

    public Game() {

        this.startScreenBg = new JLabel(backgroundImg1);
        this.add(startScreenBg);

        keyboard = new JPanel();
        keyboard.setLayout(new GridLayout(4, 0));
        keyboard.setBackground(Color.GRAY);
        createButtons(keyboard);
        this.add(keyboard, BorderLayout.SOUTH);

        numOfGuesses = 0;
        this.listOfWrongChar = new ArrayList<>();
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
        g.drawString("Let's Play the game", 150, 25);

        hiddenWordString = hiddenWordArray.toString(); // userChoice
        listOfWrongCharString = listOfWrongChar.toString();
        g.drawString(hiddenWordString, 350, 400);
        g.drawString("Typed wrong char:", 500, 275);
        g.drawString(listOfWrongCharString, 500, 305 );

        if(this.numOfGuesses ==7) {
            g.setFont(new Font("Arial",1,50));
            g.setColor(Color.BLUE);
            g.drawString("YOU LOSE!",250,200);
            keyboard.setVisible(false);
        }
        if(this.isGameOver) {
            g.setFont(new Font("Arial",1,50));
            g.setColor(Color.green);
            g.drawString("YOU WIN!",250,200);
            keyboard.setVisible(false);
        }


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
            listOfWrongChar.add(command);

            if (numOfGuesses == 8) {
                isGameOver = true;
            }

            // shows wrong selected letter
        }
        return hiddenWordArray;
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

        if(numOfGuesses <= 7 && !isGameOver) {
            this.startScreenBg.setIcon(new ImageIcon("src/main/java/Swing/hangmanUI/images/h"+numOfGuesses+".png"));
            isGameOver = isWon(storedWord);
        }
        repaint();

    }

}






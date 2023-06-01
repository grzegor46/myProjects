package Swing.hangmanUI.mainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private Button newGameButton;
    private Button exitButton;
    JButton[] buttons;

    JLabel startScreenBg;

    public Game(JPanel container, CardLayout cardLayout) {

        this.startScreenBg = new JLabel(backgroundImg1);
        this.add(startScreenBg);

        this.keyboard = new JPanel();
        this.keyboard.setLayout(new GridLayout(4, 0));
        this.keyboard.setBackground(Color.GRAY);
        createButtons();
        this.add(this.keyboard, BorderLayout.SOUTH);

        this.newGameButton = new NewGameButton("New Game", container, cardLayout);
        this.newGameButton.setBounds(400, 50, 100, 50);
        newGameButton.addActionListener(this);
        this.add(this.newGameButton);

        this.exitButton = new Button("Exit");
        this.exitButton.setBounds(500, 150, 30, 20);
        exitButton.addActionListener(this);
        this.add(this.exitButton);

        this.numOfGuesses = 0;
        this.listOfWrongChar = new ArrayList<>();
        this.storedWord = generateWord();
        this.hiddenWordArray = hideWord(storedWord);
    }

    public void createButtons() {

        this.buttons = new JButton[26];
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z"};

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(letters[i]);
            buttons[i].setSize(60, 60);
            buttons[i].setActionCommand(letters[i]);
            buttons[i].addActionListener(this);

            this.keyboard.add(buttons[i]);
        }

    }

    public void disableKeyboard() {

        for (int i=0; i<this.buttons.length; i++) {
            this.buttons[i].setEnabled(false);
        }
    }

    public void enableKeyboard() {

        for (int i=0; i<this.buttons.length; i++) {
            this.buttons[i].setEnabled(true);
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

        this.hiddenWordString = this.hiddenWordArray.toString(); // userChoice
        this.listOfWrongCharString = this.listOfWrongChar.toString();

        g.setFont(new Font("Arial", 0, 25));
        g.drawString(this.hiddenWordString, 350, 400);
        g.setFont(new Font("Arial", 0, 15));
        g.drawString("Typed wrong char:", 500, 275);
        g.drawString(this.listOfWrongCharString, 500, 305);

        if (this.numOfGuesses == 7) {
            g.setFont(new Font("Arial", 1, 50));
            g.setColor(Color.BLUE);
            g.drawString("YOU LOSE!", 250, 200);
            this.keyboard.setVisible(true);
            disableKeyboard();
            repaint();
            g.setFont(new Font("Arial", 0, 25));
            g.drawString(this.storedWord.toString(), 350, 350);
        }
        if (this.isGameOver) {
            g.setFont(new Font("Arial", 1, 50));
            g.setColor(Color.green);
            g.drawString("YOU WIN!", 250, 200);
            this.keyboard.setVisible(true);
            disableKeyboard();
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
            this.numOfGuesses++;
            this.listOfWrongChar.add(command);

            if (this.numOfGuesses == 8) {
                this.isGameOver = true;
            }
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
        if (e.getSource() == this.newGameButton) {
            this.resetGame(e);
            repaint();
        } else {
            System.out.println(e.getActionCommand()); // it gets string from button
            System.out.println(this.storedWord);
            String command = e.getActionCommand();

            ArrayList<String> temp = userChoice(command, this.storedWord, this.hiddenWordArray);
            this.hiddenWordString = temp.toString();

            if (this.numOfGuesses <= 7 && !this.isGameOver) {
                this.startScreenBg.setIcon(new ImageIcon("src/main/java/Swing/hangmanUI/images/h" + this.numOfGuesses + ".png"));
                this.isGameOver = isWon(this.storedWord);
            }
            repaint();
        }
        if (e.getSource() == this.exitButton) {
            System.exit(0);
        }

    }

    private void resetGame(ActionEvent e) {

        if (e.getSource() == this.newGameButton) {
            int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?");
            if (result == 0) {

                this.numOfGuesses = 0;
                this.startScreenBg.setIcon(new ImageIcon("src/main/java/Swing/hangmanUI/images/h" + this.numOfGuesses + ".png"));
                this.listOfWrongChar = new ArrayList<>();
                this.storedWord = generateWord();
                this.hiddenWordArray = hideWord(this.storedWord);
                this.isGameOver = false;
                this.newGameButton.swapCard("2");
                this.keyboard.setVisible(true);
                enableKeyboard();
                repaint();

            }
        }

    }

}






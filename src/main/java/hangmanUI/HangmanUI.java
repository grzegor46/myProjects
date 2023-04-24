package hangmanUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HangmanUI {

    String playerName;
    Scanner scanner = new Scanner(System.in);

    public void startGame() {
        greetingsPlayer();

        System.out.println("Would you like to play? - y/n");

        String choice = scanner.nextLine();

        while(true) {
            if (choice.equals("y")) {

                ArrayList<String> storedGeneratedWord = generateWord();
                ArrayList<String> wordAsArray = new ArrayList<>(storedGeneratedWord);
                ArrayList<String> hidedList = hideWord(storedGeneratedWord);
                System.out.println("hidden word is: " + hidedList);
                Game(hidedList, wordAsArray);

            }else if (choice.equals("n")){
                System.out.println("See you soon... I hope.. :) ");
                break;
            }
            System.out.println("Would you like to play again? - y/n");

            choice = scanner.nextLine();
        }
        scanner.close();
    }

    private void Game(ArrayList<String> hidedStoredGeneratedWord, ArrayList<String> storedGeneratedWord) {
        int countWrongChoices = 0;
        boolean isWon;
        Scanner scanner = new Scanner(System.in);

        while (countWrongChoices < 12) {
            System.out.println("Please type one character: ");
            String typedCharacter = scanner.nextLine();
            int positionTypedChar = storedGeneratedWord.indexOf(typedCharacter);

            if(positionTypedChar >= 0) {
                String charList = storedGeneratedWord.get(positionTypedChar);
                hidedStoredGeneratedWord.set(positionTypedChar, charList);
                storedGeneratedWord.set(positionTypedChar, "$");
                isWon = checkIfWon(storedGeneratedWord);

                if(isWon) {
                    System.out.println("the hidden word: " + hidedStoredGeneratedWord);
                    System.out.println("congratulation " + playerName + ", you won!" + "\n");
                    break;
                }
                System.out.println(hidedStoredGeneratedWord);

            } else{
                countWrongChoices++;
                System.out.println("amount of wrong char: " + countWrongChoices + " of 12");
                drawHangman(countWrongChoices);
                if(countWrongChoices == 12){
                    System.out.println("sorry, you lose...");
                }
            }

        }
    }

    private void greetingsPlayer() {
        System.out.println("Welcome in hangman!");
        System.out.println("What's your name?");
        this.playerName = scanner.nextLine();
        System.out.println("Welcome " + playerName + " !");
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

    private boolean checkIfWon(ArrayList<String> storedGeneratedWord) {
        int count = 0;        // it counts '$' in array

        for (String s : storedGeneratedWord) {
            if (s.equals("$")) {
                count++;
            }
        }
        return count == storedGeneratedWord.size();
    }

    private void drawHangman(int countWrongChoices) {

        switch (countWrongChoices)
        {
            case 0:
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                break;
            case 1:
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("/           ");
                break;
            case 2:
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("            ");
                System.out.println("/\\         ");
                break;
            case 3:
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println("/\\          ");
                break;
            case 4:
                System.out.println(" |---------  ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println("/\\          ");
                break;
            case 5:
                System.out.println(" |---------  ");
                System.out.println(" |        |  ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println("/\\          ");
                break;
            case 6:
                System.out.println(" |---------  ");
                System.out.println(" |        |  ");
                System.out.println(" |        0  ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println("/\\          ");
                break;
            case 7:
                System.out.println(" |---------  ");
                System.out.println(" |        |  ");
                System.out.println(" |        0  ");
                System.out.println(" |        |  ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println("/\\          ");

                break;
            case 8:
                System.out.println(" |---------  ");
                System.out.println(" |        |  ");
                System.out.println(" |        0  ");
                System.out.println(" |        |\\");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println("/\\          ");
                break;
            case 9:
                System.out.println(" |---------  ");
                System.out.println(" |        |  ");
                System.out.println(" |        0  ");
                System.out.println(" |       /|\\");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println("/\\          ");
                break;
            case 10:
                System.out.println(" |---------  ");
                System.out.println(" |        |  ");
                System.out.println(" |        0  ");
                System.out.println(" |       /|\\");
                System.out.println(" |         \\");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println("/\\          ");
                break;
            case 11:
                System.out.println(" |---------  ");
                System.out.println(" |        |  ");
                System.out.println(" |        0  ");
                System.out.println(" |       /|\\");
                System.out.println(" |       / \\");
                System.out.println(" |           ");
                System.out.println(" |           ");
                System.out.println("/\\          ");
                break;
        }
    }

}

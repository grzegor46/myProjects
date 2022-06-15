package hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    private String namePlayer;

    public Hangman(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void startGame() {

        System.out.println("Welcome in hangman!");
        System.out.println("What's your name?");

        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome " + getNamePlayer() + " !");
        System.out.println(getNamePlayer() + ", would you like to play? - y/n");


        String choice = scanner.nextLine();

        while(true) {
            if (choice.equals("y")) {
                System.out.println("hello");

                ArrayList<String> storedGeneratedWord = generateWord();
//                String storedGeneratedWord = generateWord();
                System.out.println("generated word is: " + storedGeneratedWord);
                ArrayList<String> listNew = new ArrayList<>(storedGeneratedWord);
                ArrayList<String> hidedList = hideWord(storedGeneratedWord);
                System.out.println("hideword is: " + hidedList);

                Game(hidedList, listNew);


                break;
            }

            System.out.println("See you soon... I hope.. :) ");
            break;

        }
        scanner.close();
    }
    // secretWord
    private ArrayList<String> generateWord(){

//        String[] listOfWords = {"kotek", "mama", "auto", "pies"};
        String[] listOfWords = {"mama"};
        int numberOfword = (int)(Math.random() * listOfWords.length); // range 0 and 3, random returns between 0 and 1
        String name = listOfWords[numberOfword];
        String[] array = name.split("");
        ArrayList<String> listOfSavedWord = new ArrayList<String>(Arrays.asList(array));

        return listOfSavedWord;


    }


    public boolean Game(ArrayList<String> hidedStoredGeneratedWord, ArrayList<String> storedGeneratedWord) {
        int countWrongChoices = 0;
        boolean isWon;
        Scanner scanner = new Scanner(System.in);
        while (countWrongChoices < 12) {

            // wyswietlac liste z _ i jesli trafi index z odpowiednia litwera w pierwszej liscie, to podmieniac to w drugiej
            System.out.println("Please type one character: ");
            String typedCharacter = scanner.nextLine();

//                int positionTypedChar = findCharacter(storedGeneratedWord,typedCharacter);
            int positionTypedChar = storedGeneratedWord.indexOf(typedCharacter);
            if(positionTypedChar >= 0) {
                String charList = storedGeneratedWord.get(positionTypedChar);
                hidedStoredGeneratedWord.set(positionTypedChar, charList);
                storedGeneratedWord.set(positionTypedChar, "$");
                isWon = checkIfWon(storedGeneratedWord);
                if(isWon) {
                    System.out.println("congratulation");
                    break;
                }
                // put here something to check if every char is $...
                System.out.println(hidedStoredGeneratedWord);

            } else{
                countWrongChoices++;
                System.out.println("amount of wrong char: " + countWrongChoices);
                drawHangman(countWrongChoices);
                if(countWrongChoices == 12){
                    System.out.println("sorry, you lose...");
                }
            }

        }
        return false;
    }



    //    //generateWord()
    private ArrayList<String> hideWord(ArrayList<String> generatedWord){

        generatedWord.replaceAll(e -> e.replaceAll("[a-z]", "_"));


        return generatedWord;
    }

    private boolean checkIfWon(ArrayList<String> storedGeneratedWord) {
        int count = 0;        // it counts $ in array

        for(int i = 0; i < storedGeneratedWord.size(); i++) {
            if(storedGeneratedWord.get(i).equals("$")) {
                count++;
            } else {
                continue;
            }
        }
        if(count == storedGeneratedWord.size()) {
            return true;
        }
        return false;
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
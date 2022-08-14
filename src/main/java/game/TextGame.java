package game;


import java.util.ArrayList;

public class TextGame {

    Action action = new Action();


    public static void main(String[] args) {
        System.out.println("Welcome in escape room");
        TextGame textGame = new TextGame();

        textGame.action.showBackpack();
        textGame.action.takeItem(Items.ThorHammer);
        textGame.action.describeItem("hammer");
        textGame.action.describeItem("fire sword");
        textGame.action.showBackpack();



    }
}

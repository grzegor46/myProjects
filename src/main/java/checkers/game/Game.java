package checkers.game;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Game {

    enum WhoesTurn {
        RED,
        BLACK
    }

    WhoesTurn whoesTurn;


    public void getNextMove(){
        Scanner scanner = new Scanner(System.in);

        if(whoesTurn == WhoesTurn.RED) {
            System.out.println("It is your turn, red.");
        }
	    else
            System.out.println("It is your turn, black.");

        boolean moved = false;

        System.out.println("Please type position from which square would you like to move");
        System.out.println("enter 2 digits, example first is '1'  on 'x' axis and next enter '2' is on 'y' axis");

        int[] arrayOfPositionMoveFrom = {scanner.nextInt(), scanner.nextInt()};
        int[] arrayOfPositionMoveTo = {scanner.nextInt(), scanner.nextInt()};

    }

    public boolean validMove(int[] arrayOfPositionMoveFrom, int[] arrayOfPositionMoveTo) {

        int fromX = arrayOfPositionMoveFrom[0];
        int fromY = arrayOfPositionMoveFrom[1];
        int toX = arrayOfPositionMoveTo[0];
        int toY = arrayOfPositionMoveTo[1];

        if((fromX < 0 && fromY < 0) || (fromX > 7 && fromY > 7) || (toX < 0 && toY < 0) || (toX > 7 && toY > 7)){
            return false;
        } else if() {

        }

        return false;

    }
}

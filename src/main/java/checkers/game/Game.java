package checkers.game;

import checkers.board.Board;

import java.util.Objects;
import java.util.Scanner;

public class Game {

    Board board = new Board();
    WhoesTurn whoesTurn;


    enum WhoesTurn {
        WHITE,
        BLACK
    }

    public void getNextMove(){

        Scanner scanner = new Scanner(System.in);

        if(whoesTurn == WhoesTurn.WHITE) {
            System.out.println("It is your turn, white.");
        }
	    else
            System.out.println("It is your turn, black.");

        boolean moved = false;

        System.out.println("Please type position FROM which square would you like to move");
        System.out.println("enter 2 digits, example first is '1'  on 'x' axis and next enter '2' is on 'y' axis");

        int[] arrayOfPositionMoveFrom = {scanner.nextInt(), scanner.nextInt()};

        System.out.println("Please type position TO which square would you like to move");
        int[] arrayOfPositionMoveTo = {scanner.nextInt(), scanner.nextInt()};

        //code with relevant move
        // if valid move then execute move

        if(validMove(arrayOfPositionMoveFrom, arrayOfPositionMoveTo)) {
            executeMove(arrayOfPositionMoveFrom, arrayOfPositionMoveTo);
        }

    }

    public boolean validMove(int[] arrayOfPositionMoveFrom, int[] arrayOfPositionMoveTo) {

        int fromX = (arrayOfPositionMoveFrom[0])-1;
        int fromY = (arrayOfPositionMoveFrom[1])-1;
        int toX = (arrayOfPositionMoveTo[0])-1;
        int toY = (arrayOfPositionMoveTo[1])-1;

        if((fromX < 0 && fromY < 0) || (fromX > 7 && fromY > 7) || (toX < 0 && toY < 0) || (toX > 7 && toY > 7)){
            return false;
        } else return (Math.abs(fromX - toX) == 1 || Math.abs(fromY - toY) == 1) && Objects.equals(board.field[toX][toY], "[ ]");

    }

    public void executeMove(int[] arrayOfPositionMoveFrom, int[] arrayOfPositionMoveTo) {

        int fromX = (arrayOfPositionMoveFrom[0])-1;
        int fromY = (arrayOfPositionMoveFrom[1])-1;
        int toX = (arrayOfPositionMoveTo[0])-1;
        int toY = (arrayOfPositionMoveTo[1])-1;

        board.field[toX][toY] = board.field[fromX][fromY];
        board.field[fromX][fromY] = "[ ]";


    }
}

package checkers.game;

import checkers.board.Board;

import java.util.Objects;
import java.util.Scanner;

public class Game {

    //    Board board = new Board();
    WhoesTurn whoesTurn;
    public String[][] field = new String[8][8];
    int checker_b = 12;
    int checker_w = 12;

    enum WhoesTurn {
        WHITE,
        BLACK
    }

    public void initialBoardWithRedAndBlackChecker() {

        for (int i = 0; i < 8; i += 1) {
            for (int j = 0; j < 8; j += 1) {
                field[i][j] = "[ ]";
            }
            System.out.println();
        }

        for (int i = 0; i < 8; i += 1) {
            for (int j = 1; j < 8; j += 2) {
                if (i == 0 || i == 2) {
                    field[i][j] = "[w]";
                }
                if (i == 6) {
                    field[i][j] = "[b]";
                }
            }
            for (int j = 0; j < 8; j += 2) {
                if (i == 1) {
                    field[i][j] = "[w]";
                }
                if (i == 7 || i == 5) {
                    field[i][j] = "[b]";
                }
            }
            System.out.println();
        }
    }

    public void printBoard() {
        System.out.println("   1   2   3   4   5   6   7   8  X");
        for (int i = 0; i < 8; i += 1) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 8; j += 1) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("Y");
    }


    public void getNextMove() {
        WhoesTurn whoesTurn = WhoesTurn.WHITE;

        Scanner scanner = new Scanner(System.in);

        if (whoesTurn == WhoesTurn.WHITE) {
            System.out.println("It is your turn, white.");
        } else
            System.out.println("It is your turn, black.");

        boolean moved = false;

        System.out.println("Please type position FROM which square would you like to move");
        System.out.println("enter 2 digits, example first is '1'  on 'x' axis and next enter '2' is on 'y' axis");

        int[] arrayOfPositionMoveFrom = {scanner.nextInt(), scanner.nextInt()};

        System.out.println("Please type position TO which square would you like to move");
        int[] arrayOfPositionMoveTo = {scanner.nextInt(), scanner.nextInt()};

        //code with relevant move
        // if valid move then execute move

        if (validMove(arrayOfPositionMoveFrom, arrayOfPositionMoveTo)) {
            executeMove(arrayOfPositionMoveFrom, arrayOfPositionMoveTo);
        }

    }

    public boolean validMove(int[] arrayOfPositionMoveFrom, int[] arrayOfPositionMoveTo) {

        int fromX = (arrayOfPositionMoveFrom[0]) - 1;
        int fromY = (arrayOfPositionMoveFrom[1]) - 1;
        int toX = (arrayOfPositionMoveTo[0]) - 1;
        int toY = (arrayOfPositionMoveTo[1]) - 1;

        if ((fromX < 0 && fromY < 0) || (fromX > 7 && fromY > 7) || (toX < 0 && toY < 0) || (toX > 7 && toY > 7)) {
            return false;
        } else if ((Math.abs(fromX - toX) == 1) && Objects.equals(field[toY][toX], "[ ]")) {
            return true;
        } else if (((Math.abs(fromX - toX) == 2)  && field[toY][toX].equals("[ ]")) && field[(fromY+toY)/2][(fromX+toX)/2].equals("[w]")) {
            return true;
        }else if (((Math.abs(fromX - toX) == 2)  && field[toY][toX].equals("[ ]")) && field[(fromY+toY)/2][(fromX+toX)/2].equals("[b]")) {
            return true;
        }else {
                System.out.println("invalid move");
            }
            return false;
        }


        public void executeMove ( int[] arrayOfPositionMoveFrom, int[] arrayOfPositionMoveTo){

            int fromX = (arrayOfPositionMoveFrom[0]) - 1;
            int fromY = (arrayOfPositionMoveFrom[1]) - 1;
            int toX = (arrayOfPositionMoveTo[0]) - 1;
            int toY = (arrayOfPositionMoveTo[1]) - 1;

            if ((Math.abs(fromX - toX) == 1) && Objects.equals(field[toY][toX], "[ ]")) {
                field[toY][toX] = field[fromY][fromX];
                field[fromY][fromX] = "[ ]";
            }
            if((Math.abs(fromX - toX) == 2) && Math.abs(fromY - toY) ==2 ) {
                field[(fromY+toY)/2][(fromX+toX)/2] = "[ ]";
                field[toY][toX] = field[fromY][fromX];
                field[fromY][fromX] = "[ ]";
                checker_w--;
            }


        }
    // Checks to see if game is over based on number of checkers left.
    public boolean gameOver() {
        return (checker_w == 0 || checker_b == 0);
    }

    // Returns color of the winner.
    public String winnerIs() {
        if (checker_b == 0)
            return "red";
        else
            return "black";
    }
    }


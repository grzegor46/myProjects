package checkers.game;

import checkers.board.Board;

import java.util.Objects;
import java.util.Scanner;

public class Game {

    public Board board = new Board();
    private int checker_b = 12;
    private int checker_w = 12;
    private String whoesIsTurn = "b";
    private boolean moved;

    public int getChecker_b() {
        return checker_b;
    }

    public int getChecker_w() {
        return checker_w;
    }

    public void getNextMove() {

        Scanner scanner = new Scanner(System.in);

        if (whoesIsTurn.equals("w")) {
            System.out.println("It is your turn, white.");
        } else
            System.out.println("It is your turn, black.");

        System.out.println("Please type position FROM which square would you like to move");
        System.out.println("enter 2 digits, example first is '1'  on 'x' axis and next enter '2' is on 'y' axis");

//        int[] selectedField = {scanner.nextInt(), scanner.nextInt()};
        int[] selectedField = selectField(scanner.nextInt(), scanner.nextInt());
        
        System.out.println("Please type position TO which square would you like to move");
        int[] fieldToMove = selectField(scanner.nextInt(), scanner.nextInt());
        

        if (validMove(selectedField, fieldToMove)) {
            executeMove(selectedField, fieldToMove);
            //add here second move if is chance to hit another checker during same turn
        }
        
        }
        
        
    private int[] selectField(int val1, int val2) {
        return new int[]{val1-1, val2-1};
    }
    
// TODO: try to figure out how implement all valid moves for AI from selected Piece
    
    
    public boolean validMove(int[] selectedField, int[] fieldToMove) {

        int fromX = (selectedField[0]);
        int fromY = (selectedField[1]);
        int toX = (fieldToMove[0]);
        int toY = (fieldToMove[1]);

        if ((fromX < 0 && fromY < 0) || (fromX > 7 && fromY > 7) || (toX < 0 && toY < 0) || (toX > 7 && toY > 7)) {
            return false;
        } else if ((Math.abs(fromX - toX) == 1) && board.field[toY][toX].equals("[ ]") && ((whoesIsTurn.equals("b") && board.field[fromY][fromX].equals("[b]")) && fromY-toY == 1 || (whoesIsTurn.equals("w") && board.field[fromY][fromX].equals("[w]")) && fromY-toY == -1)) {
            return true;
        } else if (((Math.abs(fromX - toX) == 2)  && board.field[toY][toX].equals("[ ]")) && board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[w]") && whoesIsTurn.equals("b")) {
            return true;
        }else if (((Math.abs(fromX - toX) == 2)  && board.field[toY][toX].equals("[ ]")) && board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[b]") && whoesIsTurn.equals("w")) {
            return true;
        }else {
            System.out.println("invalid move");
        }
            return false;
        }


        public void executeMove( int[] selectedField, int[] fieldToMove){

            int fromX = (selectedField[0]);
            int fromY = (selectedField[1]);
            int toX = (fieldToMove[0]);
            int toY = (fieldToMove[1]);

            if ((Math.abs(fromX - toX) == 1) && Objects.equals(board.field[toY][toX], "[ ]")) {
                board.field[toY][toX] = board.field[fromY][fromX];
                board.field[fromY][fromX] = "[ ]";
                if(whoesIsTurn.equals("w")) {
                    whoesIsTurn = "b";
                } else {
                    whoesIsTurn = "w";
                }
            }
            // jump over opponent
            if((Math.abs(fromX - toX) == 2) && Math.abs(fromY - toY) ==2 ) {
                if(whoesIsTurn.equals("w") && board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[b]"))
                board.field[(fromY+toY)/2][(fromX+toX)/2] = "[ ]";
                board.field[toY][toX] = board.field[fromY][fromX];
                board.field[fromY][fromX] = "[ ]";

                if(whoesIsTurn.equals("w")) {
                    checker_b--;
                    whoesIsTurn = "b";
                } else {
                    checker_w--;
                    whoesIsTurn = "w";

                }
            }

        }

    public int evaluate() {
        return checker_w - checker_b;
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


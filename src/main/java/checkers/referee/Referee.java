package checkers.referee;

import checkers.board.Board;
import checkers.game.Game;



public class Referee {

    private Board board;
    private String whoesIsTurn;
    private boolean isAi;

    public Referee(Board board, String whoesIsTurn, boolean isAi) {
        this.board = board;
        this.whoesIsTurn = whoesIsTurn;
        this.isAi = isAi;
    }

    public boolean validCrownMove(int[] selectedField, int[] fieldToMove, String whoesIsTurn) {

        int fromX = (selectedField[0]);
        int fromY = (selectedField[1]);
        int toX = (fieldToMove[0]);
        int toY = (fieldToMove[1]);
        int counterLoop = Math.abs(fromX-toX);

        if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[W]") && whoesIsTurn.equals("[w]")) && ((fromX >= toX) && (fromY <= toY)) && (board.field[toY][toX].equals("[ ]"))) {
            for (int i = 1; i < counterLoop; i++) {
                boolean isEmpty = board.field[fromY+i][fromX-i].equals("[ ]");
                System.out.println("fromY+i:" +(fromY+i) );
                System.out.println("fromX-i:" +(fromX-i) );
                if(!isEmpty) {
                    return false;
                }
            }
            return true;
        }
        else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[W]") && whoesIsTurn.equals("[w]")) && ((fromX <= toX) && (fromY >= toY)) && (board.field[toY][toX].equals("[ ]"))) {
            for (int i = 1; i < counterLoop; i++) {
                boolean isEmpty = board.field[fromY-i][fromX+i].equals("[ ]");
                System.out.println("fromY-i:" +(fromY-i) );
                System.out.println("fromX+i:" +(fromX+i) );
                if(!isEmpty) {
                    return false;
                }
            }
            return true;
        }
        else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[W]") && whoesIsTurn.equals("[w]")) && ((fromX <= toX) && (fromY <= toY)) && (board.field[toY][toX].equals("[ ]"))) {
            for (int i = 1; i < counterLoop; i++) {
                boolean isEmpty = board.field[fromY+i][fromX+i].equals("[ ]");
                System.out.println("fromY+i:" +(fromY+i) );
                System.out.println("fromX+i:" +(fromX+i) );
                if(!isEmpty) {
                    return false;
                }
            }
            return true;
        }
        else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[W]") && whoesIsTurn.equals("[w]")) && ((fromX >= toX) && (fromY >= toY)) && (board.field[toY][toX].equals("[ ]"))) {
            for (int i = 1; i < counterLoop; i++) {
                boolean isEmpty = board.field[fromY-i][fromX-i].equals("[ ]");
                System.out.println("fromY-i:" +(fromY-i) );
                System.out.println("fromX-i:" +(fromX-i) );
                if(!isEmpty) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean validMove(int[] selectedField, int[] fieldToMove, String whoesIsTurn) {
        try {
            int fromX = (selectedField[0]);
            int fromY = (selectedField[1]);
            int toX = (fieldToMove[0]);
            int toY = (fieldToMove[1]);

            if ((fromX < 0 && fromY < 0) || (fromX > 7 && fromY > 7) || (toX < 0 && toY < 0) || (toX > 7 && toY > 7)) {
                return false;
            } else if ((Math.abs(fromX - toX) == 1) && board.field[toY][toX].equals("[ ]") && ((whoesIsTurn.equals("[b]") && board.field[fromY][fromX].equals("[b]")) && fromY - toY == 1 || (whoesIsTurn.equals("[w]") && board.field[fromY][fromX].equals("[w]")) && fromY - toY == -1)) {
                return true;
            } else if (((Math.abs(fromX - toX) == 2) && board.field[toY][toX].equals("[ ]")) && (board.field[(fromY + toY) / 2][(fromX + toX) / 2].equals("[w]") || board.field[(fromY + toY) / 2][(fromX + toX) / 2].equals("[W]")) && whoesIsTurn.equals("[b]")) {
                return true;
            } else if (((Math.abs(fromX - toX) == 2) && board.field[toY][toX].equals("[ ]")) && (board.field[(fromY + toY) / 2][(fromX + toX) / 2].equals("[b]") || board.field[(fromY + toY) / 2][(fromX + toX) / 2].equals("[B]")) && whoesIsTurn.equals("[w]")) {
                return true;
            } else if (((Math.abs(fromX - toX) == 2) && board.field[fromY][fromX].equals("[B]") && board.field[toY][toX].equals("[ ]")) && (board.field[(fromY + toY) / 2][(fromX + toX) / 2].equals("[w]") || board.field[(fromY + toY) / 2][(fromX + toX) / 2].equals("[W]")) && whoesIsTurn.equals("[b]")) {
                return true;
            } else if (((Math.abs(fromX - toX) <= 7) && board.field[fromY][fromX].equals("[B]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[b]")) && ((fromX > toX) && (fromY < toY)) && (board.field[toY-1][toX+1].equals("[w]") || board.field[toY-1][toX+1].equals("[W]")) && board.field[toY-2][toX+2].equals("[ ]")) {
                return true;
            }else if (((Math.abs(fromX - toX) <= 7) && board.field[fromY][fromX].equals("[B]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[b]")) && ((fromX < toX) && (fromY > toY)) && (board.field[toY+1][toX-1].equals("[w]") || board.field[toY+1][toX-1].equals("[W]")) && board.field[toY+2][toX-2].equals("[ ]")) {
                return true;
            }else if (((Math.abs(fromX - toX) <= 7) && board.field[fromY][fromX].equals("[B]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[b]")) && ((fromX < toX) && (fromY < toY)) && (board.field[toY-1][toX-1].equals("[w]") || board.field[toY-1][toX-1].equals("[W]")) && board.field[toY-2][toX-2].equals("[ ]")) {
                return true;
            }else if (((Math.abs(fromX - toX) <= 7) && board.field[fromY][fromX].equals("[B]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[b]")) && ((fromX > toX) && (fromY > toY)) && (board.field[toY+1][toX+1].equals("[w]") || board.field[toY+1][toX+1].equals("[W]")) && board.field[toY+2][toX+2].equals("[ ]")) {
                return true;
            }else if (((Math.abs(fromX - toX) <= 7) && board.field[fromY][fromX].equals("[B]") && board.field[toY][toX].equals("[ ]")) && whoesIsTurn.equals("[b]")) {   // move for crown?
                return true;
            }else if (((Math.abs(fromX - toX) == 2) && board.field[fromY][fromX].equals("[W]") && board.field[toY][toX].equals("[ ]")) && whoesIsTurn.equals("[w]") && (board.field[(fromY + toY) / 2][(fromX + toX) / 2].equals("[b]") || board.field[(fromY + toY) / 2][(fromX + toX) / 2].equals("[B]"))) {
                return true;
            } else if (((Math.abs(fromX - toX) <= 7) && board.field[fromY][fromX].equals("[W]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[w]")) && ((fromX > toX) && (fromY < toY)) && (board.field[toY-1][toX+1].equals("[b]") || board.field[toY-1][toX+1].equals("[B]")) && validCrownMove(selectedField,new int[]{toX + 2, toY - 2}, whoesIsTurn)) {
                return true;
            }else if (((Math.abs(fromX - toX) <= 7) && board.field[fromY][fromX].equals("[W]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[w]")) && ((fromX < toX) && (fromY > toY)) && (board.field[toY+1][toX-1].equals("[b]") || board.field[toY+1][toX-1].equals("[B]")) && validCrownMove(selectedField,new int[]{toX - 2, toY + 2}, whoesIsTurn)) {
                return true;
            }else if (((Math.abs(fromX - toX) <= 7) && board.field[fromY][fromX].equals("[W]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[w]")) && ((fromX < toX) && (fromY < toY)) && (board.field[toY-1][toX-1].equals("[b]") || board.field[toY-1][toX-1].equals("[B]")) && validCrownMove(selectedField,new int[]{toX - 2, toY - 2}, whoesIsTurn) ) {
                return true;
            }else if (((Math.abs(fromX - toX) <= 7) && board.field[fromY][fromX].equals("[W]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[w]")) && ((fromX > toX) && (fromY > toY)) && (board.field[toY+1][toX+1].equals("[b]") || board.field[toY+1][toX+1].equals("[B]")) && validCrownMove(selectedField,new int[]{toX + 2, toY + 2}, whoesIsTurn)) {
                return true;
            }else if (((Math.abs(fromX - toX) <= 7) && validCrownMove(selectedField,fieldToMove, whoesIsTurn))) {   // move for crown?
                return true;
            }else {
                if (!isAi) {
                    System.out.println("INVALID MOVE - TRY AGAIN");
//                    board.printBoard();
                }
            }

        }catch(Exception e) {
            System.out.println("invalid coordinate");
            board.printBoard();
        }
        return false;
    }
    private int[] selectField(int val1, int val2) {
        return new int[]{val1-1, val2-1};
    }
    }

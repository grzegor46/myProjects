package checkers.game;

import checkers.board.Board;

import java.util.*;

public class Game {

    public Board board = new Board();
    private int checker_b = 12;
    private int checker_w = 12;
    private String whoesIsTurn = "[w]";
    private boolean moved;

    public int getChecker_b() {
        return checker_b;
    }

    public int getChecker_w() {
        return checker_w;
    }

    public void getNextMove() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        if (whoesIsTurn.equals("[w]")) {
            System.out.println("It is your turn, white.");
            System.out.println(getAllPieces(whoesIsTurn));
            makeComputerMove(whoesIsTurn);
        } else if(whoesIsTurn.equals("[b]")) {
            System.out.println("It is your turn, black.");
            makeComputerMove(whoesIsTurn);
//            TODO: add enum for black and white players?

            System.out.println("Please type position FROM which square would you like to move");
            System.out.println("enter 2 digits, example first is '1'  on 'x' axis and next enter '2' is on 'y' axis");

            int[] selectedField = selectField(scanner.nextInt(), scanner.nextInt());
            System.out.println("Please type position TO which square would you like to move");
            int[] fieldToMove = selectField(scanner.nextInt(), scanner.nextInt());


            if (validMove(selectedField, fieldToMove)) {
                executeMove(selectedField, fieldToMove);
                //add here second move if is a chance to hit another checker during same turn
            }
            System.out.println(getAllPieces(whoesIsTurn));
        }
    }
                                                  // 0,5
    private void isQeen (String whoesIsTurn, int [] coordinate) {
//        coordinate[y][x]
        if (whoesIsTurn.equals("[w]") && coordinate[0]==7) {
            board.field[coordinate[0]][coordinate[1]] = "[W]";
        }
        if (whoesIsTurn.equals("[b]") && coordinate[0]==0) {
//                   [ ] [ ] [ ] [ ] [ ] [ ] [ ] [B]
            board.field[coordinate[0]][coordinate[1]] = "[B]";
        }
    }

    public ArrayList<String> getAllPieces(String whoesIsTurn) {
        ArrayList<String> coordinationForAllPieces = new ArrayList<>();
        int row;
        int piece;
        for(row=0; row < board.field.length; row++) {
            for(piece=0; piece < board.field.length; piece++) {
                if(!board.field[piece][row].equals("[ ]") && board.field[piece][row].equals(whoesIsTurn)) {
                    String rowStr = Integer.toString(row);
                    String pieceStr = Integer.toString(piece);
                    ArrayList<String> coordinate = new ArrayList<>();
                    coordinate.add(pieceStr);
                    coordinate.add(rowStr);
                    coordinationForAllPieces.add(String.valueOf(coordinate));
                }
            }
        }
        return coordinationForAllPieces;
    }

//    public void getAllValidMoves(String whoesIsTurn) {
//        boolean validMoveP = false;
//        ArrayList<String> allPieces = getAllPieces(whoesIsTurn);
//        ArrayList<Integer> allPiecesWithValidMoves;
//        if(whoesIsTurn.equals("[w]")) {
////            int counterWholeLoop = 0;
//            for(int i=allPieces.size()-1; i >= 0;i--) {
//                int selectRandomPieceonBoard = (int)(Math.random() *(allPieces.size()));
//                String temp = allPieces.get(selectRandomPieceonBoard);
//                temp = temp.replaceAll("[/[\\[\\]']+/g]", "");
//                String subStr1 = temp.substring(0,1);
//                String subStr2 = temp.substring(3,4);
//                int tempInt1 = Integer.parseInt(subStr1);
//                int tempInt2 = Integer.parseInt(subStr2);
//                int [] tempInt = {tempInt2, tempInt1};
////                int [] tempInt = {1,2};
////TODO: change position : 5 is x, 2 is y in validMove method
//
//                int counterValidMove = 0; // zmienna powodująca że po 50 nieudanych wylosowanych validMoves, przeskoczy do nastepnego pionka
//                while(!validMoveP) {
//                    int [] tempIntRandom = {(int)(Math.random() *(8)),(int)(Math.random() *(8))};
//                    validMoveP = validMove(tempInt, tempIntRandom);
//                    counterValidMove++;
//                    if(counterValidMove==50) {
//                        break;
//                    }
////                    System.out.println("tempIntRandom" + Arrays.toString(tempIntRandom));
//
//                    if(validMoveP) {
//                        executeMove(tempInt, tempIntRandom);
////                        System.out.println("tempIntTable with valid move" + Arrays.toString(tempIntRandom));
////                        System.out.println("defined table {2,7}" + Arrays.toString(tempInt));
//                        board.printBoard();
////                        break;
//                    }
//                }
////                System.out.println(allPieces.get(i));
//            }
//        }
//
//        //        should return array with possible moves
//    }

    public void makeComputerMove(String whoesIsTurn) {
        boolean validMoveP = false;
        ArrayList<String> allPieces = getAllPieces(whoesIsTurn);
        if(whoesIsTurn.equals("[w]")) {
            for(int i=allPieces.size()-1; i >= 0;i--) {
                int selectRandomPieceOnBoard = (int)(Math.random() *(allPieces.size()));
                String temp = allPieces.get(selectRandomPieceOnBoard);
                temp = temp.replaceAll("[/[\\[\\]']+/g]", "");
                String subStr1 = temp.substring(0,1);
                String subStr2 = temp.substring(3,4);
                int tempInt1 = Integer.parseInt(subStr1);
                int tempInt2 = Integer.parseInt(subStr2);
                int [] tempInt = {tempInt2, tempInt1};
//                int [] tempInt = {1,2}; //TODO: change position : 5 is x, 2 is y in validMove method
                int counterValidMove = 0; // zmienna powodująca że po 50 nieudanych wylosowanych validMoves, przeskoczy do nastepnego pionka

                while(!validMoveP) {
                    int [] tempIntRandom = {(int)(Math.random() *(8)),(int)(Math.random() *(8))};
                    validMoveP = validMove(tempInt, tempIntRandom);
                    counterValidMove++;
                    if(counterValidMove==50) {
                        break;
                    }
//                    System.out.println("tempIntRandom" + Arrays.toString(tempIntRandom));

                    if(validMoveP) {
                        executeMove(tempInt, tempIntRandom);
                        isQeen(whoesIsTurn,tempIntRandom);
                        board.printBoard();
//                        break;
                    }
                }
//                System.out.println(allPieces.get(i));
            }
        }


        //        should return array with possible moves
    }

    private int[] selectField(int val1, int val2) {
        return new int[]{val1-1, val2-1};
    }

    public boolean validMove(int[] selectedField, int[] fieldToMove) {

        int fromX = (selectedField[0]);
        int fromY = (selectedField[1]);
        int toX = (fieldToMove[0]);
        int toY = (fieldToMove[1]);

        if ((fromX < 0 && fromY < 0) || (fromX > 7 && fromY > 7) || (toX < 0 && toY < 0) || (toX > 7 && toY > 7)) {
            return false;
        } else if ((Math.abs(fromX - toX) == 1) && board.field[toY][toX].equals("[ ]") && ((whoesIsTurn.equals("[b]") && board.field[fromY][fromX].equals("[b]")) && fromY-toY == 1 || (whoesIsTurn.equals("[w]") && board.field[fromY][fromX].equals("[w]")) && fromY-toY == -1)) {
            return true;
        } else if (((Math.abs(fromX - toX) == 2)  && board.field[toY][toX].equals("[ ]")) && board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[w]") && whoesIsTurn.equals("[b]")) {
            return true;
        }else if (((Math.abs(fromX - toX) == 2)  && board.field[toY][toX].equals("[ ]")) && board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[b]") && whoesIsTurn.equals("[w]")) {
            return true;
        }else if (((Math.abs(fromX - toX) <= 8) && board.field[fromY][fromX].equals("[B]") && board.field[toY][toX].equals("[ ]")) && board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[w]") && whoesIsTurn.equals("[b]")) {   // move for crown?
            return true;
        }else {
//            System.out.println("invalid move");
        }
            return false;
        }


        public void executeMove(int [] selectedField, int [] fieldToMove){

            int fromX = (selectedField[0]);
            int fromY = (selectedField[1]);
            int toX = (fieldToMove[0]); // 6 --> 5
            int toY = (fieldToMove[1]); // 1 --> 0

            if ((Math.abs(fromX - toX) == 1) && Objects.equals(board.field[toY][toX], "[ ]")) {
                board.field[toY][toX] = board.field[fromY][fromX];
                board.field[fromY][fromX] = "[ ]";
                isQeen(whoesIsTurn,new int[]{toY, toX});
                if(whoesIsTurn.equals("[w]")) {
                    whoesIsTurn = "[b]";
                } else {
                    whoesIsTurn = "[w]";
                }
            }
// TODO: think about movement with crown piece
            if ((Math.abs(fromX - toX) < 8) && Objects.equals(board.field[toY][toX], "[ ]")) {
                board.field[toY][toX] = board.field[fromY][fromX];
                board.field[fromY][fromX] = "[ ]";
                isQeen(whoesIsTurn,new int[]{toY, toX});
                if(whoesIsTurn.equals("[w]")) {
                    whoesIsTurn = "[b]";
                } else {
                    whoesIsTurn = "[w]";
                }
            }
            // jump over opponent
            if((Math.abs(fromX - toX) == 2) && Math.abs(fromY - toY) ==2 ) {
                if(whoesIsTurn.equals("[w]") && board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[b]")) {
                    board.field[(fromY + toY) / 2][(fromX + toX) / 2] = "[ ]";
                    board.field[toY][toX] = board.field[fromY][fromX];
                    board.field[fromY][fromX] = "[ ]";
              }

                if(whoesIsTurn.equals("[b]") && board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[w]")) {
                    board.field[(fromY + toY) / 2][(fromX + toX) / 2] = "[ ]";
                    board.field[toY][toX] = board.field[fromY][fromX];
                    board.field[fromY][fromX] = "[ ]";
                }

                if(whoesIsTurn.equals("[w]")) {
                    checker_b--;
                    whoesIsTurn = "[b]";
                } else {
                    checker_w--;
                    whoesIsTurn = "[w]";

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


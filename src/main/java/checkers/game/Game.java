package checkers.game;

import checkers.board.Board;


import java.util.*;

public class Game {

    public Board board = new Board();
    private int checker_b = 12;
    private int checker_w = 12;
    private String whoesIsTurn = "[w]";
    private boolean isAi = true;
    private boolean moved;

    public int getChecker_b() {
        return checker_b;
    }

    public int getChecker_w() {
        return checker_w;
    }

    public void selectGameType(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chose type of game");
        System.out.println("1 is player vs player");
        System.out.println("2 is player vs AI");
        if (scanner.nextInt() == 1){
            isAi = false;
        }
    }

    private void humanDecision (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type position FROM which square would you like to move");
        System.out.println("enter 2 digits, example first is '1'  on 'x' axis and next enter '2' is on 'y' axis");

        int[] selectedField = selectField(scanner.nextInt(), scanner.nextInt());
        System.out.println("Please type position TO which square would you like to move");
        int[] fieldToMove = selectField(scanner.nextInt(), scanner.nextInt());

        if (validMove(selectedField, fieldToMove)) {
            executeMove(selectedField, fieldToMove);
            // TODO add here second move if is a chance to hit another checker during same turn
        }
        board.printBoard();
    }

    public void getNextMove() throws InterruptedException {

        if (whoesIsTurn.equals("[w]")) {
            System.out.println("It is your turn, white.");
            System.out.println(board.getAllPieces(whoesIsTurn));
            if(isAi){
                makeComputerMove(whoesIsTurn);
            } else {
                humanDecision();
            }
        } else if(whoesIsTurn.equals("[b]")) {
            System.out.println("It is your turn, black.");
            humanDecision();
//TODO: add enum for black and white players?
// TODO add here second move if is a chance to hit another checker during same turn

//            System.out.println(getAllPieces(whoesIsTurn));
        }
    }
                                                  // 0,5
    private void isQueen (String whoesIsTurn, int [] coordinate) {
//        coordinate[y][x]
        if (whoesIsTurn.equals("[w]") && coordinate[0]==7 && Objects.equals(board.field[coordinate[0]][coordinate[1]], "[w]")) {
            board.field[coordinate[0]][coordinate[1]] = "[W]";
        }
        if (whoesIsTurn.equals("[b]") && coordinate[0]==0 && Objects.equals(board.field[coordinate[0]][coordinate[1]], "[b]")) {
//                   [ ] [ ] [ ] [ ] [ ] [ ] [ ] [B]
            board.field[coordinate[0]][coordinate[1]] = "[B]";
        }
    }

    private boolean isQueenSelected(String whoesIsTurn, int [] coordinate) {
//                             Y                 X
        return board.field[coordinate[1]][coordinate[0]].equals("[W]") && whoesIsTurn.equals("[w]");
    }

    private int [] generateRandomCoordinate() {
        return new int[]{(int) (Math.random() * (8)), (int) (Math.random() * (8))};
    }

    public void makeComputerMove(String whoesIsTurn) {
        boolean validMoveP = false;
        ArrayList<String> allPieces = board.getAllPieces(whoesIsTurn);
        if(whoesIsTurn.equals("[w]")) {
            boolean moved = false;

                for (int i = allPieces.size() - 1; i >= 0; i--) {
                  if(!moved) {
                    int selectRandomPieceOnBoard = (int) (Math.random() * (allPieces.size()));

                    String temp = allPieces.get(selectRandomPieceOnBoard);
                    temp = temp.replaceAll("[/[\\[\\]']+/g]", "");
                    String subStr1 = temp.substring(0, 1);
                    String subStr2 = temp.substring(3, 4);
                    int tempInt1 = Integer.parseInt(subStr1);
                    int tempInt2 = Integer.parseInt(subStr2);
                    int[] tempInt = {tempInt2, tempInt1};
//                int [] tempInt = {1,2}; //TODO: change position : 5 is x, 2 is y in validMove method

                    int[] tempIntRandom = generateRandomCoordinate();
                    validMoveP = validMove(tempInt, tempIntRandom);

                    if (validMoveP && !isQueenSelected(whoesIsTurn, tempInt)) {
                        executeMove(tempInt, tempIntRandom);
                        isQueen(whoesIsTurn, tempIntRandom);
                        board.printBoard();
                        moved = true;
                    }
                    if(isQueenSelected(whoesIsTurn, tempInt)) {
                        executeCrownMove(whoesIsTurn, tempInt, tempIntRandom);
                        moved = true;
                    }


                  }
            }
        }
    }
//
    private void executeCrownMove( String whoesIsTurn, int[] selectedFieldWithCrown, int[] generatedRandomFieldByComputer) {
        int fromX = (selectedFieldWithCrown[0]); // x=4
        int fromY = (selectedFieldWithCrown[1]); // y=3
        int toX = (generatedRandomFieldByComputer[0]); // x=2
        int toY = (generatedRandomFieldByComputer[1]);
        int toYDown;
        int toYUp;
        if(fromX > toX || fromX < toX) {
            toYDown =(Math.abs(fromX - toX) + fromY);
            toYUp = (Math.abs(fromX - toX) - fromY);

            if((toYDown > 7)) {
                toY = toYUp;
            }
            if(toYUp < 0) {
                toY = toYDown;
            }
            if((toYDown <= 7) && (toYUp >= 0)) {
                int randomGeneratedIndex = (int) (Math.random() * (2));
                int [] tempInt = new int[]{toYDown, toYUp};
                toY = tempInt[randomGeneratedIndex];

            }
            int [] generatedValidMoveForCrown = {toX, toY};
//            if(validMove(selectedFieldWithCrown,generatedValidMoveForCrown) && validCrownMove(selectedFieldWithCrown, generatedValidMoveForCrown)) {
            if(validCrownMove(selectedFieldWithCrown, generatedValidMoveForCrown)) {
                executeMove(selectedFieldWithCrown,generatedValidMoveForCrown);

            } else {
                System.out.println("executeCrownMove: invalidMove!");
            }

        }
        board.printBoard();
    }

    private int[] selectField(int val1, int val2) {
        return new int[]{val1-1, val2-1};
    }
//TODO crown valid move, zamiast od pkt docelowego odejmowac, to od pkt poczatkowego dodawac tak dlugo az osiagnie sie pkt docelowy
    public boolean validCrownMove(int[] selectedField, int[] fieldToMove) {



        int fromX = (selectedField[0]);
        int fromY = (selectedField[1]);
        int toX = (fieldToMove[0]);
        int toY = (fieldToMove[1]);
        int counterLoop = Math.abs(fromX-toX);

        if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[W]") && whoesIsTurn.equals("[w]")) && ((fromX > toX) && (fromY < toY)) && (board.field[toY][toX].equals("[ ]"))) {
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
         else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[W]") && whoesIsTurn.equals("[w]")) && ((fromX < toX) && (fromY > toY)) && (board.field[toY][toX].equals("[ ]"))) {
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

        else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[W]") && whoesIsTurn.equals("[w]")) && ((fromX < toX) && (fromY < toY)) && (board.field[toY][toX].equals("[ ]"))) {
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
        else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[W]") && whoesIsTurn.equals("[w]")) && ((fromX > toX) && (fromY > toY)) && (board.field[toY][toX].equals("[ ]"))) {
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

    public boolean validMove(int[] selectedField, int[] fieldToMove) {
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
            } else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[B]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[b]")) && ((fromX > toX) && (fromY < toY)) && (board.field[toY-1][toX+1].equals("[w]") || board.field[toY-1][toX+1].equals("[W]")) && board.field[toY-2][toX+2].equals("[ ]")) {
                return true;
            }else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[B]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[b]")) && ((fromX < toX) && (fromY > toY)) && (board.field[toY+1][toX-1].equals("[w]") || board.field[toY+1][toX-1].equals("[W]")) && board.field[toY+2][toX-2].equals("[ ]")) {
                return true;
            }else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[B]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[b]")) && ((fromX < toX) && (fromY < toY)) && (board.field[toY-1][toX-1].equals("[w]") || board.field[toY-1][toX-1].equals("[W]")) && board.field[toY-2][toX-2].equals("[ ]")) {
                return true;
            }else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[B]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[b]")) && ((fromX > toX) && (fromY > toY)) && (board.field[toY+1][toX+1].equals("[w]") || board.field[toY+1][toX+1].equals("[W]")) && board.field[toY+2][toX+2].equals("[ ]")) {
                return true;
            }else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[B]") && board.field[toY][toX].equals("[ ]")) && whoesIsTurn.equals("[b]")) {   // move for crown?
                return true;
            }else if (((Math.abs(fromX - toX) == 2) && board.field[fromY][fromX].equals("[W]") && board.field[toY][toX].equals("[ ]")) && whoesIsTurn.equals("[w]") && (board.field[(fromY + toY) / 2][(fromX + toX) / 2].equals("[b]") || board.field[(fromY + toY) / 2][(fromX + toX) / 2].equals("[B]"))) {
                return true;
            } else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[W]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[w]")) && ((fromX > toX) && (fromY < toY)) && (board.field[toY-1][toX+1].equals("[b]") || board.field[toY-1][toX+1].equals("[B]")) && board.field[toY-2][toX+2].equals("[ ]")) {
                return true;
            }else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[W]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[w]")) && ((fromX < toX) && (fromY > toY)) && (board.field[toY+1][toX-1].equals("[b]") || board.field[toY+1][toX-1].equals("[B]")) && board.field[toY+2][toX-2].equals("[ ]")) {
                return true;
            }else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[W]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[w]")) && ((fromX < toX) && (fromY < toY)) && (board.field[toY-1][toX-1].equals("[b]") || board.field[toY-1][toX-1].equals("[B]")) && board.field[toY-2][toX-2].equals("[ ]")) {
                return true;
            }else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[W]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[w]")) && ((fromX > toX) && (fromY > toY)) && (board.field[toY+1][toX+1].equals("[b]") || board.field[toY+1][toX+1].equals("[B]")) && board.field[toY+2][toX+2].equals("[ ]")) {
                return true;
            }else if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[W]") && board.field[toY][toX].equals("[ ]")) && whoesIsTurn.equals("[w]")) {   // move for crown?
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

        public void executeMove(int [] selectedField, int [] fieldToMove){

            int fromX = (selectedField[0]);
            int fromY = (selectedField[1]);
            int toX = (fieldToMove[0]); // 6 --> 5
            int toY = (fieldToMove[1]); // 1 --> 0

            if ((Math.abs(fromX - toX) == 1) && Objects.equals(board.field[toY][toX], "[ ]")) {
                board.field[toY][toX] = board.field[fromY][fromX];
                isQueen(whoesIsTurn,new int[]{toY, toX});
                board.field[fromY][fromX] = "[ ]";
                changePlayer();
            }
            if(((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[B]") && board.field[toY][toX].equals("[ ]")) && (board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[w]") || board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[W]")) && whoesIsTurn.equals("[b]")) {
                board.field[(fromY + toY) / 2][(fromX + toX) / 2] = "[ ]";
                board.field[toY][toX] = board.field[fromY][fromX];
                isQueen(whoesIsTurn,new int[]{toY, toX});
                board.field[fromY][fromX] = "[ ]";
                changePlayerAndRemovePiece();
            }
            if(((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[W]") && board.field[toY][toX].equals("[ ]")) && (board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[b]") || board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[B]")) && whoesIsTurn.equals("[w]")) {
                board.field[(fromY + toY) / 2][(fromX + toX) / 2] = "[ ]";
                board.field[toY][toX] = board.field[fromY][fromX];
                isQueen(whoesIsTurn,new int[]{toY, toX});
                board.field[fromY][fromX] = "[ ]";
                changePlayerAndRemovePiece();
            }

//          [B] piece
            if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[B]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[b]"))) {
                if ((fromX > toX) && (fromY < toY) && (board.field[toY-1][toX+1].equals("[w]") || board.field[toY-1][toX+1].equals("[W]")) && board.field[toY-2][toX+2].equals("[ ]")) {
                    board.field[toY][toX] = board.field[fromY][fromX];
                    isQueen(whoesIsTurn,new int[]{toY, toX});
                    board.field[toY-1][toX+1] = "[ ]";
                    board.field[fromY][fromX] = "[ ]";
                    changePlayerAndRemovePiece();
                }else if ((fromX < toX) && (fromY > toY) && (board.field[toY+1][toX-1].equals("[w]") || board.field[toY+1][toX-1].equals("[W]")) && board.field[toY+2][toX-2].equals("[ ]")) {
                    board.field[toY][toX] = board.field[fromY][fromX];
                    isQueen(whoesIsTurn,new int[]{toY, toX});
                    board.field[toY+1][toX-1] = "[ ]";
                    board.field[fromY][fromX] = "[ ]";
                    changePlayerAndRemovePiece();
                }else if ((fromX < toX) && (fromY < toY) && (board.field[toY-1][toX-1].equals("[w]") || board.field[toY-1][toX-1].equals("[W]")) && board.field[toY-2][toX-2].equals("[ ]")) {
                    board.field[toY][toX] = board.field[fromY][fromX];
                    isQueen(whoesIsTurn,new int[]{toY, toX});
                    board.field[toY-1][toX-1] = "[ ]";
                    board.field[fromY][fromX] = "[ ]";
                    changePlayerAndRemovePiece();
                }else if ((fromX > toX) && (fromY > toY) && (board.field[toY+1][toX+1].equals("[w]") || board.field[toY+1][toX+1].equals("[W]")) && board.field[toY+2][toX+2].equals("[ ]")) {
                    board.field[toY][toX] = board.field[fromY][fromX];
                    isQueen(whoesIsTurn, new int[]{toY, toX});
                    board.field[toY + 1][toX + 1] = "[ ]";
                    board.field[fromY][fromX] = "[ ]";
                    changePlayerAndRemovePiece();
                }
            }
//          [W] piece
            if (((Math.abs(fromX - toX) < 7) && board.field[fromY][fromX].equals("[W]") && board.field[toY][toX].equals("[ ]") && whoesIsTurn.equals("[w]"))) {
                if ((fromX > toX) && (fromY < toY) && (board.field[toY-1][toX+1].equals("[b]") || board.field[toY-1][toX+1].equals("[B]")) && board.field[toY-2][toX+2].equals("[ ]")) {
                    board.field[toY][toX] = board.field[fromY][fromX];
                    isQueen(whoesIsTurn,new int[]{toY, toX});
                    board.field[toY-1][toX+1] = "[ ]";
                    board.field[fromY][fromX] = "[ ]";
                    changePlayerAndRemovePiece();
                }else if ((fromX < toX) && (fromY > toY) && (board.field[toY+1][toX-1].equals("[b]") || board.field[toY+1][toX-1].equals("[B]")) && board.field[toY+2][toX-2].equals("[ ]")) {
                    board.field[toY][toX] = board.field[fromY][fromX];
                    isQueen(whoesIsTurn,new int[]{toY, toX});
                    board.field[toY+1][toX-1] = "[ ]";
                    board.field[fromY][fromX] = "[ ]";
                    changePlayerAndRemovePiece();
                }else if ((fromX < toX) && (fromY < toY) && (board.field[toY-1][toX-1].equals("[b]") || board.field[toY-1][toX-1].equals("[B]")) && board.field[toY-2][toX-2].equals("[ ]")) {
                    board.field[toY][toX] = board.field[fromY][fromX];
                    isQueen(whoesIsTurn,new int[]{toY, toX});
                    board.field[toY-1][toX-1] = "[ ]";
                    board.field[fromY][fromX] = "[ ]";
                    changePlayerAndRemovePiece();
                }else if ((fromX > toX) && (fromY > toY) && (board.field[toY+1][toX+1].equals("[b]") || board.field[toY+1][toX+1].equals("[B]")) && board.field[toY+2][toX+2].equals("[ ]")) {
                    board.field[toY][toX] = board.field[fromY][fromX];
                    isQueen(whoesIsTurn, new int[]{toY, toX});
                    board.field[toY + 1][toX + 1] = "[ ]";
                    board.field[fromY][fromX] = "[ ]";
                    changePlayerAndRemovePiece();
                }
            }
            // just move
            if ((Math.abs(fromX - toX) < 7) && Objects.equals(board.field[toY][toX], "[ ]") && (board.field[fromY][fromX].equals("[B]") || board.field[fromY][fromX].equals("[W]")) ) {
                board.field[toY][toX] = board.field[fromY][fromX];
                isQueen(whoesIsTurn,new int[]{toY, toX});
                board.field[fromY][fromX] = "[ ]";
                changePlayer();
            }
            // jump over opponent
            if((Math.abs(fromX - toX) == 2) && Math.abs(fromY - toY) ==2 ) {
                if(whoesIsTurn.equals("[w]") && (board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[b]") || board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[B]"))) {
                    board.field[(fromY + toY) / 2][(fromX + toX) / 2] = "[ ]";
                    board.field[toY][toX] = board.field[fromY][fromX];
                    isQueen(whoesIsTurn,new int[]{toY, toX});
                    board.field[fromY][fromX] = "[ ]";
                    changePlayerAndRemovePiece();
                } else if(whoesIsTurn.equals("[b]") && (board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[w]") || board.field[(fromY+toY)/2][(fromX+toX)/2].equals("[W]"))) {
                    board.field[(fromY + toY) / 2][(fromX + toX) / 2] = "[ ]";
                    board.field[toY][toX] = board.field[fromY][fromX];
                    isQueen(whoesIsTurn,new int[]{toY, toX});
                    board.field[fromY][fromX] = "[ ]";
                    changePlayerAndRemovePiece();
                }
            }
        }

    private void changePlayer() {
        if(whoesIsTurn.equals("[w]")) {
            whoesIsTurn = "[b]";
        } else {
            whoesIsTurn = "[w]";
        }
    }

    private void changePlayerAndRemovePiece() {
        if(whoesIsTurn.equals("[w]")) {
            checker_b--;
            whoesIsTurn = "[b]";
        } else {
            checker_w--;
            whoesIsTurn = "[w]";
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
            return "white";
        else
            return "black";
    }
}


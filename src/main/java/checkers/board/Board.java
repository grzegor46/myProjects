package checkers.board;

import java.util.ArrayList;

public class Board {
    public String[][] field;

    public Board() {
        this.field = new String[8][8];
    }

    public String[][] getFields() {
        return field;
    }

    public void initialBoardWithRedAndBlackChecker() {

        for( int i = 0; i < 8; i += 1) {
            for (int j = 0; j < 8; j += 1 ){
                field[i][j] = "[ ]";
            }
            System.out.println();
        }

        for( int i = 0; i < 8; i += 1) {
            for (int j = 1; j < 8; j += 2 ){
                if(i==0 || i==2 ) {
                    field[i][j] = "[w]";
                }
                if(i==6) {
                    field[i][j] = "[b]";
                }
            }
            for (int j = 0; j < 8; j += 2 ){
                if(i==1) {
                    field[i][j] = "[w]";
                }
                if(i==7 || i==5) {
                    field[i][j] = "[b]";
                }
            }
            System.out.println();
        }
    }
    public void printBoard() {
        System.out.println("   1   2   3   4   5   6   7   8  X");
        for( int i = 0; i < 8; i += 1) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < 8; j += 1 ){
                System.out.print(field[i][j]+" ");
            }
            System.out.println();
        }
        System.out.print("Y");
        System.out.println("");
    }
    public ArrayList<String> getAllPieces(String whoesIsTurn) {
        ArrayList<String> coordinationForAllPieces = new ArrayList<>();
        int row;
        int piece;
        for(row=0; row < field.length; row++) {
            for(piece=0; piece < field.length; piece++) {
                if(!field[piece][row].equals("[ ]") && field[piece][row].equals(whoesIsTurn)) {
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






    }

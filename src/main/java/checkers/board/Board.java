package checkers.board;

public class Board {
    public String[][] field;

    public Board() {
        this.field = new String[8][8];
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
    }

    }

package checkers.board;

public class Board {
    public char[][] board;

    public Board() {
        this.board = new char[8][8];
    }

    public String[][] tablicaPionkow = {
            {"[ ]", "[x]", "[ ]", "[x]", "[ ]", "[x]", "[ ]", "[x]"}, // 1
            {"[x]", "[ ]", "[x]", "[ ]", "[x]", "[ ]", "[x]", "[ ]"}, // 2
            {"[ ]", "[x]", "[ ]", "[x]", "[ ]", "[x]", "[ ]", "[x]"}, // 3
            {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, // 4
            {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, // 5
            {"[o]", "[ ]", "[o]", "[ ]", "[o]", "[ ]", "[o]", "[ ]"}, // 6
            {"[ ]", "[o]", "[ ]", "[o]", "[ ]", "[o]", "[ ]", "[o]"}, // 7
            {"[o]", "[ ]", "[o]", "[ ]", "[o]", "[ ]", "[o]", "[ ]"}, // 8
//                 1     2     3     4     5     6     7     8
    };

    public void initialBoardWithRedAndBlackChecker() {

        int i,j;
        for(i=0;i<8;i++) {
            for(j=0;j<8;j++){
                board[i][j] = '_';
            }
        }
        for(i=0;i<8;i+=2) {
            board[i][1]= 'r';
            board[i][5]= 'b';
            board[i][7]= 'b';
        }
        for(i=1;i<8;i+=2) {
            board[i][0]= 'r';
            board[i][2]= 'r';
            board[i][6]= 'b';
        }
    }
    public void printBoard() {
        int i,j;
        System.out.println("  1 2 3 4 5 6 7 8 x");
        for (i=0;i<8;i++) {
            System.out.print((i+1) + " ");
            for (j=0;j<8;j++) {
                // j - pobiera zerowy indeks z każdego nastepnego rzedu
                System.out.print(board[j][i]+ " ");
            }
            System.out.println();
        }
        System.out.println("y");
    }

    public void printBoard2() {
        int i,j;
        System.out.println("  1 2 3 4 5 6 7 8 x");
        for (i=0;i<8;i++) {
            System.out.print((i+1) + " ");
            for (j=0;j<8;j++) {
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("y");
    }

    }

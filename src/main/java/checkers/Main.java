package checkers;

import checkers.board.Board;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
//        Referee referee = new Referee();
//        Game game = new Game();
//
//        game.printboard(board.tablicaPionkow);

        board.initialBoardWithRedAndBlackChecker();
        board.printBoard();
        System.out.println("__________________");
        board.printBoard2();
    }
}

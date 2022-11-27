package checkers;

import checkers.board.Board;
import checkers.game.Game;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        Referee referee = new Referee();
        Game game = new Game();
//
//        game.printboard(board.tablicaPionkow);

        board.initialBoardWithRedAndBlackChecker();
        board.printBoard();
        game.getNextMove();
        board.printBoard();

    }

}

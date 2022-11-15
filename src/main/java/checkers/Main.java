package checkers;

import checkers.board.Board;
import checkers.referee.Referee;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Referee referee = new Referee();

        Referee.printboard(board.tablicaPionkow);


    }
}

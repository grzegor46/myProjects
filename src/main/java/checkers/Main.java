package checkers;

import checkers.board.Board;
import checkers.game.Game;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game();
		game.board.initialBoardWithRedAndBlackChecker();
		game.board.printBoard();
		game.selectGameType();

		// Loop until game is over.
	while (!game.gameOver()) {

	    game.getNextMove();
		System.out.println( "black checkers: "+ game.getChecker_b());
		System.out.println("white checkers: "+ game.getChecker_w());
	}
		System.out.println("The winner is: " + game.winnerIs());
    }
}

package checkers;

import checkers.game.Game;

import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

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

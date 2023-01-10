package checkers;

import checkers.board.Board;
import checkers.game.Game;


public class Main {

    public static void main(String[] args) {
//        Referee referee = new Referee();
        Game game = new Game();

		game.board.initialBoardWithRedAndBlackChecker();
		game.board.printBoard();

		// Loop until game is over.
	while (!game.gameOver()) {
	    //Execute a move and print the board out afterwards.
	    game.getNextMove();
		game.board.printBoard();
	}
		System.out.println("The winner is: " + game.winnerIs());
    }

}

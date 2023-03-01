package checkers;

import checkers.board.Board;
import checkers.game.Game;

import java.util.Arrays;


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
//		game.board.printBoard();    printig board is in game.getvalidmoves, for now commentout
		System.out.println( "black checkers: "+ game.getChecker_b());
		System.out.println("white checkers: "+ game.getChecker_w());

//		System.out.println(Arrays.toString(Arrays.stream(game.board.getFields()).toArray()));

	}
		System.out.println("The winner is: " + game.winnerIs());
    }

}

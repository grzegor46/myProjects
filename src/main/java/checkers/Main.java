package checkers;

import checkers.game.Game;


public class Main {

    public static void main(String[] args) {
//        Referee referee = new Referee();
        Game game = new Game();

        // Setup and print out checker board.
        game.initialBoardWithRedAndBlackChecker();
	game.printBoard();

	// Loop until game is over.
	while (!game.gameOver()) {
	    //Execute a move and print the board out afterwards.
	    game.getNextMove();
	    game.printBoard();
	}

    }

}

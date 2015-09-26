package game.exception;

/**
 * GameException is to be thrown whenever something goes wrong with the game
 * logic. Should not be used for failing to load resources.
 * 
 * @author Brendan Goodenough
 * @version 0.1.0
 */

public class GameException extends Exception {
	public GameException(String message) {
		super(message);
	}
}

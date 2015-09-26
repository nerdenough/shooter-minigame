package game.exception;

/**
 * GraphicsException is to be thrown whenever something goes when loading a
 * resource fails or any graphics related error. Should not be used for game
 * logic.
 * 
 * @author Brendan Goodenough
 * @version 0.1.0
 */

@SuppressWarnings("serial")
public class GraphicsException extends Exception {
	public GraphicsException(String message) {
		super(message);
	}
}

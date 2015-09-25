package game.state;

import java.awt.Graphics2D;

/**
 * GameState is an abstract class designed to be the foundation for each
 * possible state in the game, allowing the states to be stored in a single list
 * and accessed via the same methods.
 * 
 * @author Brendan Goodenough
 * @version 0.1.0
 */

public abstract class GameState {
	protected GameStateManager gsm;

	/**
	 * Constructs the GameState by setting the GameStateManager object to use
	 * for changing states.
	 * 
	 * @param gsm - GameStateManager object
	 */
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}

	/**
	 * Initializes the state by initializing any required objects and setting
	 * initial values.
	 */
	public abstract void init();

	/**
	 * Updates the frame for the current state by handling any game logic.
	 */
	public abstract void update();

	/**
	 * Renders the frame for the current state.
	 * 
	 * @param g2 - graphics object for rendering
	 */
	public abstract void render(Graphics2D g2);

	/**
	 * Handles a key press event.
	 * 
	 * @param key - keycode of the pressed key
	 */
	public abstract void keyPressed(int key);

	/**
	 * Handles a key release event.
	 * 
	 * @param key - keycode of the released key
	 */
	public abstract void keyReleased(int key);
}

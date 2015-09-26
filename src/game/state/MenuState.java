package game.state;

import java.awt.Color;
import java.awt.Graphics2D;

import com.sun.glass.events.KeyEvent;

import game.exception.GameException;
import game.exception.GraphicsException;
import game.graphics.GraphicsLoader;
import game.graphics.Sprite;
import game.graphics.StaticSprite;

/**
 * MenuState contains all the logic and rendering for the menu of the game.
 * 
 * @author Brendan Goodenough
 * @version 0.1.0
 */

public class MenuState extends GameState {
	private Sprite starfield;

	private int selectedOption;
	private String[] options = { "Play", "Options", "Quit" };

	/**
	 * Passes the GameStateManager object to the parent GameState class.
	 * 
	 * @param gsm - GameStateManager object
	 */
	public MenuState(GameStateManager gsm) {
		super(gsm);
	}

	/**
	 * Initializes all required objects and variables in the state.
	 */
	@Override
	public void init() {
		try {
			starfield = new StaticSprite(GraphicsLoader.loadImage("/backgrounds/menu.png"));
		} catch (GraphicsException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updates all game logic for the state.
	 */
	@Override
	public void update() {
		starfield.setX(starfield.getX() - 0.4f);
		if (starfield.getX() <= -starfield.getWidth()) {
			starfield.setX(0);
		}
	}

	/**
	 * Renders all graphics for the state.
	 * 
	 * @param g2 - graphics object
	 */
	@Override
	public void render(Graphics2D g2) {
		starfield.render(g2);
		starfield.render(g2, starfield.getX() + starfield.getWidth(), 0);

		g2.setColor(Color.WHITE);
		g2.drawString("Space Shooter", 40, 40);

		for (int i = 0; i < options.length; i++) {
			if (i == selectedOption) {
				g2.setColor(new Color(240, 60, 60));
			} else {
				g2.setColor(Color.WHITE);
			}
			g2.drawString(options[i], 40, 80 + (i * 18));
		}
	}

	/**
	 * Handles any key press events that are passed through.
	 * 
	 * @param key - key code
	 */
	@Override
	public void keyPressed(int key) {
		if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_ENTER) {
			try {
				switch (selectedOption) {
				case 0:
					gsm.setCurrentState(1);
					break;
				case 1:
					// TODO: Options menu
					break;
				case 2:
					System.exit(0);
					break;
				}
			} catch (GameException e) {
			}
		}

		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
			selectedOption--;

			if (selectedOption < 0) {
				selectedOption = options.length - 1;
			}
		}

		if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
			selectedOption++;

			if (selectedOption >= options.length) {
				selectedOption = 0;
			}
		}
	}

	/**
	 * Handles any key release events that are passed through.
	 * 
	 * @param key - key code
	 */
	@Override
	public void keyReleased(int key) {
		// TODO Auto-generated method stub

	}

}

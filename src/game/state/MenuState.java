package game.state;

import java.awt.Graphics2D;

import game.Game;
import game.graphics.Image;
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

	/**
	 * Passes the GameStateManager object to the parent GameState class.
	 * 
	 * @param gsm - GameStateManager object
	 */
	public MenuState(GameStateManager gsm) {
		super(gsm);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.state.GameState#init()
	 */
	@Override
	public void init() {
		starfield = new StaticSprite(Image.loadImage("/backgrounds/menu.png"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.state.GameState#update()
	 */
	@Override
	public void update() {
		starfield.setX(starfield.getX() - 0.5f);
		if (starfield.getX() <= -Game.WIDTH) {
			starfield.setX(0);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.state.GameState#render(java.awt.Graphics2D)
	 */
	@Override
	public void render(Graphics2D g2) {
		starfield.render(g2);
		starfield.render(g2, starfield.getX() + Game.WIDTH, 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.state.GameState#keyPressed(int)
	 */
	@Override
	public void keyPressed(int key) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.state.GameState#keyReleased(int)
	 */
	@Override
	public void keyReleased(int key) {
		// TODO Auto-generated method stub

	}

}

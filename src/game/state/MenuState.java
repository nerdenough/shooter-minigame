package game.state;

import java.awt.Color;
import java.awt.Graphics2D;

import game.Game;
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
		starfield = new StaticSprite(GraphicsLoader.loadImage("/backgrounds/menu.png"));
	}

	/**
	 * Updates all game logic for the state.
	 */
	@Override
	public void update() {
		starfield.setX(starfield.getX() - 0.5f);
		if (starfield.getX() <= -Game.WIDTH) {
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
		starfield.render(g2, starfield.getX() + Game.WIDTH, 0);
		
		g2.setColor(Color.WHITE);
		g2.drawString("Shooter Minigame", 40, 40);
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

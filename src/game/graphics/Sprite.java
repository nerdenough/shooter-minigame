package game.graphics;

import java.awt.Graphics2D;

/**
 * Sprite is an interface for the shared methods of StaticSprite and
 * AnimatedSprite, allowing both to be stored in the same arrays.
 * 
 * @author Brendan Goodenough
 * @version 0.1.0
 */

public interface Sprite {
	/**
	 * Updates the sprite for the current frame.
	 */
	public void update();

	/**
	 * Renders the sprite to the screen.
	 * 
	 * @param g2
	 */
	public void render(Graphics2D g2);

	/**
	 * Renders the sprite to the screen at an alternate position.
	 * 
	 * @param g2 - graphics object
	 * @param x - x position
	 * @param y - y position
	 */
	public void render(Graphics2D g2, float x, float y);

	/**
	 * Gets the x position of the sprite.
	 * 
	 * @return x
	 */
	public float getX();

	/**
	 * Gets the y position of the sprite.
	 * 
	 * @return y
	 */
	public float getY();

	/**
	 * Gets the width of the sprite.
	 * 
	 * @return width
	 */
	public int getWidth();

	/**
	 * Gets the height of the sprite.
	 * 
	 * @return height
	 */
	public int getHeight();

	/**
	 * Sets the x position of the sprite.
	 * 
	 * @param x - x position
	 */
	public void setX(float x);

	/**
	 * Sets the y position of the sprite.
	 * 
	 * @param y - y position
	 */
	public void setY(float y);

	/**
	 * Sets the width of the sprite.
	 * 
	 * @param width - frame width
	 */
	public void setWidth(int width);

	/**
	 * Sets the height of the sprite.
	 * 
	 * @param height - frame height
	 */
	public void setHeight(int height);
}

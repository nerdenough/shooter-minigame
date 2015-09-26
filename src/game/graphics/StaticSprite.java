package game.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * StaticSprite is responsible for rendering a single image in the specified
 * spritesheet.
 * 
 * @author Brendan Goodenough
 * @version 0.1.0
 */

public class StaticSprite implements Sprite {
	protected float x, y;
	protected int width, height, frame;
	protected BufferedImage sprite;

	/**
	 * Constructs a new Sprite with the specified image, position and
	 * dimensions.
	 * 
	 * @param sprite - image
	 * @param x - x position
	 * @param y - y position
	 * @param width - width to draw
	 * @param height - height to draw
	 */
	public StaticSprite(BufferedImage sprite, int x, int y, int width, int height) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Constructs a new Sprite with the specified image and position.
	 * 
	 * @param sprite - image
	 * @param x - x position
	 * @param y - y position
	 */
	public StaticSprite(BufferedImage sprite, int x, int y) {
		this(sprite, x, y, sprite.getWidth(), sprite.getHeight());
	}

	/**
	 * Constructs a new Sprite with the specified image.
	 * 
	 * @param sprite - image
	 */
	public StaticSprite(BufferedImage sprite) {
		this(sprite, 0, 0, sprite.getWidth(), sprite.getHeight());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.graphics.Sprite#update()
	 */
	public void update() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.graphics.Sprite#render(java.awt.Graphics2D)
	 */
	public void render(Graphics2D g2) {
		g2.drawImage(sprite, (int) x, (int) y, width, height, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.graphics.Sprite#render(java.awt.Graphics2D, int, int)
	 */
	public void render(Graphics2D g2, float x, float y) {
		g2.drawImage(sprite, (int) x, (int) y, width, height, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.graphics.Sprite#getX()
	 */
	public float getX() {
		return x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.graphics.Sprite#getY()
	 */
	public float getY() {
		return y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.graphics.Sprite#getWidth()
	 */
	public int getWidth() {
		return width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.graphics.Sprite#getHeight()
	 */
	public int getHeight() {
		return height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.graphics.Sprite#setX(int)
	 */
	public void setX(float x) {
		this.x = x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.graphics.Sprite#setY(int)
	 */
	public void setY(float y) {
		this.y = y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.graphics.Sprite#setWidth(int)
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.graphics.Sprite#setHeight(int)
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}

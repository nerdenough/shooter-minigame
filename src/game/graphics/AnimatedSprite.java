package game.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * AnimatedSprite is responsible for animating a sprite by running through
 * various frames in the specified spritesheet.
 * 
 * @author Brendan Goodenough
 * @version 0.1.0
 */

public class AnimatedSprite implements Sprite {
	protected float x, y;
	protected int width, height, frame;
	protected BufferedImage currentSprite;
	protected BufferedImage[] sprites;
	protected long timer;

	/**
	 * Constructs a new AnimatedSprite with the specified frames, position and
	 * dimensions.
	 * 
	 * @param sprites - frames
	 * @param x - x position
	 * @param y - y position
	 * @param width - width to draw
	 * @param height - height to draw
	 */
	public AnimatedSprite(BufferedImage[] sprites, int x, int y, int width, int height) {
		this.sprites = sprites;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		timer = System.currentTimeMillis();
	}

	/**
	 * Constructs a new AnimatedSprite with the specified frames and position.
	 * 
	 * @param sprites - frames
	 * @param x - x position
	 * @param y - y position
	 */
	public AnimatedSprite(BufferedImage[] sprites, int x, int y) {
		this(sprites, x, y, sprites[0].getWidth(), sprites[0].getHeight());
	}

	/**
	 * Constructs a new AnimatedSprite with the specified frames.
	 * 
	 * @param sprites - frames
	 */
	public AnimatedSprite(BufferedImage[] sprites) {
		this(sprites, 0, 0, sprites[0].getWidth(), sprites[0].getHeight());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.graphics.Sprite#update()
	 */
	public void update() {
		currentSprite = sprites[frame];

		if (frame < sprites.length && System.currentTimeMillis() - timer > 25) {
			frame++;
			timer += 25;
		}

		if (frame >= sprites.length) {
			frame = 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.graphics.Sprite#render(java.awt.Graphics2D)
	 */
	public void render(Graphics2D g2) {
		g2.drawImage(currentSprite, (int) Math.floor(x), (int) Math.floor(y), width, height, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.graphics.Sprite#render(java.awt.Graphics2D, int, int)
	 */
	public void render(Graphics2D g2, float x, float y) {
		g2.drawImage(currentSprite, (int) Math.floor(x), (int) Math.floor(y), width, height, null);
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

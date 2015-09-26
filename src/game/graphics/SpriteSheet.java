package game.graphics;

import java.awt.image.BufferedImage;

/**
 * SpriteSheet is responsible for holding a 2D array of all the frames of a
 * specified spritesheet. They can be accessed as a static sprite or an animated
 * sprite, provided the frames are in order.
 * 
 * @author Brendan Goodenough
 * @version 0.1.0
 */

public class SpriteSheet {
	private int rows, cols;
	private BufferedImage spritesheet;
	private BufferedImage[][] sprites;

	/**
	 * Constructs a new SpriteSheet by loading the image at the given filepath
	 * and adding each sprite to an array based on the number of rows and
	 * columns specified.
	 * 
	 * @param filepath - path to the image
	 * @param rows - number of rows
	 * @param cols - number of columns
	 */
	public SpriteSheet(String filepath, int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		spritesheet = GraphicsLoader.loadImage(filepath);
		sprites = new BufferedImage[rows][cols];

		int width = spritesheet.getWidth() / cols;
		int height = spritesheet.getHeight() / rows;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				int x = width * col;
				int y = height * row;
				sprites[row][col] = spritesheet.getSubimage(x, y, width, height);
			}
		}
	}

	/**
	 * Returns the sprite at a specified sprite at a given row and column.
	 * 
	 * @param row - row
	 * @param col - column
	 * @return
	 */
	public BufferedImage getSprite(int row, int col) {
		return sprites[row][col];
	}

	/**
	 * Returns the requested sprites withing a specified region.
	 * 
	 * @param startRow - start row
	 * @param startCol - start column
	 * @param endRow - end row
	 * @param endCol - end column
	 * @return sprites
	 */
	public BufferedImage[] getSprites(int startRow, int startCol, int endRow, int endCol) {
		int size = endRow - startRow + endCol - startCol + 1;
		boolean foundRowEnd = false, foundColEnd = false;
		BufferedImage[] sprites = new BufferedImage[size];

		for (int row = startRow, frame = 0; row < rows; row++) {
			if (row >= endRow) {
				foundRowEnd = true;
			}

			for (int col = startCol; col < cols; col++) {
				sprites[frame++] = this.sprites[row][col];

				if (col >= endCol && foundRowEnd) {
					foundColEnd = true;
				}

				if (foundRowEnd && foundColEnd) {
					return sprites;
				}
			}
		}

		return this.sprites[0];
	}
}

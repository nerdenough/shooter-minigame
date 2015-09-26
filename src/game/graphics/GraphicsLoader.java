package game.graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.Game;

/**
 * GraphicsLoader contains several helper methods to make the loading of images,
 * fonts, and other graphics assets as easy as possible.
 * 
 * @author Brendan Goodenough
 * @version 0.1.0
 */

public class GraphicsLoader {
	/**
	 * Attempts to load the image specified, otherwise it returns an empty
	 * BufferedImage.
	 * 
	 * @param filepath - image file
	 * @return image
	 */
	public static BufferedImage loadImage(String filepath) {
		try {
			return ImageIO.read(Game.class.getResourceAsStream(filepath));
		} catch (Exception e) {
			System.out.println("Error: " + filepath + "not found!");
			return new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
		}
	}

	/**
	 * Attempts to load the font file specified, otherwise returns null.
	 * 
	 * @param filepath - font file
	 * @return font
	 */
	public static Font loadFont(String filepath) {
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, Game.class.getResourceAsStream(filepath));
			font = font.deriveFont(12f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			return font;
		} catch (Exception e) {
			System.out.println("Error: Loading font " + filepath + " failed!");
			return null;
		}
	}
}

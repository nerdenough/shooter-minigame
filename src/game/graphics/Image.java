package game.graphics;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import game.Game;

public class Image {
	/**
	 * Tries to load the image specified, otherwise it returns an empty
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
}

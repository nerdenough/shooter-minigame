package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import game.graphics.GraphicsLoader;
import game.input.KeyHandler;
import game.state.GameStateManager;

/**
 * Game holds the main entry point for this shooter minigame and is responsible
 * for updating and rendering all the states in the game. It also creates the
 * main JFrame and Canvas to which all the graphics is drawn.
 * 
 * @author Brendan Goodenough
 * @version 0.1.0
 */

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {
	private BufferedImage image;
	private GameStateManager gsm;
	private Font font;

	private boolean running;
	private Thread thread;
	private int fps = 60;

	public static final int WIDTH = 320;
	public static final int HEIGHT = 180;
	public static final int SCALE = 4;

	/**
	 * Sets the canvas dimensions and adds it to a JFrame which is shown to the
	 * player. Initializes the BufferedImage to which all graphics will be
	 * drawn.
	 */
	public Game() {
		gsm = new GameStateManager();
		image = new BufferedImage(Game.WIDTH, Game.HEIGHT, BufferedImage.TYPE_INT_ARGB);
		font = GraphicsLoader.loadFont("/fonts/gamegirl.ttf");

		setPreferredSize(new Dimension(Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE));

		JFrame frame = new JFrame("Space Shooter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		addKeyListener(new KeyHandler(gsm));
		requestFocus();
	}

	/**
	 * Updates the current frame of the game.
	 */
	public void update() {
		gsm.update();
	}

	/**
	 * Renders the current frame of the game by drawing all assets to an image
	 * which are then scaled to the canvas size. The canvas is set to use triple
	 * buffering for drawing graphics.
	 */
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3); // Triple buffering
			return;
		}

		Graphics g = bs.getDrawGraphics();
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.setFont(font);
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

		gsm.render(g2);

		g.drawImage(image, 0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE, null);
		g.setColor(Color.WHITE);
		g.drawString("FPS: " + fps, 10, 20);

		g.dispose();
		bs.show();
	}

	/**
	 * Runs the gameloop, limiting updating and rendering to a specified frames
	 * per second.
	 */
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double ns = 1000000000D / 60D;
		double delta = 0;
		int frames = 0;

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			if (delta >= 1) {
				update();
				render();
				delta--;
				frames++;
			}

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				fps = frames;
				frames = 0;
			}
		}
	}

	/**
	 * Starts the gameloop by initializing and starting the thread.
	 */
	private synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	/*
	 * Main entry point for the game.
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}

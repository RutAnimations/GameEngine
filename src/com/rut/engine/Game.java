package com.rut.engine;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;

	private Thread thread;
	private JFrame frame;
	private boolean running = false;

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		frame = new JFrame();
	}

	public synchronized void start() {
		thread = new Thread(this, "Display");
	}

	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (running) {
			System.out.println("Working");
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(true);
		game.frame.setTitle("Game Engime");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
		
	}

}

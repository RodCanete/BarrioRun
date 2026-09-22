package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import pojo.Clouds;
import pojo.EnemiesManager;
import pojo.Land;
import pojo.MainCharacter;

public class GameScreen extends JPanel implements Runnable, KeyListener {

	private static final int START_GAME_STATE = 0;
	private static final int GAME_PLAYING_STATE = 1;
	private static final int GAME_OVER_STATE = 2;
	
	//game speeds
	private static final int EASY_MODE = 3;
	private static final int NORMAL_MODE = 5;
	private static final int HARD_MODE = 7;
	
	
	private static final String GAMEPLAY_WAV_PATH = "data//gameplay.wav";
	
	private Land land;
	private MainCharacter mainCharacter;
	private EnemiesManager enemiesManager;
	private Clouds clouds;
	private Thread thread;

	private boolean isKeyPressed;
	private boolean isGameOver;
	private int gameState = START_GAME_STATE;
	private Clip clip;
	

	public GameScreen() {
		try {
	        File audioFile = new File(GAMEPLAY_WAV_PATH);
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	        this.clip = AudioSystem.getClip();
            this.clip.open(audioStream);
            this.clip.setLoopPoints(0, -1);
            this.clip.loop(Clip.LOOP_CONTINUOUSLY);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		mainCharacter = new MainCharacter();
		setPreferredSize(new Dimension(644, 845));
		mainCharacter = new MainCharacter();
		land = new Land(GameWindow.SCREEN_WIDTH, mainCharacter);
		mainCharacter.setSpeedX(3); //speed of game
		enemiesManager = new EnemiesManager(mainCharacter);
		clouds = new Clouds(GameWindow.SCREEN_WIDTH, mainCharacter);
	}
	
	public void updateGameSpeed() {
	    int gameSpeed;
	    
	    if (mainCharacter.score >= 1000) {
	        gameSpeed = HARD_MODE;
	    } else if (mainCharacter.score >= 200) {
	        gameSpeed = NORMAL_MODE;
	    } else {
	        gameSpeed = EASY_MODE;
	    }
	    
	    mainCharacter.setSpeedX(gameSpeed);
	}
	
	public void startGame() {
		thread = new Thread(this);
		thread.start();
	}

	public void gameUpdate() {
		if (gameState == GAME_PLAYING_STATE) {
			updateGameSpeed();
			clouds.update();
			land.update();
			mainCharacter.update();
			enemiesManager.update();
			if (enemiesManager.isCollision()) {
				isGameOver = true;
				gameState = GAME_OVER_STATE;
				mainCharacter.dead(true);
			}
		}
	}

	public void paint(Graphics g) {
		Image backgroundImage = new ImageIcon("data//gameback.png").getImage();
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);

		switch (gameState) {
        case START_GAME_STATE:
        	g.setColor(Color.BLACK);
        	g.setFont(new Font("Arial", Font.BOLD, 24));
        	String text = "PRESS SPACE TO START";
        	FontMetrics metrics = g.getFontMetrics();
        	int x = (getWidth() - metrics.stringWidth(text)) / 2;
        	int y = 150;
        	g.drawString(text, x, y);
        	break;
        case GAME_PLAYING_STATE:
        case GAME_OVER_STATE:
        	
        	clouds.draw(g, 1.0);
            land.draw(g, 1.0);
            enemiesManager.draw(g, 1.0);
            mainCharacter.draw(g, GameWindow.SCREEN_WIDTH / 2, GameWindow.SCREEN_HEIGHT / 2, 1.5);
			g.setColor(Color.BLACK);
			Font font = new Font("Arial", Font.BOLD, 14);
			g.setFont(font);
			g.drawString("SCORE " + mainCharacter.score, 480, 20);
			// create a new font object
			
			if (isGameOver) {
				clip.stop();
				GameOver gg = new GameOver(mainCharacter.score);
                gg.setLocationRelativeTo(null);
                gg.setVisible(true);
                ((GameWindow)getTopLevelAncestor()).dispose();
                isGameOver = false;
               
			}
			break;
		}
	}

	@Override
	public void run() {

		int fps = 100;
		long msPerFrame = 1000 * 1000000 / fps;
		long lastTime = 0;
		long elapsed;
		
		int msSleep;
		int nanoSleep;

		while (true) {
			gameUpdate();
			repaint();
			elapsed = (lastTime + msPerFrame - System.nanoTime());
			msSleep = (int) (elapsed / 1000000);
			nanoSleep = (int) (elapsed % 1000000);
			if (msSleep <= 0) {
				lastTime = System.nanoTime();
				continue;
			}
			try {
				Thread.sleep(msSleep, nanoSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lastTime = System.nanoTime();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!isKeyPressed) {
			isKeyPressed = true;
			switch (gameState) {
			case START_GAME_STATE:
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					gameState = GAME_PLAYING_STATE;
				}
				break;
			case GAME_PLAYING_STATE:
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					mainCharacter.jump();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					mainCharacter.down(true);
				}
				break;
			case GAME_OVER_STATE:
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					gameState = GAME_PLAYING_STATE;
					resetGame();
				}
				break;

			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		isKeyPressed = false;
		if (gameState == GAME_PLAYING_STATE) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				mainCharacter.down(false);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	public int getScore() {
	    return mainCharacter.score;
	}

	
	private void resetGame() {
		enemiesManager.reset();
		mainCharacter.dead(false);
		mainCharacter.reset();
		mainCharacter.score = 0;
	}

}

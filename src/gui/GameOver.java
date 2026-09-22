package gui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class GameOver extends JFrame {

	FontLoader fontLoader = new FontLoader();
	Font minecraftFont = fontLoader.getMinecraftFont();
	Font minecraftboldFont = fontLoader.getminecraftBoldFont();
	Font hitrun = fontLoader.hitrun();
	private JPanel contentPane;
	private Clip deadSound;
	private static int score;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOver frame = new GameOver(score);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameOver(int score) {
		super("Barrio Run");
		
		playDeadSound();

		setResizable(false);
		ImageIcon icon = new ImageIcon("data/flag.png");
		Image image = icon.getImage();
		setIconImage(image);

		NameHandler askName = NameHandler.getInstance();
		String playerName = askName.getPlayerName();

		ScoreBoard scoreBoard = new ScoreBoard();
		scoreBoard.updateScoreboard(playerName, score);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton dummyButton = new JButton("");
		dummyButton.setBounds(0, 0, 0, 0);
		dummyButton.setFocusable(true);
		contentPane.add(dummyButton);

		JButton backButton = new JButton("BACK");
		backButton.setBackground(new Color(0, 255, 127));
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBounds(36, 235, 117, 36);
		backButton.setFont(minecraftFont.deriveFont(Font.BOLD, 20f));
		backButton.setUI(new StyledButtonUI());
		backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(backButton);

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deadSound.stop();
				MainScreen mainscreen = new MainScreen();
				mainscreen.setBounds(50, 50, 508, 335);
				mainscreen.setLocationRelativeTo(null);
				mainscreen.setVisible(true);
				dispose();
			}
		});

		JButton backButton_1 = new JButton("RETRY");
		backButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deadSound.stop();
				GameWindow gameWindow = new GameWindow();
				gameWindow.setLocationRelativeTo(null);
				gameWindow.startGame();
				dispose();
			}
		});
		backButton_1.setForeground(Color.WHITE);
		backButton_1.setUI(new StyledButtonUI());
		backButton_1.setFont(null);
		backButton_1.setBackground(new Color(255, 165, 0));
		backButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backButton_1.setFont(minecraftFont.deriveFont(Font.BOLD, 20f));
		backButton_1.setBounds(189, 235, 117, 36);
		contentPane.add(backButton_1);

		JButton backButton_1_1 = new JButton("QUIT");
		backButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		backButton_1_1.setForeground(Color.WHITE);
		backButton_1_1.setFont(minecraftFont.deriveFont(Font.BOLD, 20f));
		backButton_1_1.setUI(new StyledButtonUI());
		backButton_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backButton_1_1.setBackground(new Color(255, 0, 0));
		backButton_1_1.setBounds(342, 235, 117, 36);
		contentPane.add(backButton_1_1);

		JLabel score1 = new JLabel("SCORE: " + score);
		score1.setBackground(new Color(255, 255, 0));
		score1.setForeground(new Color(175, 238, 238));
		score1.setFont(hitrun.deriveFont(20f));
		score1.setBounds(36, 74, 424, 36);
		score1.setHorizontalAlignment(SwingConstants.CENTER);

		contentPane.add(score1);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("data\\gameover.png"));
		lblNewLabel.setBounds(0, -64, 514, 417);
		contentPane.add(lblNewLabel);

	}
	
	public void playDeadSound() {
		try {
			AudioInputStream deadSoundInputStream = AudioSystem.getAudioInputStream(new File("data/dead.wav"));
	        deadSound = AudioSystem.getClip();
	        deadSound.open(deadSoundInputStream);
		} catch(UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
	        System.err.println("Error loading sound file: " + ex.getMessage());
	        ex.printStackTrace();
	    }
	    if (deadSound != null) {
	        deadSound.start();
	    }
	}
}

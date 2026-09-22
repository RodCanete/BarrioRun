package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class instructions2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6322023845079413046L;

	private JPanel contentPane;

	FontLoader fontLoader = new FontLoader();
    Font minecraftFont = fontLoader.getMinecraftFont();
    Font minecraftboldFont = fontLoader.getminecraftBoldFont();
    Font hitrun = fontLoader.hitrun();
    
    private boolean hasBeenLoaded = false;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instructions2 frame = new instructions2();
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
	public instructions2() {
		super("Barrio Run");
		setResizable(false);
		 ImageIcon icon = new ImageIcon("data/flag.png");
		    Image image = icon.getImage();
		    setIconImage(image);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 316);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(411, 176, -379, -88);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSTRUCTIONS");
		lblNewLabel.setBackground(new Color(255, 69, 0));
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setBounds(69, 11, 315, 41);
		lblNewLabel.setFont(hitrun.deriveFont(30f));
		contentPane.add(lblNewLabel);
		
		JTextArea txtrObjectiveTheObjective = new JTextArea();
		txtrObjectiveTheObjective.setEditable(false);
		txtrObjectiveTheObjective.setForeground(new Color(255, 255, 255));
		txtrObjectiveTheObjective.setText("1. Objective: The objective of the game is to help your \r\ncharacter "
				+ "navigate through a series of obstacles.\r\n2. Controls: Your character moves automatically from left\r\nto right. "
				+ "To jump over obstacles, press the spacebar.\r\nMake sure you jump at the right moment to avoid\r\nobstacles.\r\n3. "
				+ "Game Over: You have one life. If you hit an obstacle, \r\nthe game is over.");
		txtrObjectiveTheObjective.setBounds(10, 64, 480, 188);
		txtrObjectiveTheObjective.setFont(minecraftFont.deriveFont(15f));
		txtrObjectiveTheObjective.setOpaque(false);
		contentPane.add(txtrObjectiveTheObjective);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("data\\instruc.png"));
		lblNewLabel_1.setBounds(10, 8, 49, 46);
		contentPane.add(lblNewLabel_1);
		
		
		JButton backButton = new JButton("TARA NA!");
		backButton.setBackground(new Color(124, 252, 0));
		backButton.setForeground(Color.BLACK);
		backButton.setBounds(153, 243, 129, 26);
		backButton.setFont(minecraftFont.deriveFont( 17f));
		backButton.setUI(new StyledButtonUI());
		backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(backButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("data\\instrucback.png"));
		lblNewLabel_2.setBounds(0, -87, 549, 473);
		contentPane.add(lblNewLabel_2);
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow gameWindow = new GameWindow();
				gameWindow.setLocationRelativeTo(null);
		        gameWindow.startGame();
		        dispose();
			}
		});
	}

	public boolean isHasBeenLoaded() {
		return hasBeenLoaded;
	}

	public void setHasBeenLoaded(boolean hasBeenLoaded) {
		this.hasBeenLoaded = hasBeenLoaded;
	}
}

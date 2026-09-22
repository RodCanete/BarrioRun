package gui;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Cursor;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainScreen extends JFrame {

	FontLoader fontLoader = new FontLoader();
    Font minecraftFont = fontLoader.getMinecraftFont();
    Font hitrun = fontLoader.hitrun();
	private JPanel contentPane;
	private Clip clip;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setLocationRelativeTo(null);
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
	public MainScreen() {
		super("Barrio Run");
		
		try {
		    File soundFile = new File("data/main.wav");
		    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		    clip = AudioSystem.getClip();  // Initialize the instance variable 'clip'
		    clip.open(audioInputStream);
		    clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception ex) {
		    ex.printStackTrace();
		}

		setResizable(false);
		 ImageIcon icon = new ImageIcon("data/flag.png");
		    Image image = icon.getImage();
		    setIconImage(image);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(10, 10, 474, 288);
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton_1 = new JButton("NEW GAME");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(127, 255, 0));
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		btnNewButton_1.setUI(new StyledButtonUI());
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				 try {
			            clip.stop();
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
					instructions2 instructions = new instructions2();
		            instructions.setLocationRelativeTo(null);
		            instructions.setVisible(true);
		            instructions.setHasBeenLoaded(true);
		            dispose();
		    }
		});
		btnNewButton_1.setFont(minecraftFont.deriveFont( 18f));
		btnNewButton_1.setBounds(145, 163, 151, 36);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
			            clip.stop();
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
				Settings s = new Settings();
				s.setLocationRelativeTo(null);
				s.setVisible(true);
		        dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon("data\\settings.png"));
		btnNewButton.setUI(new StyledButtonUI());
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(new Color(224, 255, 255));
		btnNewButton.setFont(minecraftFont.deriveFont( 18f));
		btnNewButton.setBounds(437, 0, 37, 36);
		panel.add(btnNewButton);
		
		JButton btnScore = new JButton("SCOREBOARD");
		btnScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
			            clip.stop();
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
				ScoreBoard score = new ScoreBoard();
				score.setLocationRelativeTo(null);
				score.setVisible(true);
		        dispose();
			}
		});
		btnScore.setBackground(new Color(255, 140, 0));
		btnScore.setForeground(Color.WHITE);
		btnScore.setUI(new StyledButtonUI());
		btnScore.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		btnScore.setFont(minecraftFont.deriveFont( 18f));
		btnScore.setBounds(145, 203, 151, 36);
		panel.add(btnScore);
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.setBackground(new Color(255, 0, 0));
		btnQuit.setUI(new StyledButtonUI());
		btnQuit.setForeground(new Color(240, 255, 255));
		btnQuit.setFont(minecraftFont.deriveFont(Font.BOLD, 18f));
		btnQuit.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		btnQuit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		    }
		    
		});
		btnQuit.setBounds(145, 242, 151, 36);
		panel.add(btnQuit);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(new Color(255, 69, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
			            clip.stop();
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
				Instructions instruction = new Instructions();
				instruction.setLocationRelativeTo(null);
				instruction.setVisible(true);
		        dispose();
			}
		});
		btnNewButton_2.setUI(new StyledButtonUI());
		btnNewButton_2.setIcon(new ImageIcon("data\\instruc.png"));
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		btnNewButton_2.setBounds(390, 0, 37, 36);
		panel.add(btnNewButton_2);
		
		NameHandler askName = NameHandler.getInstance();
	    String playerName = askName.getPlayerName();
	    
		JLabel lblNewLabel = new JLabel("Mabuhay!!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(360, 163, 93, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel(checkEmpty(playerName) + " :)");
		lblNewLabel_2.setForeground(new Color(255, 69, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(360, 178, 93, 27);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("data\\info.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip.stop();
				AboutUs about = new AboutUs();
	            about.setLocationRelativeTo(null);
	            about.setVisible(true);
	            dispose();
			}
		});
		btnNewButton_3.setUI(new StyledButtonUI());
		btnNewButton_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setForeground(new Color(224, 255, 255));
		btnNewButton_3.setFont(null);
		btnNewButton_3.setBackground(Color.YELLOW);
		btnNewButton_3.setBounds(0, 0, 37, 36);
		panel.add(btnNewButton_3);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("data\\mainback.png"));
		lblNewLabel_1.setBounds(0, 0, 505, 298);
		contentPane.add(lblNewLabel_1);
	}
	  public String checkEmpty(String str) {
	    	if (str == null) {
	    		return "";
	    	}
	    	return str;
	    }
}

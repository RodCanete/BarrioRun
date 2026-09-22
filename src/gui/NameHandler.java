package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class NameHandler extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3124470058267296321L;
	
	FontLoader fontLoader = new FontLoader();
    Font minecraftFont = fontLoader.getMinecraftFont();
    Font hitrun = fontLoader.hitrun();
    Font pixelgame = fontLoader.getpixelgame();
    
	private JPanel contentPane;
	private static String playerName;
	private static NameHandler instance= null;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	ScoreBoard scoreBoard = new ScoreBoard();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NameHandler frame = new NameHandler();
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

	
	private NameHandler() {
		super("Barrio Run");
		setResizable(false);
		 ImageIcon icon = new ImageIcon("data/chicken.png");
		    Image image = icon.getImage();
		    setIconImage(image);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 362, 178);
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("PLEASE ENTER YOUR NAME:");
		lblNewLabel_1.setFont(hitrun.deriveFont(20f));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(55, 10, 307, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("data\\world.png"));
		lblNewLabel_2.setBounds(0, 3, 47, 53);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setForeground(new Color(148, 0, 211));
		textField.setBackground(new Color(224, 255, 255));
		textField.setFont(minecraftFont.deriveFont(25f));
		textField.setBounds(39, 60, 290, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(165, 42, 42));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnNewButton.setBounds(48, 121, 108, 34);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(minecraftFont.deriveFont(18f));
		btnNewButton.setUI(new StyledButtonUI());
		panel.add(btnNewButton);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerName = textField.getText();
				 ScoreBoard scoreBoard = new ScoreBoard();
				    scoreBoard.updateScoreboard(playerName, 0);
				MainScreen mainscreen = new MainScreen();
		        mainscreen.setLocationRelativeTo(null);
		        mainscreen.setVisible(true);
		        dispose();
			}
		});
		btnEnter.setBackground(new Color(0, 255, 127));
		btnEnter.setBounds(204, 121, 108, 34);
		btnEnter.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEnter.setFont(minecraftFont.deriveFont(18f));
		btnEnter.setUI(new StyledButtonUI());
		panel.add(btnEnter);
		
		JLabel lblNewLabel = new JLabel(""); 
		lblNewLabel.setIcon(new ImageIcon("data\\instrucback.png"));
		lblNewLabel.setBackground(new Color(138, 43, 226));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, -22, 387, 225);
		contentPane.add(lblNewLabel);
	}
	
	public static NameHandler getInstance() {
        if (instance == null) {
            instance = new NameHandler();
        }
        return instance;
    }

    public String getPlayerName() {
        return playerName;
    }
    
    public static void setPlayerName(String name) {
        playerName = name;
    }
    
}

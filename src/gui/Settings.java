package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextField;

public class Settings extends JFrame {
	FontLoader fontLoader = new FontLoader();
    Font minecraftFont = fontLoader.getMinecraftFont();
    Font minecraftboldFont = fontLoader.getminecraftBoldFont();
    Font hitrun = fontLoader.hitrun();
	private JPanel contentPane;
	private JButton clear, rename;
	private JTextField textField;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings frame = new Settings();
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
	public Settings() {
		super("Barrio Run");
		setResizable(false);
		 ImageIcon icon = new ImageIcon("data/flag.png");
		    Image image = icon.getImage();
		    setIconImage(image);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-11, -29, 507, 302);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SETTINGS");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(88, 35, 214, 53);
		lblNewLabel_1.setFont(hitrun.deriveFont(30f));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CLEAR SCOREBOARD: ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(minecraftFont.deriveFont(20f).deriveFont(Font.BOLD));
		lblNewLabel_2.setBounds(36, 97, 292, 33);
		panel.add(lblNewLabel_2);
		

		JButton backButton = new JButton("BACK");
		backButton.setBackground(new Color(124, 252, 0));
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBounds(36, 253, 85, 26);
		backButton.setFont(minecraftFont.deriveFont(Font.BOLD, 17f));
		backButton.setUI(new StyledButtonUI());
		backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(backButton);
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen mainscreen = new MainScreen();
				mainscreen.setBounds(50, 50, 508, 335);
			    mainscreen.setLocationRelativeTo(null);
		        mainscreen.setVisible(true);
		        dispose();
			}
		});
		
		clear = new JButton("CLEAR");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        FileWriter writer = new FileWriter("src\\gui\\scores.txt", false);
			        writer.write("");
			        writer.close();
			    } catch (IOException ex) {
			        ex.printStackTrace();
			    }
			}
		});
		clear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clear.setForeground(new Color(255, 255, 255));
		clear.setFont(minecraftFont.deriveFont(17f));
		clear.setBackground(new Color(255, 0, 0)); 
		clear.setUI(new StyledButtonUI());
		clear.setBounds(260, 97, 168, 33);
		panel.add(clear);
		
		
		rename = new JButton("RENAME");
		rename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPlayerName = textField.getText();
		        if (newPlayerName != null) {
		         NameHandler.setPlayerName(newPlayerName);
		        }
		        textField.setText("");
			}
		});
		rename.setForeground(new Color(0, 0, 0));
		rename.setFont(minecraftFont.deriveFont(17f));
		rename.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rename.setBackground(new Color(224, 255, 255));
		rename.setUI(new StyledButtonUI());
		rename.setBounds(260, 193, 168, 33);
		panel.add(rename);
		
		JLabel lblNewLabel_2_1 = new JLabel("EDIT PLAYER NAME: ");
		lblNewLabel_2_1 .setFont(minecraftFont.deriveFont(Font.BOLD, 20f));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(36, 157, 292, 33);
		panel.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 250, 240));
		textField.setFont(minecraftFont.deriveFont(15f));
		textField.setBounds(260, 157, 168, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("data\\settingback.png"));
		lblNewLabel.setBounds(10, 29, 497, 292);
		panel.add(lblNewLabel);
		
		
	
	}
}

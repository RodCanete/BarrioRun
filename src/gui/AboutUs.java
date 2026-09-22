package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class AboutUs extends JFrame {
	FontLoader fontLoader = new FontLoader();
    Font minecraftFont = fontLoader.getMinecraftFont();
    Font hitrun = fontLoader.hitrun();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUs frame = new AboutUs();
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
	public AboutUs() {
		super("Barrio Run");
		setResizable(false);
		 ImageIcon icon = new ImageIcon("data/flag.png");
		    Image image = icon.getImage();
		    setIconImage(image);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-12, 0, 515, 306);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JButton backButton = new JButton("BACK");
		backButton.setBackground(new Color(124, 252, 0));
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBounds(30, 255, 85, 26);
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
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("data\\info.png"));
		lblNewLabel_1.setBounds(29, 10, 45, 33);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel23 = new JLabel("ABOUT");
		lblNewLabel23.setBackground(new Color(255, 69, 0));
		lblNewLabel23.setForeground(new Color(255, 250, 250));
		lblNewLabel23.setBounds(76, 10, 165, 41);
		lblNewLabel23.setFont(hitrun.deriveFont(30f));
		panel.add(lblNewLabel23);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("data/11.png"));
		lblNewLabel_2.setBounds(395, 10, 45, 41);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("data/10.png"));
		lblNewLabel_3.setBounds(442, 10, 45, 41);
		panel.add(lblNewLabel_3);

		JTextArea txtrBarrioRunIs = new JTextArea();
		txtrBarrioRunIs.setEditable(false);
		txtrBarrioRunIs.setForeground(new Color(255, 255, 255));
		txtrBarrioRunIs.setText("Barrio Run is a Filipino-themed game that takes \r\nplayers on a journey through a traditional rural\r\nvillage, or \"barrio,\" in the Philippines. The game \r\nis designed to evoke the charm and beauty of \r\nPhilippine rural life.\r\n\r\r\nRod Gabrielle Cañete - Lead Developer, UI/UX\r\r\nChelsea Faye Dotillos - Graphic Design\r\r\nJohn Lloyd Mercader - Tester");
		txtrBarrioRunIs.setFont(minecraftFont.deriveFont(17f));
		txtrBarrioRunIs.setOpaque(false);
		txtrBarrioRunIs.setBounds(39, 61, 476, 207);
		panel.add(txtrBarrioRunIs);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("data\\instrucback.png"));
		lblNewLabel.setBounds(10, -25, 531, 347);
		panel.add(lblNewLabel);
		
		
		
	
		
	}
}

package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;

public class ScoreBoard extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -41550299350700525L;
	FontLoader fontLoader = new FontLoader();
    Font minecraftFont = fontLoader.getMinecraftFont();
    Font hitrun = fontLoader.hitrun();
	private JPanel contentPane;
	private int topScore1;
    private int topScore2;
    private int topScore3;
    private String topPlayer1;
    private String topPlayer2;
    private String topPlayer3;
    private String fileName = "src\\gui\\scores.txt";
    
    // Save scores to file
    public void saveScores() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(topScore1 + "," + topPlayer1 + "\n");
            writer.write(topScore2 + "," + topPlayer2 + "\n");
            writer.write(topScore3 + "," + topPlayer3 + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String checkEmpty(String str) {
    	if (str == null || str.equalsIgnoreCase("null")) {
    		return "";
    	}
    	return str;
    }

    // Load scores from file
    public void loadScores() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            if ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                topScore1 = Integer.parseInt(parts[0]);
                topPlayer1 = parts[1];
            }
            if ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                topScore2 = Integer.parseInt(parts[0]);
                topPlayer2 = parts[1];
            }
            if ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                topScore3 = Integer.parseInt(parts[0]);
                topPlayer3 = parts[1];
            }
            reader.close();
        } catch (FileNotFoundException e) {
            topScore1 = 0;
            topScore2 = 0;
            topScore3 = 0;
            topPlayer1 = "Player 1";
            topPlayer2 = "Player 2";
            topPlayer3 = "Player 3";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void updateScoreboard(String name, int score) {
        if (score > topScore1) {
            topPlayer3 = topPlayer2;
            topScore3 = topScore2;
            topPlayer2 = topPlayer1;
            topScore2 = topScore1;
            topPlayer1 = name;
            topScore1 = score;
        } else if (score > topScore2) {
            topPlayer3 = topPlayer2;
            topScore3 = topScore2;
            topPlayer2 = name;
            topScore2 = score;
        } else if (score > topScore3) {
            topPlayer3 = name;
            topScore3 = score;
        }
        // Save scores to file
        saveScores();
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreBoard frame = new ScoreBoard();
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
	public ScoreBoard() {
		
		super("Barrio Run");
		setResizable(false);
		 ImageIcon icon = new ImageIcon("data/flag.png");
		    Image image = icon.getImage();
		    setIconImage(image);
		
		loadScores();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 489, 286);
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel scoretitle= new JLabel("SCORE");
		scoretitle.setForeground(new Color(255, 69, 0));
		scoretitle.setBounds(80, 5, 352, 73);
		scoretitle.setFont(hitrun.deriveFont(50f));
		panel.add(scoretitle);
		
		JLabel lblNewLabel_1 = new JLabel("BOARD");
		lblNewLabel_1.setForeground(new Color(255, 250, 205));
		lblNewLabel_1.setFont(hitrun.deriveFont(50f));
		lblNewLabel_1.setBounds(247, 5, 185, 73);
		scoretitle.setFont(hitrun.deriveFont(50f));
		panel.add(lblNewLabel_1);
		
		
		JLabel score1 = new JLabel(Integer.toString(topScore1));
		score1.setForeground(new Color(255, 250, 250));
		score1.setFont(minecraftFont.deriveFont(25f).deriveFont(Font.BOLD));
		score1.setHorizontalAlignment(SwingConstants.CENTER);
		score1.setBounds(368, 99, 111, 35);
		panel.add(score1);
		
		JLabel score2 = new JLabel(Integer.toString(topScore2));
		score2.setForeground(new Color(255, 250, 250));
		score2.setFont(minecraftFont.deriveFont(25f).deriveFont(Font.BOLD));
		score2.setHorizontalAlignment(SwingConstants.CENTER);
		score2.setBounds(368, 159, 111, 33);
		panel.add(score2);
		
		JLabel score3 = new JLabel(Integer.toString(topScore3));
		score3.setForeground(new Color(255, 250, 250));
		score3.setHorizontalAlignment(SwingConstants.CENTER);
		score3.setFont(minecraftFont.deriveFont(25f).deriveFont(Font.BOLD));
		score3.setBounds(368, 215, 111, 35);
		panel.add(score3);
		
		
		JButton backButton = new JButton("BACK");
		backButton.setBackground(new Color(124, 252, 0));
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBounds(394, 260, 85, 26);
		backButton.setFont(minecraftFont.deriveFont(Font.BOLD, 17f));
		backButton.setUI(new StyledButtonUI());
		backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(backButton);
		
		JLabel namefirst = new JLabel("1st " + checkEmpty(topPlayer1));
		namefirst.setForeground(new Color(255, 255, 255));
		namefirst.setFont(minecraftFont.deriveFont(20f).deriveFont(Font.BOLD));
		namefirst.setBounds(187, 94, 213, 44);
		panel.add(namefirst);
		
		JLabel namesecond = new JLabel("2nd " +checkEmpty(topPlayer2));
		namesecond.setForeground(new Color(255, 255, 255));
		namesecond.setFont(minecraftFont.deriveFont(20f).deriveFont(Font.BOLD));
		
		namesecond.setBounds(187, 153, 213, 44);
		panel.add(namesecond);
		
		JLabel namethird = new JLabel("3rd " + checkEmpty(topPlayer3));
		namethird.setForeground(new Color(255, 255, 255));
		namethird.setFont(minecraftFont.deriveFont(20f).deriveFont(Font.BOLD));
		
		namethird.setBounds(187, 210, 213, 44);
		panel.add(namethird);
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen mainscreen = new MainScreen();
				mainscreen.setBounds(50, 50, 508, 335);
			    mainscreen.setLocationRelativeTo(null);
		        mainscreen.setVisible(true);
		        dispose();
			}
		});

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("data\\scoreboardback.png"));
		lblNewLabel.setBounds(0, -16, 503, 327);
		contentPane.add(lblNewLabel);
			}
}

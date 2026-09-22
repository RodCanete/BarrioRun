package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SplashScreen extends JFrame {
    
    private JProgressBar progressBar;
    private int progress;
    FontLoader fontLoader = new FontLoader();
    Font minecraftFont = fontLoader.getMinecraftFont();
    
    public SplashScreen() {
        super("Barrio Run");
        
        try {
            File soundFile = new File("data/start.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setUndecorated(true); 
        getContentPane().setLayout(null);
        
        progressBar = new JProgressBar(0, 100);
        progressBar.setForeground(new Color(135, 206, 235));
        progressBar.setBounds(0, 284, 500, 16);
        progressBar.setStringPainted(true); 
        getContentPane().add(progressBar);
        
        JPanel splashScreenPanel = new JPanel();
        splashScreenPanel.setBounds(0, 0, 500, 284);
        splashScreenPanel.setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon("splash.png"); 
        splashScreenPanel.setLayout(null);
        getContentPane().add(splashScreenPanel);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("data\\2.png"));
        lblNewLabel_2.setBounds(255, 54, 200, 188);
        splashScreenPanel.add(lblNewLabel_2);
        
        
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("data\\1.png"));
        lblNewLabel_1.setBounds(45, 54, 200, 188);
        splashScreenPanel.add(lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("data\\splashscreen.png"));
        lblNewLabel.setBounds(0, -17, 506, 318);
        splashScreenPanel.add(lblNewLabel);
        
        
        setVisible(true);
        
        // Simulate loading process
        Random random = new Random();
        while (progress < 100) {
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progress += random.nextInt(7);
            progressBar.setValue(progress);
        }
        dispose();
        NameHandler ask =NameHandler.getInstance();
        ask.setLocationRelativeTo(null);
        ask.setVisible(true);
    }
    
    public static void main(String[] args) {
        new SplashScreen();
    }
}

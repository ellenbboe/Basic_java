package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

//游戏主界面
public class Start extends JFrame{
	
	
	public static BufferedImage Hero;
	public static BufferedImage Enemy;
	public static BufferedImage Background;
	public static BufferedImage Herobullet;
	public static BufferedImage Enemybullet;
	public static BufferedImage boomimage;
	
	static{
		try {
			Hero = ImageIO.read(Start.class.getResourceAsStream("../image/hero.png"));
			Enemy = ImageIO.read(Start.class.getResourceAsStream("../image/enemy.png"));
			Background = ImageIO.read(Start.class.getResourceAsStream("../image/map.jpg"));
			Herobullet = ImageIO.read(Start.class.getResourceAsStream("../image/herobullet.png"));
			Enemybullet = ImageIO.read(Start.class.getResourceAsStream("../image/enemybullet.png"));
			boomimage = ImageIO.read(Start.class.getResourceAsStream("../image/blow.gif"));
			
		}catch(IOException e) {
			e.printStackTrace();		
		}
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Start() {
		JPanel p = new JPanel();
		this.setContentPane(p);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(500, 500);
		this.setTitle("plane war");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Start();
	}
	public void run(JPanel p) {
		
		

	}
}

package main;


import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import thisobject.Bullet;
import thisobject.Enemy;
import thisobject.Hero;

//游戏主界面
public class Start extends JPanel implements KeyListener{
	
	private Dao dao=new Dao();
	private Enemy[] flyings = {}; // 敌机数组
	private Bullet[] bullets = {}; // 子弹数组
	private Hero hero = new Hero();
	private final int PanelWidth = dao.PanelWidth;
	private final int PanelHeight = dao.PanelHeight;
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
	}
	
	public void display() {
		this.repaint();
	}
	public void paint(Graphics g) {
		super.paint(g);
		dao.drawBackground(g);
		dao.drawState(g, hero);
		dao.drawHero(g, hero);
	}
	
	public static void main(String[] args) {
		Start start = new Start();
		JFrame jfr = new JFrame();
		jfr.setSize(start.PanelWidth,start.PanelHeight);
		jfr.setContentPane(start);
		jfr.setVisible(true);
		jfr.setResizable(false);
		jfr.setTitle("plane war");
		jfr.setLocationRelativeTo(null);
		jfr.setDefaultCloseOperation(3);
		jfr.addKeyListener(start);
		
		Thread threadpaint = new Thread() {
			public void run() {
				while(true) {
					start.display();
					System.out.println(1);
					try {
						sleep(30);
					}catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		};
			threadpaint.start();
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			dao.right = true;
			break;
		case KeyEvent.VK_LEFT:
			dao.left = true;
			break;
		case KeyEvent.VK_UP:
			dao.up = true;
			break;
		case KeyEvent.VK_DOWN:
			dao.down = true;
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			dao.right = false;
			break;
		case KeyEvent.VK_LEFT:
			dao.left = false;
			break;
		case KeyEvent.VK_UP:
			dao.up = false;
			break;
		case KeyEvent.VK_DOWN:
			dao.down = false;
			break;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

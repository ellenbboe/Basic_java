package main;


import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import thisobject.Bullet;
import thisobject.Enemy;
import thisobject.Hero;

//游戏主界面
public class Start extends JPanel implements KeyListener{
	
	private Dao dao=new Dao();
	private Action action = new Action();
	private Enemy[] enemy = {}; // 敌机数组
	private Bullet[] bullets = {}; // 子弹数组
	private Hero hero = new Hero();
	private final int PanelWidth = Dao.PanelWidth;
	private final int PanelHeight = Dao.PanelHeight;
	public static BufferedImage Hero;
	public static BufferedImage Enemy;
	public static BufferedImage Background;
	public static BufferedImage Herobullet;
//	public static BufferedImage Enemybullet;
	//public static BufferedImage boomimage;
	static{
		try {
			Hero = ImageIO.read(Start.class.getResourceAsStream("../image/hero.png"));
			Enemy = ImageIO.read(Start.class.getResourceAsStream("../image/enemy.png"));
			Background = ImageIO.read(Start.class.getResourceAsStream("../image/map.jpg"));
			Herobullet = ImageIO.read(Start.class.getResourceAsStream("../image/herobullet.png"));
			//Enemybullet = ImageIO.read(Start.class.getResourceAsStream("../image/enemybullet.png"));
			//boomimage = ImageIO.read(Start.class.getResourceAsStream("../image/blow.gif"));
			
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
	public void create() {
		slowpart(bullets, enemy, hero, dao);
	}
	public void paint(Graphics g) {
		super.paint(g);
		dao.drawBackground(g);
		dao.drawState(g, hero);
		dao.drawHero(g, hero);
		dao.drawBullets(g, bullets,enemy,hero);
		dao.drawEnemy(g, enemy,bullets,hero);
		destory_enemy();
		destory_bullets();
		System.out.println("飞机"+enemy.length);
		System.out.println("子弹"+bullets.length);
	}
	
	
	public  void destory_bullets() {
		int length = bullets.length;
		int a = 0;
		for(int i = 0;i<bullets.length;i++) {
			Bullet b = bullets[i];
			if(b.out == true && length != 0) {
				Bullet temp = bullets[length - 1];
				bullets[length -1] = b;
				bullets[i] = temp;
				length --;
				a = 1;
			}
		}
		if(a == 1 && length != 0)
		bullets = Arrays.copyOf(bullets, length -1);
		
	}
	public void destory_enemy() {
		
		int length = enemy.length;
		int a = 0;
		for(int i = 0;i<enemy.length;i++) {
			Enemy e = enemy[i];
			if(e.out == true && length != 0) {
				a =1;
				Enemy temp = enemy[length - 1];
				enemy[length -1] = e;
				enemy[i] = temp;
				length--;
			}
		}
		if(a ==1 && length != 0)
		enemy = Arrays.copyOf(enemy, length - 1);
	}
	
	public void slowpart(Bullet[] bullet,Enemy[] enemys,Hero hero,Dao dao) {
		enemy = action.create_enemy(enemys);
		bullets = action.create_bullets(bullet,hero);
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
				
					try {
						sleep(30);
					}catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread threadcreate = new Thread() {
			public void run() {
				while(true) {
					start.create();
					try {
						sleep(1000);
					}catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		};
		
			threadpaint.start();
			threadcreate.start();
	
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

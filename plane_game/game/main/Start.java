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
import thisobject.Boss;
//游戏主界面
public class Start extends JPanel implements KeyListener{
	private Dao dao=new Dao();
	private Boss boss = new Boss();
	private Action action = new Action();
	private Enemy[] enemy = {};
	private Bullet[] bullets = {}; 
	private Hero hero = new Hero();
	private final int PanelWidth = Dao.PanelWidth;
	private final int PanelHeight = Dao.PanelHeight;
	public static BufferedImage Hero;
	public static BufferedImage Enemy;
	public static BufferedImage Background;
	public static BufferedImage Herobullet;
	public static BufferedImage Boss;
	static{
		try {
			Hero = ImageIO.read(Start.class.getResourceAsStream("../image/hero.png"));
			Enemy = ImageIO.read(Start.class.getResourceAsStream("../image/enemy.png"));
			Background = ImageIO.read(Start.class.getResourceAsStream("../image/map.jpg"));
			Herobullet = ImageIO.read(Start.class.getResourceAsStream("../image/herobullet.png"));
			Boss = ImageIO.read(Start.class.getResourceAsStream("../image/master.png"));
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
		dao.drawState(g);
		dao.drawBoss(g,boss,hero,dao);
		dao.drawHero(g, hero);
		dao.drawBullets(g, bullets,enemy,hero);
		dao.drawEnemy(g, enemy,hero,dao);
		destory_enemy();
		destory_bullets();
	}
	
	
	public  void destory_bullets() {
		int length = bullets.length;
		for(int i = 0;i<bullets.length;i++) {
			Bullet b = bullets[i];
			if(b.out == true) {
				Bullet temp = bullets[length - 1];
				bullets[length -1] = b;
				bullets[i] = temp;
				length --;
				bullets = Arrays.copyOf(bullets, length);
			}
		}
	}
	
	public void destory_enemy() {
		
		int length = enemy.length;
		for(int i = 0;i<enemy.length;i++) {
			Enemy e = enemy[i];
			if(e.out == true) {
				Enemy temp = enemy[length - 1];
				enemy[length -1] = e;
				enemy[i] = temp;
				length--;
				enemy = Arrays.copyOf(enemy, length);
			}
		}
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
		case KeyEvent.VK_R:
			enemy = new Enemy[0];
			bullets = new Bullet[0];
			hero = new Hero();
			dao=new Dao();
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

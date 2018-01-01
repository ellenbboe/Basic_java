package plane1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class PlanePanel extends JPanel implements KeyListener{
	private int score = 0;
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	Timer time = new Timer();
	Timer time2 = new Timer();
	Timer time3 = new Timer();//备用时间计划
	public static final int Width = 1200;
	public static final int Height = 800;
	public static final int speed = 5;
	public static BufferedImage icon;
	public static BufferedImage Heroplane1;
	public static BufferedImage enemyplane1;
	public static BufferedImage background;
	public static BufferedImage hbimage;
	public static BufferedImage ebimage;
	public static BufferedImage boomimage;
	private static final int drawplaneWidth = 100;
	private static final int drawbossWidth = 200;
	private static final int drawplaneHeight= 60;
	private static final int drawbossHeight= 120;
	private static final int drawBulletWidth= 40;
	private static final int drawBulletHeight= 60;
	
	
	
	static{
		try {
			icon = ImageIO.read(PlanePanel.class.getResourceAsStream("js.png"));
			Heroplane1 = ImageIO.read(PlanePanel.class.getResourceAsStream("my_1.png"));
			enemyplane1 = ImageIO.read(PlanePanel.class.getResourceAsStream("ep_1.png"));
			background = ImageIO.read(PlanePanel.class.getResourceAsStream("map.jpg"));
			hbimage = ImageIO.read(PlanePanel.class.getResourceAsStream("myb_1.png"));
			ebimage = ImageIO.read(PlanePanel.class.getResourceAsStream("epb_1.png"));
			boomimage = ImageIO.read(PlanePanel.class.getResourceAsStream("blow.gif"));
			
		}catch(IOException e) {
			e.printStackTrace();		
		}
	}
	HeroPlane heroplane = new HeroPlane();
	private List<EnemyPlane>  ep= new ArrayList<EnemyPlane>();
	Boss boss = new Boss();
	private List<HeroBullet> hb =new ArrayList<HeroBullet>();
	private List<EnemyBullet> eb =new ArrayList<EnemyBullet>();
	private List<BossBullet> bb =new ArrayList<BossBullet>();
	public PlanePanel() {
		
	}
	private void AddEnemyPlane() {
		ep.add(new EnemyPlane());
	}
	private void AddHeroBullet(HeroBullet b) {
		hb.add(b);
	}
	private void AddEnemyBullet(EnemyBullet b) {
		eb.add(b);
	}
	private void AddBossBullet() {
		bb.add(new BossBullet());
	}
	public void paint(Graphics g){
		super.paint(g);
		drawBackground(g);
		drawHero(g);
		drawEnemy(g);
		drawboss(g);
		drawBullets(g);
		drawState(g);
		drawTools(g);
		
	}
	
	private void drawboss(Graphics g) {
		g.drawImage(boss.getImage(), boss.x, boss.y, drawbossWidth,drawbossHeight, null);

		
	}
	private void drawState(Graphics g) {
		int x = 10;
		int y = 25;
		Font font = new Font(Font.SANS_SERIF, Font.BOLD,22);
		g.setColor(new Color(0xff0000));
		g.setFont(font);
		g.drawString("Score: "+score,x, y);
		y = y + 20;
		g.drawString("Life: " +heroplane.getLife(), x, y);
		y = y + 20;
		g.drawString("Energy: " +heroplane.getSpecialEnergy(), x, y);
	}
	
	private void drawTools(Graphics g) {
	}
	
	private void drawBullets(Graphics g) {
		for(int i = 0; i < eb.size(); i++) {
			EnemyBullet b = eb.get(i);
//			EnemyPlane e = ep.get(i);
//			b.setX(e.x);
//			b.setY(e.y);
			if(!b.out){	
				g.drawImage(b.getImage(),b.x,b.y,drawBulletWidth,drawBulletHeight, null);
	
				b.setY(b.getY() + speed);//这个或许可以写到EnemyBullet里的move方法里面
				if(b.getY() > PlanePanel.Height) {
					b.out = true;//竖直方向上出界
				}
				if(b.getX() + drawBulletWidth > heroplane.x && b.getX() < heroplane.x + drawplaneWidth && b.getY()+drawBulletHeight > heroplane.y && b.getY() +drawBulletHeight < heroplane.y + drawplaneHeight) {
					heroplane.setLife(heroplane.getLife() -1);
					b.out = true;
				}
			}else {
				eb.remove(b);
				i--;
			}
		}
		
		
	//	AddHeroBullet(heroplane.shoot());
	//	System.out.println(hb.size());
		for(int i = 0; i<hb.size(); i++) {
			HeroBullet b = hb.get(i);
//			for(int j = 0; j < ep.size();j++) {
//				EnemyPlane e = ep.get(j);
//				if(b.getX()+ drawBulletWidth >e.getX() &&
//						b.getX() < e.getX() + drawplaneWidth && 
//						b.getY() <e.getY()+drawplaneHeight && 
//						b.getY()+ drawBulletHeight < e.getY()) {
//					e.out = true;
//					b.out = true;
//				}
//			}
			if(!b.out){	
				g.drawImage(b.getImage(), b.x ,b.y-drawplaneHeight,drawplaneWidth,drawplaneHeight, null);
				b.setY(b.getY() - speed);
				if(b.getY() < 0) {
					b.out = true;
				}
			}else {
				hb.remove(b);
				i--;
			}
		}
//		for(int i = 0; i<hb.size(); i++) {
//			HeroBullet b = hb.get(i);
////			if(b.out) {
////				hb.remove(i);
////				i--;
////				continue;
////			}
//			for(int j = 0; j < ep.size();j++) {
//			EnemyPlane e = ep.get(j);
//				if(b.getX()+ drawBulletWidth >e.getX() &&
//						b.getX() < e.getX() + drawplaneWidth && 
//						b.getY() <e.getY()+drawplaneHeight && 
//						b.getY()+ drawBulletHeight < e.getY()) {
//					e.out = true;
//					b.out = true;
//				}
//			if(e.out) {
//				ep.remove(j);
//				j--;
////				continue;
//				}
//			}
//			if(!b.out){	
//				g.drawImage(b.getImage(), b.x ,b.y-drawplaneHeight,drawplaneWidth,drawplaneHeight, null);
//				b.setY(b.getY() - speed);
//				if(b.getY() < 0) {
//					b.out = true;
//				}
//			}
//			else {
//				hb.remove(b);
//				i--;
//			}
////			}
			
		
			
		//if(score > 20000000) {
			for(int i = 0; i < bb.size(); i++) {
				BossBullet b = bb.get(i);
				if(!b.out){
					g.drawImage(b.getImage(), b.x+b.getImage().getWidth()/2,b.getImage().getHeight(),10,20, null);
					b.setY(b.getY() + speed);
					if(b.getY() > PlanePanel.Height) {
						b.out = true;
					}
					if(b.getX() + drawBulletWidth > boss.x && b.getX() < boss.x + drawplaneWidth && b.getY()+drawBulletHeight > boss.y && b.getY() +drawBulletHeight < boss.y + drawplaneHeight) {
						boss.setLife(boss.getLife() -1);
						b.out = true;
					}
			}else {
				bb.remove(b);
				i--;
			}
				
		}
			
	}
		
//}
	int ebcount = 0;
	private void drawEnemy(Graphics g) {
		for(int i = 0;i < ep.size();i++) {
			EnemyPlane e = ep.get(i);
			
			ebcount++;
			if(ebcount % 50 == 0){
				AddEnemyBullet(e.shoot());
				ebcount = 0;
			}
		
			//System.out.println(ep.size());
			if(!e.out){	
				g.drawImage(e.getImage(), e.x, e.y, drawplaneWidth, drawplaneHeight, null);
				e.move();
				if(e.getY() > PlanePanel.Height) {
					e.out = true;
				}
		}else {
			ep.remove(e);
			i--;
//			if() {
//				//ep.remove(i);
//				//i--;
//				System.out.println("remove 成功");
//			}else {
//				System.out.println("remove 失败");
//			}
			}
		}

		
	}
	private void drawHero(Graphics g) {
		if(heroplane.getX()<0)
			heroplane.setX(0);
		if(heroplane.getY()<0)
			heroplane.setY(0);
		if(heroplane.getX() >(Width - drawplaneWidth))
			heroplane.setX(Width - drawplaneWidth);
		if(heroplane.getY() >(Height - drawplaneHeight))
			heroplane.setY(Height - drawplaneHeight);
		if(up == true) {
			heroplane.setY(heroplane.y - 5);
		}
		if(down == true) {
			heroplane.setY(heroplane.y + 5);
		}
		if(left == true) {
			heroplane.setX(heroplane.x - 5);
		}
		if(right == true) {
			heroplane.setX(heroplane.x + 5);
		}
		g.drawImage(heroplane.getImage(), heroplane.x, heroplane.y, drawplaneWidth,drawplaneHeight, null);
	}
	//
	private void drawBackground(Graphics g) {
		g.drawImage(background,0, 0, PlanePanel.Width,PlanePanel.Height, null);
	}
	
//	public void update(Graphics g) {
//		Image i = null;
//		if(i == null) {
//			i = this.createImage(PlanePanel.Width, PlanePanel.Height);
//		}	
//			Graphics ig = i.getGraphics();
//			drawBackground(ig);
//			drawHero(g);	
//			drawEnemy(g);
//			drawBullets(g);
//			paint(ig);
//			g.drawImage(i, PlanePanel.Width, PlanePanel.Height,null);
//		
//	}
	
	
	public void GO() {
		//键盘监听
		
		
			
		
		//主流程
		//事件一
		time.schedule(new TimerTask() {
			
			@Override
			public void run() {
			//System.out.println("你好1");
			
				repaint();
			}
		},10,10);
		
		
		//事件二
		time.schedule(new TimerTask() {
			
			@Override
			public void run() {
			//System.out.println("你好2");
				AddEnemyPlane();
		
		}
		},1000,1000);
		
		//事件三
		time.schedule(new TimerTask() {
			
			@Override
			public void run() {
			//System.out.println("你好1");
			
				AddHeroBullet(heroplane.shoot());//可以在创建一个time进行时间的控制
			}
		},10,500);
	}
	//键盘监控
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				right = true;
				break;
			case KeyEvent.VK_LEFT:
				left = true;
				break;
			case KeyEvent.VK_UP:
				up = true;
				break;
			case KeyEvent.VK_DOWN:
				down = true;
				break;
			}
		}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		}
	}
	
}

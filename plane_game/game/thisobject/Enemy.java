package thisobject;
//敌人

import java.awt.image.BufferedImage;

import main.Dao;
import main.Start;

public class Enemy{
	private  int xspeed =4;
	private int yspeed = 4;
	private  BufferedImage image = Start.Enemy;
	private int x =(int)(Math.random()*(Dao.PanelWidth-Dao.drawenemyWidth));
	private int y = 0;
	public boolean out = false;
	private Bullet[] bullets;
	
	public int getXspeed() {
		return xspeed;
	}

	public void setXspeed(int xspeed) {
		this.xspeed = xspeed;
	}

	public int getYspeed() {
		return yspeed;
	}

	public void setYspeed(int yspeed) {
		this.yspeed = yspeed;
	}

	public BufferedImage getImage() {
		return image;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
		
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Bullet[] getBullets() {
		return bullets;
	}
	
	public void setBullets(Bullet[] bullets) {
		this.bullets = bullets;
	}

}

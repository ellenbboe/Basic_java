package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import thisobject.Bullet;
import thisobject.Enemy;
import thisobject.Hero;

//逻辑处理
public class Dao {
	private int herostep = 3;
	protected boolean up;
	protected boolean down;
	protected boolean left;
	protected boolean right;
	public int PanelWidth = 1200;
	public int PanelHeight = 800;
	protected int drawplaneWidth = 100;
	protected int drawenemyWidth = 200;
	protected int drawplaneHeight= 60;
	protected int drawenemyHeight= 120;
	protected int drawBulletWidth= 40;
	protected int drawBulletHeight= 60;
	public int score = 0;
	
	public void drawState(Graphics g,Hero hero) {
		int x = 10;
		int y = 25;
		Font font = new Font(Font.SANS_SERIF, Font.BOLD,22);
		g.setColor(new Color(0xff0000));
		g.setFont(font);
		g.drawString("Score: "+score,x,y);
		y = y + 20;
		g.drawString("Life: " +hero.getlife(), x, y);
	}
	public void drawBullets(Graphics g,Bullet[] bullet) {
		for(int i = 0;i<bullet.length;i++) {
			Bullet f = bullet[i];
			g.drawImage(f.getEnemyb(), f.getEnemybx(), f.getEnemyby(), null);
			g.drawImage(f.getHerob(), f.getHerobx(), f.getHeroby(), null);
		}
	}
	public void drawHero(Graphics g,Hero hero) {
		if(hero.getX()<0)
			hero.setX(0);
		if(hero.getY()<0)
			hero.setY(0);
		if(hero.getX() >(PanelWidth - drawplaneWidth))
			hero.setX(PanelWidth - drawplaneWidth);
		if(hero.getY() >(PanelHeight - drawplaneHeight))
			hero.setY(PanelHeight - drawplaneHeight);
		if(up == true) {
			hero.setY(hero.getY() - herostep);
		}
		if(down == true) {
			hero.setY(hero.getY() + herostep);
		}
		if(left == true) {
			hero.setX(hero.getX() - herostep);
		}
		if(right == true) {
			hero.setX(hero.getX() + herostep);
		}
		g.drawImage(Start.Hero,hero.getX(),hero.getY(),drawplaneWidth,drawplaneHeight,null);
	}
	
	
	public void drawEnemy(Graphics g,Enemy[] flying) {
		for (int i = 0; i < flying.length; i++) {
			Enemy f = flying[i];
			g.drawImage(f.getImage(), f.getX(), f.getY(), null);
		}
	}
	
	
	public void drawBackground(Graphics g) {
		g.drawImage(Start.Background,0, 0, PanelWidth,PanelHeight, null);//背景
	}
	
	}


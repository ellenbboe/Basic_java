package thisobject;

import java.awt.image.BufferedImage;

import main.Start;

//子弹
public class Bullet{
	private int herobx;
	private int heroby;
	private int enemybx;
	private int enemyby;
	private BufferedImage enemyb = Start.Enemybullet;
	private BufferedImage herob = Start.Herobullet;
	public int getHerobx() {
		return herobx;
	}
	public void setHerobx(int herobx) {
		this.herobx = herobx;
	}
	public int getHeroby() {
		return heroby;
	}
	public void setHeroby(int heroby) {
		this.heroby = heroby;
	}
	public int getEnemybx() {
		return enemybx;
	}
	public void setEnemybx(int enemybx) {
		this.enemybx = enemybx;
	}
	public int getEnemyby() {
		return enemyby;
	}
	public void setEnemyby(int enemyby) {
		this.enemyby = enemyby;
	}
	public BufferedImage getEnemyb() {
		return enemyb;
	}

	public BufferedImage getHerob() {
		return herob;
	}
	
}

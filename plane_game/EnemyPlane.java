package plane1;

import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemyPlane extends PlaneObject{
	private int speed = 1;
	private BufferedImage image = PlanePanel.enemyplane1;
	public boolean out;
	public int initx;
	public EnemyPlane() {
		//随机生成x坐标
		initx = new Random().nextInt(PlanePanel.Width-100);
		this.setX(initx);
	}
	
	public BufferedImage getImage() {
		return image;
	}
	int speed1 = 3;
	int i = new Random().nextInt(2);
	public void move() {
		
		
		if(x > PlanePanel.Width - 100) {
			speed1 = -speed1;
			
		}else if(x<0)
		{
			speed1 =-speed1;
		}
		if(i == 1)
			x = x + speed1;
		else if(i == 0)
			x = x - speed1;
//		如果要直飞的飞机的话就只要 y = y+ speed;
//		
		y = y + speed;
		
		
	}
	public EnemyBullet shoot() {
		EnemyBullet b = new EnemyBullet();
		b.setX(this.x);
		b.setY(this.y + 20);
		return b;
	}
	public boolean shooted(int x, int y) {
		return false;
	}
}

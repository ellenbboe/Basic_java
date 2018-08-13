package thisobject;
//敌人

import java.awt.image.BufferedImage;

import main.Start;

public class Enemy{
private  BufferedImage image = Start.Enemy;
private int x;
private int y;
private Bullet[] bullets;
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

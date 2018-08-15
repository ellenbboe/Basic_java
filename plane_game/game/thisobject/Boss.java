package thisobject;

import java.awt.image.BufferedImage;

import main.Dao;
import main.Start;

public class Boss {
private int xspeed = 5;
private int yspeed = 5;
private int x = Dao.PanelWidth/2;
private int y = Dao.PanelHeight/2;
private BufferedImage image = Start.Boss;

public BufferedImage getImage() {
	return image;
}



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


}

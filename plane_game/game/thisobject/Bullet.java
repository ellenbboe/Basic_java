package thisobject;

import java.awt.image.BufferedImage;

import main.Start;

//子弹
public class Bullet{

	private int x;
	private int y;
	public boolean out = false;
	private BufferedImage image = Start.Herobullet;
	
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

	public BufferedImage getImage() {
		return image;
	}


	
}

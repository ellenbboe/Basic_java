package plane1;

import java.awt.image.BufferedImage;

public class Boss extends PlaneObject {
	private BufferedImage image;
	private int life;
	
	public void shoot() {
		
	}
	
	public void enemyBoom() {
		
	}
	public boolean shooted(int x, int y) {
		return false;
	}

	public int getLife() {
		
		return 0;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void setLife(int life) {
		this.life = life;
	}
}

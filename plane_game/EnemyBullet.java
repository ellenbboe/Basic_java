package plane1;

import java.awt.image.BufferedImage;

public class EnemyBullet extends BulletObject{
	private BufferedImage image;
	public EnemyBullet() {
		this.setImage(PlanePanel.ebimage);
	}
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void move() {
		
	}
}

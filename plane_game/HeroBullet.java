package plane1;

import java.awt.image.BufferedImage;

public class HeroBullet extends BulletObject{
	private BufferedImage image;
	public HeroBullet() {
		this.setImage(PlanePanel.hbimage);
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

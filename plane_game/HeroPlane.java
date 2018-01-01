package plane1;

import java.awt.image.BufferedImage;

public class HeroPlane extends PlaneObject{
	
	private BufferedImage image;
	private int state;
	private int life;
	private int specialEnergy;
	public HeroPlane() {
		this.setImage(PlanePanel.Heroplane1);
		this.x = PlanePanel.Width/2;
		this.y = PlanePanel.Height/2;
		this.setLife(1000);
		this.setSpecialEnergy(50);
	}
	
	public void move() {
		
	}
	public HeroBullet shoot() {
		HeroBullet b = new HeroBullet();
		b.setX(this.x);
		b.setY(this.y + 20);
		return b;
		
	}
	public void EnergyBoom() {
		
	}
	public boolean shooted(int x, int y) {
		return false;
	}
	public void getTools(int x, int y) {
		
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getSpecialEnergy() {
		return specialEnergy;
	}

	public void setSpecialEnergy(int specialEnergy) {
		this.specialEnergy = specialEnergy;
	}
	
}

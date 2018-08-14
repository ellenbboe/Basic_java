package thisobject;

import main.Dao;

//玩家
public class Hero {

	private int life =100;
	private int x=Dao.PanelWidth/2;
	private int y=Dao.PanelHeight/2;
	public int getlife() {
		return life;
	}
	public void setlife(int life) {

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

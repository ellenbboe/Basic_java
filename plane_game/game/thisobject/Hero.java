package thisobject;

import main.Dao;

//玩家
public class Hero extends Flyobject{
	private Dao dao = new Dao();
	private int life =100;
	private int x=dao.PanelWidth/2;
	private int y=dao.PanelHeight/2;
	public int getlife() {
		return life;
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

package main;

import thisobject.Bullet;
import thisobject.Enemy;
import thisobject.Hero;

/*处理飞行物的动作
 * 1.射击
 * 2.移动
 */
public class Action {
	private int xspeed = 4;
	private int yspeed = 4;
	
	public void create_enemy(Enemy[] enemy) {
		
	}
	
	public void destory_enemy(Enemy[] enemy) {
		
	}
	
	public void create_bullets(Bullet[] bullet) {
		
	}
	
	public void destory_bullets(Bullet[] bullet) {
		
	}
	
	public void move(Enemy[] enemy) {
		
	}
	public void move(Bullet[] bullets) {
		for(int i = 0;i<bullets.length;i++) {
			Bullet b = bullets[i];
			
		}
	}

	public boolean shot() {
		
		return true;
	}
	//碰撞.英雄子弹与敌人碰撞,敌人子弹与英雄碰撞
	public boolean hit(Bullet[] b,Hero hero) {
		return true;
	}
	public boolean hit(Bullet[] b,Enemy enemy) {
		return true;
	}
	
}

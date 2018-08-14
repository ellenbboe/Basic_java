package main;

import java.util.Arrays;

import thisobject.Bullet;
import thisobject.Enemy;
import thisobject.Hero;

/*处理飞行物的动作
 * 1.射击
 * 2.移动
 */
public class Action {
	private static int yspeed = 4;
	
	public Enemy[] create_enemy(Enemy[] enemy) {
		int a = (int)(Math.random()*5 -3);
		Enemy e = new Enemy();
		if(a<0) {
			e.setXspeed(-e.getXspeed());
		}
		enemy = Arrays.copyOf(enemy, enemy.length + 1);
		enemy[enemy.length - 1] = e;
		return enemy;
	}
	//放在了Start里面,所以这里注释了
//	public void destory_enemy(Enemy[] enemy) {
//		
//		int length = enemy.length;
//		int a = 0;
//		for(int i = 0;i<enemy.length;i++) {
//			Enemy e = enemy[i];
//			if(e.out == true) {
//				a =1;
//				Enemy temp = enemy[length - 1];
//				enemy[length -1] = e;
//				enemy[i] = temp;
//				length--;
//			}
//		}
//		if(a ==1)
//		enemy = Arrays.copyOf(enemy, length - 1);
//	}
	
	public Bullet[] create_bullets(Bullet[] bullet,Hero hero) {//有问题
		Bullet b = new Bullet();
		b.setX(hero.getX()+Dao.drawplaneWidth/2 - Dao.drawBulletWidth/2);
		b.setY(hero.getY() - Dao.drawBulletHeight);
		bullet = Arrays.copyOf(bullet, bullet.length + 1);
		bullet[bullet.length - 1] = b;
		return bullet;
	}
	//写在了Start里面
//	public  void destory_bullets() {
//		int length = bullet.length;
//		int a = 0;
//		for(int i = 0;i<bullet.length;i++) {
//			Bullet b = bullet[i];
//			if(b.out == true) {
//				Bullet temp = bullet[length - 1];
//				bullet[length -1] = b;
//				bullet[i] = temp;
//				length --;
//				a = 1;
//			}
//		}
//		if(a == 1)
//		bullet = Arrays.copyOf(bullet, length -1);
//		
//	}
	
	
	
	public static void move(Enemy e) {
			if(e.getX() < 0 || e.getX() + Dao.drawenemyWidth > Dao.PanelWidth) {
				e.setXspeed(-e.getXspeed());
			}
			e.setX(e.getX()+e.getXspeed());
			e.setY(e.getY() + yspeed);
			if(e.getY() > Dao.PanelHeight) {
				e.out = true;
			}
		
	}
	
	public static void move(Bullet b) {
			b.setY(b.getY() - yspeed);
			if(b.getY() == 0) {
				b.out = true;
			}
		}


	//碰撞.英雄子弹与敌人碰撞,敌人与英雄碰撞
	public static void hit(Bullet b,Enemy e,Dao dao) {
			if(b.getX() + Dao.drawBulletWidth > e.getX() && b.getX() < e.getX() + 
					Dao.drawenemyWidth && b.getY()+Dao.drawBulletHeight > e.getY() && b.getY() 
					< e.getY() + Dao.drawenemyHeight ){
				b.out = true;
				e.out = true;
				dao.setScore(dao.getScore() + 1);
			}else if(b.getY()<=0) {
				b.out = true;
			}
	}
	
	
	public static void hit(Hero hero,Enemy e, Dao dao) {
			if(hero.getX() + Dao.drawplaneWidth > e.getX() && hero.getX() 
					< e.getX() + Dao.drawenemyWidth && hero.getY()+Dao.drawplaneHeight > 
			e.getY() && hero.getY() < e.getY() + Dao.drawenemyHeight ) {
				e.out = true;
				hero.setlife(hero.getlife()-1);
				dao.setScore(dao.getScore() - 10);
			}else if(e.getY() >= Dao.PanelHeight){
				e.out = true;
			}
		}
}

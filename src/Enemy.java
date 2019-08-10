import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GammeObject{
	int enemySpeed = 0;
	int diagonalSpeed=3;
	Enemy(int newX, int newY, int newWidth, int newHeight, int speed) {
		super(newX, newY, newWidth, newHeight);
		// TODO Auto-generated constructor stub
		enemySpeed=speed;
	}
	
	
	void update(Player p) {
		
		
		
		if(Math.abs(p.x-x)<enemySpeed&&Math.abs(p.y-y)<enemySpeed) {
			x=p.x;
			y=p.y;
			//p.isAlive=false;
		}
		
		if(Math.abs(Math.abs(p.x-x)-Math.abs(p.y-y))<=enemySpeed) {
			if(x>p.x) {
				x-=enemySpeed;
			}
			if(x<p.x) {
				x+=enemySpeed;
		}
			if(y>p.y) {
				y-=enemySpeed;
			}
			if(y<p.y) {
				y+=enemySpeed;
			}
		}
		
		else if(Math.abs(p.x-x)>Math.abs(p.y-y)) {
		if(x>p.x) {
			x-=enemySpeed;
		}
		if(x<p.x) {
			x+=enemySpeed;
		}
		}
		
	
		else if(Math.abs(p.x-x)<Math.abs(p.y-y)){
		if(y>p.y) {
			y-=enemySpeed;
		}
		if(y<p.y) {
			y+=enemySpeed;
		}
		}
		
		
	}
	
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, width, height);
	}

}

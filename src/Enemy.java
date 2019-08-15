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
		int radiuss=width/2;
		
		int radius=radiuss-5;
		

		if(Math.abs(p.x-radius-x)<enemySpeed&&Math.abs(p.y-radius-y)<enemySpeed) {
			x=p.x-radius;
			y=p.y-radius;
			//p.isAlive=false;
		}

		
		
		if(Math.abs(Math.abs(p.x-radius-x)-Math.abs(p.y-radius-y))<=enemySpeed) {
			if(x>p.x-radius) {
				x-=enemySpeed;
			}
			if(x<p.x-radius) {
				x+=enemySpeed;
		}
			if(y>p.y-radius) {
				y-=enemySpeed;
			}
			if(y<p.y-radius) {
				y+=enemySpeed;
			}
		}
		
		else if(Math.abs(p.x-radius-x)>Math.abs(p.y-radius-y)) {
		if(x>p.x-radius) {
			x-=enemySpeed;
		}
		if(x<p.x-radius) {
			x+=enemySpeed;
		}
		}
		
	
		else if(Math.abs(p.x-radius-x)<Math.abs(p.y-radius-y)){
		if(y>p.y-radius) {
			y-=enemySpeed;
		}
		if(y<p.y-radius) {
			y+=enemySpeed;
		}
		}
		
		
	}
	
	void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(x,y,width,height);
		g.setColor(Color.RED);
		g.fillOval(x, y, width, height);
	}

}

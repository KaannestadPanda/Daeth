import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GammeObject{
	int enemySpeed = 0;
	int diagonalSpeed=3;
	boolean warningg=true;
	long startTime;
	long duration;
	
	
	Enemy(int newX, int newY, int newWidth, int newHeight, int speed) {
		super(newX, newY, newWidth, newHeight);
		// TODO Auto-generated constructor stub
		enemySpeed=speed+=2;
		duration =1000;
		startTime=System.currentTimeMillis();
		
	}
	
	
	
	
	void update(Player p) {
		
		super.update();
		
		if(warningg==false) {
		
		
		
		
		
		
		
		int trueX=x+radius;
		int trueY=y+radius;
		
		
		if(collisionBox.intersectsCircle(p.collisionBox)) {
			x=p.x;
			y=p.y;
			
			p.isAlive=false;
		}

		
		
		if(Math.abs(Math.abs(p.ptruex-trueX)-Math.abs(p.ptruey-trueY))<=enemySpeed) {
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
		
		else if(Math.abs(p.ptruex-trueX)>Math.abs(p.ptruey-trueY)) {
		if(x>p.x-radius) {
			x-=enemySpeed;
		}
		if(x<p.x-radius) {
			x+=enemySpeed;
		}
		}
		
	
		else if(Math.abs(p.ptruex-trueX)<Math.abs(p.ptruey-trueY)){
		if(y>p.y-radius) {
			y-=enemySpeed;
		}
		if(y<p.y-radius) {
			y+=enemySpeed;
		}
		}
		
		
		
		
		

//		if(Math.abs(p.ptruex-trueX)<enemySpeed&&Math.abs(p.ptruey-trueY)<enemySpeed) {
//			x=p.x;
//			y=p.y;
//			
//			//p.isAlive=false;
//		}
//
//		
//		
//		if(Math.abs(Math.abs(p.ptruex-trueX)-Math.abs(p.ptruey-trueY))<=enemySpeed) {
//			if(x>p.x-radius) {
//				x-=enemySpeed;
//			}
//			if(x<p.x-radius) {
//				x+=enemySpeed;
//		}
//			if(y>p.y-radius) {
//				y-=enemySpeed;
//			}
//			if(y<p.y-radius) {
//				y+=enemySpeed;
//			}
//		}
//		
//		else if(Math.abs(p.ptruex-trueX)>Math.abs(p.ptruey-trueY)) {
//		if(x>p.x-radius) {
//			x-=enemySpeed;
//		}
//		if(x<p.x-radius) {
//			x+=enemySpeed;
//		}
//		}
//		
//	
//		else if(Math.abs(p.ptruex-trueX)<Math.abs(p.ptruey-trueY)){
//		if(y>p.y-radius) {
//			y-=enemySpeed;
//		}
//		if(y<p.y-radius) {
//			y+=enemySpeed;
//		}
//		}
//		
		
	
		}
		else {
			if(System.currentTimeMillis()>startTime+duration) {
				warningg=false;
			}
		}
		
	}
	
	void draw(Graphics g) {
		
		if(warningg==false) {
	//	g.setColor(Color.BLACK);
		//g.drawRect(x,y,width,height);
		g.setColor(Color.RED);
		g.fillOval(x, y, width, height);
		}
		else {
			g.setColor(Color.ORANGE);
			g.fillOval(x, y, width, height);
		}
		
	}

}

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GammeObject {
	int enemySpeed = 0;
	int movingSpeed;
	boolean warningg = true;
	long startTime;
	long duration;
	boolean frozen=false;

	Enemy(int newX, int newY, int newWidth, int newHeight, int speed) {
		super(newX, newY, newWidth, newHeight);
		// TODO Auto-generated constructor stub
		enemySpeed = speed;
		movingSpeed = speed;
		duration = 1000;
		startTime = System.currentTimeMillis();

	}

	void update(Player p) {

		super.update();
		
		if(frozen) {
			enemySpeed=0;
		}
		else {
			enemySpeed=movingSpeed;
		}
		

		if (warningg == false) {

			

			if (collisionBox.intersectsCircle(p.collisionBox)==true) {
				x=p.trueX-radius;
				y=p.trueY-radius;

				p.isAlive = false;
				
			}
			
			if(frozen==false) {

			if (Math.abs(trueX - p.trueX) <= enemySpeed) {

			} else if (trueX > p.trueX) {
				x -= enemySpeed;
			} else if (trueX < p.trueX) {
				x += enemySpeed;
			}

			if (Math.abs(trueY - p.trueY) <= enemySpeed) {

			} else if (trueY > p.trueY) {
				y -= enemySpeed;
			} else if (trueY < p.trueY) {
				y += enemySpeed;
			}
			
			}



		} else {
			
			if (System.currentTimeMillis() > startTime + duration) {
				warningg = false;
			}
			
			
		}

	}

	void draw(Graphics g) {

		if(warningg&&frozen) {
			g.setColor(Color.ORANGE);
		}
		else if(warningg) {
			g.setColor(Color.ORANGE);
		}
		else if(frozen){
			g.setColor(Color.CYAN);
		}
		else {
			g.setColor(Color.RED);
		}
		g.fillOval(x, y, width, height);	


	}

}

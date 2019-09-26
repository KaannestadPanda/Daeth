import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GammeObject {
	int enemySpeed = 0;
	int diagonalSpeed = 3;
	boolean warningg = true;
	long startTime;
	long duration;

	Enemy(int newX, int newY, int newWidth, int newHeight, int speed) {
		super(newX, newY, newWidth, newHeight);
		// TODO Auto-generated constructor stub
		enemySpeed = speed += 2;
		duration = 1000;
		startTime = System.currentTimeMillis();

	}

	void update(Player p) {

		super.update();

		if (warningg == false) {

			

			if (collisionBox.intersectsCircle(p.collisionBox)==true) {
				//x = p.x;
				//y = p.y;
				x=p.trueX-radius;
				y=p.trueY-radius;

				p.isAlive = false;
				
			}

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



		} else {
			if (System.currentTimeMillis() > startTime + duration) {
				warningg = false;
			}
		}

	}

	void draw(Graphics g) {

		if (warningg == false) {
			// g.setColor(Color.BLACK);
			// g.drawRect(x,y,width,height);
			g.setColor(Color.RED);
			g.fillOval(x, y, width, height);
			g.setColor(Color.BLACK);
			g.drawOval(x, y, width, height);
			g.drawOval(x, y, 5, 5);
		} else {
			g.setColor(Color.ORANGE);
			g.fillOval(x, y, width, height);
		}

	}

}

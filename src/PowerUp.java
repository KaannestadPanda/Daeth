import java.awt.Color;
import java.awt.Graphics;

public class PowerUp extends GammeObject {

	PowerUp(int newX, int newY, int newWidth, int newHeight) {
		super(newX, newY, newWidth, newHeight);
		// TODO Auto-generated constructor stub

	}

	boolean available = false;

	void update(Player p) {
		
		super.update();

		if (available) {
			
			if (collisionBox.intersectsCircle(p.collisionBox) == true) {
				
				p.powerUpCount++;
				available = false;
				p.score+=20;
			}

		}

	}

	void draw(Graphics g) {
		if (available) {
			g.setColor(Color.BLUE);
			g.fillOval(x, y, width, height);
		}
	}

}

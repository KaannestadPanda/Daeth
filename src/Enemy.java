import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GammeObject{

	Enemy(int newX, int newY, int newWidth, int newHeight) {
		super(newX, newY, newWidth, newHeight);
		// TODO Auto-generated constructor stub
	}
	int enemySpeed = 3;
	
	void update(Player p) {
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
	
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval(x, y, width, height);
	}

}

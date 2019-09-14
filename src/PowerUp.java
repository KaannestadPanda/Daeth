import java.awt.Color;
import java.awt.Graphics;

public class PowerUp extends GammeObject{

	boolean isAlive=false;
	
	PowerUp(int newX, int newY, int newWidth, int newHeight) {
		super(newX, newY, newWidth, newHeight);
		// TODO Auto-generated constructor stub
		
	}
	
	boolean available=false;
	
	int radiuss=width/2;
	
	int radius=radiuss-5;
	
	
	
	void update(Player p) {
		
		if(isAlive) {
		if(Math.abs(p.x-(radius-x))<20||Math.abs(p.y-(radius-y))<20) {
			p.powerUpCount++;
			isAlive=false;
		}
		
		}
		
	}
	
	
	void draw(Graphics g) {
		if(isAlive) {
		g.setColor(Color.BLUE);
		g.fillOval(x, y, width, height);
		}
	}
	
	
	
	
	
	
}

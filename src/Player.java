import java.awt.Color;
import java.awt.Graphics;

public class Player extends GammeObject{

	int speed;
	Player(int newX, int newY, int newWidth, int newHeight) {
		super(newX, newY, newWidth, newHeight);
		speed = 5;
	}
	
	void update() {
		
		
	if(rightPressed==true) {
		x+=speed;
		}
	if(leftPressed==true) {
		x-=speed;
		}
	if(upPressed==true) {
		y-=speed;
		}
	if(downPressed==true) {
		y+=speed;
		}
	
	
	
	}
	
	
	void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
		
	}
	
	
	
}

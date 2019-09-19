import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Player extends GammeObject{

	int powerUpCount=0;
	int speed;
	int ptruex;
	int ptruey;
	Player(int newX, int newY, int newWidth, int newHeight) {
		super(newX, newY, newWidth, newHeight);
		speed = 5;
	}
	
	void update() {
		
		super.update();
		ptruex=x+radius;
		ptruey=y+radius;
	
	
	
	
	}
	
	
	void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
		
	}

	
	
	
}

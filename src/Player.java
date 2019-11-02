import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Player extends GammeObject{

	
	int score = 0;
	int powerUpCount=1;
	int speed;
	
	Player(int newX, int newY, int newWidth, int newHeight) {
		super(newX, newY, newWidth, newHeight);
		speed = 5;
	}
	
	void update() {
		
		super.update();
		
	
	
	
	
	}
	
	
	void draw(Graphics g) {
		g.drawImage(Gamme.diabloImg,(x-(1/2*width)),(y-(1/2*height)),width,height,null);
		//g.setColor(Color.BLACK);
		//g.drawOval(x, y, width, height);
		
	}

	
	
	
}

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class GammeObject {

	
	Boolean isAlive=true;
	int x;
    int y;
    int width;
    int height;
    CollisionCircle collisionBox;
    int radius=width/2;

GammeObject(int newX, int newY, int newWidth, int newHeight){
	x=newX;
	y=newY;
	width=newWidth;
	height=newHeight;
	collisionBox=new CollisionCircle(x,y,width);
}

void update() {
	collisionBox.setBounds(x+radius, y+radius);
	
}

void draw(Graphics ge) {
	
}

	
}

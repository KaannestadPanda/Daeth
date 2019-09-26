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
    int radius;
    int trueX;
    int trueY;

GammeObject(int newX, int newY, int newWidth, int newHeight){
	x=newX;
	y=newY;
	width=newWidth;
	height=newHeight;
	radius=width/2;
	collisionBox=new CollisionCircle(x,y,radius);
	trueX=x+radius;
	trueY=y+radius;
}

void update() {
	trueX=x+radius;
	trueY=y+radius;
	collisionBox.setBounds(trueX, trueY);
	
}

void draw(Graphics ge) {
	
}

	
}

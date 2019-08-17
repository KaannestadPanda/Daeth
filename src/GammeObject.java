import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class GammeObject {

	
	Boolean isAlive=true;
	int x;
    int y;
    int width;
    int height;
    Rectangle collisionBox;
   // Ellipse2D collisionCircle;

GammeObject(int newX, int newY, int newWidth, int newHeight){
	x=newX;
	y=newY;
	width=newWidth;
	height=newHeight;
	collisionBox=new Rectangle(x,y,width,height);
}

void update() {
	collisionBox.setBounds(x, y, width, height);
	//collisionCircle.
}

void draw(Graphics ge) {
	
}

	
}

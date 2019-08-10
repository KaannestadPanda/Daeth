import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Buttonn {
int x;
int y;
int width;
int height;
	boolean clicked=false;
	
	
	Buttonn(int newX, int newY, int newWidth, int newHeight){
	
		x=newX;
		y=newY;
		width=newWidth;
		height=newHeight;
		
		
	}
	
	void update(){
		
	}
	
	void draw(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(x, y, width, height);
	}

boolean checkClicked(int cx, int cy) {
	if(cx>x&&cx<x+width&&cy>y&&cy<y+height) {
		return true;
	}
	
		return false;
	
}
	
	


	

	
	
	
	
	
	
	
}

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Buttonn implements ActionListener, MouseListener {
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
		g.fillRect(x, y, width, height);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()>=x  &&  e.getX()<=x+width  &&  e.getY()>= y  &&  e.getY()<= y+height){
			clicked=true;
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}

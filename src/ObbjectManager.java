import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ObbjectManager {

	
	long timeTimer=1000;
	
	Random ranX=new Random();
	Random ranY=new Random();
	
	int seconds=-1;
	
	
	Player play;
	ArrayList<Enemy> zergs=new ArrayList<Enemy>();
	
	int life=500;
	Rectangle r=new Rectangle(860,450,100,100);
	int frameCount=0;
	
	ObbjectManager(Player z){
		play=z;
	}
	
	void update() {
		frameCount++;
		
		
		if(frameCount==2) {
			Gamme.alreadyRan=false;
		}
		
		play.update();
		for(int i = zergs.size()-1;i>=0;i--) {
			zergs.get(i).update(play);

		}
		
		
		
		
	}
	
	void draw(Graphics g) {
		timeDoStuff(g);

		if(life<100) {
			g.setColor(Color.RED);
		}
		else if(life<200) {
			g.setColor(Color.ORANGE);
		}
		else if(life<300) {
			g.setColor(Color.YELLOW);
		}
		else {
			g.setColor(Color.GREEN);
		}
		
		
		g.fillRect(660, 930, life, 30);
		
		g.setColor(Color.BLUE);
		g.fillRect(860,450,100,100);
		play.draw(g);
		for(int i = zergs.size()-1;i>=0;i--) {
			zergs.get(i).draw(g);
		}
		if(play.collisionBox.intersects(r)) {
			life=500;
		}
		else {
			life--;
			if(life<=0) {
				//play.isAlive=false;
			}
		}
		
		
		manageTime();
		g.setColor(Color.BLACK);
		
		g.drawString(""+seconds, 10, 10);
		
		
		
	}
	
	void addEnemy(Enemy e){
		zergs.add(e);
	}
	
	
	void manageTime() {
		if(System.currentTimeMillis()-timeTimer>=1000){
			seconds++;
			
			timeTimer=System.currentTimeMillis();
		

	}
	

	
}
	int spawn12Already=0;
	boolean spawn6Already=false;
	
	void timeDoStuff(Graphics g) {
		if(seconds==5) {
			g.setColor(Color.GREEN);
			g.fillOval(20, 20, 30, 30);
			g.fillOval(400, 200, 30, 30);
			g.fillOval(800, 400, 30, 30);
		}
		if(seconds==6) {
			if(spawn6Already==false) {
			addEnemy(new Enemy(20,20,10,10,4));
			addEnemy(new Enemy(400,200,10,10,5));
			addEnemy(new Enemy(800,400,10,10,6));
			spawn6Already=true;
			}
			
		}
		
		if(seconds==11) {
			g.setColor(Color.YELLOW);
			g.fillOval(1879,54, 30, 30);
			g.fillOval(1877,911, 30, 30);
			g.fillOval(35,919, 30, 30);
			g.fillOval(36,53, 30, 30);
		}
		
		if(seconds==12) {
			if(spawn12Already<20) {
			addEnemy(new Enemy(1879,54,10,10,7));
			addEnemy(new Enemy(1877,911,10,10,8));
			addEnemy(new Enemy(35,919,10,10,9));
			addEnemy(new Enemy(36,53,10,10,9));
			
			
			spawn12Already++;
			}
		}
		
		
		int x18=ranX.nextInt(1911);
		int y18 = ranY.nextInt(981);
		if(seconds==17) {
			g.setColor(Color.YELLOW);
			
			
			
			g.fillOval(x18,y18,60, 60);
		}
		
		
		boolean spawn18Already=false;
		if(seconds==18) {
			if(spawn18Already==false) {
				addEnemy(new Enemy(x18,y18,60,60,2));
				spawn18Already=true;
			}
		}
		
		
	}
	
	
	
	
	
}

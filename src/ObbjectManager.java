import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class ObbjectManager {

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
				play.isAlive=false;
			}
		}
		
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
		
		
		g.fillRect(660, 950, life, 10);
		
		
		
	}
	
	void addEnemy(Enemy e){
		zergs.add(e);
	}
	

	
	
	
	
	
}

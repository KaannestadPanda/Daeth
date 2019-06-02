import java.awt.Graphics;
import java.util.ArrayList;

public class ObbjectManager {

	Player play;
	ArrayList<Enemy> zergs=new ArrayList<Enemy>();
	
	
	ObbjectManager(Player z){
		play=z;
	}
	
	void update() {
		
		play.update();
		for(int i = zergs.size()-1;i>=0;i--) {
			zergs.get(i).update(play);
		}
		
		
	}
	
	void draw(Graphics g) {
		play.draw(g);
		for(int i = zergs.size()-1;i>=0;i--) {
			zergs.get(i).draw(g);
		}
		
	}
	
	void addEnemy(Enemy e){
		zergs.add(e);
	}
	
	void checkCollision() {
		for(int i=zergs.size()-1;i>0;i--) {
			
			if(zergs.get(i).collisionBox.intersects(play.collisionBox)){
				
				play.isAlive=false;
				
			}
			
		}
		
	}
	
}

import java.awt.Graphics;

public class ObbjectManager {

	Player play;
	
	ObbjectManager(Player z){
		play=z;
	}
	
	void update() {
		play.update();
	}
	
	void draw(Graphics g) {
		play.draw(g);
	}
	
}

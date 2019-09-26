import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ObbjectManager implements ActionListener {

	int phaseCount = 0;
	boolean updatedPhaseCount = false;

	PowerUp power;
	
	int rand;

	long timeTimer = 1000;

	Random ranX = new Random();
	Random ranY = new Random();

	Random randomNum = new Random();

	int randX;
	int randY;

	int seconds;

	

	

	

	Player play;
	ArrayList<Enemy> zergs = new ArrayList<Enemy>();

	int life = 500;
	
	Rectangle r = new Rectangle(860, 450, 100, 100);
	
	int frameCount = 0;

	
	int randomSpeed;

	ObbjectManager(Player z) {
		play = z;
		power= new PowerUp(0,0,20,20);
	}

	void update() {
		frameCount++;

		if (frameCount == 2) {
			Gamme.alreadyRan = false;
		}

		play.update();
		power.update(play);
		for (int i = zergs.size() - 1; i >= 0; i--) {
			zergs.get(i).update(play);

		}

	}

	void draw(Graphics g) {
		
		for(int i=0;i<play.powerUpCount;i++) {
			int ycoord=i*50;
			g.setColor(Color.CYAN);
			g.fillOval(50,ycoord,20,20);
		}

		if (life < 100) {
			g.setColor(Color.RED);
		} else if (life < 200) {
			g.setColor(Color.ORANGE);
		} else if (life < 300) {
			g.setColor(Color.YELLOW);
		} else {
			g.setColor(Color.GREEN);
		}
		g.fillRect(660, 930, life, 30);

		if (seconds % 60 == 0 && updatedPhaseCount == false) {
			phaseCount++;
			updatedPhaseCount = true;
		}

		if ((seconds - 1) % 60 == 0) {
			updatedPhaseCount = false;
		}

		g.setColor(Color.BLUE);
		g.fillRect(860, 450, 100, 100);
		play.draw(g);
		power.draw(g);
		for (int i = zergs.size() - 1; i >= 0; i--) {
			zergs.get(i).draw(g);
		}
		if (play.x>=860&&play.x<=960&&play.y>=450&&play.y<=550) {
			life = 500;
		} else {
			life--;
			if (life <= 0) {
				play.isAlive=false;
			}
		}

		g.setColor(Color.BLACK);

		
		
		g.drawString("powerups:" +play.powerUpCount+ "  phase:" +phaseCount + "  seconds:" + seconds, 10, 10);

	}

	void addEnemy(Enemy e) {
		zergs.add(e);
	}

	void timeDoStuff() {

		if (seconds == 6) {
			
				addEnemy(new Enemy(20, 20, 10, 10, 4));
				addEnemy(new Enemy(400, 200, 10, 10, 5));
				addEnemy(new Enemy(800, 400, 10, 10, 6));
				
			

		}

		if (seconds == 12) {
			
				addEnemy(new Enemy(1879, 54, 10, 10, 7));
				addEnemy(new Enemy(1877, 911, 10, 10, 8));
				addEnemy(new Enemy(35, 919, 10, 10, 9));
				addEnemy(new Enemy(36, 53, 10, 10, 9));

				
			
		}

		if (seconds == 18) {
			
				addEnemy(new Enemy(ranX.nextInt(1911), ranY.nextInt(901), 60, 60, 5));
				
			
		}

		if (seconds == 24) {
			
				addEnemy(new Enemy(ranX.nextInt(1911), ranY.nextInt(901), 120, 120, 2));
				
			
		}



		if (seconds >= 30 && seconds % 6 == 0) {

			
				randomSpeed = ranX.nextInt(5);
				randomSpeed++;

			
			

			if (rand == 0) {

				addEnemy(new Enemy(randX, randY, 10, 10, 1));
				addEnemy(new Enemy(randX, randY, 10, 10, 2));
				addEnemy(new Enemy(randX, randY, 10, 10, 3));
				addEnemy(new Enemy(randX, randY, 10, 10, 4));
				addEnemy(new Enemy(randX, randY, 10, 10, 5));
				addEnemy(new Enemy(randX, randY, 10, 10, 6));
				addEnemy(new Enemy(randX, randY, 10, 10, 7));
				rand = randomNum.nextInt(3);
				randX = ranX.nextInt(1911);
				randY = ranY.nextInt(901);
			} else if (rand == 1) {

				addEnemy(new Enemy(randX, randY, 60, 60, randomSpeed));
				rand = randomNum.nextInt(3);
				randX = ranX.nextInt(1911);
				randY = ranY.nextInt(901);
			}

			else if (rand == 2) {

				addEnemy(new Enemy(randX, randY, 120, 120, randomSpeed));
				rand = randomNum.nextInt(3);
				randX = ranX.nextInt(1911);
				randY = ranY.nextInt(901);
			}
			
		}

	}
	
	void powerUpCall() {
		if(seconds%30==0) {
		int powerX=ranX.nextInt(1911);
		int powerY=ranY.nextInt(901);
		
		power.x=powerX;
		power.y=powerY;
		power.available=true;
		}
		
		if((seconds-6)%30==0) {
			power.available=false;
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		seconds++;
		powerUpCall();
		for(int i=0;i<phaseCount;i++) {
		timeDoStuff();
		}

	}

}

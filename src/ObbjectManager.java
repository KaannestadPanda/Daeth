import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ObbjectManager implements ActionListener {

	int secondsScore=0;
	int overallScore;
	int phaseCount = 0;
	boolean updatedPhaseCount = false;
	boolean enemiesFrozen=false;
	long duration=4000;
	long startTime;

	Color silver=new Color(227,227,227);
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
	int freezeGraphicY = 230;
	double freezeGraphicHeight=600;
	
	Rectangle r = new Rectangle(860, 450, 100, 100);
	
	int frameCount = 0;

	
	int randomSpeed;

	ObbjectManager(Player z) {
		play = z;
		power= new PowerUp(0,0,80,80);
	}

	void update() {
		frameCount++;

		if (frameCount == 2) {
			Gamme.alreadyRan = false;
		}

		overallScore=play.score+secondsScore;
		play.update();
		power.update(play);
		for (int i = zergs.size() - 1; i >= 0; i--) {
			zergs.get(i).update(play);

		}
		
		if(enemiesFrozen==false) {
			for (int i = zergs.size() - 1; i >= 0; i--) {
				zergs.get(i).frozen=false;
			}

		}
		
		

	}

	void draw(Graphics g) {
		
		g.setColor(silver);
		g.fillRect(0, 0, RunnGame.width, RunnGame.height);
	
		if(enemiesFrozen) {
			
			
			int redVal=(int) ((250)-(freezeGraphicHeight/2.5));

Color timerColor=new Color(redVal,(int) (freezeGraphicHeight/2.5),0);
		g.setColor(timerColor);
		g.fillRect(1850, freezeGraphicY, 160, (int) freezeGraphicHeight);
		freezeGraphicHeight-=2.5;
		freezeGraphicY++;
		if(freezeGraphicHeight<=0) {
			enemiesFrozen=false;
			freezeGraphicY = 230;
			freezeGraphicHeight=600;
		}
		
		}
		
		
		
		for(int i=1;(i-1)<play.powerUpCount;i++) {
			int ycoord=(i)*25;
			g.setColor(Color.BLUE);
			g.fillOval(13,ycoord+60,10,10);
		}

		if (life < 100) {
			g.setColor(Color.RED);
		} else if (life < 200) {
			g.setColor(Color.ORANGE);
		} else if (life < 300) {
			g.setColor(Color.YELLOW);
		} else if(life<475){
			g.setColor(Color.GREEN);
		}
		else {
			g.setColor(silver);
		}
		g.fillRect(660, 930, life, 30);
		g.setColor(Color.BLACK);
		g.drawRect(660, 930, 500, 30);

		if (seconds % 30 == 0 && updatedPhaseCount == false) {
			phaseCount++;
			updatedPhaseCount = true;
		}

		if ((seconds - 1) % 30 == 0) {
			updatedPhaseCount = false;
		}

		g.setColor(Color.BLUE);
		g.fillRect(860, 450, 100, 100);
		play.draw(g);
		power.draw(g);
		for (int i = zergs.size() - 1; i >= 0; i--) {
			zergs.get(i).draw(g);
		}
		//g.fillOval(play.x, play.y, 2, 2);
		//g.fillOval(play.x, play.y, 100, 100);
		
		if (play.x>=(860-play.width)&&play.x<=(960)&&play.y>=(450-play.width)&&play.y<=(550)) {
			if(life>300&&life<475) {
				play.score+=30;
			}
			life = 500;
		} else {
			life--;
			if (life <= 0) {
				play.isAlive=false;
			}
		}

		g.setColor(Color.BLACK);

		
		g.setFont(new Font("Arial",Font.PLAIN,40));
		g.drawString("powerups:" +play.powerUpCount+ "  phase:" +phaseCount + "  seconds:" + seconds, 10, 40);
g.drawString("score: "+overallScore, 800, 40);
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
		if(seconds!=0&&seconds%15==0&&enemiesFrozen==false) {
			startTime=System.currentTimeMillis();
		int powerX=ranX.nextInt(1911);
		int powerY=ranY.nextInt(901);
		
		power.x=powerX;
		power.y=powerY;
		power.available=true;
		}
		
		if (System.currentTimeMillis() > startTime + duration) {
					power.available=false;
		}
		
		
	}
	
	void activatePower() {
		if(play.powerUpCount>0&&enemiesFrozen==false&&seconds>=1) {
			
			for (int i = zergs.size() - 1; i >= 0; i--) {
				zergs.get(i).frozen=true;
			}
			enemiesFrozen=true;
			play.powerUpCount--;
			
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(enemiesFrozen==false) {
		seconds++;
		
		int scorePerSecond=phaseCount*5;
		secondsScore+=scorePerSecond;
		
		}
		
		
		
		powerUpCall();
		
		for(int i=0;i<phaseCount;i++) {
			if(enemiesFrozen==false) {
		timeDoStuff();
			}
		}

	}

}

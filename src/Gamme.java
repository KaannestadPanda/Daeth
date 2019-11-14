import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Gamme extends JPanel implements ActionListener, KeyListener,MouseMotionListener,  MouseListener{

	static Player player=new Player(500,500,20,20);
	
	public static BufferedImage diabloImg;
	
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Buttonn clicky=new Buttonn(860,450,100,100);
	static ObbjectManager manager=new ObbjectManager(player);
	Font titleFont=new Font("Arial",Font.PLAIN,20);
	static boolean alreadyRan=true;
	
	int clickedX;
	int clickedY;
	
	Timer timer;
	static Timer enemyTimer;
	
	Gamme(){
		timer = new Timer(1000/60,this);
		
	   try {
		diabloImg=ImageIO.read(this.getClass().getResourceAsStream("DIABLO.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	   
	}
	
	void startGame() {
		
		manager.addEnemy(new Enemy(20,20,10,10,1));
		manager.addEnemy(new Enemy(400,200,10,10,2));
		manager.addEnemy(new Enemy(800,400,10,10,3));
		
		
		
		

		
		 
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
		
		
		if(currentState==MENU_STATE) {
			updateMenuState();
		}
		else if(currentState==GAME_STATE) {
			updateGameState();
		}
		else if(currentState==END_STATE) {
			updateEndState();
		}
		
		
	}
	
void updateEndState() {

	}
void updateMenuState() {
	
}
	void updateGameState() {
		
		manager.update();
		if(player.isAlive==false) {
			currentState=END_STATE;
		}
		
		pause(4000);
		
	}
	
	
	void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("YOU HAVE LOST, PRESS THE BUTTON TO TRY AGAIN", 100, 100);
		g.drawString("YOUR SCORE: "+manager.overallScore, 100, 140);
		clicky.draw(g);
	}
	
void drawGameState(Graphics g) {
	
		manager.draw(g);
		
	}

void drawMenuState(Graphics g) {
	g.setColor(Color.BLACK);
	g.setFont(titleFont);
	
	g.drawString("How to play: Your character will follow your mouse.  Use your mouse to dodge the red dots, which will follow you.", 400, 100);
	g.drawString("Every six seconds, an orange warning dot will appear, and a second later an enemy will spawn there.", 460, 150);
	g.drawString("Every fifteen seconds, a blue dot will appear.  Touch this to collect a power up.  Your number of power ups is indicated in the top left.",330,200);
	g.drawString("Click the mouse to use one power up and freeze all enemies for four seconds.  Frozen enemies will still kill you if you touch them.", 355, 250);
	g.drawString("You lose if a red dot touches you or if the timer on the bottom of the screen runs out.", 520, 300);
	g.drawString("Reset the timer by touching the blue square in the middle of the screen.", 600, 350);
	g.drawString("Press the pink button to begin.  You will have four seconds before the game begins.", 550, 400);
	g.drawString("GET READY TO RUN", 810, 700);
	g.drawString("You get score per second, per power up collected, and for resetting your timer while the timer is in the green.", 420,600);
	clicky.draw(g);
	
	
}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
			 
			 		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
			 
			 
		 
		 
		
		 
		
		
	}
	
	public void paintComponent(Graphics g){
		if(currentState==MENU_STATE) {
			drawMenuState(g);
		}
		else if(currentState==GAME_STATE) {
			drawGameState(g);
		}
		else if(currentState==END_STATE) {
			drawEndState(g);
		}
		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getX());
		//System.out.println(e.getY());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		clickedX=e.getX();
		clickedY=e.getY()-24;
		if(currentState==GAME_STATE) {
			manager.activatePower();
		}
		
		if(currentState==MENU_STATE&&clicky.checkClicked(clickedX, clickedY)) {
			manager.seconds=0;
			currentState=GAME_STATE;
			clicky.clicked=false;
		}
		
		if(currentState==END_STATE&&clicky.checkClicked(clickedX, clickedY)) {
			player=new Player(500,500,20,20);
			 manager=new ObbjectManager(player);
			 currentState=0;
			
			 startGame();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		player.x=e.getX()-6;
		player.y=e.getY()-30;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		player.x=e.getX()-6;
		player.y=e.getY()-30;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		player.x=e.getX()-6;
		player.y=e.getY()-30;
	}
	
	public static void pause(int milli) {
		if(alreadyRan==false) {
			try {
				Thread.sleep(milli);
				enemyTimer = new Timer(1000 , manager);
				enemyTimer.start();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			alreadyRan=true;
			
			}
	}

	
	
}

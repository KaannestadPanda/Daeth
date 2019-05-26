import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Gamme extends JPanel implements ActionListener, KeyListener,MouseMotionListener,  MouseListener{

	Player player=new Player(500,500,10,10);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = GAME_STATE;
	ObbjectManager manager=new ObbjectManager(player);
	
	
	Timer timer;
	
	Gamme(){
		timer = new Timer(1000/60,this);
		
		
	}
	
	void startGame() {
		manager.addEnemy(new Enemy(20,20,10,10));
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
	}
	
	
	void drawEndState(Graphics g) {
		
	}
	
void drawGameState(Graphics g) {
		manager.draw(g);
	}

void drawMenuState(Graphics g) {
	
}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
			 if(e.getKeyCode()==KeyEvent.VK_D) {
				player.rightPressed=true;
			}
			 		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		 if(e.getKeyCode()==KeyEvent.VK_D) {
			player.rightPressed=false;
		}
		
		
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
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	
	
}

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Gamme extends JPanel implements ActionListener, KeyListener{

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
		
		SwingUtilities.invokeLater(new Thread(()-> {
			if(e.getKeyCode()==KeyEvent.VK_A) {
				player.leftPressed=true;
			}
			 if(e.getKeyCode()==KeyEvent.VK_D) {
				player.rightPressed=true;
			}
			 if(e.getKeyCode()==KeyEvent.VK_W) {
					player.upPressed=true;
				}
			if(e.getKeyCode()==KeyEvent.VK_S) {
					player.downPressed=true;
				}
		}));
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		SwingUtilities.invokeLater(new Thread(()-> {
		if(e.getKeyCode()==KeyEvent.VK_A) {
			player.leftPressed=false;
		}
		 if(e.getKeyCode()==KeyEvent.VK_D) {
			player.rightPressed=false;
		}
		 if(e.getKeyCode()==KeyEvent.VK_W) {
				player.upPressed=false;
			}
			 if(e.getKeyCode()==KeyEvent.VK_S) {
				player.downPressed=false;
			}
		}));
		
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

	
	
}

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RunnGame {

	Gamme gamme;
	JFrame frame;
	final static int width=1920;
	final static int height=1000;

	
	public static void main(String[] args) {
		RunnGame k=new RunnGame();
		k.setup();
		
		
		
	}
	
	
	
	

		
		
		
		
		
		RunnGame(){
			frame=new JFrame();
			
			gamme= new Gamme();
		}
		
		void setup() {
			

			frame.add(gamme);
			frame.addKeyListener(gamme);
			frame.addMouseListener(gamme);
			frame.addMouseMotionListener(gamme);
			frame.getContentPane().setPreferredSize(new Dimension(width, height));
			
			frame.pack();
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			frame.setVisible(true);
			gamme.startGame();
		}
		

}

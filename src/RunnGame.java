import java.awt.Dimension;

import javax.swing.JFrame;

public class RunnGame {

	Gamme gamme;
	JFrame frame;
	final static int width=1500;
	final static int height=950;
	
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
			frame.getContentPane().setPreferredSize(new Dimension(width, height));
			frame.pack();
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			frame.setVisible(true);
			gamme.startGame();
		}
		

}

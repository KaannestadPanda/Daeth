import java.applet.AudioClip;

import javax.swing.JApplet;

public class Song {

	AudioClip a;
	
	Song(String fileName){
		loadSound(fileName);
	}
	
	public AudioClip loadSound(String fileName) {
		a=JApplet.newAudioClip(getClass().getResource(fileName));
		
		return a;
	}
	
	public void play() {
		a.loop();
	}
	
	public void stop() {
		a.stop();
	}
	
	
	
	
}

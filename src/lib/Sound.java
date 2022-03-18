package lib;

import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	Clip clip;
	List<URL> soundURL=new ArrayList<>();
	
	
	public Sound(List<String> sounds) {
		for(String I:sounds) {
			soundURL.add(getClass().getResource(I));
		}
	}
	
	
	public void setFile(int i) {
		 try {
			 AudioInputStream ais=AudioSystem.getAudioInputStream(soundURL.get(i));
			 clip=AudioSystem.getClip();
			 clip.open(ais);
		 }catch(Exception ex) {}
		
	}
	
	public void play() {
		clip.start();
	}
	
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		clip.stop();
	}
}

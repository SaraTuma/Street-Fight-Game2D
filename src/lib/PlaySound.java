package lib;

public class PlaySound {
	
	Sound sound;
	public PlaySound(Sound sound, int i) {
		this.sound=sound;
		this.sound.setFile(i);
	}

	public static void playMusic(Sound sound, int i) {
		sound.setFile(i);
		sound.play();
		sound.loop();
		
	}
	
	public static void playEffect(Sound sound, int i) {
		sound.setFile(i);
		sound.play();
	}
	
	public static void stopEffect(Sound sound, int i) {
		sound.setFile(i);
		sound.stop();
	}
	
	public void playMusic() {
		sound.play();
		sound.loop();
		
	}
	
	public void playEffect() {
		sound.play();
	}
	
	public  void stopEffect() {
		sound.stop();
	}
	
}

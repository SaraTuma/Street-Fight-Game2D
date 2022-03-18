package lib;

import java.awt.event.KeyEvent;


import java.awt.event.KeyListener;

public abstract class KeyManager{
	
	private Game game;
	private static KeyManager keymanager=null;
	public KeyManager(Game game) {
		this.game=game;
	}
	
	public abstract void keyPressed(KeyEvent arg0);

	
	public abstract void keyReleased(KeyEvent arg0) ;


	public abstract void keyTyped(KeyEvent arg0);

	public static KeyManager getKeymanager() {
		return keymanager;
	}

	public static void setKeymanager(KeyManager keymanager) {
		KeyManager.keymanager = keymanager;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	
	

}

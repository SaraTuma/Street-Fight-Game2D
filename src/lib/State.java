package lib;

import java.awt.Graphics;

public abstract class State {

	
	private static State state=null;
	private Game game;
	
	public State(Game game) {
		this.game=game;
	}
	public abstract void actualizar();
	
	public abstract void desenhar(Graphics g);
	
	public abstract void init();
	
	public static State getState() {
		return state;
	}
	public static void setState(State state) {
		State.state = state;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	
	
	
}

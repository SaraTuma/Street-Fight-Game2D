package lib;

import java.awt.Graphics;

public interface ElementoBehavior {

	public void init(State state);
	public void actualizar(State state);
	public void desenhar(Graphics g);
}

package lib;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangulo extends Elemento implements ElementoBehavior{

	private Color color;
	public Rectangulo(int px, int py, int largura, int altura, Color cor) {
		super(px,py,largura,altura);
		this.color=cor;
	}
	
	public Rectangulo(int px, int py, int largura, int altura) {
		super(px,py,largura,altura);
		this.color=Color.BLACK;
	}
	
	@Override
	public void desenhar(Graphics g) {
		g.setColor(this.color);
		g.fillRect(getPx(),getPy(),getLargura(), getAltura());
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void init(State state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(State state) {
		// TODO Auto-generated method stub
		
	}
	
	
}

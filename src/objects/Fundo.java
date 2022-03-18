/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;
import java.awt.Color;
import java.awt.Graphics;
import apgc.gamedev2d.Elemento;
import apgc.gamedev2d.ElementoBehavior;
import apgc.gamedev2d.State;
import game.GameState;
/**
 *
 * @author Denizia Fernanda
 */
public class Fundo extends Elemento implements ElementoBehavior{
    public Fundo() {
		setPx(0);
		setPy(0);
	}
	public Fundo(int largura, int altura) {
		setLargura(largura);
		setAltura(altura);
		setPx(0);
		setPy(0);
	}

	@Override
	public void actualizar(State arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desenhar(Graphics g) {
		g.setColor(new Color(20, 196, 235));
		g.fillRect(0,0,800, 600);
	}

	@Override
	public void init(State arg0) {
		GameState game=(GameState)arg0;
		game.getPalco().setAltura (game.getGame().getDisplay().getCanvas().getHeight());
		game.getPalco().setLargura(game.getGame().getDisplay().getCanvas().getWidth());
		
	}

}

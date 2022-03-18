/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import apgc.gamedev2d.Elemento;
import apgc.gamedev2d.ElementoBehavior;
import apgc.gamedev2d.State;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import game.GameState;
/**
 *
 * @author Denizia Fernanda
 */
public class Scores extends Elemento implements ElementoBehavior{
   private GameState gamestate;
   
   public Scores(GameState gamestate){
       this.gamestate=gamestate;
   }
   

    @Override
    public void init(State state) {
    }

    @Override
    public void actualizar(State state) {
    }
    @Override
    public void desenhar(Graphics g) { 
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Jogador 1 :"+gamestate.getGame().getScorePlayer1(),10,50);
                
                g.setColor(Color.BLACK);
                g.drawString("Jogador 2 :"+gamestate.getGame().getScorePlayer2(),10,100);
                
                g.setColor(Color.GREEN);
                g.drawString("Round: "+gamestate.getGame().getRound(),gamestate.getGame().getDisplay().getWidth()-250,50);
                
                
                g.drawString("Tempo do jogo: "+gamestate.getGame().getRoundTime(),gamestate.getGame().getDisplay().getWidth()-250,100);
    }
    public GameState getGamestate() {
        return gamestate;
    }

    public void setGamestate(GameState gamestate) {
        this.gamestate = gamestate;
    }
    
    
}

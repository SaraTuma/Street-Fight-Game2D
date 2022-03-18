/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author admin
 */
public class GameOver extends Elemento implements ElementoBehavior{
    
    private GameState gamestate;
    public GameOver(GameState gamestate) {
        this.gamestate=gamestate;
    }
    
    
    

    @Override
    public void init(State arg0) {
        GameState game=(GameState)arg0;
        int w=game.getGame().getDisplay().getWidth();
        int h=game.getGame().getDisplay().getHeight();
        setLargura(w-2*w/6);
        setAltura(h-h/3);
        setPx(w/6);
        setPy(30); 
    }

    @Override
    public void actualizar(State state) {
    }
    
    @Override
    public void desenhar(Graphics g) {
        String winner = null;
        if(gamestate.getGame().getScorePlayer1() > gamestate.getGame().getScorePlayer2()){
            winner = " é o : Jogador 1";
            gamestate.getGame().getListWinner()[0]=gamestate.getGame().getScorePlayer1();
            gamestate.getGame().setWinnerRound1(1);
        }
        else if(gamestate.getGame().getScorePlayer1() < gamestate.getGame().getScorePlayer2()){
            winner = " é o : Jogador 2";
            gamestate.getGame().getListWinner()[0]=gamestate.getGame().getScorePlayer2();
            gamestate.getGame().setWinnerRound1(2);
        }
        else{
            winner = " não existe, foi empate!!";
            gamestate.getGame().getListWinner()[0]=gamestate.getGame().getScorePlayer2();
            gamestate.getGame().setWinnerRound1(0);
        }
        
        g.setColor(new Color(20, 196, 235));
        g.fillRect(0,0, 800, 600);
        g.setColor(Color.WHITE);
        g.setFont(new Font("ROBOTO", Font.BOLD, 30));
        g.drawString("Tempo acabou : "+gamestate.getGame().getRoundTime(),gamestate.getGameOver().getPx()+10,
                gamestate.getGameOver().getPy()+80);
        g.setFont(new Font("ROBOTO", Font.BOLD, 20));
        g.drawString("Jogador 1 : "+gamestate.getGame().getScorePlayer1(),gamestate.getGameOver().getPx()+10,
                gamestate.getGameOver().getPy()+2*80);
        g.drawString("Jogador 2 : "+gamestate.getGame().getScorePlayer2(),gamestate.getGameOver().getPx()+10,
                gamestate.getGameOver().getPy()+3*80);
        
        g.drawString("Vencedor do Round "+gamestate.getGame().getRound() + winner,gamestate.getGameOver().getPx()+10,
                gamestate.getGameOver().getPy()+4*80);

        g.setColor(Color.green);
        g.drawString("Clica R para jogar novo Round",
                gamestate.getGameOver().getPx()+10,
                gamestate.getGameOver().getPy()+5*80);            
                
    }
    public void desenhar1(Graphics g) {
        String winner = null;
        if(gamestate.getGame().getScorePlayer1() > gamestate.getGame().getScorePlayer2()){
            gamestate.getGame().getListWinner()[1]=gamestate.getGame().getScorePlayer1();
            gamestate.getGame().setWinnerRound2(1);
        }
        else if(gamestate.getGame().getScorePlayer1() < gamestate.getGame().getScorePlayer2()){
            gamestate.getGame().getListWinner()[1]=gamestate.getGame().getScorePlayer2();
            gamestate.getGame().setWinnerRound2(2);
        }
        else{
            
            gamestate.getGame().getListWinner()[1]=gamestate.getGame().getScorePlayer2();
            gamestate.getGame().setWinnerRound2(0);
        }
        if(gamestate.getGame().getWinnerRound1()==0 && gamestate.getGame().getWinnerRound2()==0){
            winner = " não existe, foi empate!!";
        }
        else{
            if(gamestate.getGame().getListWinner()[1]>gamestate.getGame().getListWinner()[0])
                winner = " é o : Jogador 2";
            else
                winner = " é o : Jogador 1";
        }
        
        g.setColor(new Color(20, 196, 235));
        g.fillRect(0,0, 800, 600);
        g.setColor(Color.RED);
        g.setFont(new Font("ROBOTO", Font.BOLD, 30));
        g.drawString("Fim do jogo",gamestate.getGameOver().getPx()+10,
                gamestate.getGameOver().getPy()+80);
        g.setColor(Color.white);
        g.setFont(new Font("ROBOTO", Font.BOLD, 20));
        g.drawString("Jogador 1 : "+gamestate.getGame().getScorePlayer1(),gamestate.getGameOver().getPx()+10,
                gamestate.getGameOver().getPy()+2*80);
        g.drawString("Jogador 2 : "+gamestate.getGame().getScorePlayer2(),gamestate.getGameOver().getPx()+10,
                gamestate.getGameOver().getPy()+3*80);
        
        g.drawString("Vencedor do jogo "+ winner,gamestate.getGameOver().getPx()+10,
                gamestate.getGameOver().getPy()+4*80);

        g.setColor(Color.BLACK);
        g.drawString("Clica N para começar novo JOGO",
                gamestate.getGameOver().getPx()+10,
                gamestate.getGameOver().getPy()+5*80);            
        
    }
    
}

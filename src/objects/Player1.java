/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import java.awt.Color;

import java.awt.Graphics;

import apgc.gamedev2d.Direction;
import apgc.gamedev2d.Elemento;
import apgc.gamedev2d.ElementoBehavior;
import apgc.gamedev2d.State;
import game.GameState;
import game.MyGame;

/**
 *
 * @author Denizia Fernanda
 */
public class Player1 extends Elemento implements ElementoBehavior{
        MyGame game;
	GameState state;
	public Player1(MyGame game, GameState state) {
		setLargura(30);
		setAltura(90);
		this.game=game;
		this.state=state;
	}
	

	@Override
	public void actualizar(State arg0) {
		GameState gameState=(GameState)arg0;
                if(gameState.getGame().isInitPlayer2()){
                    init(arg0);
                    gameState.getGame().setInitPlayer2(false);
                }
		int w=gameState.getGame().getDisplay().getCanvas().getWidth();
                int h=gameState.getGame().getDisplay().getCanvas().getHeight();
		if(gameState.getGame().isRunning()) {
			if(gameState.getGame().isRight()) {
				if(gameState.getPlayer1().getPx()+gameState.getPlayer1().getLargura()<w/2) {
					Direction.moveToRight(gameState.getPlayer1(),5);
				}
				
			}
			if(gameState.getGame().isLeft()) {
				Direction.moveToLeft(gameState.getPlayer1(),5);
				Direction.stopMoveToLeft(gameState.getPlayer1(), w/6);
			}
			
		}
                
                //COLISÕES
                
                Player1 player1 =gameState.getPlayer1();
                Player2 player2  = gameState.getPlayer2();
                
                int distancia= player2.getPx()-(player1.getPx()+player1.getLargura());
                
                //System.out.println("Distancia....:"+distancia);
                if(gameState.getGame().getDesenhoPlayer1()==2){
                    if(distancia<54){
                        gameState.getGame().setScorePlayer1(gameState.getGame().getScorePlayer1()+2);
                    }
                }
                
                if(gameState.getGame().getDesenhoPlayer1()==3){
                    if(distancia<=59){
                        gameState.getGame().setScorePlayer1(gameState.getGame().getScorePlayer1()+4);
                    }
                }
                
                if(gameState.getGame().getDesenhoPlayer1()==4){
                    if(distancia<=79){
                        gameState.getGame().setScorePlayer1(gameState.getGame().getScorePlayer1()+6);
                    }
                }
                
                
                if(gameState.getGame().getRoundTime()==gameState.getGame().getEndRoundTime()){
                        gameState.getGame().setGameover(true);
                 }
		
	}

	@Override
	public void desenhar(Graphics g) {
		if(this.game.getDesenhoPlayer1()==1) {
			//g.setColor(Color.BLACK);
			//g.fillRect(getPx(),getPy(), getLargura(), getAltura());
			g.setColor(Color.WHITE);
			g.fillOval(getPx()+10, getPy()+30, 40, 40);//cabeca
			g.fillRect(getPx()+10+15, getPy()+30+40, 10, 10);//pesco�o
			g.fillRect(getPx()+10, getPy()+30+40+10, 40, 60);//corpo
			g.fillRect(getPx()+10, getPy()+30+40+10+60, 10, 50);//perna1
			g.fillRect(getPx()+10+40-10, getPy()+30+40+10+60, 10, 50);//perna2
			g.setColor(Color.GREEN);
			g.fillRect(getPx()+10-10, getPy()+30+40+10, 10, 55);//bra�o 1
			g.fillRect(getPx()+10+40, getPy()+30+40+10, 10, 55);//bra�o 2
		}
                // Levanta mao esquerda
                if(this.game.getDesenhoPlayer1()==2) {
                        //g.setColor(Color.BLACK);
			//g.fillRect(getPx(),getPy(), getLargura(), getAltura());
			g.setColor(Color.WHITE);
			g.fillOval(getPx()+10, getPy()+30, 40, 40);//cabeca
			g.fillRect(getPx()+10+15, getPy()+30+40, 10, 10);//pesco�o
			g.fillRect(getPx()+10, getPy()+30+40+10, 40, 60);//corpo
			g.fillRect(getPx()+10, getPy()+30+40+10+60, 10, 50);//perna1
			g.fillRect(getPx()+10+40-10, getPy()+30+40+10+60, 10, 50);//perna2
			g.setColor(Color.GREEN);
			g.fillRect(getPx(), getPy()+30+40+10, 10, 10);//bra�o 1
			g.fillRect(getPx()-10, getPy()+30+40+10, 10, 50);//bra�o 1
			g.fillRect(getPx()+10+40, getPy()+30+40+10, 60,10);//bra�o 2
                }
                
                if(this.game.getDesenhoPlayer1()==3) {
                   // g.setColor(Color.BLACK);
				//g.fillRect(getPx(),getPy(), getLargura(), getAltura());
				g.setColor(Color.WHITE);
				g.fillOval(getPx()+10, getPy()+30, 40, 40);//cabeca
				g.fillRect(getPx()+10+15, getPy()+30+40, 10, 10);//pesco�o
				g.fillRect(getPx()+10, getPy()+30+40+10, 40, 60);//corpo
				g.fillRect(getPx()+10, getPy()+30+40+10+60, 10, 50);//perna1
				g.fillRect(getPx()+10+40-10, getPy()+30+40+10+60, 10, 50);//perna2
				g.setColor(Color.GREEN);
				g.fillRect(getPx()+10+15, getPy()+30+40+10+15, 100, 10);//bra�o 1
				g.fillRect(getPx()+10+40, getPy()+30+40+10, 10,10);//bra�o 2
                }
                
                if(this.game.getDesenhoPlayer1()==4) {
                   // g.setColor(Color.BLACK);
			//g.fillRect(getPx(),getPy(), getLargura(), getAltura());
			g.setColor(Color.WHITE);
			g.fillOval(getPx()+10, getPy()+30, 40, 40);//cabeca
			g.fillRect(getPx()+10+15, getPy()+30+40, 10, 10);//pesco�o
			g.fillRect(getPx()+10, getPy()+30+40+10, 40, 60);//corpo
			g.fillRect(getPx()+10, getPy()+30+40+10+60, 10, 50);//perna1
			g.fillRect(getPx()+10+40-10, getPy()+30+40+10+60-10, 100, 10);//perna2
			g.setColor(Color.GREEN);
			g.fillRect(getPx()+10-10, getPy()+30+40+10, 10, 50);//bra�o 1
			g.fillRect(getPx()+10+40, getPy()+30+40+10, 10, 50);//bra�o 2
                }
		
	}

	@Override
	public void init(State arg0) {
		GameState game=(GameState)arg0;
		game.getPlayer1().setPx(100);
		game.getPlayer1().setPy(250);
		game.getPalco().setLargura(game.getGame().getDisplay().getCanvas().getWidth());
		
	}

    
}

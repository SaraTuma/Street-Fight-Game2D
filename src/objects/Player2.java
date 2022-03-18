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
import apgc.gamedev2d.Matematica;
import apgc.gamedev2d.PlaySound;
import apgc.gamedev2d.State;
import game.GameState;
import game.MyGame;
/**
 *
 * @author Denizia Fernanda
 */
public class Player2 extends Elemento implements ElementoBehavior{
        MyGame game;
	GameState state;
        private boolean isAtCenter=false;


        public Player2(MyGame game, GameState state) {
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
		Player2 player2=gameState.getPlayer2();
                
                
                if(player2.isIsAtCenter()==false){
                    gameState.getGame().setDesenhoPlayer2(1);
                
                    if(player2.getPx()>(w/2)){
                        Direction.moveToLeft(player2, 5);
                    }
                    else{
                        player2.setIsAtCenter(true);
                    }
                }
                
               
                if(player2.isIsAtCenter()){
                    int movimento=Matematica.numeroAleatorio(1, 100);
                    if(movimento==1){
                        gameState.getGame().setDesenhoPlayer2(1);
                        Direction.moveToLeft(player2, 5);
                        gameState.getGame().setDesenhoPlayer2(Matematica.numeroAleatorio(2, 5));
                        PlaySound.playEffect(getGame().getSound(), 1);
                    }
                    if(movimento==2){
                        gameState.getGame().setDesenhoPlayer2(1);
                        Direction.moveToRight(player2, 5);
                        gameState.getGame().setDesenhoPlayer2(1);
                        Direction.moveToRight(player2, 5);
                        gameState.getGame().setDesenhoPlayer2(Matematica.numeroAleatorio(2, 5));
                        PlaySound.playEffect(getGame().getSound(), 1);
                    }
                    if(movimento==3){
                        gameState.getGame().setDesenhoPlayer2(1);
                        Direction.moveToLeft(player2, 5);
                        gameState.getGame().setDesenhoPlayer2(Matematica.numeroAleatorio(2, 5));
                        PlaySound.playEffect(getGame().getSound(), 1);
                    }
                    
                    if(player2.getPx()>w/2){
                        player2.setPx(w-w/6-player2.getLargura());
                        player2.setIsAtCenter(false);
                    }
                    
                    
                    
                    //COLISOES OU CONTACTO
                    
                    Player1 player1=gameState.getPlayer1();

                    int distancia=player2.getPx()-(player1.getPx()+player1.getLargura());

                    //System.out.println("Distancia....:"+distancia);
                    if(gameState.getGame().getDesenhoPlayer2()==2){
                        if(distancia<54){ 
                            gameState.getGame().setScorePlayer2(gameState.getGame().getScorePlayer2()+2);
                        }
                    }

                    if(gameState.getGame().getDesenhoPlayer2()==3){
                        if(distancia<=59){
                            gameState.getGame().setScorePlayer2(gameState.getGame().getScorePlayer2()+4);
                        }
                    }

                    if(gameState.getGame().getDesenhoPlayer2()==79){
                        if(distancia<=79){
                            gameState.getGame().setScorePlayer2(gameState.getGame().getScorePlayer2()+6);
                        }
                    } 
                    //System.out.println(enemy.getPontos()+"  ---- enemy");
                    if(gameState.getGame().getRoundTime()==gameState.getGame().getEndRoundTime()){
                        gameState.getGame().setGameover(true);
                    }
                }
                
		
	}

	@Override
  public void desenhar(Graphics g) {
        if(this.game.getDesenhoPlayer2()==1) {
            //g.setColor(Color.BLACK);
            //g.fillRect(getPx(),getPy(), getLargura(), getAltura());
            g.setColor(Color.BLACK);
            g.fillOval(getPx()+10, getPy()+30, 40, 40);//cabeca
            g.fillRect(getPx()+10+15, getPy()+30+40, 10, 10);//pesco�o
            g.fillRect(getPx()+10, getPy()+30+40+10, 40, 60);//corpo
            g.fillRect(getPx()+10, getPy()+30+40+10+60, 10, 50);//perna1
            g.fillRect(getPx()+10+40-10, getPy()+30+40+10+60, 10, 50);//perna2
            g.setColor(Color.WHITE);
            g.fillRect(getPx()+10-10, getPy()+30+40+10, 10, 55);//bra�o 1
            g.fillRect(getPx()+10+40, getPy()+30+40+10, 10, 55);//bra�o 2
        }

        if(this.game.getDesenhoPlayer2()==2) {
            //g.setColor(Color.BLACK);
            //g.fillRect(getPx(),getPy(), getLargura(), getAltura());
            g.setColor(Color.BLACK);
            g.fillOval(getPx()+10, getPy()+30, 40, 40);//cabeca
            g.fillRect(getPx()+10+15, getPy()+30+40, 10, 10);//pesco�o
            g.fillRect(getPx()+10, getPy()+30+40+10, 40, 60);//corpo
            g.fillRect(getPx()+10, getPy()+30+40+10+60, 10, 50);//perna1
            g.fillRect(getPx()+10+40-10, getPy()+30+40+10+60, 10, 50);//perna2
            g.setColor(Color.WHITE);
            g.fillRect(getPx()+10+40, getPy()+30+40+10, 10, 10);//bra�o 1
            g.fillRect(getPx()+10+40+10, getPy()+30+40+10, 10, 50);//bra�o 1
            g.fillRect(getPx()-60+10, getPy()+30+40+10, 60,10);//bra�o 2
        }

        if(this.game.getDesenhoPlayer2()==3) {
            //g.setColor(Color.BLACK);
            //g.fillRect(getPx(),getPy(), getLargura(), getAltura());
            g.setColor(Color.BLACK);
            g.fillOval(getPx()+10, getPy()+30, 40, 40);//cabeca
            g.fillRect(getPx()+10+15, getPy()+30+40, 10, 10);//pesco�o
            g.fillRect(getPx()+10, getPy()+30+40+10, 40, 60);//corpo
            g.fillRect(getPx()+10, getPy()+30+40+10+60, 10, 50);//perna1
            g.fillRect(getPx()+10+40-10, getPy()+30+40+10+60, 10, 50);//perna2
            g.setColor(Color.WHITE);
            g.fillRect(getPx()+10-60-15, getPy()+30+40+10+15, 100, 10);//bra�o 1
            g.fillRect(getPx()+10-10, getPy()+30+40+10, 10,10);//bra�o 2
        }

        if(this.game.getDesenhoPlayer2()==4) {
            //g.setColor(Color.BLACK);
            //g.fillRect(getPx(),getPy(), getLargura(), getAltura());
            g.setColor(Color.BLACK);
            g.fillOval(getPx()+10, getPy()+30, 40, 40);//cabeca
            g.fillRect(getPx()+10+15, getPy()+30+40, 10, 10);//pesco�o
            g.fillRect(getPx()+10, getPy()+30+40+10, 40, 60);//corpo
            g.fillRect(getPx()+10+40-10, getPy()+30+40+10+60, 10, 50);//perna1
            g.fillRect(getPx()+10-100, getPy()+30+40+10+60-10, 100, 10);//perna2
            g.setColor(Color.WHITE);
            g.fillRect(getPx()+10-10, getPy()+30+40+10, 10, 50);//bra�o 1
            g.fillRect(getPx()+10+40, getPy()+30+40+10, 10, 50);//bra�o 2
        }
		
    }

	@Override 
	public void init(State arg0) {
                
		GameState game=(GameState)arg0;
                int w=game.getGame().getDisplay().getCanvas().getWidth();
		game.getPlayer2().setPx(700);
		game.getPlayer2().setPy(250);
		game.getPalco().setLargura(game.getGame().getDisplay().getCanvas().getWidth());
		
	}

    

    public boolean isIsAtCenter() {
        return isAtCenter;
    }

    public void setIsAtCenter(boolean isAtCenter) {
        this.isAtCenter = isAtCenter;
    }

    public MyGame getGame() {
        return game;
    }

    public void setJogo(MyGame game) {
        this.game = game;
    }

}

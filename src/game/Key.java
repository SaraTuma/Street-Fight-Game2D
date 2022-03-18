package game;

import java.awt.event.KeyEvent;

import apgc.gamedev2d.Game;
import apgc.gamedev2d.KeyManager;
import apgc.gamedev2d.PlaySound;

public class Key extends KeyManager{

	private MyGame game;
	public Key(MyGame game) {
		super(game);
		this.game=game;
	}

    @Override
    public void keyPressed(KeyEvent arg0) {
            
        if(arg0.getKeyCode()==KeyEvent.VK_N) {

            if(getGame().getRound() == 2 && getGame().isEndRound()){
                getGame().setGameover(false);
                getGame().setScorePlayer2(0);
                getGame().setScorePlayer1(0);
                getGame().setInitPlayer2(true);
                getGame().setInitPlayer1(true);
                getGame().setRound(1);
                getGame().setRoundTime(0);
                int[] novo = {0,0};
                getGame().setListWinner(novo);
                getGame().setEndRound(false);
            }

        }

        if(arg0.getKeyCode()==KeyEvent.VK_R) {
            if(getGame().getRound()<2  && getGame().isEndRound()){
                getGame().setGameover(false);
                getGame().setScorePlayer2(0);
                getGame().setScorePlayer1(0);
                getGame().setInitPlayer2(true);
                getGame().setInitPlayer1(true);
                getGame().setRoundTime(0);
                getGame().setRound(getGame().getRound() + 1);
                getGame().setEndRound(false);
            }
           
        }
                
        if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE) {
                System.exit(0);
        }

        if(arg0.getKeyCode()==KeyEvent.VK_D) {
                getGame().setRight(true);
        }

        if(arg0.getKeyCode()==KeyEvent.VK_A) {
                getGame().setLeft(true);
        }

        if(arg0.getKeyCode()==KeyEvent.VK_J) {
                getGame().setDesenhoPlayer1(2);
                PlaySound.playEffect(getGame().getSound(), 1);
        }

        if(arg0.getKeyCode()==KeyEvent.VK_K) {
                getGame().setDesenhoPlayer1(3);
                PlaySound.playEffect(getGame().getSound(), 1);
        }

        if(arg0.getKeyCode()==KeyEvent.VK_L) {
                getGame().setDesenhoPlayer1(4);
                PlaySound.playEffect(getGame().getSound(), 1);
        }
		
    }

    @Override
    public void keyReleased(KeyEvent arg0) {

        if(arg0.getKeyCode()==KeyEvent.VK_D) {
                getGame().setRight(false);
        }

        if(arg0.getKeyCode()==KeyEvent.VK_A) {
                getGame().setLeft(false);
        }

        if(arg0.getKeyCode()==KeyEvent.VK_J) {
            getGame().setDesenhoPlayer1(1);
        }

        if(arg0.getKeyCode()==KeyEvent.VK_K) {
            getGame().setDesenhoPlayer1(1);

        }

        if(arg0.getKeyCode()==KeyEvent.VK_L) {
            getGame().setDesenhoPlayer1(1);
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }

    public MyGame getGame() {
        return game;
    }

    public void setGame(MyGame game) {
        this.game = game;
    }

}

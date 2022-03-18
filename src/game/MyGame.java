/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;
import apgc.gamedev2d.Game;
import apgc.gamedev2d.Sound;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Denizia Fernanda
 */
public class MyGame extends Game{
        private boolean up = false;
	private boolean down = false;
	private boolean right = false;
	private boolean left = false;
	private boolean enter=false;
	private boolean running=false;
	private int desenhoPlayer1=1;
        private int desenhoPlayer2=1;
        private boolean stop=false;
        private boolean gameover=false;
        
        private int scorePlayer2=0;
        private int scorePlayer1=0;
        private boolean initPlayer1=true;
        private boolean initPlayer2=true;
        private boolean endRound = false;
        private int round = 1;
        private int[] listWinner ={0,0} ;
        private int endRoundTime=1000; // 17 minutos = 1020 segundos
        
        private int roundTime=0;
        //winnerRound
        // 0 para empate
        // 1 para jogador 1
        // 2 para jogador 2
        private int winnerRound1=2;
        private int winnerRound2=2;
                
        private GameState gameState;
       
        
        Sound sound=new Sound(
			Arrays.asList(
					"/sound/background.wav",
					"/sound/shoot.wav"));

	public MyGame(String title, int width, int height, boolean resizable, boolean fullscreen) {
		super(title, width, height, resizable,fullscreen);
		this.setTeclado(new Key(this));
		this.setEstado(new GameState(this));
		this.setFps(60);
                
                this.gameState=new GameState(this);
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isEnter() {
		return enter;
	}

	public void setEnter(boolean enter) {
		this.enter = enter;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

    public int getDesenhoPlayer1() {
        return desenhoPlayer1;
    }

    public void setDesenhoPlayer1(int desenhoPlayer1) {
        this.desenhoPlayer1 = desenhoPlayer1;
    }

    public int getEndRoundTime() {
        return endRoundTime;
    }

    public void setEndRoundTime(int endRoundTime) {
        this.endRoundTime = endRoundTime;
    }

    public int getRoundTime() {
        return roundTime;
    }

    public void setRoundTime(int roundTime) {
        this.roundTime = roundTime;
    }

    public int getWinnerRound1() {
        return winnerRound1;
    }

    public void setWinnerRound1(int winnerRound1) {
        this.winnerRound1 = winnerRound1;
    }

    public int getWinnerRound2() {
        return winnerRound2;
    }

    public void setWinnerRound2(int winnerRound2) {
        this.winnerRound2 = winnerRound2;
    }

    public boolean isEndRound() {
        return endRound;
    }

    public void setEndRound(boolean endRound) {
        this.endRound = endRound;
    }

    

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public int getDesenhoPlayer2() {
        return desenhoPlayer2;
    }

    public void setDesenhoPlayer2(int desenhoPlayer2) {
        this.desenhoPlayer2 = desenhoPlayer2;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public boolean isGameover() {
        return gameover;
    }

    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public void setScorePlayer2(int scorePlayer2) {
        this.scorePlayer2 = scorePlayer2;
    }

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public void setScorePlayer1(int scorePlayer1) {
        this.scorePlayer1 = scorePlayer1;
    }

    public boolean isInitPlayer1() {
        return initPlayer1;
    }

    public void setInitPlayer1(boolean initPlayer1) {
        this.initPlayer1 = initPlayer1;
    }

    public boolean isInitPlayer2() {
        return initPlayer2;
    }

    public void setInitPlayer2(boolean initPlayer2) {
        this.initPlayer2 = initPlayer2;
    }
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int[] getListWinner() {
        return listWinner;
    }

    public void setListWinner(int[] listWinner) {
        this.listWinner = listWinner;
    }
    
}

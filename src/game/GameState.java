package game;

import java.awt.Graphics;
import apgc.gamedev2d.State;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import objects.Player2;
import objects.Player1;
import objects.Fundo;
import objects.GameOver;
import objects.Scores;

public class GameState extends State{
	
	Fundo palco=new Fundo();
	Player1 player1;
        Player2 player2;
        GameOver gameOver;
        Scores score;
	private MyGame game;
	
	public GameState(MyGame game) {        
                super(game);
		this.game=game;
		
		player1 =new Player1(this.game,this);
                player2 =new Player2(this.game,this);
                score = new Scores(this);
                
                gameOver=new GameOver(this);
	}

	@Override
	public void actualizar() {
            
            if(this.game.isRunning()){
                if(this.getGame().isStop()==false){
                    if(this.game.isGameover()==false){
                        
                        palco.actualizar(this);
                        player1.actualizar(this);
                        player2.actualizar(this);
                    }
                }
            }
	}
  

    @Override
    public void desenhar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
        palco.desenhar(g2d);
        this.game.setRunning(true);
            if(this.game.isGameover()==false){

                score.desenhar(g2d);

                player1.desenhar(g2d);
                player2.desenhar(g2d);
                this.game.setRoundTime(this.game.getRoundTime() + 1);
            }
            else{
                this.game.setEndRound(true);
                if(game.getRound() == 2){
                    gameOver.desenhar1(g2d);
                }
                else{
                    gameOver.desenhar(g2d);
                }


            }


    }

	@Override
	public void init() {
            palco.init(this);

            player1.init(this);
            player2.init(this);

            gameOver.init(this);   
	}

	public Fundo getPalco() {
		return palco;
	}

	public void setPalco(Fundo palco) {
		this.palco = palco;
	}

	public MyGame getGame() {
		return game;
	}

	public void setGame(MyGame game) {
		this.game = game;
	}

        public Player1 getPlayer1() {
            return player1;
        }

        public void setPlayer1(Player1 player1) {
            this.player1 = player1;
        }

        public Player2 getPlayer2() {
            return player2;
        }

        public void setPlayer2(Player2 player2) {
            this.player2 = player2;
        }

        public GameOver getGameOver() {
            return gameOver;
        }

        public void setGameOver(GameOver gameOver) {
            this.gameOver = gameOver;
        }

}

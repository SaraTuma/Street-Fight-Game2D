package lib;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game implements Runnable,KeyListener{

	public Display display;
	public int width, height;
	public String title;
	
	private boolean running=false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private Thread thread;
	//private KeyManager keymanager;
	
	//GameScene gameScene;
	//StartScene startScene;
	
	//
	
	private State estado;
	private KeyManager teclado;
	
	private int fps=60;
	private boolean resizable=false;
	private boolean fullscreen=false;
	
	
	public Game(String title, int width, int height, boolean resizable, boolean fullscreen) {
		this.width=width;
		this.height=height;
		this.title=title;
		this.resizable=resizable;
		this.fullscreen=fullscreen;
//		keymanager=new KeyManager(this);
//		gameScene=new GameScene(this);
//		startScene=new StartScene(this);
		
	}
	
	
	public void init() {
		display=new Display(title,width,height,resizable,fullscreen);
		display.getJframe().addKeyListener(this);
		//gameScene.init();
		//Assets.init();
		
		//State.setState(startScene);
		
		KeyManager.setKeymanager(getTeclado());
		
		State.setState(getEstado());
		if(State.getState()!=null) {
			State.getState().init();
		}
	    
	}
	
	private void tick() {
		if(State.getState()!=null) {
			State.getState().actualizar();
		}
	}
	public void render() {
		bs=display.getCanvas().getBufferStrategy();
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g=bs.getDrawGraphics();
		
		g.clearRect(0,0,width,height);
		if(State.getState()!=null) {
			State.getState().desenhar(g);
		}
		
		bs.show();
		g.dispose();
	}
	public void run() {
		init();
		
		int fps=getFps();
		double timePerTicket=1000000000/fps;
		double delta=0;
		long now;
		long lastTime=System.nanoTime();
		long timer=0;
		int ticks=0;
		
		
		while(running){
			
			now=System.nanoTime();
			delta+=(now-lastTime)/timePerTicket;
			timer+=now-lastTime;
			lastTime=now;
			
			if(delta>=1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer>=1000000000) {
				System.out.println("Ticks and Frames.:"+ticks);
				ticks=0;
				timer=0;
			}
		}
		stop();
	}
	
	public synchronized void start() {
		if(running)
			return;
		running=true;
		thread=new Thread(this);
		thread.start();
		
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Display getDisplay() {
		return display;
	}


	public void setDisplay(Display display) {
		this.display = display;
	}


	

	public int getFps() {
		return fps;
	}


	public void setFps(int fps) {
		this.fps = fps;
	}


	public State getEstado() {
		return estado;
	}


	public void setEstado(State estado) {
		this.estado = estado;
	}


	public boolean isRunning() {
		return running;
	}


	public void setRunning(boolean running) {
		this.running = running;
	}


//	public KeyManager getTeclado() {
//		return teclado;
//	}
//
//
//	public void setTeclado(KeyManager teclado) {
//		this.teclado = teclado;
//	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		if(KeyManager.getKeymanager()!=null) {
			KeyManager.getKeymanager().keyPressed(arg0);
		}
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		if(KeyManager.getKeymanager()!=null) {
			KeyManager.getKeymanager().keyReleased(arg0);
		}
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		if(KeyManager.getKeymanager()!=null) {
			KeyManager.getKeymanager().keyTyped(arg0);
		}
		
	}


	public KeyManager getTeclado() {
		return teclado;
	}


	public void setTeclado(KeyManager teclado) {
		this.teclado = teclado;
	}


	

	
	
	

}

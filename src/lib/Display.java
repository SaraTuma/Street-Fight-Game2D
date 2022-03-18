package lib;

import java.awt.Canvas;
import java.awt.Dimension;
import java.nio.channels.SelectableChannel;

import javax.swing.JFrame;

public class Display {

	private JFrame jframe;
	private Canvas canvas;
	
	private String title;
	private int width;
	private int height;
	private boolean resizable=false;
	private boolean fullscreen;
	
	
	public Display(String title, int width, int height, boolean resizable, boolean fullscreen) {
		this.title=title;
		this.height=height;
		this.width=width;
		this.resizable=resizable;
		this.fullscreen=fullscreen;
		
		createDisplay();
	}
	
	private void createDisplay() {
		jframe=new JFrame(title);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		if(isFullscreen()) {
			jframe.setBounds(0,0,jframe.getToolkit().getScreenSize().width,jframe.getToolkit().getScreenSize().height);
			jframe.setUndecorated(true);
			
			width=jframe.getToolkit().getScreenSize().width;
			height=jframe.getToolkit().getScreenSize().height;
			
			canvas=new Canvas();
			canvas.setPreferredSize(new Dimension(width,height));
			canvas.setMaximumSize(new Dimension(width,height));
			canvas.setMinimumSize(new Dimension(width,height));
			canvas.setFocusable(false);
		}
		else {
			jframe.setSize(width,height);
			jframe.setResizable(resizable);
			
			canvas=new Canvas();
			canvas.setPreferredSize(new Dimension(width,height));
			canvas.setMaximumSize(new Dimension(width,height));
			canvas.setMinimumSize(new Dimension(width,height));
			canvas.setFocusable(false);
		}
		
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
		
		
		
		jframe.add(canvas);
		jframe.pack();
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getJframe() {
		return jframe;
	}

	public void setJframe(JFrame jframe) {
		this.jframe = jframe;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isResizable() {
		return resizable;
	}

	public void setResizable(boolean resizable) {
		this.resizable = resizable;
	}

	public boolean isFullscreen() {
		return fullscreen;
	}

	public void setFullscreen(boolean fullscreen) {
		this.fullscreen = fullscreen;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	
	
}

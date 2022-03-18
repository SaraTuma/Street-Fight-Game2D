package lib;

public class Direction {

	public static final int LEFT=1;
	public static final int RIGHT=2;
	public static final int UP=3;
	public static final int DOWN=4;
	
	
	
	public static void stopMoveToLeft(Elemento el) {
		if(el.getPx()<=0) {
			el.setPx(0);
		}
	}
	
	public static void stopMoveToLeft(Elemento el,int value) {
		if(el.getPx()<=value) {
			el.setPx(value);
		}
	}
	
	public static void stopMoveToRight(Elemento el,Game game) {
		if(el.getPx()+el.getLargura()>
		game.getDisplay().getCanvas().getWidth()) {
			el.setPx(game.getDisplay().getCanvas().getWidth()-el.getLargura());
		}
	}
	
	public static void stopMoveToRight(Elemento el,Game game, int value) {
		if(el.getPx()+el.getLargura()>
		game.getDisplay().getCanvas().getWidth()-value) {
			el.setPx((game.getDisplay().getCanvas().getWidth()-value)-el.getLargura());
		}
	}
	
	public static void moveToLeft(Elemento el, int speed) {
		el.setPx(el.getPx()-speed);
	}
	
	public static void moveToRight(Elemento el, int speed) {
		el.setPx(el.getPx()+speed);
	}
	
	public static void moveToUp(Elemento el, int speed) {
		el.setPy(el.getPy()-speed);
	}
	
	public static void moveToDown(Elemento el, int speed) {
		el.setPy(el.getPy()+speed);
	}
	
	
	public static void stopMoveToUp(Elemento el, int value) {
		if(el.getPy()<=value) {
			el.setPy(value);
		}
	}
	
	public static void stopMoveToDown(Elemento el,Game game, int value) {
		if(el.getPy()+el.getAltura()>
		game.getDisplay().getCanvas().getHeight()-value) {
			el.setPy((game.getDisplay().getCanvas().getHeight()-value)-el.getAltura());
		}
	}
}

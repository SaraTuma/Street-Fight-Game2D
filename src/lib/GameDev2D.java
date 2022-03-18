package lib;
import java.awt.Toolkit;

public class GameDev2D {

	public static int height_of_desktop() {
		return (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	}
	
	public static int width_of_desktop() {
		return (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	}
	
	public static boolean colide(Elemento a, Elemento b) {
		final double plA = a.getPx() + a.getLargura();
		final double plB = b.getPx() + b.getLargura();
		final double paA = a.getPy() + a.getAltura();
		final double paB = b.getPy() + b.getAltura();

		if (plA > b.getPx() && a.getPx() < plB && paA > b.getPy() && a.getPy() < paB) {
			return true;
		}

		return false;
	}
}

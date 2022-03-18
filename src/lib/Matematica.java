package lib;

public class Matematica {

	public static int numeroAleatorio(int x, int y) {
		return new java.util.Random().ints(x,y).findAny().orElse(0);
	}
}

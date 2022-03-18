package lib;

import java.awt.image.BufferedImage;

public class ReturnBufferedImage {

	public static BufferedImage returnBufferedImage(String image, int px, int py, int largura, int altura) {
		try {
			return ReturnSpriteSheet.returnSpriteSheet("/images/"+image+".png").crop(px,py,largura,altura);
		}
		catch(Exception ex) {
			return ReturnSpriteSheet.returnSpriteSheet("/images/"+image+".jpg").crop(px,py,largura,altura);
		}
	}
}

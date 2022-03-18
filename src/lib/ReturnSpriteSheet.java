package lib;

import apgc.gamedev2d.ImageLoader;
import apgc.gamedev2d.SpriteSheet;

public class ReturnSpriteSheet {

	public static SpriteSheet returnSpriteSheet(String path) {
		return new SpriteSheet(ImageLoader.loadImage(path));
	}
}

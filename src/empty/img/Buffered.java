package empty.img;

import java.awt.image.BufferedImage;

public class Buffered {
	
	private BufferedImage sheet;
	
	public Buffered(BufferedImage sheet) {
		this.sheet = sheet;
	}

	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
}

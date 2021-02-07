package empty.img;

import java.awt.image.BufferedImage;

import empty.ImageLoader;
import entities.creatures.Player;

public class Assets {
	
	public static final int width =  20, height = 20;
	
	public static BufferedImage player, dirt, grass, stone, tree, stone2, wood, rock;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] btn_start, name;
	
	public static void init() {
		Buffered bf = new Buffered(ImageLoader.loadImage("/textures/Untitled111.png"));
		
		btn_start = new BufferedImage[2];
		btn_start[0] =bf.crop(width * 3, height * 3, width * 2, height);
		
		name = new BufferedImage[2];
		name[0] = bf.crop(width * 2, height * 4, width * 3, height);
		
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_left = new BufferedImage[2];
		
		player_down[0] = bf.crop(0, 0, width, height);
		player_down[1] = bf.crop(0, height, width, height);
		player_up[0] = bf.crop(0, height * 2, width, height);
		player_up[1] = bf.crop(width, height * 2, width, height);
		player_right[0] = bf.crop(width, height, width, height);
		player_right[1] = bf.crop(width * 3, height, width, height);
		player_left[0] = bf.crop(width * 2, height, width, height);
		player_left[1] = bf.crop(width * 4, height, width, height);
		
		grass = bf.crop(width, 0, width, height);
		stone = bf.crop(width, 0, width, height);
		stone2 = bf.crop(0, height * 3, width, height);
		dirt = bf.crop(width * 3, 0, width, height);
		tree = bf.crop(width * 2, height * 2, width, height);
		wood = bf.crop(width, height * 3, width, height);
		rock = bf.crop(width * 2, height * 3, width, height);
	}

}

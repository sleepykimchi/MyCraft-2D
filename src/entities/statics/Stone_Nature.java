package entities.statics;

import java.awt.Graphics;

import empty.Handler;
import empty.img.Assets;
import empty.item.Item;
import empty.tiles.Tile;

public class Stone_Nature extends StaticEntity {
	
	public Stone_Nature(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.stone2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}

package empty.world;

import java.awt.Graphics;

import empty.Handler;
import empty.item.ItemManager;
import empty.tiles.Tile;
import empty.untils.Untils;
import entities.EntityManager;
import entities.creatures.Player;
import entities.statics.Stone_Nature;
import entities.statics.Tree;

public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int [][] tiles;
	//Entities
	private EntityManager entityManager;
	//Item
	private ItemManager itemManager;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		itemManager = new ItemManager(handler);
		//Temporary entity code!
		entityManager.addEntity(new Tree(handler, 100, 250));
		entityManager.addEntity(new Tree(handler, 100, 350));
		entityManager.addEntity(new Tree(handler, 100, 450));
		entityManager.addEntity(new Tree(handler, 100, 550));
		entityManager.addEntity(new Stone_Nature(handler, 300, 560));
		entityManager.addEntity(new Stone_Nature(handler, 400, 560));
		entityManager.addEntity(new Stone_Nature(handler, 500, 560));
		entityManager.addEntity(new Stone_Nature(handler, 600, 560));
		entityManager.addEntity(new Stone_Nature(handler, 700, 560));
		entityManager.addEntity(new Stone_Nature(handler, 300, 660));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick() {
		itemManager.tick();
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(width, (handler.getGameCamera().getyOffset() + handler.getWidth()) / Tile.TILEHEIGHT + 1);
		
		for (int y = yStart;y < yEnd;y++) {
			for (int x = xStart;x < xEnd;x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//items
		itemManager.render(g);
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Untils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Untils.parseInt(tokens[0]);
		height = Untils.parseInt(tokens[1]);
		spawnX = Untils.parseInt(tokens[2]);
		spawnY = Untils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for (int y = 0;y < height;y++) {
			for (int x = 0;x < width;x++) {
				tiles[x][y] = Untils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
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

	public EntityManager getEntityManager() {
		return entityManager;
	}

}

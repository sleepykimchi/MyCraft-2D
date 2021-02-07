package empty.item;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import empty.Handler;

public class ItemManager {
	
	private Handler handler;
	private ArrayList<Item> items;
	private ArrayList<Item> remove;
	
	public int manyitem = 0;
	
	public ItemManager (Handler handler) {
		this.handler = handler;
		items = new ArrayList<Item>();
		remove = new ArrayList<Item>();
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void tick() {
		Iterator<Item> it = items.iterator();
		while (it.hasNext()) {
			Item i = it.next();
			i.tick();
			if (i.getCount() == Item.PICKED_UP)
				manyitem += 1;
				it.remove();
		}
	}
	
	public void render(Graphics g) {
		for (Item i : items)
			i.render(g);
	}
	
	public void addItem(Item i) {
		i.setHandler(handler);
		items.add(i);
	}
	
	// Getters and Setters
	
	public Handler getHandler() {
		return handler;
	}

}

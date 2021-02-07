package empty.inventory;

import java.awt.Graphics;

import empty.Handler;
import empty.item.Item;
import empty.item.ItemManager;

public class Inventory {
	
	private Handler handler;
	private ItemManager itemManager;
	private boolean active = false;
	
	public Inventory(Handler handler2) {
		this.handler = handler;
	}

	public void tick() {
			
	}
	
	public void render(Graphics g) {
		
	}
	
	//GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

}

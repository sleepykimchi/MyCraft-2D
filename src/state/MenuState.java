package state;

import java.awt.Graphics;

import empty.Handler;
import empty.img.Assets;
import empty.item.ItemManager;
import empty.ui.ClickListener;
import empty.ui.UIImageButton;
import empty.ui.UIManager;
import entities.EntityManager;
import entities.statics.Stone_Nature;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	private EntityManager entityManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().getGameState());
			}	
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}

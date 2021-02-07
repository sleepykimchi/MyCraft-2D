package state;

import java.awt.Graphics;

import empty.Handler;
import empty.world.World;
import entities.creatures.Player;
import entities.statics.Tree;

public class GameState extends State {
	
	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}

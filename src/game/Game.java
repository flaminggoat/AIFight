package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState{

	private int ID;
	private Player player;
	private Level level;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		level = new Level();
		player = new Player(level, 10, 300);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		
		Image img = new Image("src/Background03.png");
		Image scaledImg = img.getScaledCopy(AiFight.WINDOW_WIDTH, AiFight.WINDOW_HEIGHT);
		
		g.drawImage(scaledImg, 0, 0);
		
		g.drawString("Game", 10, 10);
		player.draw(g);
		level.draw(g);
		
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		player.update(delta);
	}

	@Override
	public int getID() {
		return ID;
	}

	public Game(int ID) {
		this.ID = ID;
	}

}

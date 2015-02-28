package game;

import java.util.ArrayList;

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
	ArrayList<Button> functionArray;
	int currentFunction = 0;
	int timer = 0;
	
	public void setFunctions(ArrayList<Button> buttons)
	{
		functionArray = buttons;
	}
	
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
		timer += delta;
		if(timer > 1000){
			timer=0;
			if(functionArray.get(currentFunction).name == "RUN")
			{
				player.speedX = 0.08f;
			}	
			else if(functionArray.get(currentFunction).name == "STOP")
			{
				player.speedX = 0f;
			}
			else if(functionArray.get(currentFunction).name == "JUMP")
			{
				player.speedY = 1.f;
			}
			currentFunction++;
			if(currentFunction >= functionArray.size())
				currentFunction = 0;
		}
	}

	@Override
	public int getID() {
		return ID;
	}

	public Game(int ID) {
		this.ID = ID;
	}

}

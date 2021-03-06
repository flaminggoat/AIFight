package game;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import de.matthiasmann.twl.ToggleButton;

public class AiFight extends StateBasedGame
{
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;
	public static final int MAIN_MENU = 0;
	public static final int GAME = 1;
	public static final int SELECTOR = 0;
	
	
	public AiFight(String gamename)
	{
		super(gamename);
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new AiFight("Simple Slick Game"));
			appgc.setDisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, false);
			appgc.setShowFPS(false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(AiFight.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {	
		addState(new Menu(MAIN_MENU));
		Game game = new Game(GAME);
		addState(game);
		addState(new Selector(SELECTOR, game));
	}

}

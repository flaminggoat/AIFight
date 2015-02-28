package game;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class AiFight extends StateBasedGame
{
	public static final int MAIN_MENU = 0;
	public static final int GAME = 1;
	
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
			appgc.setDisplayMode(640, 480, false);
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
		addState(new Game(GAME));
	}

}

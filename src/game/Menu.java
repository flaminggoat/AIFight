package game;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;


public class Menu extends BasicGameState{

	private StateBasedGame game;
	private int ID;	
	
	private Button playButton, highScoreButton, quitButton;
	
	public Menu(int ID) {
		this.ID = ID;
		
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		this.game = game;
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		Image img = new Image("src/hackathonMenu.jpg");
		Image scaledImg = img.getScaledCopy(AiFight.WINDOW_WIDTH, AiFight.WINDOW_HEIGHT);
		
		g.drawImage(scaledImg, 0, 0);
		g.setBackground(Color.blue);

		g.setColor(Color.white);
	    g.drawString("Game Title", 10, 10);	
		
		playButton = new Button(10, 100, 130, 20, "Play Game");
		playButton.Draw(g);
		
		highScoreButton = new Button(10, 130, 130, 20, "High Scores");
		highScoreButton.Draw(g);
		
		quitButton = new Button(10, 160, 130, 20, "Quit");
		quitButton.Draw(g);
				   
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		if(playButton.update(container))
		{
	        game.enterState(AiFight.GAME, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
		}
		
		if(quitButton.update(container))
		{
			container.exit();
		}
		
	}
	
	public void keyReleased(int key, char c) {
	    switch(key) {
	    case Input.KEY_1:
	        game.enterState(AiFight.GAME, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
	        break;
	    case Input.KEY_2:
	        // TODO: Implement later
	        break;
	    case Input.KEY_3:
	        // TODO: Implement later
	        break;
	    default:
	        break;
	    }
	}

	@Override
	public int getID() {
		return ID;
	}

}

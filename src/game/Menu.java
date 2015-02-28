package game;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;


public class Menu extends BasicGameState{

	private StateBasedGame game;
	private int ID;	
	private float ButtonWidth = 200;
	private float ButtonHeight = 20;
	
	
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

		Font titleFont = new Font("Verdana", Font.BOLD, 28);
		TrueTypeFont ttf = new TrueTypeFont(titleFont, true);
		
	    ttf.drawString((scaledImg.getWidth()/2) - ttf.getWidth("Game Title")/2, 50,"Game Title");	
		
		playButton = new Button((scaledImg.getWidth()/2) - 200/2, 100, ButtonWidth, ButtonHeight, "Play Game");
		playButton.Draw(g);
		
		highScoreButton = new Button((scaledImg.getWidth()/2) - 200/2, 130, ButtonWidth, ButtonHeight, "High Scores");
		highScoreButton.Draw(g);
		
		quitButton = new Button((scaledImg.getWidth()/2) - 200/2, 160, ButtonWidth, ButtonHeight, "Quit");
		quitButton.Draw(g);
				   
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		if(playButton.update(container))
		{
	        game.enterState(AiFight.SELECTOR, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
		}
		
		if(quitButton.update(container))
		{
			container.exit();
		}
		
	}
	
	public void keyReleased(int key, char c) {
	    switch(key) {
	    case Input.KEY_1:
	        game.enterState(AiFight.SELECTOR, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
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

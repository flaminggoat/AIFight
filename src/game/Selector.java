package game;

import java.util.ArrayList;

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

public class Selector extends BasicGameState{

	private int ID;
	private Level level;
	Button runButton,jumpButton,stopButton,delayButton, executeButton;
	Button ifButton,elseButton,endifButton;
	ArrayList<Button> numberButtons = new ArrayList<Button>(); 
	Button blockedButton,edgeButton;
	int tracker;
	ArrayList<Button> functionArray = new ArrayList<Button>();
	Game game;
	
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		executeButton = new Button(AiFight.WINDOW_WIDTH - 200, 50, 50, 20, "Execute");	
		runButton = new Button(AiFight.WINDOW_WIDTH/2, AiFight.WINDOW_HEIGHT/2, 50, 20, "RUN");	
		jumpButton = new Button(AiFight.WINDOW_WIDTH/2, AiFight.WINDOW_HEIGHT/2+20, 50, 20,"JUMP");
		stopButton = new Button(AiFight.WINDOW_WIDTH/2, AiFight.WINDOW_HEIGHT/2+40, 50, 20,"STOP");
		delayButton = new Button(AiFight.WINDOW_WIDTH/2, AiFight.WINDOW_HEIGHT/2+60, 50, 20, "DELAY");
		ifButton = new Button(AiFight.WINDOW_WIDTH/2, AiFight.WINDOW_HEIGHT/2+80, 50, 20, "IF");
		elseButton = new Button(AiFight.WINDOW_WIDTH/2, AiFight.WINDOW_HEIGHT/2+100, 50, 20,"ELSE");
		endifButton = new Button(AiFight.WINDOW_WIDTH/2, AiFight.WINDOW_HEIGHT/2+120, 50, 20,"ENDIF");
		
		for (int i=0;i<10;i++)
		{
			numberButtons.add(new Button(AiFight.WINDOW_WIDTH/2+70, AiFight.WINDOW_HEIGHT/2+i*20, 20, 18,Integer.toString(i+1)));
		}
		blockedButton = new Button(AiFight.WINDOW_WIDTH/2+120, AiFight.WINDOW_HEIGHT/2, 50, 10,"BLOCKED");
		edgeButton = new Button(AiFight.WINDOW_WIDTH/2+120, AiFight.WINDOW_HEIGHT/2+20, 50, 10,"EDGE");
		tracker = 0;
		level = new Level();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException
			{
		Image img = new Image("src/hackathonMenu.jpg");
		Image scaledImg = img.getScaledCopy(AiFight.WINDOW_WIDTH, AiFight.WINDOW_HEIGHT);
		
		g.drawImage(scaledImg, 0, 0);
		
		level.draw(g);
		
		g.drawString("Selector", 10, 10);
		runButton.Draw(g);
		jumpButton.Draw(g);
		stopButton.Draw(g);
		delayButton.Draw(g);
		ifButton.Draw(g);
		elseButton.Draw(g);
		endifButton.Draw(g);
		executeButton.Draw(g);
		for (int i=0;i<10;i++)
		{
			numberButtons.get(i).Draw(g);
		}
		blockedButton.Draw(g);
		edgeButton.Draw(g);
		for (int i=0;i<functionArray.size();i++)
		{
			functionArray.get(i).Draw(g);
		}
	
	}
	@Override
	public void update(GameContainer container, StateBasedGame arg1, int arg2)
			throws SlickException {
		float mx = container.getInput().getMouseX();
		float my = container.getInput().getMouseY();
		boolean mousedown = container.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON);
		
		if(executeButton.update(mx, my, mousedown))
		{
			game.setFunctions(functionArray);
			arg1.enterState(AiFight.GAME, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
		}
		
		if(jumpButton.update(mx, my, mousedown))
		{
			System.out.println("Button Added");
			functionArray.add(new Button(50, 50+tracker*20, 30, 18, "JUMP"));
			tracker++;
		}
		
		if(runButton.update(mx, my, mousedown))
		{
			System.out.println("Button Added");
			functionArray.add(new Button(50, 50+tracker*20, 30, 18, "RUN"));
			tracker++;
		}

		if(stopButton.update(mx, my, mousedown))
		{
			System.out.println("Button Added");
			functionArray.add(new Button(50, 50+tracker*20, 30, 18, "STOP"));
			tracker++;
		}

		if(delayButton.update(mx, my, mousedown))
		{
			functionArray.add(new Button(50, 50+tracker*20, 30, 18, "DELAY"));
			tracker++;
		}

		for(int i=0; i<10;i++)
		{
		if(numberButtons.get(i).update(mx, my, mousedown))
		{
			System.out.println("Button Added");
			functionArray.add(new Button(120, 50+(tracker-1)*20, 30, 18, Integer.toString(i+1)));
		}
		}
	}

	@Override
	public int getID() {
		return ID;
	}

	public Selector(int ID, Game game) {
		this.ID = ID;
		this.game = game;
	}

}

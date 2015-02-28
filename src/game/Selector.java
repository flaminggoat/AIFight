package game;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Selector extends BasicGameState{

	private int ID;
	Button runButton,jumpButton,stopButton,delayButton;
	Button ifButton,elseButton,endifButton;
	ArrayList<Button> numberButtons = new ArrayList<Button>(); 
	Button blockedButton,edgeButton;
	int tracker;
	ArrayList<Button> functionArray = new ArrayList<Button>(); 
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
		runButton = new Button(AiFight.WINDOW_WIDTH/2, AiFight.WINDOW_HEIGHT/2, 30, 10, "RUN");	
		jumpButton = new Button(AiFight.WINDOW_WIDTH/2, AiFight.WINDOW_HEIGHT/2+20, 30, 10,"JUMP");
		stopButton = new Button(AiFight.WINDOW_WIDTH/2, AiFight.WINDOW_HEIGHT/2+40, 30, 10,"STOP");
		delayButton = new Button(AiFight.WINDOW_WIDTH/2, AiFight.WINDOW_HEIGHT/2+60, 30, 10, "DELAY");
		ifButton = new Button(AiFight.WINDOW_WIDTH/2, AiFight.WINDOW_HEIGHT/2+80, 30, 10, "IF");
		elseButton = new Button(AiFight.WINDOW_WIDTH/2, AiFight.WINDOW_HEIGHT/2+100, 30, 10,"ELSE");
		endifButton = new Button(AiFight.WINDOW_WIDTH/2, AiFight.WINDOW_HEIGHT/2+120, 30, 10,"ENDIF");
		
		for (int i=0;i<10;i++)
		{
			numberButtons.add(new Button(AiFight.WINDOW_WIDTH/2+70, AiFight.WINDOW_HEIGHT/2+i*20, 20, 18,Integer.toString(i+1)));
		}
		blockedButton = new Button(AiFight.WINDOW_WIDTH/2+120, AiFight.WINDOW_HEIGHT/2, 50, 10,"BLOCKED");
		edgeButton = new Button(AiFight.WINDOW_WIDTH/2+120, AiFight.WINDOW_HEIGHT/2+20, 50, 10,"EDGE");
		tracker = 0;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException
			{
		g.drawString("Selector", 10, 10);
		runButton.Draw(g);
		jumpButton.Draw(g);
		stopButton.Draw(g);
		delayButton.Draw(g);
		ifButton.Draw(g);
		elseButton.Draw(g);
		endifButton.Draw(g);
		runButton.Draw(g);
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
		if(runButton.update(container))
		{
			System.out.println("Button Added");
			functionArray.add(new Button(50, 50+tracker*20, 30, 18, "RUN"));
			tracker++;
		}
		else
		if(jumpButton.update(container))
		{
			System.out.println("Button Added");
			functionArray.add(new Button(50, 50+tracker*20, 30, 18, "JUMP"));
			tracker++;
		}
		else
		if(stopButton.update(container))
		{
			System.out.println("Button Added");
			functionArray.add(new Button(50, 50+tracker*20, 30, 18, "STOP"));
			tracker++;
		}
		else
		if(delayButton.update(container))
		{
			functionArray.add(new Button(50, 50+tracker*20, 30, 18, "DELAY"));
			tracker++;
		}
		else
		for(int i=0; i<10;i++)
		{
		if(numberButtons.get(i).update(container))
		{
			System.out.println("Button Added");
			functionArray.add(new Button(120, 50+tracker*20, 30, 18, Integer.toString(i+1)));
		}
		}
	}

	@Override
	public int getID() {
		return ID;
	}

	public Selector(int ID) {
		this.ID = ID;
	}

}

package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Button {

	private float x, y, width, height;

	public Button(int xPosition, int yPosition, int width, int height){
		
		x = xPosition;
		y = yPosition;
		this.width = width;
		this.height = height;
	}
	
	public void Draw(Graphics g){
	
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);	
	}
	
	public boolean update(GameContainer gc){
		
		float mx = gc.getInput().getMouseX();
		float my = gc.getInput().getMouseY();
		boolean button = gc.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON);
		
		if(button)
		{
			if((mx > x && x < mx + width) && (my > y && y < my + height))
			{
					return true;
			}
		}	
		return false;
	}	
	
	public void AddString(String str, Graphics g){

		g.setColor(Color.white);
		g.drawString(str, x, y);
	}
}

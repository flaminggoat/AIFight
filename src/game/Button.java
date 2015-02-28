package game;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.TrueTypeFont;

public class Button {

	private float x, y, width, height;
	String name;

	public Button(int xPosition, int yPosition, float width, float height, String name){
		
		x = xPosition;
		y = yPosition;
		this.width = width;
		this.height = height;
		this.name = name;
	}
	
	public void Draw(Graphics g){
	
		Color semiTransparent = new Color(0,0,0, 0.4f);
		g.setColor(semiTransparent);
		g.fillRect(x, y, width, height);
		g.setColor(Color.white);		
		
		Font buttonFont = new Font("Verdana", Font.PLAIN, 20);
		TrueTypeFont ttf = new TrueTypeFont(buttonFont, true);
		
		
		ttf.drawString(x + width/2 - ttf.getWidth(name)/2, y + height/2 - ttf.getHeight(name)/2, name);
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
}

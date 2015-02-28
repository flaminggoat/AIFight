package game;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.TrueTypeFont;

public class Button {

	private float x, y, width, height;
	public String name;
	private TrueTypeFont ttf;
	private Font buttonFont;

	public Button(int xPosition, int yPosition, float width, float height, String name){
		
		x = xPosition;
		y = yPosition;
		this.width = width;
		this.height = height;
		this.name = name;
		
		buttonFont = new Font("Verdana", Font.PLAIN, 20);
		ttf = new TrueTypeFont(buttonFont, true);
	}
	
	public void Draw(Graphics g){
	
		Color semiTransparent = new Color(0,0,0, 0.4f);
		g.setColor(semiTransparent);
		g.fillRect(x, y, width, height);
		g.setColor(Color.white);		

		ttf.drawString(x + width/2 - ttf.getWidth(name)/2, y + height/2 - ttf.getHeight(name)/2, name);
	}
	
	public boolean update(float mx, float my, boolean mouseDown){
		if(mouseDown)
		{
			if((mx > x && mx < (x + width)) && (my > y && my < (y + height)))
			{
					return true;
			}
		}	
		return false;
	}	
}

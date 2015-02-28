package game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Player {
	
	enum state{
		IDLE, RUNNING
	}
	
	private float x, y, w, h, speedX, speedY;
	private Level level;
	
	public Player(Level level, float x, float y)
	{
		this.x = x;
		this.y = y;
		w = 20;
		h = 20;
		speedX = 0.1f;
		speedY = 0f;
		this.level = level;
	}
	
	public void draw(Graphics g){
		g.draw(new Rectangle(x, y, w, h));
	}
	
	public void update(int delta)
	{
		//Gravity
		if(level.getHeight(x) > y){
			speedY += 0.001f;
		} else {
			speedY -= 0.02f;
		}
		
		//Air resistance
		if(speedY > 0)
		{
			speedY -= 0.0005f;
		}
		
		x += delta*speedX;
		y += delta*speedY; 
	}
	
	

}

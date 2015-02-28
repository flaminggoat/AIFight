package game;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

public class Level {
	private List<Vector2f> points;
	
	public Level(){
		points = new ArrayList<Vector2f>();
		
		points.add(new Vector2f(0,200));
		points.add(new Vector2f(100,200));
		points.add(new Vector2f(100,180));
		points.add(new Vector2f(600,180));
		
	}	
	
	public void draw(Graphics g)
	{
		Vector2f lastPoint = points.get(0);
		for(Vector2f p : points)
		{
			g.drawLine(lastPoint.x, lastPoint.y, p.x, p.y);
			lastPoint = p;
		}
	}
	
	public float getHeight(float x){
		Vector2f lastPoint = points.get(0);
		for(Vector2f p : points)
		{
			if(lastPoint.x < x && p.x > x)
			{
				//TODO actually interpolate the height
				return (lastPoint.y + p.y)/2;
			}
			lastPoint = p;
		}
		
		return 0;
	}
}

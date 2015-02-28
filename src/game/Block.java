package game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Block {
	public Rectangle r;
	
	public Block(float x, float y, float w, float h){
		r = new Rectangle(x, y, w, h);	
	}

	public void draw(Graphics g) {
		g.draw(r);
	}
}

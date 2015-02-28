package game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Player {
	
	enum state{
		IDLE, RUNNING
	}
	
	private float x, y, w, h, speedX, speedY;
	private Level level;
	
	private Animation currentAnimation, moveRight, jump, land, idle;
	private static final int SPRITE_HEIGHT = 290;
	private static final int SPRITE_WIDTH = 165;
	private static final int SPRITE_ROW_2 = 295;
	private static final int SPRITE_ROW_3 = 590;
	private static final int SPRITE_ROW_4 = 875;
	private static final int SPRITE_ROW_5 = 1175;
	private static final int SPRITE_ROW_6 = 1460;
	
	public Player(Level level, float x, float y)
	{
		this.x = x;
		this.y = y;
		w = 20;
		h = 20;
		speedX = 0.1f;
		speedY = 0f;
		this.level = level;
		try {
			init();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init() throws SlickException {
		
		Image sprite = new Image("res/runningGrant.png");
		
		Image[] runRight = {sprite.getSubImage(0, 0, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(165, 0, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(330, 0, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(495, 0, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(660, 0, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(825, 0, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(990, 0, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1155, 0, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1328, 0, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1485, 0, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1650, 0, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1815, 0, SPRITE_WIDTH, SPRITE_HEIGHT),
							sprite.getSubImage(0, SPRITE_ROW_2, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(165, SPRITE_ROW_2, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(330, SPRITE_ROW_2, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(495, SPRITE_ROW_2, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(660, SPRITE_ROW_2, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(825, SPRITE_ROW_2, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(990, SPRITE_ROW_2, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1155, SPRITE_ROW_2, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1320, SPRITE_ROW_2, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1485, SPRITE_ROW_2, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1650, SPRITE_ROW_2, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1815, SPRITE_ROW_2, SPRITE_WIDTH, SPRITE_HEIGHT),
							};
							
		
		
		Image[] jumpImage = {sprite.getSubImage(0, SPRITE_ROW_3, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(165, SPRITE_ROW_3, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(330, SPRITE_ROW_3, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(495, SPRITE_ROW_3, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(660, SPRITE_ROW_3, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(825, SPRITE_ROW_3, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(990, SPRITE_ROW_3, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1155, SPRITE_ROW_3, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1320, SPRITE_ROW_3, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1485, SPRITE_ROW_3, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1650, SPRITE_ROW_3, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1815, SPRITE_ROW_3, SPRITE_WIDTH, SPRITE_HEIGHT),
							 sprite.getSubImage(0, SPRITE_ROW_4, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(165, SPRITE_ROW_4, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(330, SPRITE_ROW_4, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(495, SPRITE_ROW_4, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(660, SPRITE_ROW_4, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(825, SPRITE_ROW_4, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(990, SPRITE_ROW_4, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1155, SPRITE_ROW_4, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1320, SPRITE_ROW_4, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1485, SPRITE_ROW_4, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1650, SPRITE_ROW_4, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1815, SPRITE_ROW_4, SPRITE_WIDTH, SPRITE_HEIGHT),
							};
		
		Image[] landImage = {sprite.getSubImage(0, SPRITE_ROW_5, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(165, SPRITE_ROW_5, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(330, SPRITE_ROW_5, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(495, SPRITE_ROW_5, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(660, SPRITE_ROW_5, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(825, SPRITE_ROW_5, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(990, SPRITE_ROW_5, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1155, SPRITE_ROW_5, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1320, SPRITE_ROW_5, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1485, SPRITE_ROW_5, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1650, SPRITE_ROW_5, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(1815, SPRITE_ROW_5, SPRITE_WIDTH, SPRITE_HEIGHT),
							 sprite.getSubImage(0, SPRITE_ROW_6, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(165, SPRITE_ROW_6, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(330, SPRITE_ROW_6, SPRITE_WIDTH, SPRITE_HEIGHT),sprite.getSubImage(495, SPRITE_ROW_6, SPRITE_WIDTH, SPRITE_HEIGHT),
			};
		
		Image[] idleImage = {sprite.getSubImage(0, SPRITE_ROW_6, SPRITE_WIDTH, SPRITE_HEIGHT),};
		
		moveRight = new Animation(runRight, 50, true);
		jump = new Animation(jumpImage,50,true);
		land = new Animation(landImage,50,true);
		idle = new Animation(idleImage,50,true);
		
		currentAnimation = moveRight;	
	}
	
	public void draw(Graphics g){
		g.draw(new Rectangle(x, y, w, h));
		g.drawAnimation(currentAnimation, x - 40, y - 270);
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

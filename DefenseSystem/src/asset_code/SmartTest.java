package asset_code;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.image.ImageObserver;
import java.util.LinkedList;

import defenseSystem.Handler;
import defenseSystem.ID;
import defenseSystem.Sprite;
import defenseSystem.Universal;

public class SmartTest extends Sprite{
	
	private boolean destroyed = false;
	public int targetNum = -1;
	public int splitTimer = 0;
	public boolean splitCheck = false;
	public boolean b = false;
	private Handler handler;
	float velX;
	float velY;
	public float preX;
	public float preY;
	
	float pX = 0.0f;
	float pY = 0.0f;
	
	public SmartTest(int x, int y, float lpX, float lpY, ID id, Handler handler)
	{
		super (x, y, id);
		this.x = x;
		this.y = y;
		pX = lpX;
		pY = lpY;
		this.handler = handler;
		uploadImage("regularEnemyOne_1.png");
	
		/*
		ImageIcon ii = new ImageIcon("assets/brick.png");
		image = ii.getImage();
		
		i_width = image.getWidth(null);
		i_height = image.getHeight(null);
		*/
		destroyed = false;	
	}
	
	public void move()
	{
		x+=1;
	}
	
	
	public void seek(Sprite player)
	{
		if(player != null)
			{
				x += velX*Universal.globalDiff;
				y += velY*Universal.globalDiff;
				
					
				//	handler.addObject(new Trail(x,y,ID.Trail,Color.green,16,16,0.02f,handler));
				
				float diffX = x -player.getCentralX();
				float diffY = y -player.getCentralY();
				//float distance = (float) Math.sqrt((x-player.getVelX())*2+(y-player.getVelY())*2);
				//double distance = Point2D.distance(x1, y1, x2, y2);
				float distance =  (float) Point2D.distance(x, y, player.getCentralX(), player.getCentralY());
				//float distance = (float) Math.sqrt((y-player.getVelX()));
				
				velX = (float)((-1.0/distance)*diffX*Universal.globalDiff);
				
				velY = (float)((-1.0/distance)*diffY*Universal.globalDiff);
			}
		else if(player == null)
			{
				System.out.println("We didn't crash!");
			}
	
	}
	
	public void toPosition()
	{
		x += velX;
		y += velY;
		
		float diffX = x -pX;
		float diffY = y -pY;
		//float distance = (float) Math.sqrt((x-player.getVelX())*2+(y-player.getVelY())*2);
		//double distance = Point2D.distance(x1, y1, x2, y2);
		float distance =  (float) Point2D.distance(x, y, pX, pY);
		//float distance = (float) Math.sqrt((y-player.getVelX()));
		
		if(y<pY)
		{
		velX = (float)((-1.0/distance)*diffX*Universal.globalDiff);
		
		velY = (float)((-1.0/distance)*diffY*Universal.globalDiff);
		}
		
		
	}
	public boolean isDestroyed()
	{
		return destroyed;
	}
	
	public void setDestroyed(boolean val)
	{
		destroyed = val;
	}

	
	public boolean onCollission(Sprite sprite) {
		
		if(this.getRect().intersects(sprite.getRect()))
		{
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onCollission(LinkedList<SiloOne> siloOne) {
		
		for(int n = 0; n<siloOne.size();n++)
		{
			if(this.getRect().intersects(siloOne.get(n).getRect()))
			{
				return true;
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
		splitTimer++;
		
		if(splitTimer>=Universal.PERIOD && splitTimer<Universal.PERIOD*2)
		{
			uploadImage("regularEnemyOne_1.png");
		}
		else if(splitTimer<=Universal.PERIOD)
		{
			uploadImage("regularEnemyOne_2.png");
		}
		else if(splitTimer>=Universal.PERIOD*2)
		{
			splitTimer=0;
		}
		if(pX == 0.0f && pY == 0.0f)
		{
			for(int n=0; n<handler.sprite.size();n++)
			{
				if(handler.sprite.get(n).getID() == ID.silo1)
				{
					pX = handler.sprite.get(n).getX();
					pY = handler.sprite.get(n).getY();
				}
			}
		}
		
		 toPosition();
		 
		preX = x;
		preY = y;
	}

	@Override
	public void collission() {
		// TODO Auto-generated method stub
		for(int n=0;n<handler.sprite.size();n++)
		{
			Sprite tempSprite = handler.sprite.get(n);
			if(tempSprite.getID() == ID.pMissile)
			{
			//	boolean b = false;
				if(this.getRect().intersects(tempSprite.getRect()))
				{
					
					if(b == false)
					{
					handler.sprite.add(new standard_explosion((int)x, (int)y, ID.pMissile, handler));

					b = true;
				}
				//	else{
					Universal.gScore+=1;
					handler.removeObject(this);
				//	handler.sprite.add(new standard_explosion((int)x, (int)y, ID.pMissile, handler));
				//	}
				}
			}
		}
		
	}

	

}

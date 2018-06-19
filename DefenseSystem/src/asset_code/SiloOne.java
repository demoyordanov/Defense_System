package asset_code;

import defenseSystem.Handler;
import defenseSystem.ID;
import defenseSystem.Sprite;


public class SiloOne extends Sprite{
	
	public Handler handler; 
	public SiloOne(int x,int y, ID id, Handler handler)
	{
		super (x, y, id);
		this.x = x;
		this.y = y;
		this.handler = handler;
		
		uploadImage("largeGray.png");
	
		/*
		ImageIcon ii = new ImageIcon("assets/brick.png");
		image = ii.getImage();
		
		i_width = image.getWidth(null);
		i_height = image.getHeight(null);
		*/
	}
	


	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collission() {
		for(int n=0;n<handler.sprite.size();n++)
		{
			Sprite tempSprite = handler.sprite.get(n);
			if(tempSprite.getID() == ID.missile)
			{
				if(this.getRect().intersects(tempSprite.getRect()))
				{
				
				this.dead = true;
				handler.removeObject(this);
				handler.removeObject(tempSprite);
				}
			}
		}
		
	}
	
}

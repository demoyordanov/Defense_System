package asset_code;

import defenseSystem.ID;
import defenseSystem.Sprite;

public class playButton extends Sprite{

	private boolean destroyed = false;
	
	public playButton(int x, int y, ID id)
	{
		super (x, y, id);
		this.x = x;
		this.y = y;
		
		uploadImage("b_play.png");
	
		/*
		ImageIcon ii = new ImageIcon("assets/brick.png");
		image = ii.getImage();
		
		i_width = image.getWidth(null);
		i_height = image.getHeight(null);
		*/
		destroyed = false;	
	}
	
	public boolean isDestroyed()
	{
		return destroyed;
	}
	
	public void setDestroyed(boolean val)
	{
		destroyed = val;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collission() {
		// TODO Auto-generated method stub
		
	}
	
}

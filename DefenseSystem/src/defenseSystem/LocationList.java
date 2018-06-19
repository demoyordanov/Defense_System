package defenseSystem;

import java.util.LinkedList;

public class LocationList {

	private Handler handler;
	public LinkedList<playerCoordinates> pLocation = new LinkedList<playerCoordinates>();

	public void addLink(playerCoordinates plLocation, float pX, float pY)
	{
		this.pLocation.add(plLocation);
	}
	
	public void setPCoordinates()
	{
		//handler = new Handler();
		for(int n=0;n<handler.sprite.size();n++)
		{
			if(handler.sprite.get(n).getID() == ID.silo1)
			{
			//	Sprite tempSprite = handler.sprite.get(n);
			//	pLocation.add(new playerCoordinates(handler.sprite.get(n).getX(),handler.sprite.get(n).getY()));
				pLocation.add(new playerCoordinates(1f, 1f));

			}
		}
	}
}

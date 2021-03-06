package defenseSystem;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	public LinkedList<Sprite> sprite = new LinkedList<Sprite>();

	public void tick()
	{
		for(int n=0; n<sprite.size(); n++)
		{
			sprite.get(n).tick();
		}
	}
	
	public void render(Graphics g)
	{
		for(int n=0;n<sprite.size();n++)
		{
			sprite.get(n).drwRect(g);
			sprite.get(n).drwImage(g);
		}
	}
	
	
	public void addObject(Sprite sprite)
	{
		Sprite tempObject = sprite;
		this.sprite.add(sprite);
	}
	
	public void removeObject(Sprite sprite)
	{
		this.sprite.remove(sprite);
	}
	
	public void collission()
	{
		for(int n=0; n<sprite.size(); n++)
		{
			sprite.get(n).collission();
		}
	}
	
	public void clearOutOfBounds()
	{
		for(int n=0; n<sprite.size(); n++)
		{
			if(sprite.get(n).getY() >= (Universal.HEIGHT+20))
			sprite.remove(n);
		}
	}
}

package asset_code;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import defenseSystem.Handler;
import defenseSystem.ID;
import defenseSystem.Sprite;
import defenseSystem.Universal;
import defenseSystem_levels.LevelOne;

public class TestPMissile extends Sprite{

//	float pX = 0.0f;
//	float pY = 0.0f;
	float diff = 3.0f;
	public Handler handler;
	private int preX =0;
	private int preY =0;
	private int pX =0;
	private int pY =0;
	private int iX =0;
	private int iY =0;
	public TestPMissile(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		uploadImage("tinyGreen.png");
		pX = Universal.mX;
		pY = Universal.mY;
		iX =  x;
		iY = y;
	}
	
	public void toPosition()
	{
	//	if(pX == 0 && pY == 0)
	//	{
	//	pX = LevelOne.mX;
	//	pY = LevelOne.mY;
	//	}
		
		x += velX;
		y += velY;
		
		int diffX = (int) (x -pX);
		int diffY = (int) (y -pY);
		//float distance = (float) Math.sqrt((x-player.getVelX())*2+(y-player.getVelY())*2);
		//double distance = Point2D.distance(x1, y1, x2, y2);
		double distance = Point2D.distance(x, y, pX, pY);
		//float distance = (float) Math.sqrt((y-player.getVelX()));
		//diff = 1.0f; //<---- game difficulty
		
		if(y>pY)
		{
		velX = (float)((-1.0/distance)*diffX*diff);
		
		velY = (float) ((-1.0/distance)*diffY*diff);
		}
	}
	
	@Override
	public void drwRect(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.GREEN);
		g2.setStroke(new BasicStroke(4));
//		g2.drawOval((int)x, (int)y, 5, 5);
		g2.drawLine(iX, iY, (int)this.getCentralX(), (int)this.getCentralY());
	}

	@Override
	public void tick() {
		
		// TODO Auto-generated method stub
		toPosition();
		//System.out.println("X: " + x +" Y: " + y + " pX: " + pX + " pY: " + pY);
		if((int)x==(int)pX || (int)y==(int)pY)
		{
			handler.sprite.add(new standard_explosion((int)x, (int)y, ID.pMissile, handler));
			handler.removeObject(this);
		}
		if(y<pY)
		{
			handler.sprite.add(new standard_explosion((int)x, (int)y, ID.pMissile, handler));
			handler.removeObject(this);
		}
		
	}

	@Override
	public void collission() {
		// TODO Auto-generated method stub
	}

}

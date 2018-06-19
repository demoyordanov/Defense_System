package asset_code;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import defenseSystem.Handler;
import defenseSystem.ID;
import defenseSystem.Sprite;
import defenseSystem.Universal;

public class IngameUI extends Sprite{

	public String txScore ="";
//	public int score = 0;
	public String txTimer ="";
	public String txWave  ="";
	public String txAmmo ="";
	public int currentX;
	public int currentY;
	private Handler handler;
	
	public IngameUI(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler; 
		// TODO Auto-generated constructor stub
		currentX = (int)(x+(Universal.WIDTH/2));
		currentY = (int)(y+(Universal.WIDTH));
	}
	
	public void updateUI(int score, int nWave, int nAmmo)
    {
		txScore = "Score: " + Integer.toString(score);
		txWave = "Wave: " + Integer.toString(nWave);
		txAmmo = "Ammo: " + Integer.toString(nAmmo);
    }
	
	public void drwRect(Graphics g)
	{
	
		g.setColor(Color.BLACK);
		g.fillRect((int)this.getX(), (int)this.getY(), Universal.WIDTH, Universal.HEIGHT/35);
		g.setColor(Color.WHITE);
		g.drawString(txScore, (int)x+Universal.WIDTH/24, 15);
		g.drawString(txWave, (int)x+Universal.WIDTH/7, 15);
		g.drawString(txAmmo, (int)x+Universal.WIDTH/5, 15);
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

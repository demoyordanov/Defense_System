package asset_code;
import defenseSystem.Handler;
import defenseSystem.ID;
import defenseSystem.Sprite;

public class TestMark extends Sprite{

	public double lifetime = 0.0;
	public boolean expload = false;
	public Handler handler;
	public TestMark(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		uploadImage("mediumRed.png");
	}
	
	
	public boolean sExplode()
	{
		return expload = true;
	}
	
	public void explode()
	{
		setHeight(0.33);
		setWidth(0.33);
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

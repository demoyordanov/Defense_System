package defenseSystem_levels;

import defenseSystem.Handler;
import defenseSystem.ID;
import defenseSystem.Universal;
import defenseSystem.playerCoordinates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import asset_code.IngameUI;
import asset_code.SiloOne;
import asset_code.SmartTest;
import asset_code.TestMark;
import asset_code.TestPMissile;
import defenseSystem.*;


public class LevelOne extends JPanel{
	
	private Timer timer;
	private Random r = new Random();
	public int ammo = 5;
	public float rsX;
	public float rsY;
	public int LastPoint=0;
	public int rsL;
	public int wave=0;
	private boolean spawnNew = false;
//	public static int mX = 0;
//	public static int mY = 0;
	int countAlot;
//	int targetNum;
	int secondSpawn;
	public Handler handler;
	//public LocationList locationList;
	public IngameUI ingameUI;
	public LinkedList<Sprite> sprite = new LinkedList<Sprite>();
	public LinkedList<playerCoordinates> pLocation = new LinkedList<playerCoordinates>();
	public LinkedList<playerCoordinates> updatedLocations = new LinkedList<playerCoordinates>();
	public LevelOne()
	{
		handler = new Handler();
	//	locationList = new LocationList();
		initialization();
	}
	
	
	public void initialization()
	{
		setDoubleBuffered(true);
		
//		smart2.add(new SmartTest(r.nextInt(Universal.WIDTH),(-5), null));
//		smart2.add(new SmartTest(r.nextInt(Universal.WIDTH),(-5), null));
//		smart2.add(new SmartTest(r.nextInt(Universal.WIDTH),(-5), null));
//		smart2.add(new SmartTest(r.nextInt(Universal.WIDTH),(-5), null));
//		smart2.add(new SmartTest(r.nextInt(Universal.WIDTH),(-5), null));
		
		
		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), Universal.DELAY, Universal.PERIOD);
		
		ingameUI = new IngameUI(0,0,ID.GUI, handler);
		//handler.addObject(new IngameUI(Universal.WIDTH, 20, score, wave, ID.GUI, handler));
		handler.addObject(new SiloOne(Universal.WIDTH/8, (Universal.HEIGHT-Universal.HEIGHT/7), ID.silo1, handler));
		handler.addObject(new SiloOne(Universal.WIDTH/3, (Universal.HEIGHT-Universal.HEIGHT/7), ID.silo1, handler));
		handler.addObject(new SiloOne((Universal.WIDTH-Universal.WIDTH/3), (Universal.HEIGHT-Universal.HEIGHT/7), ID.silo1, handler));
		handler.addObject(new SiloOne((Universal.WIDTH-Universal.WIDTH/8), (Universal.HEIGHT-Universal.HEIGHT/7), ID.silo1, handler));
		setPCoordinates();
	//	System.out.println(locationList.pLocation.size());
		addNextWave(6);
	}
	
	public void setPCoordinates()
	{
		//handler = new Handler();
		for(int n=0;n<handler.sprite.size();n++)
		{
			if(handler.sprite.get(n).getID() == ID.silo1)
			{
				pLocation.add(new playerCoordinates(handler.sprite.get(n).getCentralX(), handler.sprite.get(n).getCentralY()));
			//	LastPoint++;
			}
		}
	}
	
	public void updatedPCoordinates()
	{
		//handler = new Handler();
		/*
		for(int n=0;n<updatedLocations.size();n++)
		{
			updatedLocations.set(n, null);
			LastPoint = 0;
		}
		
		while(updatedLocations.size()!=0)
		{
			updatedLocations.removeLast();
			LastPoint = 0;
		}*/
		//updatedLocations.removeFirst();
		
		
		for(int n=0;n<handler.sprite.size();n++)
		{
			if(handler.sprite.get(n).getID() == ID.silo1)
			{
//				if(handler.sprite.get(n).dead == false)
//				{
				if(handler.sprite.get(n).getX() != 0 && handler.sprite.get(n).getY() != 0)
				{
				updatedLocations.add(new playerCoordinates(handler.sprite.get(n).getCentralX(), handler.sprite.get(n).getCentralY()));
				LastPoint=n;
				}
			}
		}
		
				if(Universal.mX>0 && Universal.mX<((updatedLocations.getFirst().pX)))
				{
					rsL=0;
				}
				else if(Universal.mX>updatedLocations.get(LastPoint).pX)
				{
					
					rsL=LastPoint;
					
				}
				else if(Universal.mX>updatedLocations.getFirst().pX && Universal.mX<updatedLocations.getLast().pX)
				{
					for(int n=1;n<updatedLocations.size()-1;n++)
					{
						if(Universal.mX>updatedLocations.get(n-1).pX && Universal.mX<updatedLocations.get(n+1).pX)
						{
							rsL=n;
						}
					}
				}
		//			}
		//	else
		//	{
		//		rsL=1;
		//	}
	//	}
	}
	
	public void updatedMSite()
	{
		//handler = new Handler();
		for(int n=0;n<pLocation.size();n++)
		{
		//	if(handler.sprite.get(n).getID() == ID.silo1)
		//	{
		//		updatedLocations.add(new playerCoordinates(handler.sprite.get(n).getCentralX(), handler.sprite.get(n).getCentralY()));
		//	}	
			//	if(Universal.mX>updatedLocations.get(n-1).pX && Universal.mX>updatedLocations.get(n+1).pY)
			//	{
			//		System.out.println("Hi");
			//	}
		}
	}
	
	public void clearPCoordinates()
	{
		while(updatedLocations.size()!=0)
		{
			updatedLocations.removeLast();
			LastPoint = 0;
		}
		/*
		for(int n=updatedLocations.size();n>0;n--)
		{
				updatedLocations.remove(n);
		}*/
		
		
	}
	
	public void rocketList()
	{
		int rocketNumber = 0;
		for(int n=0;n<handler.sprite.size();n++)
		{
			
			if(handler.sprite.get(n).getID() == ID.missile)
			{
				rocketNumber++;
			}
		}
		if(rocketNumber == 0)
		{
			spawnNew = true;
		}
	}
	
	public void drawObjects(Graphics2D g2d)
	{
		setBackground(Color.BLUE); //<--- does not work
		handler.render(g2d);
		ingameUI.drwRect(g2d);

	}
	

	// --| Listener is in Hub
   	public void mouseMoved(MouseEvent e) {
   // 	mX = e.getX(); 
   // 	mY = e.getY();
    	}
    	
    	
    public void mouseReleased(MouseEvent e) {
    	
    	if(ammo > 0)
    	{
		handler.addObject(new TestPMissile((int)pLocation.get(rsL).pX,(int)pLocation.get(rsL).pY, ID.pMissile, handler));
		ammo -=1;
    	}
        }
    
    //will be called to increase difficulty while spamming
    public void addNextWave(int iterations)
	{
    	int spWaves = iterations + wave;
    	for(int n=0; n<spWaves; n++)
    	{
    	int b = r.nextInt(pLocation.size());
		handler.addObject(new SmartTest(r.nextInt(Universal.WIDTH),(-5), (int)pLocation.get(b).pX, (int)pLocation.get(b).pY, ID.missile, handler));
    	}
    	spawnNew = false;
    	wave+=1;
    //	Universal.globalDiff+=0.1f;
    	ammo+=(wave+updatedLocations.size()*2);
    	Universal.increaseDiff();
    	Universal.gScore+=(ammo+rsL);
	}
	
    //will add random number of non-standard missiles
    public void addExtraMissiles()
    {
    	
    }
    
	//real-time updates are done here
    private class ScheduleTask extends TimerTask 
		{
			@Override
			public void run()
			{
			//	addNextWave();
			//	System.out.println(wave);
				updatedPCoordinates();
				rocketList();
				
				handler.tick();
				handler.collission();
				if(spawnNew == true)
				{
					addNextWave(4);
				}
			//	updatedMSite();
				handler.clearOutOfBounds();
				ingameUI.updateUI(Universal.gScore, wave, ammo);
				clearPCoordinates();
				
			}
			
		}

}

package defenseSystem_levels;

import defenseSystem.ID;

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
import asset_code.standard_explosion;
import defenseSystem.*;


public class LevelTwo extends JPanel{/*
	
	private Timer timer;
	private Random r = new Random();
	public float mouseX;
	public float mouseY;
	public int deleteThisNumber;
	private boolean spawnAlot = true;
	public int mouseState;
	int countAlot;
	int lvlScore = 0, lvlWave = 0;
//	int targetNum;
	int secondSpawn;
	public IngameUI ingameUI;
	public LinkedList<SmartTest> smart2 = new LinkedList<SmartTest>();
	public LinkedList<SiloOne> siloOne = new LinkedList<SiloOne>();
	public LinkedList<TestMark> testMark = new LinkedList<TestMark>();
	public LinkedList<TestPMissile> testPMissile = new LinkedList<TestPMissile>();
	public LinkedList<standard_explosion> stExplosion = new LinkedList<standard_explosion>();
	public int MissileCount = 8;
	public boolean gameOver = false;
	public LevelTwo()
	{
		
		initialization();
	}
	
	public void initialization()
	{
		setDoubleBuffered(true);
		addNextWave();
		
		ingameUI = new IngameUI(0,0,null);
		ingameUI.updateUI(lvlScore, lvlWave);
		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), Universal.DELAY, Universal.PERIOD);
		siloOne.add(new SiloOne(Universal.WIDTH/8, (Universal.HEIGHT-Universal.HEIGHT/8), ID.silo1));
		siloOne.add(new SiloOne(Universal.WIDTH/3, (Universal.HEIGHT-Universal.HEIGHT/8), null));
		siloOne.add(new SiloOne((Universal.WIDTH-Universal.WIDTH/3), (Universal.HEIGHT-Universal.HEIGHT/8), null));
		siloOne.add(new SiloOne((Universal.WIDTH-Universal.WIDTH/8), (Universal.HEIGHT-Universal.HEIGHT/8), null));
	}
	
	public void drawObjects(Graphics2D g2d)
	{
		setBackground(Color.BLUE); //<--- does not work

		//ingameUI.drwRect(g2d);
		for(int n=0;n<testMark.size(); n++)
		{
			testMark.get(n).drwImage(g2d);
		}
		
		for(int n=0;n<testPMissile.size(); n++)
		{
			testPMissile.get(n).drwImage(g2d);
		}
		
		for(int n = 0; n<siloOne.size(); n++)
		{
		siloOne.get(n).drwImage(g2d);
		}
		
		for(int n=0;n<smart2.size(); n++)
		{
			smart2.get(n).drwImage(g2d);
		}
		for(int n=0;n<stExplosion.size();n++)
		{
			stExplosion.get(n).drwImage(g2d);
		}
		
		if(gameOver == true)
		{
			g2d.drawString("Game Over", Universal.HEIGHT/2, Universal.WIDTH/2);
		}
		ingameUI.drwRect(g2d);

	}
	

	// --| Listener is in Hub
   	public void mouseMoved(MouseEvent e) {
   		mouseX = (float)e.getX();
   		mouseY = (float)e.getY();
		if(e.getX()<Universal.WIDTH/8) mouseState = 0;
    	else if(e.getX()>Universal.WIDTH/8 && e.getX()<Universal.WIDTH/2) mouseState = 1;
    	else if(e.getX()>Universal.WIDTH/3 && e.getX()<(Universal.WIDTH-Universal.WIDTH/3)) mouseState = 2;
    	else if(e.getX()>(Universal.WIDTH-Universal.WIDTH/3) && e.getX()<(Universal.WIDTH-Universal.WIDTH/8)) mouseState = 3;
   	}
    	
    	
    public void mouseReleased(MouseEvent e) {
    	
    		if(MissileCount != 0)
    		{
    		testMark.add(new TestMark(e.getX(), e.getY(), null));
    		if(mouseState == 0)
    		{
    		testPMissile.add(new TestPMissile((int)siloOne.get(0).getCentralX(), (int)siloOne.get(0).getCentralY(), null));
    		}
    		if(mouseState == 1)
    		{
    		testPMissile.add(new TestPMissile((int)siloOne.get(1).getCentralX(), (int)siloOne.get(0).getCentralY(), null));
    		}
    		if(mouseState == 2)
    		{
    		testPMissile.add(new TestPMissile((int)siloOne.get(2).getCentralX(), (int)siloOne.get(0).getCentralY(), null));
    		}
    		if(mouseState == 3)
    		{
    		testPMissile.add(new TestPMissile((int)siloOne.get(3).getCentralX(), (int)siloOne.get(0).getCentralY(), null));
    		}
    		//    		smart2.get(n).seek(siloOne.get(smart2.get(n).targetNum));
    		//testPMissile.getLast().toPosition(testMark.getLast());
    		MissileCount -= 1;
    		}
        }
    
    //will be called to increase difficulty while spamming
    public void addNextWave()
	{
		smart2.add(new SmartTest(r.nextInt(Universal.WIDTH),(-5), null));
		smart2.add(new SmartTest(r.nextInt(Universal.WIDTH),(-5), null));
		smart2.add(new SmartTest(r.nextInt(Universal.WIDTH),(-5), null));
		smart2.add(new SmartTest(r.nextInt(Universal.WIDTH),(-5), null));
		smart2.add(new SmartTest(r.nextInt(Universal.WIDTH),(-5), null));
		lvlWave+=1;
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
			if(gameOver == false)
			{
				if(stExplosion.size()>0)
				{
					for(int n=0;n<stExplosion.size();n++)
					{
						if(stExplosion.get(n).lifetime < stExplosion.get(n).maxLifetime)
						{
						stExplosion.get(n).lifetime += 1;
						stExplosion.get(n).setHeight(0.33);
						stExplosion.get(n).setWidth(0.33);
						}else if(stExplosion.get(n).lifetime >= stExplosion.get(n).maxLifetime)
						{
							stExplosion.remove(n);
						}
						
					}
				}
				
				for(int n=0;n<testMark.size();n++)
				{
					
					testPMissile.get(n).toPosition(mouseX, mouseY);
					
					if(testMark.get(n).expload == true)
					{
					
					//	stExplosion.add(new standard_explosion((int)testMark.get(n).getCentralX(), (int)testMark.get(n).getCentralY(), null));
						
						testPMissile.remove(n);
						testMark.remove(n);
					}
				//	testMark.get(n).setHeight(0.33);
				//	testMark.get(n).setWidth(0.33);
				}
				
				//add scalable things
				for(int n=0;n<testMark.size();n++)
				{
					for(int i=0;i<testPMissile.size();i++)
					{
					if(testMark.get(n).getRect().intersects(testPMissile.get(i).getRect()))
					{
							testMark.get(n).sExplode();
					
					}
					
					}
					
					
				}
				//testPMissile.getLast().seek(testMark.getLast());
				//countAlot++;
				if(smart2.size() == 0)
				{
					addNextWave();
					MissileCount = 2;
	//				countAlot = 0;
				}
				
			try{
				for(int n=0;n<smart2.size(); n++)
				{
	
					if(smart2.get(n).targetNum == -1)
					{
						smart2.get(n).targetNum = r.nextInt(siloOne.size());
						smart2.get(n).diff += (r.nextFloat() - 0.5f);
					}
					
					if(smart2.get(n).getX() <= (Universal.HEIGHT/2 + Universal.HEIGHT/4))
					{
						if(smart2.get(n).splitCheck == false)
						{
							smart2.get(n).splitTimer = r.nextInt(10);
							System.out.println(" " + smart2.get(n).splitTimer + " ");
							if(smart2.get(n).splitTimer >= 2)
							{
								System.out.print(" SPLIT! SPLIT!");
								smart2.add(new SmartTest((int)smart2.get(n).getCentralX(),(int)smart2.get(n).getCentralY(), null));
								smart2.getLast().splitCheck = true;
								smart2.add(new SmartTest((int)smart2.get(n).getCentralX(),(int)smart2.get(n).getCentralY(), null));
								smart2.getLast().splitCheck = true;
								smart2.add(new SmartTest((int)smart2.get(n).getCentralX(),(int)smart2.get(n).getCentralY(), null));
								smart2.getLast().splitCheck = true;
								smart2.remove(n);
							}
							
							smart2.get(n).splitCheck = true;
						}
					}
					//		smart2.get(n).seek(siloOne.get(smart2.get(n).targetNum));
					smart2.get(n).toPosition(siloOne.get(smart2.get(n).targetNum));
	
					
					if(smart2.get(n).onCollission(siloOne))
					{
							System.out.println("hit");
					//		siloOne.remove(i);
					//		smart2.remove(n);
					//		deleteThisNumber = n;
							lvlScore += 1;
						
					}
					for(int i=0; i<stExplosion.size(); i++)
					{
					if(smart2.get(n).getRect().intersects(stExplosion.get(i).getRect()))
					{
							System.out.println("hit");
					//		siloOne.remove(i);
							lvlScore += 1;
							smart2.remove(n);
					//		deleteThisNumber = n;
							
						
					}
					}
					
				}
				
			}catch (IndexOutOfBoundsException e) {
			    //System.err.println("IndexOutOfBoundsException: " + e.getMessage());
				for(int n=0;n<smart2.size(); n++)
					{
						smart2.get(n).targetNum = r.nextInt(siloOne.size());
					}
				}
			
			for(int n=0;n<siloOne.size(); n++)
			{
				for(int i=0;i<smart2.size(); i++)
				{
				try{
					if(siloOne.get(n).getRect().intersects(smart2.get(i).getRect()))
					{
					 siloOne.remove(n);
					}
				}catch(IndexOutOfBoundsException e)
					{
					if(siloOne.size() == 0)
					{
						gameOver = true;
						System.out.println("Game Over");
					}
					else
					{
						smart2.get(n).targetNum = r.nextInt(siloOne.size());
					}
					
					}
				
				}
				
			}
			ingameUI.updateUI(lvlScore, lvlWave);
			}
		}
			
		}
*/
}

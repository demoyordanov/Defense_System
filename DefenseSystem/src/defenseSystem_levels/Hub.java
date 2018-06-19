package defenseSystem_levels;

import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JPanel;

import defenseSystem.Game;
import defenseSystem.Handler;
import defenseSystem.Universal;


public class Hub extends JPanel{
	
			private Timer timer;
			private Game game;
			private Menu menu;
			private LevelOne levelOne;
			public Handler handler;
		//	private LevelTwo levelTwo;
			public int pray = 0;

			public Hub()
			{
			//	handler = new Handler();
				initialization();
			//	render(g);
			}
			
			public void initialization()
			{
			//	addKeyListener(new TAdapter());
				setFocusable(true);
				requestFocusInWindow();
				MAdapter mouseAdapter = new MAdapter(); 
				addMouseMotionListener(mouseAdapter);
				addMouseListener(mouseAdapter);
				//bricks = new Brick[N_OF_BRICKS];
				setDoubleBuffered(true);
				//game = new Game();
				//initialize everything here
				menu = new Menu();
				levelOne = new LevelOne();
			//	levelTwo = new LevelTwo();
				timer = new Timer();
				timer.scheduleAtFixedRate(new ScheduleTask(), Universal.DELAY, Universal.PERIOD);
				
			}
			
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
				g2d.scale(1.0, 1.0);     //<--- scale to resolution (hopefully)
				
				// ***********************************
				// ********* LOAD LEVEL HERE *********
				// ***********************************
				
				//menu.drawObjects(g2d); //<--- important
				levelOne.drawObjects(g2d);
				//levelTwo.drawObjects(g2d); //<--- important
				
				
				Toolkit.getDefaultToolkit().sync();
			}
			
			private class MAdapter extends MouseAdapter
		    {
				
		    	@Override
		    	public void mouseMoved(MouseEvent e) {
		    		Universal.mX = e.getX(); 
		    		Universal.mY = e.getY();	
		    		levelOne.mouseMoved(e);	
		    	}
		    	
		    	
		    	public void mouseReleased(MouseEvent e) {
		    	//	levelTwo.mouseReleased(e);
		    		levelOne.mouseReleased(e);	
		        }
		    }
			
			 private class ScheduleTask extends TimerTask 
				{
					@Override
					public void run()
					{		
						repaint();
						
					}
				}
			

}

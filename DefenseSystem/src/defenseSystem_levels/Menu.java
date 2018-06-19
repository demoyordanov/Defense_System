package defenseSystem_levels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import asset_code.playButton;
import defenseSystem.Universal;

public class Menu extends JPanel{
	
	private Timer timer;
	public playButton b_play;

	public Menu()
	{
		initialization();
	//	render(g);
	}
	
	public void initialization()
	{
	//	addKeyListener(new TAdapter());
		setFocusable(true);
		//bricks = new Brick[N_OF_BRICKS];
		setDoubleBuffered(true);
		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), Universal.DELAY, Universal.PERIOD);
		b_play = new playButton(Universal.WIDTH/2, Universal.HEIGHT/2, null);
	}
	
	/*
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		setBackground(Color.CYAN);
		drawObjects(g2d);
		
		
		Toolkit.getDefaultToolkit().sync();
	}
	*/
	public void drawObjects(Graphics2D g2d)
	{
		
		g2d.drawImage(b_play.getImage(), (int)b_play.getX(), (int)b_play.getY(), b_play.getWidth(), b_play.getHeight(), (ImageObserver) this);

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

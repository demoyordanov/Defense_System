package defenseSystem;

import javax.swing.JFrame;

import defenseSystem_levels.Hub;

import java.awt.EventQueue;

//program executes from this file 

public class Game extends JFrame{

	
	public static int testInt = 0; //for testing purposes, -* to be removed
	
	
	public enum gameState //game states
	{
		menu, levelOne, levelTwo, levelThree, levelFour; 
	}
	
	public Game()
	{
		initUI();
		//gameState = menu;
	}
	
	private void initUI()
	{
		add(new Hub()); //Hub handles the level 
			
		setTitle("Defense System");						
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		   setSize(Universal.WIDTH, Universal.HEIGHT);	//"Universal: handles global values 
	        setLocationRelativeTo(null);				//center screen
	        setResizable(false);						//self-explanatory
	        setVisible(true);							//so is this
	    }

	    public static void main(String[] args) {
	        
	        EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {                
	                Game game = new Game();
	                game.setVisible(true);  
	              
	            }
	        });
	}
}

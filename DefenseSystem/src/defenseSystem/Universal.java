package defenseSystem;

public class Universal {
	
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 600;
	public static final int DELAY = 1000;
	public static final int PERIOD = 10;
	public static float globalDiff = 0.3f;
	public static int gScore = 00000;
	public static int mX = 0;
	public static int mY = 0;
	
	public static void defaultDiff()
	{
		globalDiff = 0.3f;
	}
	
	public static void increaseDiff()
	{
		globalDiff+=0.1f;
	}
	

}
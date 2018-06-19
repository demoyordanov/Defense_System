package defenseSystem;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public abstract class Sprite implements ImageObserver{
	
	//declaring variables - all protected
	protected float x;
	protected float y;
	protected float w;
	protected float h;
	public boolean dead = false;
	protected ID id;
	protected float velX;
	protected float velY;
	protected float i_width;
	protected float i_height;
	protected Image image;
	private ImageIcon ii;
	
	//constructor - consider adding universal values
	public Sprite(int x,int y, ID id)
	{
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	//getters and setters
	
	public ID getID()
	{
		return id;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getCentralX()
	{
		return x+i_width/2;
	}
	
	public float getCentralY()
	{
		return y+i_height/2;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public float getY()
	{
		return y;
	}
	
	public int getWidth()
	{
		return (int)i_width;
	}
	
	public void setWidth(double a)
	{
		i_width +=a;
	}
	
	public int getHeight()
	{
		return (int)i_height;
	}
	
	public void setHeight(double a)
	{
		i_height+=a;
	}
	
	public Image getImage()
	{
		return image;
	}
	
	//explore alternative I/O
	protected void uploadImage(String fileLocation)
	{
		this.ii = new ImageIcon("assets/" + fileLocation);
		image = ii.getImage();
		i_width = image.getWidth(null);
		i_height = image.getHeight(null);
		
	//	return ii;
	}
	
	public void RotateImage()
	{
	//	image.
	}
	
	public float getVelX() {
		return velX;
	}
	public void setVelX(float velX) {
		this.velX = velX;
	}
	public float getVelY() {
		return velY;
	}
	public void setVelY(float velY) {
		this.velY = velY;
	}

	//draws an Image - only works with Lists
	public void drwImage(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(this.getImage(), (int)this.getX(), (int)this.getY(), this.getWidth(), this.getHeight(), this);
	//	ii.paintIcon(this, g, (int)getX(), (int)getY());
//		imageIcon.paintIcon(this, g2d, getWidth() / 2 - imageIcon.getIconWidth() / 2, getHeight() / 2);
		//	g2d.drawImage(this.getImage(), (int)this.getX(), (int)this.getY(), this.getWidth(), this.getHeight(), (ImageObserver) this);
	}
	
	public void drwRect(Graphics g)
	{
		
	}
	
	public Rectangle getRect()
	{
		
			return new Rectangle((int)x, (int)y, (int)i_width, (int)i_height);
		
	}

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
			int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean dead()
	{
		return dead = true;
//		return dead();
	}
	
	public abstract void tick();
	public abstract void collission();

}

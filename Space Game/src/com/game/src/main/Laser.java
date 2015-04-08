package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.classes.EntityB;


public class Laser extends GameObject implements EntityB {

	
	private Textures tex;
	
	private int fireRate;
	private int dmg;
	private double ySpeed;
	private double xSpeed;
	
	public Laser(double x, double y, Textures tex, int fireRate, int dmg, double ySpeed, double xSpeed)
	{
		super(x, y);
		this.tex = tex;
		this.fireRate = fireRate;
		this.dmg = dmg;
		this.ySpeed = ySpeed;
		this.xSpeed = xSpeed;
	}
	
	public void tick()
	{
		y += ySpeed;
		x += xSpeed;
		/*Physics.Collider(this, game.ec);
		if(Physics.Collision(this, game.ec))
		{
			c.removeEntity(this);
		}
		*/
	}
	
	public void render(Graphics g)
	{
		g.drawImage(tex.laser, (int) x, (int) y, null);
	}
	
	
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x + 16, (int) y + 9, 2, 16);
	}
	
	public double getY()
	{
		return y;
	}
	public double getX()
	{
		return x;
	}
	
	public int getFireRate()
	{
		return fireRate;
	}
	public int getDmg()
	{
		return dmg;
	}
}
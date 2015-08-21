package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.classes.EntityC;


public class EnemyHuge extends GameObject implements EntityC{
	
	private Textures tex;
	private int health;
	private boolean dead;
	private int points;
	
	public EnemyHuge(double x, double y, Textures tex)
	{
		super(x, y);
		this.tex = tex;
		health = 24;
		points = 80;
	}
	
	public void tick()
	{
		y += (2 * powerUpStopwatch.getMultiplier() * Mastery.getEnemySpeedMultiplier());
		
	}
	
	public void render(Graphics g)
	{
	
		g.drawImage(tex.enemyhuge, (int) x,(int) y, 96, 96, null);
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x + 13, (int) y, 69, 78);
	}
	
	public double getY()
	{
		return y;
	}
	public double getX()
	{
		return x;
	}
	public void setY(double y)
	{
		this.y = y;  
	}
	public void setHealth(int dmg)
	{
		health = health - dmg;
		if(health <= 0)
		{
			dead = true;
		}
	}
	public boolean checkDead()
	{
		return dead;
	}
	
	public int getPoints()
	{
		return points;
	}
}

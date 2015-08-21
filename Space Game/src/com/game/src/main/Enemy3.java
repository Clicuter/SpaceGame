package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.classes.EntityC;


public class Enemy3 extends GameObject implements EntityC{
	
	private Textures tex;
	private int health;
	private boolean dead;
	private int points;
	
	public Enemy3(double x, double y, Textures tex)
	{
		super(x, y);
		this.tex = tex;
		health = 3;
		points = 14;
	}
	
	public void tick()
	{
		y += (3 * Waves.speed * powerUpStopwatch.getMultiplier() * Mastery.getEnemySpeedMultiplier());
		
	}
	
	public void render(Graphics g)
	{
		if(health == 3)
		{
		g.drawImage(tex.enemy3, (int) x,(int) y, 48, 48, null);
		}
		if(health == 2)
		{
			g.drawImage(tex.enemy2, (int) x,(int) y, 48, 48, null);
		}
		if(health == 1)
		{
			g.drawImage(tex.enemy, (int) x,(int) y, 48, 48, null);
		}
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int) y, 48, 48);
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

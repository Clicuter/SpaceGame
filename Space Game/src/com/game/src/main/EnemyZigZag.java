package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.game.src.main.classes.EntityC;


public class EnemyZigZag extends GameObject implements EntityC{
	
	private Textures tex;
	private int health;
	private boolean dead;
	private int points;
	private double leftBoundary;
	private double rightBoundary;
	private double xSpeed;
	private double ySpeed;
	private Random r = new Random();;
	
	public EnemyZigZag(double x, double y, Textures tex)
	{
		super(x, y);
		this.tex = tex;
		health = 1;
		points = 16;
		leftBoundary = (x - 30 - (r.nextInt(10) + 1));
		rightBoundary = (x + 30 + (r.nextInt(10) + 1));
		xSpeed = (10 + (r.nextInt(10) + 1))/ 10;
		ySpeed = (15 + (r.nextInt(10) + 1))/ 10;
	}
	
	public void tick()
	{
		y += (ySpeed * Waves.speed * powerUpStopwatch.getMultiplier() * Mastery.getEnemySpeedMultiplier());
		if(x >= rightBoundary || x >= 452)
		{
			if(x >= 452)
			{
			leftBoundary = 452 - (rightBoundary - leftBoundary);
			rightBoundary = 452;
			xSpeed = (xSpeed * -1);
			x = 451;
			}
			else
			xSpeed = (xSpeed * -1);

		}
		if(x <= leftBoundary || x <= 58)
		{
			if(x <= 58)
			{
				rightBoundary = 58 + (rightBoundary - leftBoundary);
				leftBoundary = 58;
				xSpeed = (xSpeed * -1);
				x = 57;
			}
			else
			xSpeed = (xSpeed * -1);
		}
		x += (xSpeed * Waves.speed * powerUpStopwatch.getMultiplier());
	}
	
	public void render(Graphics g)
	{
		g.drawImage(tex.enemyzigzag, (int) x,(int) y, null);
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int) y, 32, 32);
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

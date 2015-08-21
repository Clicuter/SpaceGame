package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.game.src.main.classes.EntityC;


public class EnemyZigZag2 extends GameObject implements EntityC{
	
	private Textures tex;
	private int health;
	private boolean dead;
	private int points;
	private double leftBoundary;
	private double rightBoundary;
	private double xSpeed;
	private double ySpeed;
	private Random r = new Random();
	
	public EnemyZigZag2(double x, double y, Textures tex)
	{
		super(x, y);
		this.tex = tex;
		health = 2;
		points = 24;
		leftBoundary = (x - 35 - (r.nextInt(20) + 1));
		rightBoundary = (x + 35 + (r.nextInt(20) + 1));
		xSpeed = (20 + (r.nextInt(10) + 1))/ 10;
		ySpeed = (15 + (r.nextInt(15) + 1))/ 10;
	}
	
	public void tick()
	{
		y += (ySpeed *( Waves.speed )* Mastery.getEnemySpeedMultiplier());
		if(x >= rightBoundary || x >= 466)
		{
			if(x >= 466)
			{
			leftBoundary = 466 - (rightBoundary - leftBoundary);
			rightBoundary = 466;
			xSpeed = (xSpeed * -1);
			x = 465;
			}
			else
			xSpeed = (xSpeed * -1);
		}
		if(x <= leftBoundary || x <= 44)
		{
			if(x <= 44)
			{
			rightBoundary = 44 + (rightBoundary - leftBoundary);
			leftBoundary = 44;
			xSpeed = (xSpeed * -1);
			x = 45;
			}
			else
			xSpeed = (xSpeed * -1);
		}
		x += (xSpeed * Waves.speed);
	}
	
	public void render(Graphics g)
	{
		if(health == 1)
		{
		g.drawImage(tex.enemyzigzag, (int) x,(int) y, null);
		}
		if(health == 2)
		{
		g.drawImage(tex.enemyzigzag2, (int) x,(int) y, null);
		}
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

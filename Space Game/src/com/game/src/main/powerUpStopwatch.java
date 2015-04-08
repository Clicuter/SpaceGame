package com.game.src.main;

import java.awt.Graphics;

public class powerUpStopwatch {

	private Textures tex;
	
	public boolean available;
	private boolean active;
	private int timer;
	private int duration;
	private static double enemySpeedMultiplier;
	private int x;
	private int y;
	
	public powerUpStopwatch(Textures tex)
	{
		this.tex = tex;
		timer = 0;
		duration = 10;
		enemySpeedMultiplier = 1;
		x = 566;
		y = 408;
		available = false;
	}
	
	public void tick()
	{
		if(active)
		{
			timer++;
			if(timer == (duration * 60))
			{
				timer = 0;
				deactivatePowerUp();
			}
				
		}
		
	}
	public void render(Graphics g)
	{
		if(available == true)
			g.drawImage(tex.powerupstopwatch, x, y, 48, 48, null);
		if(active == true)
		{
			g.drawImage(tex.powerupstopwatch, 430, 40, null);
			g.drawString("" + (duration - (timer/60)), 465, 60);
		}
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public static double getMultiplier()
	{
		return enemySpeedMultiplier;
	}
	
	public boolean getAvailable()
	{
		return available;
	}
	public boolean getActive()
	{
		return active;
	}
	
	public void toggleUse()
	{
		if(available)
		{
		available = false;
		}
		else
		{
			available = true;
		}
	}
	
	public void activatePowerUp()
	{
		available = false;
		active = true;
		enemySpeedMultiplier = .5;
	}
	public void deactivatePowerUp()
	{
		active = false;
		enemySpeedMultiplier = 1;
	}
	public void resetPowerUpStopwatch()
	{
		available = false;
		deactivatePowerUp();
		timer = 0;
	}
	
}

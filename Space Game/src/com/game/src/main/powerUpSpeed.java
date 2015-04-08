package com.game.src.main;

import java.awt.Graphics;

public class powerUpSpeed {

	private Textures tex;
	private Mastery mastery;
	
	public boolean available;
	private boolean active;
	private int timer;
	private int duration;
	private static double playerSpeedMultiplier;
	private int x;
	private int y;
	
	public powerUpSpeed(Textures tex)
	{
		this.tex = tex;
		timer = 0;
		duration = 10;
		playerSpeedMultiplier = 1;
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
			g.drawImage(tex.powerupspeed, x, y, 48, 48, null);
		if(active == true)
		{
			g.drawImage(tex.powerupspeed, 430, 40, null);
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
		return playerSpeedMultiplier;
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
		playerSpeedMultiplier = 1.4;
	}
	public void deactivatePowerUp()
	{
		active = false;
		playerSpeedMultiplier = 1;
	}
	public void resetPowerUpSpeed()
	{
		available = false;
		deactivatePowerUp();
		timer = 0;
	}
	public void addMastery(Mastery mastery)
	{
		this.mastery = mastery;
	}
	public void implementMastery()
	{
		duration = (10 + (int)mastery.getSpeedPowerUpBonus());
	}
	
}

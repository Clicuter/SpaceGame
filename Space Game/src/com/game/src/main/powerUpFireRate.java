package com.game.src.main;

import java.awt.Font;
import java.awt.Graphics;

public class powerUpFireRate {

	private Textures tex;
	private Mastery mastery;
	
	public boolean available;
	private boolean active;
	private int timer;
	private int duration;
	private static double fireRateMultiplier;
	private int x;
	private int y;
	
	public powerUpFireRate(Textures tex)
	{
		this.tex = tex;
		timer = 0;
		duration = 10;
		fireRateMultiplier = 1;
		x = 40;
		y = 846;
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
			g.drawImage(tex.powerupfirerate, x, y, 64, 64, null);
		if(active == true)
		{
			g.drawImage(tex.powerupfirerate, 486, 899, null);
			g.setFont(new Font("arial", 20, 20));
			g.drawString("" + (duration - (timer/60)), 450, 922);
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
		return fireRateMultiplier;
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
		fireRateMultiplier = .5;
	}
	public void deactivatePowerUp()
	{
		active = false;
		fireRateMultiplier = 1;
	}
	public void resetPowerUpFireRate()
	{
		deactivatePowerUp();
		available = false;
		timer = 0;
	}
	public void addMastery(Mastery mastery)
	{
		this.mastery = mastery;
	}
	public void implementMastery()
	{
		duration = 10 + (int)mastery.getFireRatePowerUpBonus();
	}
	
}

package com.game.src.main;

import java.awt.Font;
import java.awt.Graphics;

import com.game.src.main.classes.EntityA;

public class powerUpShield {

	private Textures tex;
	private Controller c;
	private EntityA p;
	private Mastery mastery;
	
	public boolean available;
	private boolean active;
	private int timer;
	private int duration;
	private int x;
	private int y;
	
	public powerUpShield(EntityA p, Controller c, Textures tex)
	{
		this.tex = tex;
		this.p = p;
		this.c = c;
		timer = 0;
		duration = 10;
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
			g.drawImage(tex.powerupshield, x, y, 64, 64, null);
		if(active == true)
		{
			g.drawImage(tex.powerupshield, 486, 899, null);
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
		c.addEntity(new Shield(p));
	}
	public void deactivatePowerUp()
	{
		active = false;
		c.removeEntity(c.getEntityE().get(c.getEntityE().size() - 1));
	}
	public void setActiveFalse()
	{
		active = false;
	}
	public void resetPowerUpShield()
	{
		available = false;
		timer = 0;
		setActiveFalse();
	}
	public void addMastery(Mastery mastery)
	{
		this.mastery = mastery;
	}
	public void implementMastery()
	{
		duration = (10 + (int)mastery.getShieldPowerUpBonus());
	}
	
	
}

package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.classes.EntityD;

public class dropShield implements EntityD {

	private Textures tex;
	
	private double x;
	private double y;
	private int powerUpType;
	
	public dropShield(double x, double y, int powerUpType, Textures tex)
	{
		this.tex = tex;
		this.x = x;
		this.y = y;
		this.powerUpType = powerUpType;
	}
	
	public void tick()
	{
		 y += 1.5;
	}
	
	public void render(Graphics g)
	{
		g.drawImage(tex.powerupshield, (int)x, (int)y, null);
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x + 1, (int) y + 1, 30, 30);
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public int getType()
	{
		return powerUpType;
	}
	
}

package com.game.src.main;

public class Background {

	private double y = 72;
	private double y2 = -660;
	private double y3 = 72;
	private double y4 = -660;
	
	public void tick()
	{
		if(y >= 790)
		{
			y = -660;
		}
		else
		{
		y += .25;
		}
		if(y2 >= 790)
		{
			y2  = -660;
		}
		else
		{
			y2 += .25;
		}
		// ROCK WALL
		if(y3 >= 790)
		{
			y3 = -660;
		}
		else
		{
		y3 += 1;
		}
		if(y4 >= 790)
		{
			y4  = -660;
		}
		else
		{
			y4 += 1;
		}
	}
	
	public int getY()
	{
		return (int)y;
	}
	
	public int getY2()
	{
		return (int)y2;
	}
	public int getY3()
	{
		return (int)y3;
	}
	
	public int getY4()
	{
		return (int)y4;
	}
	
}

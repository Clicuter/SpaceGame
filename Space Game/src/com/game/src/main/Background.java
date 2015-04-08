package com.game.src.main;

public class Background {

	private double y = 0;
	private double y2 = -480;
	private double y3 = 0;
	private double y4 = -480;
	
	public void tick()
	{
		if(y >= 480)
		{
			y = -480;
		}
		else
		{
		y += .25;
		}
		if(y2 >= 480)
		{
			y2  = -480;
		}
		else
		{
			y2 += .25;
		}
		// ROCK WALL
		if(y3 >= 480)
		{
			y3 = -479;
		}
		else
		{
		y3 += 1;
		}
		if(y4 >= 480)
		{
			y4  = -479;
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

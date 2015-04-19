package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Points {
	
	private static int points;
	private static double meters;
	private double goalmeters;
	private Font pointFont;
	
	public Points()
	{
		points = 0;
		meters = 0;
		goalmeters = 2;
		pointFont = new Font("arial", 20, 20);
	}
	
	public void tick()
	{
		meters += .0334;
		if(meters >= goalmeters)
		{
			points += 1;
			goalmeters += 2;
		}
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.setFont(pointFont);
		g.drawString("" + points, 565, 169);
		g.drawString("" + ((int)meters), 565, 249);
	}
	
	public static void addPoints(int pts)
	{
		points += pts;
	}
	
	public static int getPoints()
	{
		return points;
	}
	public static double getMeters()
	{
		return meters;
	}
	public void resetPoints()
	{
		points = 0;
		meters = 0;
		goalmeters = 0;
	}
}

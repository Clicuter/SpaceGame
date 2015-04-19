package com.game.src.main.menu;

import java.awt.Color;
import java.awt.Graphics;

public class buttonPopUp {

	private int alpha;
	private Color alphaValue;
	private int xpos;
	
	public buttonPopUp(int xpos)
	{
		alpha = 255;
		this.xpos = xpos;
	}
	public void tick()
	{
		if(alpha > 0)
		{
		alpha--;
		}
		if(xpos > -30)
		{
			xpos--;
		}
	}
	public void render(Graphics g)
	{
		alphaValue = new Color(255,255,255,alpha);
		g.setColor(alphaValue);
		g.fillRect(100, xpos, 100, 30);
	}
}

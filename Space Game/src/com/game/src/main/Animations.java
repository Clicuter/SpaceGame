package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Animations {

	private int xpos;
	private int ypos;
	private int originalypos;
	private int alpha;
	private String message;
	private Color fadingWhite;
	private Font bigFont;
	private boolean moveImage;
	
	public Animations(int xpos, int ypos, String message)
	{
		this.xpos = xpos;
		this.ypos = ypos;
		this.originalypos = ypos;
		this.message = message;
		moveImage = false;
		alpha = 255;
		bigFont = new Font("arial", 20, 30);
	}
	public void tick()
	{
		if(moveImage && alpha > 0)
		{
			alpha += -2;
			ypos += -1;
			if(alpha <= 0)
			{
				moveImage = false;
				alpha = 255;
				ypos = originalypos;
			}
		}
	}
	public void render(Graphics g)
	{
		if(moveImage)
		{
			fadingWhite = new Color(255, 255, 255, alpha);
			g.setColor(fadingWhite);
			g.setFont(bigFont);
			g.drawString(message, xpos, ypos);
		}
	}
	
	public void playAnimation()
	{
		moveImage = true;
	}
	public void setAnimationText(String message)
	{
		this.message = message;
	}
}

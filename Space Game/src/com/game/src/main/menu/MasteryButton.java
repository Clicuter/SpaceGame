package com.game.src.main.menu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MasteryButton {
	
	private int mx;
	private int my;
	private int posx;
	private int posy;
	private int sizex;
	private int sizey;
	private BufferedImage normal;
	private BufferedImage hovered;
	private BufferedImage clicked;
	private MasteryButtonActionHandler masterybuttonactionhandler;
	private String actionKeyword;
	private boolean hoveredState;
	private boolean clickedState;
	
	public MasteryButton(BufferedImage normal, BufferedImage hovered, BufferedImage clicked, int posx, int posy, int sizex, int sizey, String actionKeyword, MasteryButtonActionHandler masterybuttonactionhandler)
	{
		
		this.normal = normal;
		this.hovered = hovered;
		this.clicked = clicked;
		this.posx = posx;
		this.posy = posy;
		this.sizex = sizex;
		this.sizey = sizey;
		this.actionKeyword = actionKeyword;
		this.masterybuttonactionhandler = masterybuttonactionhandler;
		
	}
	
	public void updateButton(int mx, int my, String actionType)
	{
		this.mx = mx;
		this.my = my;
		
		if(mx >= posx && mx <= (posx + sizex) && my >= posy && my <= (posy + sizey))
		{
			if(actionType.equals("hovered"))
			{
				hoveredState = true;
			}
			else if(actionType.equals("clicked"))
			{
				clickedState = true;
			}
			else if(actionType.equals("released"))
			{
				if(clickedState)
				{
					clickedState = false;
					buttonPressed();
				}
			}
		}
		else
		{
			if(actionType.equals("hovered"))
			{
				hoveredState = false;
			}
			else if(actionType.equals("released"))
			{
				clickedState = false;
			}
		}
		
	}
	
	public void render(Graphics g)
	{
		if(clickedState)
		{
			g.drawImage(clicked, posx, posy, sizex, sizey, null);
		}
		else if(hoveredState)
		{
			g.drawImage(hovered, posx, posy, sizex, sizey, null);
		}
		else
		{
			g.drawImage(normal, posx, posy, sizex, sizey, null);
		}
	}
	
	public void buttonPressed()
	{
		masterybuttonactionhandler.masteryHandler(actionKeyword);
	}
}

package com.game.src.main.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.game.src.main.Coins;
import com.game.src.main.Experience;
import com.game.src.main.Points;
import com.game.src.main.Textures;

public class PostGame {
	
	private int adjuster;
	private Textures tex;
	
public PostGame(Textures tex)
{
	this.tex = tex;
	adjuster = 0;
}
	
public void tick()
{
	if(Points.getPoints() < 10)
	{
		adjuster = 40;
	}
	else if(Points.getPoints() < 100)
	{
		adjuster = 20;
	}
	else if(Points.getPoints() < 1000)
	{
		adjuster = 5;
	}
	else if(Points.getPoints() < 10000)
	{
		adjuster = -5;
	}
	else if(Points.getPoints() < 100000)
	{
		adjuster = -15;
	}
}
	public void render(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(175, 100, 200, 300);
		g.setColor(Color.gray);
		g.fillRect(180, 105, 190, 290);
		Font postgamefnt2 = new Font("arial", 20,20);
		g.setFont(postgamefnt2);
		g.setColor(Color.black);
		g.drawString("Score", 250, 130);
		g.drawString("Coins:", 200, 220);
		g.drawString("Exp  :" , 200, 260);
		g.fillRect(195, 285, 130, 10);
		g.setColor(Color.green);
		g.fillRect(195, 285, Experience.getExpPercent(), 10);
		g.setColor(Color.white);
		// MAKE THIS TAKE A VARIABLE
		g.drawString("+ " + Coins.getGainedCoins(), 260, 220);
		g.drawString("+ " + Experience.getTempExp(), 260, 260);
		///////////////////////////////
		/*
		g.setColor(Color.red);
		g.fillOval(325, 270, 40, 40);
		g.setColor(Color.black);
		g.fillOval(327, 272, 36, 36);
		*/
		////////////////////////////////////////////////
		////////////////////////////////////////////////
		if(Experience.getLevel() == 1)
		{
			g.drawImage(tex.lvl1, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 2)
		{
			g.drawImage(tex.lvl2, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 3)
		{
			g.drawImage(tex.lvl3, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 4)
		{
			g.drawImage(tex.lvl4, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 5)
		{
			g.drawImage(tex.lvl5, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 6)
		{
			g.drawImage(tex.lvl6, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 7)
		{
			g.drawImage(tex.lvl7, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 8)
		{
			g.drawImage(tex.lvl8, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 9)
		{
			g.drawImage(tex.lvl9, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 10)
		{
			g.drawImage(tex.lvl10, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 11)
		{
			g.drawImage(tex.lvl11, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 12)
		{
			g.drawImage(tex.lvl12, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 13)
		{
			g.drawImage(tex.lvl13, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 14)
		{
			g.drawImage(tex.lvl14, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 15)
		{
			g.drawImage(tex.lvl15, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 16)
		{
			g.drawImage(tex.lvl16, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 17)
		{
			g.drawImage(tex.lvl17, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 18)
		{
			g.drawImage(tex.lvl18, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 19)
		{
			g.drawImage(tex.lvl19, 325, 270, 40, 40, null);
		}
		else if(Experience.getLevel() == 20)
		{
			g.drawImage(tex.lvl20, 325, 270, 40, 40, null);
		}
		
		////////////////////////////////////////////////
		////////////////////////////////////////////////
		
		
		//////////////////////////// HOME BUTTON
		if(MainMenuMouseInput.getHomeButtonClicked())
		{
			g.drawImage(tex.homebuttonclicked, 310, 335, null);
		}
		else if(MainMenuMouseInput.getHomeButtonHovered())
		{
			g.drawImage(tex.homebuttonhovered, 310, 335, null);
		}
		else
		{
			g.drawImage(tex.homebuttonnormal, 310, 335, null);
		}
		///////////////////////////// HOME BUTTON
		//////////////////////////// RETRY BUTTON
		g.setColor(Color.yellow);
		g.fillRect(195, 335, 100, 48);
		if(MainMenuMouseInput.getAgainButtonClicked())
		{
			g.drawImage(tex.againbuttonclicked, 195, 335, null);
		}
		else if(MainMenuMouseInput.getAgainButtonHovered())
		{
			g.drawImage(tex.againbuttonhovered, 195, 335, null);
		}
		else
		{
			g.drawImage(tex.againbuttonnormal, 195, 335, null);
		}
		//////////////////////////// ReTRY BUTTON
		Font postgamefnt1 = new Font("arial", 50, 50);
		g.setFont(postgamefnt1);
		g.setColor(Color.white);
		g.drawString("" + Points.getPoints(), (225 + adjuster), 175);
	}
public void resetAdjuster()
{
	adjuster = 0;
}
}

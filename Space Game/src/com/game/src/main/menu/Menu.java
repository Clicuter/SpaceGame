package com.game.src.main.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.Coins;
import com.game.src.main.Experience;
import com.game.src.main.Game;

public class Menu {

	public Rectangle playButton = new Rectangle(224, 150, 192, 48);
	public Rectangle multiplayerButton = new Rectangle(224, 210, 192, 48);
	public Rectangle masteriesButton = new Rectangle(224, 270, 192, 48);
	public Rectangle storeButton = new Rectangle(224, 330, 192, 48);
	public Rectangle quitButton = new Rectangle(224, 390, 192, 48);
	
	private TexturesMenu texmenu;
	
	public Menu(TexturesMenu texmenu)
	{
		this.texmenu = texmenu;
	}
	
	public void render(Graphics g)
	{
		
		Font menuFnt = new Font("arial", Font.BOLD, 50);
		g.setFont(menuFnt);
		g.setColor(Color.white);
		g.drawString("SPACE GAME", Game.WIDTH / 2, 100);
		g.drawString("" + Coins.getCurrentCoins() + " COINS", 400, 50);
		g.drawString("" + Experience.getTotalExp() + " EXP" , 400, 150);
		
		// PLAY BUTTON GRAPHICS
		if(MainMenuMouseInput.getPlayButtonClicked())
		{
			g.drawImage(texmenu.playbuttonclicked, playButton.x, playButton.y, null);
		}
		else if(MainMenuMouseInput.getPlayButtonHovered())
		{
			g.drawImage(texmenu.playbuttonhovered, playButton.x, playButton.y, null);
		}
		else
		{
			g.drawImage(texmenu.playbuttonnormal, playButton.x, playButton.y, null);
		}
		// MULTIPLAYER BUTTON GRAPHICS
		if(MainMenuMouseInput.getMultiplayerButtonClicked())
		{
			g.drawImage(texmenu.multiplayerbuttonclicked, multiplayerButton.x, multiplayerButton.y, null);
		}
		else if(MainMenuMouseInput.getMultiplayerButtonHovered())
		{
			g.drawImage(texmenu.multiplayerbuttonhovered, multiplayerButton.x, multiplayerButton.y, null);
		}
		else
		{
			g.drawImage(texmenu.multiplayerbuttonnormal, multiplayerButton.x, multiplayerButton.y, null);
		}
		// MASTERIES BUTTON GRAPHICS
		if(MainMenuMouseInput.getMasteriesButtonClicked())
		{
			g.drawImage(texmenu.masteriesbuttonclicked, masteriesButton.x, masteriesButton.y, null);
		}
		else if(MainMenuMouseInput.getMasteriesButtonHovered())
		{
			g.drawImage(texmenu.masteriesbuttonhovered, masteriesButton.x, masteriesButton.y, null);
		}
		else
		{
			g.drawImage(texmenu.masteriesbuttonnormal, masteriesButton.x, masteriesButton.y, null);
		}
		// STORE BUTTON GRAPHICS
		if(MainMenuMouseInput.getStoreButtonClicked())
		{
			g.drawImage(texmenu.storebuttonclicked, storeButton.x, storeButton.y, null);
		}
		else if(MainMenuMouseInput.getStoreButtonHovered())
		{
			g.drawImage(texmenu.storebuttonhovered, storeButton.x, storeButton.y, null);
		}
		else
		{
			g.drawImage(texmenu.storebuttonnormal, storeButton.x, storeButton.y, null);
		}
		// QUIT BUTTON GRAPHICS
		if(MainMenuMouseInput.getQuitButtonClicked())
		{
			g.drawImage(texmenu.quitbuttonclicked, quitButton.x, quitButton.y, null);
		}
		else if(MainMenuMouseInput.getQuitButtonHovered())
		{
			g.drawImage(texmenu.quitbuttonhovered, quitButton.x, quitButton.y, null);
		}
		else
		{
			g.drawImage(texmenu.quitbuttonnormal, quitButton.x, quitButton.y, null);
		}	
				
	
	}
	
}

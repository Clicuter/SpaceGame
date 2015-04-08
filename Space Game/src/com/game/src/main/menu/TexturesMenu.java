package com.game.src.main.menu;

import java.awt.image.BufferedImage;

import com.game.src.main.Game;
import com.game.src.main.SpriteSheet;

public class TexturesMenu {

	public BufferedImage playbuttonnormal, playbuttonhovered, playbuttonclicked, quitbuttonnormal, quitbuttonhovered, quitbuttonclicked;
	public BufferedImage storebuttonnormal, storebuttonhovered, storebuttonclicked, masteriesbuttonnormal, masteriesbuttonhovered, masteriesbuttonclicked;
	public BufferedImage multiplayerbuttonnormal, multiplayerbuttonhovered, multiplayerbuttonclicked;
	private SpriteSheet mb;
	
	public TexturesMenu(Game game)
	{
		mb = new SpriteSheet(game.getMenuButtons());
		
		getTextures();
	}
	
	private void getTextures()
	{
		// COLUMN BY ROW
		playbuttonnormal = mb.grabImage(1, 1, 192, 48);
		playbuttonhovered = mb.grabImage(7, 1, 192, 48);
		playbuttonclicked = mb.grabImage(13, 1, 192, 48);
		quitbuttonnormal = mb.grabImage(1, 3, 192, 48);
		quitbuttonhovered = mb.grabImage(7, 3, 192, 48);
		quitbuttonclicked = mb.grabImage(13, 3, 192, 48);
		storebuttonnormal = mb.grabImage(1, 5, 192, 48);
		storebuttonhovered = mb.grabImage(7, 5, 192, 48);
		storebuttonclicked = mb.grabImage(13, 5, 192, 48);
		masteriesbuttonnormal = mb.grabImage(1, 7, 192, 48);
		masteriesbuttonhovered = mb.grabImage(7, 7, 192, 48);
		masteriesbuttonclicked = mb.grabImage(13, 7, 192, 48);
		multiplayerbuttonnormal = mb.grabImage(1, 9, 192, 48);
		multiplayerbuttonhovered = mb.grabImage(7, 9, 192, 48);
		multiplayerbuttonclicked = mb.grabImage(13, 9, 192, 48);
	}
	
}

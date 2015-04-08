package com.game.src.main;

import java.awt.image.BufferedImage;

public class Textures {

	public BufferedImage player, missile, enemy, enemy2, enemy3, enemy4, enemy5, enemy6, scattershot, player_damaged, laser, rocket, enemyzigzag, enemyzigzag2, dropmissile, dropscattershot, droplaser, droprocket;
	public BufferedImage powerupshield, powerupfirerate, powerupstopwatch, powerupspeed, playershield, playerspeed, playerstopwatch, playerfirerate;
	public BufferedImage enemyhuge, homebuttonnormal, homebuttonhovered, homebuttonclicked;
	public BufferedImage againbuttonnormal, againbuttonhovered, againbuttonclicked, lvl1;
	public BufferedImage lvl2, lvl3, lvl4, lvl5, lvl6, lvl7, lvl8, lvl9, lvl10;
	private SpriteSheet ss;
	
	public Textures(Game game)
	{
		ss = new SpriteSheet(game.getSpriteSheet());
		
		getTextures();
	}
	
	private void getTextures()
	{
		
		// COLUMN BY ROW
		player = ss.grabImage(1, 1, 32, 32);
		player_damaged = ss.grabImage(1, 2, 32, 32);
		missile = ss.grabImage(2, 1 ,32 ,32);
		scattershot = ss.grabImage(4, 1, 32, 32);
		laser = ss.grabImage(5, 1, 32, 32);
		rocket = ss.grabImage(7, 1, 32, 32);
		enemy = ss.grabImage(3, 1, 32, 32);
		enemy2 = ss.grabImage(3, 2, 32, 32);
		enemy3 = ss.grabImage(3, 3, 32, 32);
		enemy4 = ss.grabImage(3, 4, 32, 32);
		enemy5 = ss.grabImage(3, 5, 32, 32);
		enemy6 = ss.grabImage(3, 6, 32, 32);
		enemyzigzag = ss.grabImage(3, 7, 32, 32);
		enemyzigzag2 = ss.grabImage(3, 8, 32, 32);
		dropmissile = ss.grabImage(2, 2 ,32 ,32);
		dropscattershot = ss.grabImage(4, 2, 32, 32);
		droplaser = ss.grabImage(5, 2, 32, 32);
		droprocket = ss.grabImage(7, 2, 32, 32);
		powerupshield = ss.grabImage(4, 3, 32, 32);
		powerupfirerate = ss.grabImage(5, 3, 32, 32);
		powerupstopwatch = ss.grabImage(6, 3, 32, 32);
		powerupspeed = ss.grabImage(7, 3, 32, 32);
		playershield = ss.grabImage(1, 3, 32, 32);
		playerspeed = ss.grabImage(1, 4, 32, 32);
		playerstopwatch = ss.grabImage(1, 5, 32, 32);
		playerfirerate = ss.grabImage(1, 6, 32, 32);
		enemyhuge = ss.grabImage(4, 4, 64, 64);
		homebuttonnormal = ss.grabImage(1, 10, 48, 48);
		homebuttonhovered = ss.grabImage(1, 12, 48, 48);
		homebuttonclicked = ss.grabImage(1, 14, 48, 48);
		againbuttonnormal = ss.grabImage(3, 10, 100, 48);
		againbuttonhovered = ss.grabImage(3, 12, 100, 48);
		againbuttonclicked = ss.grabImage(3, 14, 100, 48);
		lvl1 = ss.grabImage(7, 15, 32, 32);
		lvl2 = ss.grabImage(8, 15, 32, 32);
		lvl3 = ss.grabImage(9, 15, 32, 32);
		lvl4 = ss.grabImage(10, 15, 32, 32);
		lvl5 = ss.grabImage(11, 15, 32, 32);
		lvl6 = ss.grabImage(12, 15, 32, 32);
		lvl7 = ss.grabImage(13, 15, 32, 32);
		lvl8 = ss.grabImage(14, 15, 32, 32);
		lvl9 = ss.grabImage(15, 15, 32, 32);
		lvl10 = ss.grabImage(16, 15, 32, 32);
		
	}
	
}

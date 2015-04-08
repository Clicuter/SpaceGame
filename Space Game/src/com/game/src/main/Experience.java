package com.game.src.main;

public class Experience {

	private static int expPercent; //AUTO RESET
	private static int tempExp; //AUTO RESET
	private static int experience; // NO RESET
	private static int level; // NO RESET
	private static int extraCoins; // AUTO RESET
	private static int startExp; // NO RESET
	private static int endExp; // NO RESET
	
	private Controller c;
	private Points points;
	private Coins coins;
	
	public Experience(Points points, Controller c, int experience, int level)
	{
		this.c = c;
		this.points = points;
		this.experience = experience;
		this.level = level;
		if(experience < 12000)
		{
			checkLevelUp();
		}
		startExp = 0;
		endExp = 300;
	}
	
	public void addExp()
	{
		tempExp = (((int)Points.getMeters() / 2) + c.getEnemiesKilled());
		experience += tempExp;
		checkLevelUp();
		updateExpPercent();
	}
	
	public void checkLevelUp()
	{
		if(experience >= 0 && experience < 300)
		{
			level = 1;
			startExp = 0;
			endExp = 300;
			//UPDATE MASTERIES
		}
		else if(experience >= 300 && experience < 800)
		{
			level = 2;
			startExp = 300;
			endExp = 800;
		}
		else if(experience >= 800 && experience < 1500)
		{
			level = 3;
			startExp = 800;
			endExp = 1500;
		}
		else if(experience >= 1500 && experience < 2400)
		{
			level = 4;
			startExp = 1500;
			endExp = 2400;
		}
		else if(experience >= 2400 && experience < 3500)
		{
			level = 5;
			startExp = 2400;
			endExp = 3500;
		}
		else if(experience >= 3500 && experience < 4800)
		{
			level = 6;
			startExp = 3500;
			endExp = 4800;
		}
		else if(experience >= 4800 && experience < 6300)
		{
			level = 7;
			startExp = 4800;
			endExp = 6300;
		}
		else if(experience >= 6300 && experience < 8000)
		{
			level = 8;
			startExp = 6300;
			endExp = 8000;
		}
		else if(experience >= 8000 && experience < 9900)
		{
			level = 9;
			startExp = 8000;
			endExp = 9900;
		}
		else if(experience >= 9900 && experience < 12000)
		{
			level = 10;
			startExp = 9900;
			endExp = 12000;
		}
		else if(experience > 12000)
		{
			level = 10;
			startExp = 12000;
			endExp = 130000;
			extraCoins = ((experience - 12000) / 5);
			experience = 12000;
			//UPDATE TEMPCOIN VARIABLE
		}
	}
	public static int getExpPercent()
	{
		return expPercent;
	}
	public static void updateExpPercent()
	{
		expPercent = (int)((((experience - startExp)* 100)/(endExp - startExp)) * 1.3);
	}
	public static int getExtraCoins()
	{
		return extraCoins; 
	}
	public static int getTempExp()
	{
		return tempExp;
	}
	public static int getTotalExp()
	{
		return experience;
	}
	public static int getLevel()
	{
		return level;
	}
	public static void updateStoredVars()
	{
		FileHandler.experience = experience;
		FileHandler.level = level;
	}
}

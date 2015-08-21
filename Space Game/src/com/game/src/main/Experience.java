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
		else if(experience >= 12000 && experience < 14300)
		{
			level = 11;
			startExp = 12000;
			endExp = 14300;
		}
		else if(experience >= 14300 && experience < 16800)
		{
			level = 12;
			startExp = 14300;
			endExp = 16800;
		}
		else if(experience >= 16800 && experience < 19500)
		{
			level = 13;
			startExp = 16800;
			endExp = 19500;
		}
		else if(experience >= 19500 && experience < 22400)
		{
			level = 14;
			startExp = 19500;
			endExp = 22400;
		}
		else if(experience >= 22400 && experience < 25500)
		{
			level = 15;
			startExp = 22400;
			endExp = 25600;
		}
		else if(experience >= 25500 && experience < 28800)
		{
			level = 16;
			startExp = 25600;
			endExp = 28800;
		}
		else if(experience >= 28800 && experience < 32300)
		{
			level = 17;
			startExp = 28800;
			endExp = 32300;
		}
		else if(experience >= 32300 && experience < 36000)
		{
			level = 18;
			startExp = 32300;
			endExp = 36000;
		}
		else if(experience >= 36000 && experience < 40000)
		{
			level = 19;
			startExp = 36000;
			endExp = 40000;
		}
		else if(experience >= 40000)
		{
			level = 20;
			startExp = 40000;
			endExp = 40001;
			extraCoins = ((experience - 40000) / 5);
			experience = 40001;
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

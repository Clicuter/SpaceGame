package com.game.src.main;

public class Coins {

	private Controller c;
	private Mastery mastery;
	
	private static int savedCoins;
	private static int currentCoins;
	private static int gainedCoins;
	
	public Coins(Controller c, int savedCoins)
	{
		this.c = c;
		this.savedCoins = savedCoins;
		currentCoins = this.savedCoins;
		gainedCoins = 0;
	}
	
	public void setGainedCoins()
	{
		gainedCoins += (int)((double)((((int)(Points.getMeters()/10)) + c.getEnemiesKilled()) + Experience.getExtraCoins())*mastery.getExtraCoinsMultiplier());
	}
	public void setGainedCoins(int coins)
	{
		gainedCoins += coins;
		updateCoins();
	}
	
	public void updateCoins()
	{
		currentCoins += gainedCoins;
		gainedCoins = 0;
		
		
	}
	
	public static int getGainedCoins()
	{
		return gainedCoins;
	}
	public static int getCurrentCoins()
	{
		return currentCoins;
	}
	public static void updateSavedCoins()
	{
		FileHandler.coins = currentCoins;
		savedCoins = currentCoins;
	}
	public void addMastery(Mastery mastery)
	{
		this.mastery = mastery;
	}
	
}

package com.game.src.main;

import java.awt.Graphics;

public class PowerUps {
	
	private powerUpFireRate powerupfirerate;
	private powerUpStopwatch powerupstopwatch;
	private powerUpSpeed powerupspeed;
	private powerUpShield powerupshield;
/*
	private static double fireRateMultiplier;
	private static double speedMultiplier;
	private static double enemySpeedMultiplier;
	private static boolean powerUpfireRate;
	private static boolean powerUpSpeed;
	private static boolean powerUpEnemySpeed;
	private static boolean powerUpShield;
	private static boolean powerUpActive;
	private static int powerUpType;
*/
	
	public PowerUps(powerUpFireRate powerupfirerate, powerUpStopwatch powerupstopwatch, powerUpSpeed powerupspeed, powerUpShield powerupshield)
	{
		this.powerupfirerate = powerupfirerate;
		this.powerupstopwatch = powerupstopwatch;
		this.powerupspeed = powerupspeed;
		this.powerupshield = powerupshield;
		/*
		fireRateMultiplier = 1;
		speedMultiplier = 1;
		enemySpeedMultiplier = 1;
		*/
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		
	}
	
	public void powerUpPickup(int powerUpType)
	{
		System.out.println(powerUpType);
		if(powerUpType == 5)
		{
			if(powerupshield.getAvailable() == false && powerupfirerate.getAvailable() == false && powerupstopwatch.getAvailable() == false && powerupspeed.getAvailable() == false)
			{
				powerupshield.toggleUse();
			}
		}
		else if(powerUpType == 6)
		{
			if(powerupshield.getAvailable() == false && powerupfirerate.getAvailable() == false && powerupstopwatch.getAvailable() == false && powerupspeed.getAvailable() == false)
			{
				powerupfirerate.toggleUse();
			}
		}
		else if(powerUpType == 7)
		{
			if(powerupshield.getAvailable() == false && powerupfirerate.getAvailable() == false && powerupstopwatch.getAvailable() == false && powerupspeed.getAvailable() == false)
			{
				powerupstopwatch.toggleUse();
			}
		}
		else if(powerUpType == 8)
		{
			if(powerupshield.getAvailable() == false && powerupfirerate.getAvailable() == false && powerupstopwatch.getAvailable() == false && powerupspeed.getAvailable() == false)
			{
				powerupspeed.toggleUse();
			}
		}
	/*	if(powerUpType == 5) //SHIELD
		{
			if(powerUpShield.available == false && powerupfirerate.available == false && powerUpStopwatch.available == false && powerUpSpeed.available == false)
			{
				powerUpShield.enableUse();
			}
		}
		if(powerUpType == 6) //FIRERATE
		{
			if(powerUpShield.available == false && powerupfirerate.available == false && powerUpStopwatch.available == false && powerUpSpeed.available == false)
			{
				powerUpFireRate.enableUse();;
			}
		}
		if(powerUpType == 7) //STOPWATCH
		{
			if(powerUpShield.available == false && powerupfirerate.available == false && powerUpStopwatch.available == false && powerUpSpeed.available == false)
			{
				powerUpSpeed.enableUse();
			}
		}
		if(powerUpType == 8) //SPEED
		{
			if(powerUpShield.available == false && powerupfirerate.available == false && powerUpStopwatch.available == false && powerUpSpeed.available == false)
			{
				powerUpSpeed.enableUse();
			}
		}
		*/
	}
}

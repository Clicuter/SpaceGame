package com.game.src.main;

import java.io.IOException;

public class Mastery {

	private double masteryPoints, usedMasteryPoints, unusedMasteryPoints, damagePoints, defensePoints, utilityPoints;
	private double fireRateMultiplier, fireRateCounter, fireRatePowerUpBonus, fireRatePowerUpCounter, blastRadiusMultiplier, blastRadiusCounter, bonusDamage, bonusDamageCounter;
	private double enemySpeedCounter, postDamageUnkillableBonus, postDamageUnkillableCounter, shieldPowerUpBonus, shieldPowerUpCounter, gainLivesMultiplier, gainLivesCounter;
	private double speedMultiplier, speedCounter, speedPowerUpBonus, speedPowerUpCounter, powerUpDropRateMultiplier, powerUpDropRateCounter, extraCoinsMultiplier, extraCoinsCounter;
	private double fireRateCost, fireRatePowerUpCost, blastRadiusCost, bonusDamageCost, enemySpeedCost, postDamageUnkillableCost, shieldPowerUpCost, gainLivesCost, speedCost, speedPowerUpCost, powerUpDropRateCost, extraCoinsCost;
	private static double enemySpeedMultiplier;
	private Coins coins;
	private FileHandler filehandler;
	public Mastery (FileHandler filehandler)
	{
		this.filehandler = filehandler;
		loadPoints();
	}
	public void loadPoints()
	{
		fireRateCounter = FileHandler.fireRateCounter;
		fireRatePowerUpCounter = FileHandler.fireRatePowerUpCounter;
		blastRadiusCounter = FileHandler.blastRadiusCounter;
		bonusDamageCounter = FileHandler.bonusDamageCounter;
		enemySpeedCounter = FileHandler.enemySpeedCounter;
		postDamageUnkillableCounter = FileHandler.postDamageUnkillableCounter;
		shieldPowerUpCounter = FileHandler.shieldPowerUpCounter;
		gainLivesCounter = FileHandler.gainLivesCounter;
		speedCounter = FileHandler.speedCounter;
		speedPowerUpCounter = FileHandler.speedPowerUpCounter;
		powerUpDropRateCounter = FileHandler.powerUpDropRateCounter;
		extraCoinsCounter = FileHandler.extraCoinsCounter;
		updatePoints();
		updateBonuses();
	}
	public void updatePoints()
	{
		masteryPoints = (Experience.getLevel() - 1);
		damagePoints = (fireRateCounter + fireRatePowerUpCounter + blastRadiusCounter + bonusDamageCounter);
		defensePoints = (enemySpeedCounter + postDamageUnkillableCounter + shieldPowerUpCounter + gainLivesCounter);
		utilityPoints = (speedCounter + speedPowerUpCounter + powerUpDropRateCounter + extraCoinsCounter);
		usedMasteryPoints = (damagePoints + defensePoints + utilityPoints);
		unusedMasteryPoints = (masteryPoints - usedMasteryPoints);
	}
	public void updateBonuses()
	{
		updateSpeedMultiplier(0);
		updateSpeedPowerUpBonus(0);
		updatePowerUpDropRateMultiplier(0);
		updateExtraCoinsMultiplier(0);
		
		updateFireRateMultiplier(0);
		updateFireRatePowerUpBonus(0);
		
		
		updateBlastRadiusMultiplier(0);
		updateBonusDamage(0);
		
		updateEnemySpeedMultiplier(0);
		updatePostDamageUnkillableBonus(0);
		updateShieldPowerUpBonus(0);
		updateGainLivesMultiplier(0);
	}
	////////////////////////////////////////////// UTILITY
	public void updateSpeedMultiplier(int counter)
	{
		System.out.println("speedCounter called!");
		if(counter != 0 && speedCounter < 6 && Coins.getCurrentCoins() >= speedCost && unusedMasteryPoints > 0)
		{
		speedCounter += counter;
		coins.setGainedCoins(((int)speedCost) * -1);
		savePoints();
		}
		speedMultiplier = 1 + (.06 * speedCounter);
		speedCost = 50 + (25*speedCounter);
		updatePoints();
	}
	public double getSpeedMultiplier()
	{
		return speedMultiplier;
	}
	public int getSpeedCounter()
	{
		return (int) speedCounter;
	}
	public void updateSpeedPowerUpBonus(int counter)
	{
		System.out.println("speedPowerUpCounter called!");
		if(counter != 0 && speedPowerUpCounter < 6 && Coins.getCurrentCoins() >= speedPowerUpCost && unusedMasteryPoints > 0 && utilityPoints >= 6)
		{
			speedPowerUpCounter += counter;
			coins.setGainedCoins(((int)speedPowerUpCost) * -1);
			savePoints();
		}
		speedPowerUpBonus = speedPowerUpCounter;
		speedPowerUpCost = 500 + (100*speedPowerUpCounter);
		updatePoints();
	}
	public double getSpeedPowerUpBonus()
	{
		return speedPowerUpBonus;
	}
	public int getSpeedPowerUpCounter()
	{
		return (int) speedPowerUpCounter;
	}
	public void updatePowerUpDropRateMultiplier(int counter)
	{
		System.out.println("powerUpDropRateCounter called!");
		if(counter != 0 && powerUpDropRateCounter < 6 && Coins.getCurrentCoins() >= powerUpDropRateCost && unusedMasteryPoints > 0 && utilityPoints >= 12)
		{
			powerUpDropRateCounter += counter;
			coins.setGainedCoins(((int)powerUpDropRateCost) * -1);
			savePoints();
		}
		powerUpDropRateMultiplier = 1 + (.1 * powerUpDropRateCounter);
		powerUpDropRateCost = 1500 + (500*powerUpDropRateCounter);
		updatePoints();
	}
	public double getPowerUpDropRateMultiplier()
	{
		return powerUpDropRateMultiplier;
	}
	public int getPowerUpDropRateCounter()
	{
		return (int) powerUpDropRateCounter;
	}
	public void updateExtraCoinsMultiplier(int counter)
	{
		System.out.println("extraCoinsCounter called!");
		if(counter != 0 && extraCoinsCounter < 1 && Coins.getCurrentCoins() >= extraCoinsCost && unusedMasteryPoints > 0 && utilityPoints >= 18)
		{
			extraCoinsCounter += counter;
			coins.setGainedCoins(((int)extraCoinsCost) * -1);
			savePoints();
		}
		extraCoinsMultiplier = 1 + (.25 * extraCoinsCounter);
		extraCoinsCost = 15000;
		updatePoints();
	}
	public double getExtraCoinsMultiplier()
	{
		return extraCoinsMultiplier;
	}
	public int getExtraCoinsCounter()
	{
		return (int) extraCoinsCounter;
	}
	////////////////////////////////////////////// UTILITY
	////////////////////////////////////////////// DAMAGE
	public void updateFireRateMultiplier(int counter)
	{
		System.out.println("fireRateCounter called!");
		if(counter != 0 && fireRateCounter < 6 && Coins.getCurrentCoins() >= fireRateCost && unusedMasteryPoints > 0)
		{
			fireRateCounter += counter;
			coins.setGainedCoins(((int)fireRateCost) * -1);
			savePoints();
		}
		fireRateMultiplier = 1 - (.04 * fireRateCounter);
		fireRateCost = 50 + (25*fireRateCounter);
		updatePoints();
	}
	public double getFireRateMultiplier()
	{
		return fireRateMultiplier;
	}
	public int getFireRateCounter()
	{
		return (int) fireRateCounter;
	}
	public void updateFireRatePowerUpBonus(int counter)
	{
		System.out.println("fireRatePowerUpCounter called!");
		if(counter != 0 && fireRatePowerUpCounter < 6 && Coins.getCurrentCoins() >= fireRatePowerUpCost && unusedMasteryPoints > 0 && damagePoints >= 6)
		{
			fireRatePowerUpCounter += counter;
			coins.setGainedCoins(((int)fireRatePowerUpCost) * -1);
			savePoints();
		}
		fireRatePowerUpBonus = fireRatePowerUpCounter;
		fireRateCost = 500 + (100*fireRatePowerUpCounter);
		updatePoints();
	}
	public double getFireRatePowerUpBonus()
	{
		return fireRatePowerUpBonus;
	}
	public int getFireRatePowerUpCounter()
	{
		return (int) fireRatePowerUpCounter;
	}
	public void updateBlastRadiusMultiplier(int counter)
	{
		System.out.println("blastRadiusCounter called!");
		if(counter != 0 && blastRadiusCounter < 6 && Coins.getCurrentCoins() >= blastRadiusCost && unusedMasteryPoints > 0 && damagePoints >= 12)
		{
			blastRadiusCounter += counter;
			coins.setGainedCoins(((int)blastRadiusCost) * -1);
			savePoints();
		}
		blastRadiusMultiplier = 1 + (.02 * blastRadiusCounter);
		blastRadiusCost = 1500 + (500*blastRadiusCounter);
		updatePoints();
	}
	public double getBlastRadiusMultiplier()
	{
		return blastRadiusMultiplier;
	}
	public int getBlastRadiusCounter()
	{
		return (int) blastRadiusCounter;
	}
	public void updateBonusDamage(int counter)
	{
		System.out.println("bonusDamage called!");
		if(counter != 0 && bonusDamageCounter < 1 && Coins.getCurrentCoins() >= bonusDamageCost && unusedMasteryPoints > 0 && damagePoints >= 18)
		{
			bonusDamageCounter += counter;
			coins.setGainedCoins(((int)bonusDamageCost) * -1);
			savePoints();
		}
		bonusDamage = bonusDamageCounter;
		bonusDamageCost = 15000;
		updatePoints();
	}
	public double getBonusDamage()
	{
		return bonusDamage;
	}
	public int getBonusDamageCounter()
	{
		return (int) bonusDamageCounter;
	}
	////////////////////////////////////////////// DAMAGE
	////////////////////////////////////////////// DEFENSE
	public void updateEnemySpeedMultiplier(int counter)
	{
		System.out.println("enemySpeedCounter called!");
		if(counter != 0 && enemySpeedCounter < 6 && Coins.getCurrentCoins() >= enemySpeedCost && unusedMasteryPoints > 0)
		{
			enemySpeedCounter += counter;
			coins.setGainedCoins(((int)enemySpeedCost) * -1);
			savePoints();
		}
		enemySpeedMultiplier = 1 - (.03 * enemySpeedCounter);
		enemySpeedCost = 50 + (25*enemySpeedCounter);
		updatePoints();
	}
	public static double getEnemySpeedMultiplier()
	{
		return enemySpeedMultiplier;
	}
	public int getEnemySpeedCounter()
	{
		return (int) enemySpeedCounter;
	}
	public void updatePostDamageUnkillableBonus(int counter)
	{
		System.out.println("postDamageUnkillableCounter called!");
		if(counter != 0 && postDamageUnkillableCounter < 6 && Coins.getCurrentCoins() >= postDamageUnkillableCost && unusedMasteryPoints > 0 && defensePoints >= 6)
		{
			postDamageUnkillableCounter += counter;
			coins.setGainedCoins(((int)postDamageUnkillableCost) * -1);
			savePoints();
		}
		postDamageUnkillableBonus = (postDamageUnkillableCounter * .5);
		postDamageUnkillableCost = 500 + (100*postDamageUnkillableCounter);
		updatePoints();
	}
	public double getPostDamageUnkillableBonus()
	{
		return postDamageUnkillableBonus;
	}
	public int getPostDamageUnkillableCounter()
	{
		return (int) postDamageUnkillableCounter;
	}
	public void updateShieldPowerUpBonus(int counter)
	{
		System.out.println("shieldPowerUpCounter called!");
		if(counter != 0 && shieldPowerUpCounter < 6 && Coins.getCurrentCoins() >= shieldPowerUpCost && unusedMasteryPoints > 0 && defensePoints >= 12)
		{
			shieldPowerUpCounter += counter;
			coins.setGainedCoins(((int)shieldPowerUpCost) * -1);
			savePoints();
		}
		shieldPowerUpBonus = shieldPowerUpCounter;
		shieldPowerUpCost = 1500 + (500*shieldPowerUpCounter);
		updatePoints();
	}
	public double getShieldPowerUpBonus()
	{
		return shieldPowerUpBonus;
	}
	public int getShieldPowerUpCounter()
	{
		return (int) shieldPowerUpCounter;
	}
	public void updateGainLivesMultiplier(int counter)
	{
		System.out.println("gainLivesCounter called!");
		if(counter != 0 && gainLivesCounter < 1 && Coins.getCurrentCoins() >= gainLivesCost && unusedMasteryPoints > 0 && defensePoints >= 18)
		{
			gainLivesCounter += counter;
			coins.setGainedCoins(((int)gainLivesCost) * -1);
			savePoints();
		}
		gainLivesMultiplier = (0.8 * gainLivesCounter);
		gainLivesCost = 15000;
		updatePoints();
	}
	public double getGainLivesMultiplier()
	{
		return gainLivesMultiplier;
	}
	public int getGainLivesCounter()
	{
		return (int) gainLivesCounter;
	}
	public void resetButton()
	{
		if(Coins.getCurrentCoins() >= 2000 && usedMasteryPoints != 0)
		{
		System.out.println(usedMasteryPoints);
		coins.setGainedCoins(-2000);
		speedCounter = speedPowerUpCounter = powerUpDropRateCounter = extraCoinsCounter = bonusDamageCounter = blastRadiusCounter = fireRatePowerUpCounter = fireRateCounter = enemySpeedCounter = postDamageUnkillableCounter = shieldPowerUpCounter = gainLivesCounter = 0;
		updatePoints();
		updateBonuses();
		savePoints();
		}
	}
	public int getMasteryPoints()
	{
		return (int) masteryPoints;
	}
	public int getUnusedMasteryPoints()
	{
		return (int) unusedMasteryPoints;
	}
	////////////////////////////////////////////// DEFENSE
	public void addCoins(Coins coins)
	{
		this.coins = coins;
	}
	public void savePoints()
	{
		Coins.updateSavedCoins();
		FileHandler.speedCounter = (int) speedCounter;
		FileHandler.speedPowerUpCounter = (int) speedPowerUpCounter;
		FileHandler.powerUpDropRateCounter = (int) powerUpDropRateCounter;
		FileHandler.extraCoinsCounter = (int) extraCoinsCounter;
		FileHandler.bonusDamageCounter = (int) bonusDamageCounter;
		FileHandler.blastRadiusCounter = (int) blastRadiusCounter;
		FileHandler.fireRatePowerUpCounter = (int) fireRatePowerUpCounter;
		FileHandler.fireRateCounter = (int) fireRateCounter;
		FileHandler.enemySpeedCounter = (int) enemySpeedCounter;
		FileHandler.postDamageUnkillableCounter = (int) postDamageUnkillableCounter;
		FileHandler.shieldPowerUpCounter = (int) shieldPowerUpCounter;
		FileHandler.gainLivesCounter = (int) gainLivesCounter;
		FileHandler.mastery = (int) masteryPoints;
				
		try {
			filehandler.storeInfo();
		} catch (IOException e) {
			e.printStackTrace();
	}
		
	}
	
	
	
}

/* IMPLEMENTING MASTERIES:
- Load Masteries From Text File:
	- Count individual Masteries
	- Count points per "Mastery Tree"
	- Store/Load From Data Text File
- Variables:
	- Mastery Points
	- Unused, Used Mastery Points
	- Damage, Defense, Utility Mastery Points
	- Damage:
		- FireRate Multiplier (0-6) *** frMultiplier, frCounter					*Created && Implemented
		- FireRate PowerUp ExtraTime (0-6) *** frpBonus, frpCounter				*Created && Implemented
		- Increase Rocket Blast Radius (0-6) *** brMultiplier, brCounter		*Created // NOT POSSIBLE YET
		- Damage +1 (1) *** bonusDamage, bonusDamageCounter						*Created && Implemented
	- Defense:
		- EnemySpeed Reduction Multiplier(0-6) *** eprMultiplier, eprCounter	*Created && Implemented
		- PostDamageUnKillable Time Bonus (0-6) *** pduBonus, pduCounter		*Created && Implemented
		- Shield PowerUp ExtraTime (0-6) *** spBonus, spCounter					*Created && Implemented
		- Gain Lives 20% Faster (1) *** glMultiplier, glCounter					*Created && Implemented
	- Utility:
		- Speed Multiplier (0-6) *** sMultiplier, sCounter						*Created && Implemented
		- Speed PowerUp ExtraTime (0-6) *** spBonus, spCounter					*Created && Implemented
		- PowerUp DropRate Multiplier (0-6) *** pdrMultiplier, pdrCounter		*Created && Implemented
		- Gain 25% More Coins (1) *** xcMultiplier, xcCounter					*Created && Implemented
		
- Methods:
	- Level Up -> +1 Mastery Point || Mastery Points = Level - 1
	- Unused == Mastery Points - Used MP <= Mastery Points
	- Load Counter from FileHandler
	- Save Counter to FileHandler
	- Update Multipliers & Bonuses with Counters



*/
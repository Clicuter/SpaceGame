package com.game.src.main;

public class Mastery {

	private double masteryPoints, usedMasteryPoints, unusedMasteryPoints, damagePoints, defensePoints, utilityPoints;
	private double fireRateMultiplier, fireRateCounter, fireRatePowerUpBonus, fireRatePowerUpCounter, blastRadiusMultiplier, blastRadiusCounter, bonusDamage, bonusDamageCounter;
	private double enemySpeedCounter, postDamageUnkillableBonus, postDamageUnkillableCounter, shieldPowerUpBonus, shieldPowerUpCounter, gainLivesMultiplier, gainLivesCounter;
	private double speedMultiplier, speedCounter, speedPowerUpBonus, speedPowerUpCounter, powerUpDropRateMultiplier, powerUpDropRateCounter, extraCoinsMultiplier, extraCoinsCounter;
	private double fireRateCost, fireRatePowerUpCost, blastRadiusCost, bonusDamageCost, enemySpeedCost, postDamageUnkillableCost, shieldPowerUpCost, gainLivesCost, speedCost, speedPowerUpCost, powerUpDropRateCost, extraCoinsCost;
	private static double enemySpeedMultiplier;
	private Coins coins;
	public Mastery ( )
	{
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
		
		System.out.println(speedMultiplier);
	}
	////////////////////////////////////////////// UTILITY
	public void updateSpeedMultiplier(int counter)
	{
		if(counter != 0 && speedCounter < 6 && Coins.getCurrentCoins() >= speedCost && unusedMasteryPoints > 0)
		{
		speedCounter += counter;
		coins.setGainedCoins(((int)speedCost) * -1);
		}
		speedMultiplier = 1 + (.06 * speedCounter);
		speedCost = 50 + (25*counter);
		updatePoints();
	}
	public double getSpeedMultiplier()
	{
		return speedMultiplier;
	}
	public void updateSpeedPowerUpBonus(int counter)
	{
		if(counter != 0 && speedPowerUpCounter < 6 && Coins.getCurrentCoins() >= speedPowerUpCost && unusedMasteryPoints > 0)
		{
			speedPowerUpCounter += counter;
			coins.setGainedCoins(((int)speedPowerUpCost) * -1);
		}
		speedPowerUpBonus = speedPowerUpCounter;
		speedPowerUpCost = 500 + (100*counter);
		updatePoints();
	}
	public double getSpeedPowerUpBonus()
	{
		return speedPowerUpBonus;
	}
	public void updatePowerUpDropRateMultiplier(int counter)
	{
		if(counter != 0 && powerUpDropRateCounter < 6 && Coins.getCurrentCoins() >= powerUpDropRateCost && unusedMasteryPoints > 0)
		{
			powerUpDropRateCounter += counter;
			coins.setGainedCoins(((int)powerUpDropRateCost) * -1);
		}
		powerUpDropRateMultiplier = 1 + (.1 * powerUpDropRateCounter);
		powerUpDropRateCost = 1750 + (250*counter);
	}
	public double getPowerUpDropRateMultiplier()
	{
		return powerUpDropRateMultiplier;
	}
	public void updateExtraCoinsMultiplier(int counter)
	{
		if(counter != 0 && extraCoinsCounter < 1 && Coins.getCurrentCoins() >= extraCoinsCost && unusedMasteryPoints > 0)
		{
			extraCoinsCounter += counter;
			coins.setGainedCoins(((int)extraCoinsCost) * -1);
		}
		extraCoinsMultiplier = 1 + (.25 * extraCoinsCounter);
		extraCoinsCost = 10000;
	}
	public double getExtraCoinsMultiplier()
	{
		return extraCoinsMultiplier;
	}
	////////////////////////////////////////////// UTILITY
	////////////////////////////////////////////// DAMAGE
	public void updateFireRateMultiplier(int counter)
	{
		if(counter != 0 && fireRateCounter < 6 && Coins.getCurrentCoins() >= fireRateCost && unusedMasteryPoints > 0)
		{
			fireRateCounter += counter;
			coins.setGainedCoins(((int)fireRateCost) * -1);
		}
		fireRateMultiplier = 1 - (.04 * fireRateCounter);
		fireRateCost = 50 + (25*fireRateCounter);
	}
	public double getFireRateMultiplier()
	{
		return fireRateMultiplier;
	}
	public void updateFireRatePowerUpBonus(int counter)
	{
		if(counter != 0 && fireRatePowerUpCounter < 6 && Coins.getCurrentCoins() >= fireRatePowerUpCost && unusedMasteryPoints > 0)
		{
			fireRatePowerUpCounter += counter;
			coins.setGainedCoins(((int)fireRatePowerUpCost) * -1);
		}
		fireRatePowerUpBonus = fireRatePowerUpCounter;
		fireRateCost = 500 + (100*fireRatePowerUpCounter);
	}
	public double getFireRatePowerUpBonus()
	{
		return fireRatePowerUpBonus;
	}
	public void updateBlastRadiusMultiplier(int counter)
	{
		if(counter != 0 && blastRadiusCounter < 6 && Coins.getCurrentCoins() >= blastRadiusCost && unusedMasteryPoints > 0)
		{
			blastRadiusCounter += counter;
			coins.setGainedCoins(((int)blastRadiusCost) * -1);
		}
		blastRadiusMultiplier = 1 + (.02 * blastRadiusCounter);
		blastRadiusCost = 1750 + (250*blastRadiusCounter);
	}
	public double getBlastRadiusMultiplier()
	{
		return blastRadiusMultiplier;
	}
	public void updateBonusDamage(int counter)
	{
		if(counter != 0 && bonusDamageCounter < 1 && Coins.getCurrentCoins() >= bonusDamageCost && unusedMasteryPoints > 0)
		{
			bonusDamageCounter += counter;
			coins.setGainedCoins(((int)bonusDamageCost) * -1);
		}
		bonusDamage = bonusDamageCounter;
		bonusDamageCost = 10000;
	}
	public double getBonusDamage()
	{
		return bonusDamage;
	}
	////////////////////////////////////////////// DAMAGE
	////////////////////////////////////////////// DEFENSE
	public void updateEnemySpeedMultiplier(int counter)
	{
		if(counter != 0 && enemySpeedCounter < 6 && Coins.getCurrentCoins() >= enemySpeedCost && unusedMasteryPoints > 0)
		{
			enemySpeedCounter += counter;
			coins.setGainedCoins(((int)enemySpeedCost) * -1);
		}
		enemySpeedMultiplier = 1 - (.03 * enemySpeedCounter);
		enemySpeedCost = 50 + (25*enemySpeedCounter);
	}
	public static double getEnemySpeedMultiplier()
	{
		return enemySpeedMultiplier;
	}
	public void updatePostDamageUnkillableBonus(int counter)
	{
		if(counter != 0 && postDamageUnkillableCounter < 6 && Coins.getCurrentCoins() >= postDamageUnkillableCost && unusedMasteryPoints > 0)
		{
			postDamageUnkillableCounter += counter;
			coins.setGainedCoins(((int)postDamageUnkillableCost) * -1);
		}
		postDamageUnkillableBonus = (postDamageUnkillableCounter * .5);
		postDamageUnkillableCost = 500 + (100*postDamageUnkillableCounter);
	}
	public double getPostDamageUnkillableBonus()
	{
		return postDamageUnkillableBonus;
	}
	public void updateShieldPowerUpBonus(int counter)
	{
		if(counter != 0 && shieldPowerUpCounter < 6 && Coins.getCurrentCoins() >= shieldPowerUpCost && unusedMasteryPoints > 0)
		{
			shieldPowerUpCounter += counter;
			coins.setGainedCoins(((int)shieldPowerUpCost) * -1);
		}
		shieldPowerUpBonus = shieldPowerUpCounter;
		shieldPowerUpCost = 1750 + (250*shieldPowerUpCounter);
	}
	public double getShieldPowerUpBonus()
	{
		return shieldPowerUpBonus;
	}
	public void updateGainLivesMultiplier(int counter)
	{
		if(counter != 0 && gainLivesCounter < 1 && Coins.getCurrentCoins() >= gainLivesCost && unusedMasteryPoints > 0)
		{
			gainLivesCounter += counter;
			coins.setGainedCoins(((int)gainLivesCost) * -1);
		}
		gainLivesMultiplier = (0.8 * gainLivesCounter);
		gainLivesCost = 10000;
	}
	public double getGainLivesMultiplier()
	{
		return gainLivesMultiplier;
	}
	////////////////////////////////////////////// DEFENSE
	public void addCoins(Coins coins)
	{
		this.coins = coins;
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
package com.game.src.main.menu;

import com.game.src.main.Game;
import com.game.src.main.Game.STATE;
import com.game.src.main.Mastery;

public class MasteryButtonActionHandler {
	
	private Mastery mastery;
	
	public MasteryButtonActionHandler(Mastery mastery)
	{
		this.mastery = mastery;
	}
	
	public void masteryHandler(String actionKeyword)
	{
		switch(actionKeyword)
		{
		case "speed":
			mastery.updateSpeedMultiplier(1);
			break;
		case "speedpowerup":
			mastery.updateSpeedPowerUpBonus(1);
			break;
		case "powerupdroprate":
			mastery.updatePowerUpDropRateMultiplier(1);
			break;
		case "coins":
			mastery.updateExtraCoinsMultiplier(1);
			break;
		case "firerate":
			mastery.updateFireRateMultiplier(1);
			break;
		case "fireratepowerup":
			mastery.updateFireRatePowerUpBonus(1);
			break;
		case "blastradius":
			mastery.updateBlastRadiusMultiplier(1);
			break;
		case "damage":
			mastery.updateBonusDamage(1);
			break;
		case "enemyspeed":
			mastery.updateEnemySpeedMultiplier(1);
			break;
		case "unkillable":
			mastery.updatePostDamageUnkillableBonus(1);
			break;
		case "shieldpowerup":
			mastery.updateShieldPowerUpBonus(1);
			break;
		case "lives":
			mastery.updateGainLivesMultiplier(1);
			break;
		case "menu":
			Game.State = STATE.MENU;
			break;
		case "reset":
			mastery.resetButton();
			break;
		}
	}
}

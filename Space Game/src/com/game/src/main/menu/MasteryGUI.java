package com.game.src.main.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.game.src.main.Textures;
import com.game.src.main.Mastery;

public class MasteryGUI {

	private Textures tex;
	private Mastery mastery;
	private MasteryButtonActionHandler masterybuttonactionhandler;
	public MasteryButton speedButton, speedPowerUpButton, powerUpDropRateButton, coinsButton,fireRateButton, fireRatePowerUpButton, blastRadiusButton, bonusDamageButton, enemySpeedButton, unkillableButton, shieldPowerUpButton, gainLivesButton;
	public MasteryButton homeButton, resetButton;
	private Font masteryguifont;
	private Font masteryguifont2;
	private Font masteryguifont3;
	
	public MasteryGUI(Mastery mastery, Textures tex, MasteryButtonActionHandler masterybuttonactionhandler)
	{
		this.tex = tex;
		this.mastery = mastery;
		this.masterybuttonactionhandler = masterybuttonactionhandler;
		speedButton = new MasteryButton(tex.homebuttonnormal, tex.homebuttonhovered, tex.homebuttonclicked, 230, 125, 50, 50, "speed", masterybuttonactionhandler);
		speedPowerUpButton = new MasteryButton(tex.homebuttonnormal, tex.homebuttonhovered, tex.homebuttonclicked, 230, 190, 50, 50, "speedpowerup", masterybuttonactionhandler);
		powerUpDropRateButton = new MasteryButton(tex.homebuttonnormal, tex.homebuttonhovered, tex.homebuttonclicked, 230, 255, 50, 50, "powerupdroprate", masterybuttonactionhandler);
		coinsButton = new MasteryButton(tex.homebuttonnormal, tex.homebuttonhovered, tex.homebuttonclicked, 230, 320, 50, 50, "coins", masterybuttonactionhandler);
		fireRateButton = new MasteryButton(tex.homebuttonnormal, tex.homebuttonhovered, tex.homebuttonclicked, 350, 125, 50, 50, "firerate", masterybuttonactionhandler);
		fireRatePowerUpButton = new MasteryButton(tex.homebuttonnormal, tex.homebuttonhovered, tex.homebuttonclicked, 350, 190, 50, 50, "fireratepowerup", masterybuttonactionhandler);
		blastRadiusButton = new MasteryButton(tex.homebuttonnormal, tex.homebuttonhovered, tex.homebuttonclicked, 350, 255, 50, 50, "blastradius", masterybuttonactionhandler);
		bonusDamageButton = new MasteryButton(tex.homebuttonnormal, tex.homebuttonhovered, tex.homebuttonclicked, 350, 320, 50, 50, "damage", masterybuttonactionhandler);
		enemySpeedButton = new MasteryButton(tex.homebuttonnormal, tex.homebuttonhovered, tex.homebuttonclicked, 470, 125, 50, 50, "enemyspeed", masterybuttonactionhandler);
		unkillableButton = new MasteryButton(tex.homebuttonnormal, tex.homebuttonhovered, tex.homebuttonclicked, 470, 190, 50, 50, "unkillable", masterybuttonactionhandler);
		shieldPowerUpButton = new MasteryButton(tex.homebuttonnormal, tex.homebuttonhovered, tex.homebuttonclicked, 470, 255, 50, 50, "shieldpowerup", masterybuttonactionhandler);
		gainLivesButton = new MasteryButton(tex.homebuttonnormal, tex.homebuttonhovered, tex.homebuttonclicked, 470, 320, 50, 50, "lives", masterybuttonactionhandler);
		homeButton = new MasteryButton(tex.homebuttonnormal, tex.homebuttonhovered, tex.homebuttonclicked, 74, 310, 72, 72, "menu", masterybuttonactionhandler);
		resetButton = new MasteryButton(tex.homebuttonnormal, tex.homebuttonhovered, tex.homebuttonclicked, 57, 230, 110, 40, "reset", masterybuttonactionhandler);
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(30, 60, 160, 340);
		g.setColor(Color.white);
		g.fillRect(30, 60, 160, 40);
		g.setColor(Color.gray);
		g.fillRect(34, 64, 152, 32);
		g.setColor(Color.white);
		g.drawString("MASTERY PAGE", 68, 84);
		//UTILITY
		g.setColor(Color.gray);
		g.fillRect(210, 60, 90, 340);
		g.setColor(Color.green);
		g.fillRect(210, 60, 90, 40);
		g.setColor(Color.gray);
		g.fillRect(214, 64, 82, 32);
		g.setColor(Color.white);
		g.drawString("UTILITY", 234, 85);
		//UTILITY
		//DAMAGE
		g.setColor(Color.gray);
		g.fillRect(330, 60, 90, 340);
		g.setColor(Color.RED);
		g.fillRect(330, 60, 90, 40);
		g.setColor(Color.gray);
		g.fillRect(334, 64, 82, 32);
		g.setColor(Color.white);
		g.drawString("DAMAGE", 351, 85);
		//DAMAGE
		//DEFENSE
		g.setColor(Color.gray);
		g.fillRect(450, 60, 90, 340);
		g.setColor(Color.CYAN);
		g.fillRect(450, 60, 90, 40);
		g.setColor(Color.gray);
		g.fillRect(454, 64, 82, 32);
		g.setColor(Color.white);
		g.drawString("DEFENSE", 468, 85);
		//DEFENSE
		//EMBLEMS
		g.drawImage(tex.powerupshield, 478, 410, null);
		g.drawImage(tex.powerupfirerate, 358, 410, null);
		g.drawImage(tex.powerupspeed, 238, 410, null);
		//EMBLEMS
		speedButton.render(g);
		speedPowerUpButton.render(g);
		powerUpDropRateButton.render(g);
		coinsButton.render(g);
		fireRateButton.render(g);
		fireRatePowerUpButton.render(g);
		blastRadiusButton.render(g);
		bonusDamageButton.render(g);
		enemySpeedButton.render(g);
		unkillableButton.render(g);
		shieldPowerUpButton.render(g);
		gainLivesButton.render(g);
		homeButton.render(g);
		resetButton.render(g);
		g.setColor(Color.WHITE);
		
		g.drawString("6", 286, 170);
		g.drawString("6", 406, 170);
		g.drawString("6", 526, 170);
		
		g.drawString("_", 286, 156);
		g.drawString("_", 406, 156);
		g.drawString("_", 526, 156);
		
		g.drawString("" + mastery.getSpeedCounter(), 286, 154);
		g.drawString("" + mastery.getFireRateCounter(), 406, 154);
		g.drawString("" + mastery.getEnemySpeedCounter(), 526, 154);
		
		g.drawString("6", 286, 235);
		g.drawString("6", 406, 235);
		g.drawString("6", 526, 235);
		
		g.drawString("_", 286, 221);
		g.drawString("_", 406, 221);
		g.drawString("_", 526, 221);
		
		g.drawString("" + mastery.getSpeedPowerUpCounter(), 286, 219);
		g.drawString("" + mastery.getFireRatePowerUpCounter(), 406, 219);
		g.drawString("" + mastery.getPostDamageUnkillableCounter(), 526, 219);
		
		g.drawString("6", 286, 300);
		g.drawString("6", 406, 300);
		g.drawString("6", 526, 300);
		
		g.drawString("_", 286, 286);
		g.drawString("_", 406, 286);
		g.drawString("_", 526, 286);
		
		g.drawString("" + mastery.getPowerUpDropRateCounter(), 286, 284);
		g.drawString("" + mastery.getBlastRadiusCounter(), 406, 284);
		g.drawString("" + mastery.getShieldPowerUpCounter(), 526, 284);
		
		g.drawString("1", 286, 365);
		g.drawString("1", 406, 365);
		g.drawString("1", 526, 365);
		
		g.drawString("_", 286, 351);
		g.drawString("_", 406, 351);
		g.drawString("_", 526, 351);
		
		g.drawString("" + mastery.getExtraCoinsCounter(), 286, 349);
		g.drawString("" + mastery.getBonusDamageCounter(), 406, 349);
		g.drawString("" + mastery.getGainLivesCounter(), 526, 349);
		
		Font masteryguifont = new Font("arial", 20, 17);
		g.setFont(masteryguifont);
		g.drawString("REMAINING", 66, 140);
		g.drawString("MASTERY POINTS", 38, 160);
		g.setColor(Color.green);
		g.fillRect(34, 165, 152, 4);
		Font masteryguifont2 = new Font("arial", 20, 24);
		g.setFont(masteryguifont2);
		g.setColor(Color.black);
		g.drawString("" + mastery.getUnusedMasteryPoints(), 80, 196);
		g.drawString("/", 110, 196);
		g.drawString("" + mastery.getMasteryPoints(), 118, 196);
		
	}
	
}

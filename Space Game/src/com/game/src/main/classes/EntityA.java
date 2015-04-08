package com.game.src.main.classes;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.Experience;
import com.game.src.main.Mastery;
import com.game.src.main.powerUpFireRate;
import com.game.src.main.powerUpShield;
import com.game.src.main.powerUpSpeed;
import com.game.src.main.powerUpStopwatch;

public interface EntityA {

	public void tick();
	public void render(Graphics g);
	public Rectangle getBounds();
	
	public double getX();
	public double getY();
	
	
	public void moveRight(double moveRight);
	public void moveLeft(double moveLeft);
	public void moveUp(double moveUp);
	public void moveDown(double moveDown);
	public void addPowerUps(powerUpShield powerupshield, powerUpFireRate powerupfirerate, powerUpStopwatch powerupstopwatch, powerUpSpeed powerupspeed);
	public void addExperience(Experience exp);
	public void resetPlayer();
	
	public boolean checkDamaged();
	public void setInvulnerable();
	public void setHealth(int dmg);
	
	public void addMastery(Mastery mastery);
	
}

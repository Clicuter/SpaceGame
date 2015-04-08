package com.game.src.main;

import java.awt.Graphics;

public class Upgrades {

	private Controller c;
	private Textures tex;
	private PowerUps powerups;
	private Mastery mastery;
	
	private int bulletType;
	private int bulletLevel;
	
	private int fireRate;
	private int adjustedFireRate;
	private int dmg;
	private double ySpeed;
	private double xSpeed;
	
	public Upgrades(Controller c, Textures tex)
	{
		fireRate = 600;
		dmg = 1;
		this.tex = tex;
		this.c = c;
		bulletType = 1;
		bulletLevel = 1;
		ySpeed = -10;
		xSpeed = 0;
		
	}
	
	public void tick()
	{
		adjustedFireRate = (int)((double)fireRate * (powerUpFireRate.getMultiplier() * mastery.getFireRateMultiplier()));
	}
	public void render(Graphics g)
	{
		g.drawString("" + bulletLevel, 468, 25);
		if(bulletType == 1)
		{
			g.drawImage(tex.dropmissile, 430, 4, null);
		}
		if(bulletType == 2)
		{
			g.drawImage(tex.dropscattershot, 430, 4, null);
		}
		if(bulletType == 3)
		{
			g.drawImage(tex.droplaser, 430, 4, null);
		}
		if(bulletType == 4)
		{
			g.drawImage(tex.droprocket, 430, 4, null);
		}
	}
	
	public void bulletPickup(int bulletDropType)
	{
		if (bulletDropType == bulletType)
		{
			if(bulletLevel < 4)
			{
			bulletLevel++;
			}
			Bullet();
			ScatterShot();
			Laser();
			Rocket();
		}
		else if(bulletDropType == 1)
		{
			bulletType = 1;
			bulletLevel = 1;
			Bullet();
		}
		else if(bulletDropType == 2)
		{
			bulletType = 2;
			bulletLevel = 1;
			ScatterShot();
		}
		else if(bulletDropType == 3)
		{
			bulletType = 3;
			bulletLevel = 1;
			Laser();
		}
		else if(bulletDropType == 4)
		{
			bulletType = 4;
			bulletLevel = 1;
			Rocket();
		}
		else if(bulletDropType > 4)
		{
			System.out.println("Number Passed On");
			powerups.powerUpPickup(bulletDropType);
		}
	}
	
		public void Bullet()
		{
			if(bulletType == 1)
			{
			if (bulletLevel == 1)
			{
				fireRate = 600;
				dmg = 1 + (int)mastery.getBonusDamage();
				ySpeed = -10;
				xSpeed = 0;
			}
			else if(bulletLevel == 2)
			{
				fireRate = 550;
				dmg = 2 + (int)mastery.getBonusDamage();
				ySpeed = -10;
				xSpeed = 0;
			}
			else if(bulletLevel == 3)
			{
				fireRate = 500;
				dmg = 4 + (int)mastery.getBonusDamage();
				ySpeed = -10;
				xSpeed = 0;
			}
			else if(bulletLevel == 4)
			{
				fireRate = 450;
				dmg = 6 + (int)mastery.getBonusDamage();
				ySpeed = -10;
				xSpeed = 0;
			}
			}
		}
		public void ScatterShot()
		{
			if(bulletType == 2)
			{
			if (bulletLevel == 1)
			{
				fireRate = 800;
				dmg = 1 + (int)mastery.getBonusDamage();
				ySpeed = -10;
				xSpeed = 0;
			}
			else if(bulletLevel == 2)
			{
				fireRate = 775;
				dmg = 2 + (int)mastery.getBonusDamage();
				ySpeed = -8;
				xSpeed = 4;
			}
			else if(bulletLevel == 3)
			{
				fireRate = 775;
				dmg = 3 + (int)mastery.getBonusDamage();
				ySpeed = -8;
				xSpeed = 3;
			}
			else if(bulletLevel == 4)
			{
				fireRate = 750;
				dmg = 3 + (int)mastery.getBonusDamage();
				ySpeed = -8;
				xSpeed = 3;
			}
			}
		}
		public void Laser()
		{
			if(bulletType == 3)
			{
			if (bulletLevel == 1)
			{
				fireRate = 600;
				dmg = 1 + (int)mastery.getBonusDamage();
				ySpeed = -15;
				xSpeed = 0;
			}
			else if(bulletLevel == 2)
			{
				fireRate = 500;
				dmg = 2 + (int)mastery.getBonusDamage();
				ySpeed = -15;
				xSpeed = 0;
			}
			else if(bulletLevel == 3)
			{
				fireRate = 400;
				dmg = 3 + (int)mastery.getBonusDamage();
				ySpeed = -15;
				xSpeed = 0;
			}
			else if(bulletLevel == 4)
			{
				fireRate = 300;
				dmg = 4 + (int)mastery.getBonusDamage();
				ySpeed = -15;
				xSpeed = 0;
			}
			}
		}
		public void Rocket()
		{
			if(bulletType == 4)
			{
			if (bulletLevel == 1)
			{
				fireRate = 800;
				dmg = 2 + (int)mastery.getBonusDamage();
				ySpeed = -6;
				xSpeed = 0;
			}
			else if(bulletLevel == 2)
			{
				fireRate = 775;
				dmg = 4 + (int)mastery.getBonusDamage();
				ySpeed = -6;
				xSpeed = 0;
			}
			else if(bulletLevel == 3)
			{
				fireRate = 750;
				dmg = 6 + (int)mastery.getBonusDamage();
				ySpeed = -6;
				xSpeed = 0;
			}
			else if(bulletLevel == 4)
			{
				fireRate = 700;
				dmg = 10 + (int)mastery.getBonusDamage();
				ySpeed = -6;
				xSpeed = 0;
			}
			}
		}
		
		public void shootProjectile(double xpos, double ypos)
		{
			
			if(bulletType == 1)
			{
				shootBullet(xpos, ypos);
			}
			if(bulletType == 2)
			{
				shootScatterShot(xpos, ypos);
			}
			if(bulletType == 3)
			{
				shootLaser(xpos, ypos);
			}
			if(bulletType == 4)
			{
				shootRocket(xpos, ypos);
			}
			if(bulletType > 4)
			{
				powerups.powerUpPickup(bulletType);
			}
		}
		public void shootBullet(double xpos, double ypos)
		{
			if(bulletLevel == 1)
			{
				c.addEntity(new Bullet(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
			}
			if(bulletLevel == 2)
			{
				c.addEntity(new Bullet(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
			}
			if(bulletLevel == 3)
			{
				c.addEntity(new Bullet(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
			}
			if(bulletLevel == 4)
			{
				c.addEntity(new Bullet(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
			}
		}
		public void shootScatterShot(double xpos, double ypos)
		{
			if(bulletLevel == 1)
			{
				c.addEntity(new ScatterShot(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
			}
			if(bulletLevel == 2)
			{
				c.addEntity(new ScatterShot(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
				c.addEntity(new ScatterShot(xpos, ypos, tex, fireRate, dmg, ySpeed, (xSpeed*-1)));
			}
			if(bulletLevel == 3)
			{
				c.addEntity(new ScatterShot(xpos, ypos, tex, fireRate, dmg, ySpeed, 0));
				c.addEntity(new ScatterShot(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
				c.addEntity(new ScatterShot(xpos, ypos, tex, fireRate, dmg, ySpeed, (xSpeed*-1)));
			}
			if(bulletLevel == 4)
			{
				c.addEntity(new ScatterShot(xpos, ypos, tex, fireRate, dmg, ySpeed, 0));
				c.addEntity(new ScatterShot(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
				c.addEntity(new ScatterShot(xpos, ypos, tex, fireRate, dmg, ySpeed, (xSpeed*-1)));
			}
		}
		public void shootLaser(double xpos, double ypos)
		{
			if(bulletLevel == 1)
			{
				c.addEntity(new Laser(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
			}
			if(bulletLevel == 2)
			{
				c.addEntity(new Laser(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
			}
			if(bulletLevel == 3)
			{
				c.addEntity(new Laser(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
			}
			if(bulletLevel == 4)
			{
				c.addEntity(new Laser(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
			}
		}
		public void shootRocket(double xpos, double ypos)
		{
			if(bulletLevel == 1)
			{
				c.addEntity(new Rocket(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
			}
			if(bulletLevel == 2)
			{
				c.addEntity(new Rocket(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
			}
			if(bulletLevel == 3)
			{
				c.addEntity(new Rocket(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
			}
			if(bulletLevel == 4)
			{
				c.addEntity(new Rocket(xpos, ypos, tex, fireRate, dmg, ySpeed, xSpeed));
			}
		}
	
	public int getFireRate()
	{
		return adjustedFireRate;
	}
	
	public void addPowerUps(PowerUps powerups)
	{
		this.powerups = powerups;
	}
	public void resetUpgrades()
	{
		fireRate = 600;
		dmg = 1;
		bulletType = 1;
		bulletLevel = 1;
		ySpeed = -10;
		xSpeed = 0;
	}
	public void addMastery(Mastery mastery)
	{
		this.mastery = mastery;
	}
	
	
}

package com.game.src.main;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;
import com.game.src.main.classes.EntityD;
import com.game.src.main.classes.EntityE;

public class Controller {

	private LinkedList<EntityA> ea = new LinkedList<EntityA>();
	private LinkedList<EntityB> eb = new LinkedList<EntityB>();
	private LinkedList<EntityC> ec = new LinkedList<EntityC>();
	private LinkedList<EntityD> ed = new LinkedList<EntityD>();
	private LinkedList<EntityE> ee = new LinkedList<EntityE>();
	
	private Random r = new Random();
	private Upgrades upgrades;
	private Mastery mastery;
	
	private int weaponDrop;
	private boolean weaponDropped;
	private int powerUpDrop;
	private Textures tex;
	private int enemiesKilled;
	private int extraLives;
	private int killCounter;
	private double gainLivesMultiplier;
	private double powerUpDropRateMultiplier;
	
	EntityA enta;
	EntityB entb;
	EntityC entc;
	EntityD entd;
	EntityE ente;
	
	private int dmg;
	
	public Controller(Textures tex)
	{
		this.tex = tex;
		enemiesKilled = 0;
		extraLives = 1;
		killCounter = 75;
		weaponDropped = false;
		gainLivesMultiplier = 1;
		powerUpDropRateMultiplier = 1;
	}
	
	public void tick()
	{
		// E CLASS
				for(int i = 0; i < ee.size(); i++)
				{
					ente = ee.get(i);
					for(int e = 0; e < ec.size(); e++)
					{
						entc = ec.get(e);
					if(Physics.shieldCollision(entc, ee))
					{
						removeEntity(entc);
					}
					}
					ente.tick();
				}
		// A CLASS
		for(int i = 0; i < ea.size(); i++)
		{
			enta = ea.get(i);
			if(enta.getY()>= 580 || enta.getY()<= -100)
			{
				removeEntity(enta);
			}
			if(Physics.Collision(enta, ec))
			{
				if(enta.checkDamaged() == false)
				{
					enta.setInvulnerable();
					enta.setHealth(-1);
				}
				
			}
			if(enemiesKilled == extraLives * killCounter)
			{
				extraLives++;
				enta.setHealth(1);
			}
			enta.tick();
		}
		// E CLASS #2
		for(int i = 0; i < ee.size(); i++)
		{
			ente = ee.get(i);
			for(int e = 0; e < ec.size(); e++)
			{
				entc = ec.get(e);
			if(Physics.shieldCollision(entc, ee))
			{
				removeEntity(entc);
			}
			}
			ente.tick();
		}
		// B CLASS
		for(int i = 0; i < eb.size(); i++)
		{
			entb = eb.get(i);
			if(entb.getY()>= 580 || entb.getY()<= 0)
			{
				removeEntity(entb);
			}
			if(Physics.Collision(entb, ec))
			{
				
				for(int e = 0; e < ec.size(); e++)
				{
					entc = ec.get(e);
					if(Physics.Collision(entc, eb))
					{
						dmg = entb.getDmg();
						entc.setHealth(dmg);
						removeEntity(entb);
						if(entc.checkDead())
						{
							Points.addPoints(entc.getPoints());
							weaponDrop = (r.nextInt(7 + (Waves.wave / 2)) + 1);
							if(weaponDrop == 1)
							{
								weaponDropped = true;
								weaponDrop = (r.nextInt(4) + 1);
								if(weaponDrop == 1)
								{
									addEntity(new dropBullet(entc.getX(), entc.getY(), 1, tex));
								}
								else if(weaponDrop == 2)
								{
									addEntity(new dropScatterShot(entc.getX(), entc.getY(), 2, tex));
								}
								else if(weaponDrop == 3)
								{
									addEntity(new dropLaser(entc.getX(), entc.getY(), 3, tex));
								}
								else if(weaponDrop == 4)
								{
									addEntity(new dropRocket(entc.getX(), entc.getY(), 4, tex));
								}
							}
							if(weaponDropped == false)
							{
								powerUpDrop = (r.nextInt(10000 ) + 1);
								if(powerUpDrop >= 1 && powerUpDrop <= (225 * powerUpDropRateMultiplier))
								{
									powerUpDrop = (r.nextInt(4) + 5);
									if(powerUpDrop == 5)
									{
										addEntity(new dropShield(entc.getX(), entc.getY(), powerUpDrop, tex));
									}
									else if(powerUpDrop == 6)
									{
										addEntity(new dropFireRate(entc.getX(), entc.getY(), powerUpDrop, tex));
										System.out.println("FIRERATE DROPPED");
									}
									else if(powerUpDrop == 7)
									{
										addEntity(new dropStopwatch(entc.getX(), entc.getY(), powerUpDrop, tex));
										System.out.println("STOPWATCH DROPPED");
									}
									else if(powerUpDrop == 8)
									{
										addEntity(new dropSpeed(entc.getX(), entc.getY(), powerUpDrop, tex));
										System.out.println("SPEED DROPPED");
									}
								}
							}
							weaponDropped = false;
							removeEntity(entc);
							enemiesKilled++;
						}
					}
				}
			}
			entb.tick();
		}
		// C CLASS
		for(int i = 0; i < ec.size(); i++)
		{
			entc = ec.get(i);
			if(entc.getY()> 480)
			{
				removeEntity(entc);
			}
			if(entc.getY()>= 580)
			{
				removeEntity(entc);
			}
			entc.tick();
		}
		// D CLASS
		for(int i = 0; i < ed.size(); i++)
		{
			entd = ed.get(i);
			if(entd.getY()>= 580 || entd.getY()<= -100)
			{
				removeEntity(entd);
			}
			if(Physics.Collision(entd, ea))
			{
				upgrades.bulletPickup(entd.getType());
				removeEntity(entd);
			}
			entd.tick();
		}
		 
	}
	
	public void render(Graphics g)
	{
		
		// A CLASS
		for(int i = 0; i < ea.size(); i++)
		{
			enta = ea.get(i);
			
			enta.render(g);
		}
		// B CLASS
		for(int i = 0; i < eb.size(); i++)
		{
			entb = eb.get(i);
			
			entb.render(g);
		}
		// D CLASS
		for(int i = 0; i < ed.size(); i++)
		{
			entd = ed.get(i);
					
			entd.render(g);
		}
		// C CLASS
		for(int i = 0; i < ec.size(); i++)
		{
			entc = ec.get(i);
			
			entc.render(g);
		}
		// E CLASS
		for(int i = 0; i < ee.size(); i++)
		{
			ente = ee.get(i);
			
			ente.render(g);
		}
	}
	
	public void addEntity(EntityA block)
	{
		ea.add(block);
	}
	public void removeEntity(EntityA block)
	{
		ea.remove(block);
	}
	// B CLASS
	public void addEntity(EntityB block)
	{
		eb.add(block);
	}
	public void removeEntity(EntityB block)
	{
		eb.remove(block);
	}
	// C CLASS
	public void addEntity(EntityC block)
	{
		ec.add(block);
	}
	public void removeEntity(EntityC block)
	{
		ec.remove(block);
	}
	// D CLASS
	public void addEntity(EntityD block)
	{
		ed.add(block);
	}
	public void removeEntity(EntityD block)
	{
		ed.remove(block);
	}
	// E CLASS
	public void addEntity(EntityE block)
	{
		ee.add(block);
	}
	public void removeEntity(EntityE block)
	{
		ee.remove(block);
	}
		
	
	public LinkedList<EntityA> getEntityA()
	{
		return ea;
	}
	
	public LinkedList<EntityB> getEntityB()
	{
		return eb;
	}
	public LinkedList<EntityC> getEntityC()
	{
		return ec;
	}
	public LinkedList<EntityE> getEntityE()
	{
		return ee;
	}
	public void addUpgrades(Upgrades upgrades)
	{
		this.upgrades = upgrades;
	}
	public int getEnemiesKilled()
	{
		return enemiesKilled;
	}
	public void resetEnemiesKilled()
	{
		enemiesKilled = 0;
	}
	public void resetLives()
	{
		extraLives = 1;
	}
	// DOESNT CLEAR PLAYER
	public void clearEntities()
	{
		int ebs = eb.size();
		int ecs = ec.size();
		int eds = ed.size();
		int ees = ee.size();
		System.out.println("clearENTITES ENTERED!!!");
		for(int i = (ebs - 1); i >= 0; i--)
		{
			entb = eb.get(i);
			removeEntity(entb);
		}
		for(int i = (ecs - 1); i >= 0; i--)
		{
			System.out.println("Size: " + ec.size());
			entc = ec.get(i);
			removeEntity(entc);
			System.out.println("ENEMY RESET!!!");
		}
		for(int i = (eds - 1); i >= 0; i--)
		{
			entd = ed.get(i);
			removeEntity(entd);
		}
		for(int i = (ees - 1); i >= 0; i--)
		{
			ente = ee.get(i);
			removeEntity(ente);
		}
	}
	public void addMastery(Mastery mastery)
	{
		this.mastery = mastery;
	}
	public void implementMastery()
	{
		gainLivesMultiplier = ((int)mastery.getGainLivesMultiplier());
		powerUpDropRateMultiplier = ((int)mastery.getPowerUpDropRateMultiplier());
		killCounter = (int)(75 * powerUpDropRateMultiplier);
	}

}

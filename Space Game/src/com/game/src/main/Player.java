package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.Game.STATE;
import com.game.src.main.classes.EntityA;

public class Player extends GameObject implements EntityA{
		
		/* OLD MOVING TECHNIQUE VARIABLES
		private double velX = 0;
		private double velY = 0;
		*/
		
		private double moveLeft = 0;
		private double moveRight = 0;
		private double moveUp = 0;
		private double moveDown = 0;
		private int health;
		private boolean damaged;
		private int safeCounter;
		private Font f;
		private Experience exp;
		private powerUpShield powerupshield;
		private powerUpFireRate powerupfirerate;
		private powerUpStopwatch powerupstopwatch;
		private powerUpSpeed powerupspeed;
		private Coins coins;
		private Mastery mastery;
		
		private Textures tex;
		
		public Player(double x, double y, Textures tex, Coins coins)
		{
			super(x,y);
			this.tex = tex;
			this.coins = coins;
			health = 3;
			damaged = false;
			safeCounter = 0;
			f = new Font(Font.SANS_SERIF, 10, 20);
		}
		
		public void tick(){
			
			x += ((moveLeft + moveRight) * powerUpSpeed.getMultiplier());
			y += ((moveUp + moveDown)* powerUpSpeed.getMultiplier());
			
			if (x <= 28)
			{
				if(damaged == false && powerupshield.getActive() == false)
				{
					setInvulnerable();
					setHealth(-1);
				}
				 x = 28;
			}
			if (x >= 520 - 28)
			{
				if(damaged == false && powerupshield.getActive() == false)
				{
					setInvulnerable();
					setHealth(-1);
				}
				x = 520 - 28;
			}
			if (y <= 100) y = 100;
			if (y >= 960 - 196) y = 960 - 196;
			
			if(damaged)
			{
				safeCounter++;
				if(safeCounter >= (180 + ((int)mastery.getPostDamageUnkillableBonus()*30)))
				{
					damaged = false;
					safeCounter = 0;
				}
			}
			if(health <= 0)
			{
				exp.addExp();
				coins.setGainedCoins();
				Game.State = STATE.POSTGAME;
			}
		}
		
		public void render(Graphics g)
		{
			if(damaged)
			{
				if(Game.State == STATE.GAME && powerupshield.getActive())
				{
				g.drawImage(tex.playershield,(int)x,(int)y, null);
				}
				else if(Game.State == STATE.GAME)
				{
				g.drawImage(tex.player_damaged,(int)x,(int)y, null);
				}
				else
				{
					g.drawImage(tex.player,(int)x,(int)y, null);
				}
			}
			else
			{
				if(powerupshield.getActive())
				{
					g.drawImage(tex.playershield,(int)x,(int)y, null);
				}
				else if(powerupspeed.getActive())
				{
					g.drawImage(tex.playerspeed,(int)x,(int)y, null);
				}
				else if(powerupstopwatch.getActive())
				{
					g.drawImage(tex.playerstopwatch,(int)x,(int)y, null);
				}
				else if(powerupfirerate.getActive())
				{
					g.drawImage(tex.playerfirerate,(int)x,(int)y, null);
				}
				else
				{
				g.drawImage(tex.player,(int)x,(int)y, null);
				}
			}
			g.setColor(Color.white);
			g.setFont(f);
			g.drawString("" + health, 490, 60);
			
		}
		
		public double getX()
		{
			return x;
		}
		public double getY()
		{
			return y;
		}
		public void setX(double x)
		{
			this.x = x;
		}
		public void setY(double y)
		{
			this.y = y;
		}
		
		/* OLD MOVING TECHNIQUE METHODS
		public void setVelX(double velX)
		{
			this.velX = velX;
		}
		public void setVelY(double velY)
		{
			this.velY = velY;
		}
		*/
		
		public Rectangle getBounds()
		{
			return new Rectangle((int)x + 4, (int) y + 3, 23, 24);
		}
		
		public void moveUp(double moveUp)
		{
			this.moveUp = moveUp;
		}
		public void moveDown(double moveDown)
		{
			this.moveDown = moveDown;
		}
		public void moveLeft(double moveLeft)
		{
		  	this.moveLeft = moveLeft;
		}
		
		public void moveRight(double moveRight)
		{
			this.moveRight = moveRight;
		}
		
		public boolean checkDamaged()
		{
			return damaged;
		}
		
		public void setInvulnerable()
		{
			damaged = true;
		}
		public void setHealth(int dmg)
		{
			health += dmg;
		}
		
		public void addPowerUps(powerUpShield powerupshield, powerUpFireRate powerupfirerate, powerUpStopwatch powerupstopwatch, powerUpSpeed powerupspeed)
		{
			this.powerupshield = powerupshield;
			this.powerupfirerate = powerupfirerate;
			this.powerupstopwatch = powerupstopwatch;
			this.powerupspeed = powerupspeed;
		}
		public void addExperience(Experience exp)
		{
			this.exp = exp;
		}
		public void resetPlayer()
		{
			x = 240;
			y = 400;
			health = 3;
			damaged = false;
			safeCounter = 0;
			moveLeft= 0;
			moveRight = 0;
			moveUp = 0;
			moveDown = 0;
		}
		public void addMastery(Mastery mastery)
		{
			this.mastery = mastery;
		}	
		
}

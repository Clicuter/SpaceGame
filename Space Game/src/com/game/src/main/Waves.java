package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import com.game.src.main.classes.EntityC;

public class Waves {
	
	Random r = new Random();
	private Controller c;
	private Textures tex;
	private EntityC currentEnemy;
	
	
	private int xpos;
	private int enemies;
	private int difficulty;
	private int ypos;
	public static double speed;
	public static int wave;
	private int oldwave;
	private int xOffsetEnemies, randomSpawnContainer;
	private double spawner;
	private int antiglitch;
	private Animations waveAnimation;
	
	public Waves(Controller c, Textures tex)
	{
		this.c = c;
		this.tex = tex;
		speed = 1;
		wave = 1;
		oldwave = 0;
		antiglitch = 0;
		waveAnimation = new Animations(230, 200, "Wave 1");
		xOffsetEnemies = 38;
		randomSpawnContainer = 430;
	}
	
	public void tick()
	{
		if(Points.getPoints() <= 100)
		{
			Wave1();
			speed = 1.1;
			wave = 1;
			if(oldwave != wave)
			{
				waveAnimation.setAnimationText("Wave " + wave);
				waveAnimation.playAnimation();
			}
		}
		else if(Points.getPoints() <= 300)
		{
			Wave2();
			speed = 1.2;
			wave = 2;
			if(oldwave != wave)
			{
				waveAnimation.setAnimationText("Wave " + wave);
				waveAnimation.playAnimation();
			}
		}
		else if(Points.getPoints() <= 500)
		{
			Wave3();
			speed = 1.25;
			wave = 3;
			if(oldwave != wave)
			{
				waveAnimation.setAnimationText("Wave " + wave);
				waveAnimation.playAnimation();
			}
		}
		else if(Points.getPoints() <= 800)
		{
			Wave4();
			speed = 1.4;
			wave = 4;
			if(oldwave != wave)
			{
				waveAnimation.setAnimationText("Wave " + wave);
				waveAnimation.playAnimation();
			}
		}
		else if(Points.getPoints() <= 1000)
		{
			Wave5();
			speed = 1.5;
			wave = 5;
			if(oldwave != wave)
			{
				waveAnimation.setAnimationText("Wave " + wave);
				waveAnimation.playAnimation();
			}
		}
		else if(Points.getPoints() <= 1500)
		{
			Wave6();
			speed = 1.6;
			wave = 6;
			if(oldwave != wave)
			{
				waveAnimation.setAnimationText("Wave " + wave);
				waveAnimation.playAnimation();
			}
		}
		else if(Points.getPoints() <= 2000)
		{
			Wave7();
			speed = 1.75;
			wave = 7;
			if(oldwave != wave)
			{
				waveAnimation.setAnimationText("Wave " + wave);
				waveAnimation.playAnimation();
			}
		}
		else if(Points.getPoints() <= 2600)
		{
			Wave8();
			speed = 1.9;
			wave = 8;
			if(oldwave != wave)
			{
				waveAnimation.setAnimationText("Wave " + wave);
				waveAnimation.playAnimation();
			}
		}
		else if(Points.getPoints() >= 2600)
		{
			WaveFinal();
			if(oldwave != wave)
			{
				waveAnimation.setAnimationText("Wave " + wave);
				waveAnimation.playAnimation();
			}
		}
		oldwave = wave;
	}
	public void tick2()
	{
		waveAnimation.tick();
	}
	public void render(Graphics g)
	{
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 20));
		g.drawString(("" + wave), 160, 60);
		waveAnimation.render(g);
	}
	
	private void Wave1()
	{
		enemies = (r.nextInt(3) + 1);
		for(int i = 0; i < enemies; i++)
		{
			difficulty = (r.nextInt(10)+ 1);
			if(difficulty >= 1 && difficulty <= 10)
			{
					ypos = ((r.nextInt(128)) + 48) * - 1;
					xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy(xpos, (ypos), tex));
				System.out.println("E1 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			currentEnemy = c.getEntityC().get(c.getEntityC().size()- 1);
			if(Physics.selfCollision(currentEnemy, c.getEntityC()))
			{
				System.out.println("Enemy Deleted at ( " + xpos + " , " + ypos + ")");
				c.removeEntity(currentEnemy);
				i--;
			}
		}
	}
	private void Wave2()
	{
		enemies = (r.nextInt(3) + 2);
		for(int i = 0; i < enemies; i++)
		{
			difficulty = (r.nextInt(10)+ 1);
			if(difficulty >= 6 && difficulty <= 10)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy(xpos, (ypos), tex));
				System.out.println("E1 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			
			if(difficulty >= 1 && difficulty <= 5)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy2(xpos, (ypos), tex));
				System.out.println("E2 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			currentEnemy = c.getEntityC().get(c.getEntityC().size()- 1);
			if(Physics.selfCollision(currentEnemy, c.getEntityC()))
			{
				System.out.println("Enemy Deleted at ( " + xpos + " , " + ypos + ")");
				c.removeEntity(currentEnemy);
				i--;
			}
		}
	}
	private void Wave3()
	{
		enemies = (r.nextInt(2) + 3);
		for(int i = 0; i < enemies; i++)
		{
			difficulty = (r.nextInt(10)+ 1);
			if(difficulty >= 1 && difficulty <= 2)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy(xpos, (ypos), tex));
				System.out.println("E1 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty == 3)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new EnemyZigZag(xpos, (ypos), tex));
				System.out.println("EZ1 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 4 && difficulty <= 6)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy2(xpos, (ypos), tex));
				System.out.println("E2 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 7 && difficulty <= 10)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy3(xpos, (ypos), tex));
				System.out.println("E3 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			currentEnemy = c.getEntityC().get(c.getEntityC().size()- 1);
			if(Physics.selfCollision(currentEnemy, c.getEntityC()))
			{
				System.out.println("Enemy Deleted at ( " + xpos + " , " + ypos + ")");
				c.removeEntity(currentEnemy);
				i--;
			}
		}
	}
	private void Wave4()
	{
		enemies = (r.nextInt(2) + 4);
		for(int i = 0; i < enemies; i++)
		{
			difficulty = (r.nextInt(10)+ 1);
			if(difficulty == 1)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy(xpos, (ypos), tex));
				System.out.println("E1 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty == 2)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new EnemyZigZag(xpos, (ypos), tex));
				System.out.println("EZ1 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 3 && difficulty <= 4)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy2(xpos, (ypos), tex));
				System.out.println("E2 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 5 && difficulty <= 6)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy3(xpos, (ypos), tex));
				System.out.println("E3 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 7 && difficulty <=10)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy4(xpos, (ypos), tex));
				System.out.println("E4 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			currentEnemy = c.getEntityC().get(c.getEntityC().size()- 1);
			if(Physics.selfCollision(currentEnemy, c.getEntityC()))
			{
				System.out.println("Enemy Deleted at ( " + xpos + " , " + ypos + ")");
				c.removeEntity(currentEnemy);
				i--;
			}
		}
	}
	private void Wave5()
	{
		enemies = (r.nextInt(2) + 5);
		for(int i = 0; i < enemies; i++)
		{
			difficulty = (r.nextInt(10)+ 1);
			if(difficulty == 1)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy(xpos, (ypos), tex));
				System.out.println("E1 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty == 2)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new EnemyZigZag(xpos, (ypos), tex));
				System.out.println("EZ1 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty == 3)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy2(xpos, (ypos), tex));
				System.out.println("E2 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty == 4)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new EnemyZigZag2(xpos, (ypos), tex));
				System.out.println("EZ2 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 5 && difficulty <= 6)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy3(xpos, (ypos), tex));
				System.out.println("E3 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 7 && difficulty <=10)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy4(xpos, (ypos), tex));
				System.out.println("E4 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			currentEnemy = c.getEntityC().get(c.getEntityC().size()- 1);
			if(Physics.selfCollision(currentEnemy, c.getEntityC()))
			{
				System.out.println("Enemy Deleted at ( " + xpos + " , " + ypos + ")");
				c.removeEntity(currentEnemy);
				i--;
			}
		}
	}
	private void Wave6()
	{
		enemies = (r.nextInt(2) + 5);
		for(int i = 0; i < enemies; i++)
		{
			difficulty = (r.nextInt(10)+ 1);
			if(difficulty == 1)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new EnemyZigZag(xpos, (ypos), tex));
				System.out.println("EZ1 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty == 2)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				c.addEntity(new EnemyZigZag2(xpos, (ypos), tex));
				System.out.println("EZ2 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 3 && difficulty <= 4)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy3(xpos, (ypos), tex));
				System.out.println("E3 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 5 && difficulty <=6)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy4(xpos, (ypos), tex));
				System.out.println("E4 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 7 && difficulty <=10)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy5(xpos, (ypos), tex));
				System.out.println("E5 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			currentEnemy = c.getEntityC().get(c.getEntityC().size()- 1);
			if(Physics.selfCollision(currentEnemy, c.getEntityC()))
			{
				System.out.println("Enemy Deleted at ( " + xpos + " , " + ypos + ")");
				c.removeEntity(currentEnemy);
				i--;
			}
		}
	}
	private void Wave7()
	{
		enemies = (r.nextInt(2) + 5);
		for(int i = 0; i < enemies; i++)
		{
			difficulty = (r.nextInt(10)+ 1);
			if(difficulty == 1)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new EnemyZigZag(xpos, (ypos), tex));
				System.out.println("EZ1 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty == 2)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				c.addEntity(new EnemyZigZag2(xpos, (ypos), tex));
				System.out.println("EZ2 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty == 3)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy3(xpos, (ypos), tex));
				System.out.println("E3 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 4 && difficulty <=5)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy4(xpos, (ypos), tex));
				System.out.println("E4 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 6 && difficulty <=7)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy5(xpos, (ypos), tex));
				System.out.println("E5 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 8 && difficulty <=10)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy6(xpos, (ypos), tex));
				System.out.println("E6 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			currentEnemy = c.getEntityC().get(c.getEntityC().size()- 1);
			if(Physics.selfCollision(currentEnemy, c.getEntityC()))
			{
				System.out.println("Enemy Deleted at ( " + xpos + " , " + ypos + ")");
				c.removeEntity(currentEnemy);
				i--;
			}
		}
	}
	private void Wave8()
	{
		enemies = (r.nextInt(3) + 6);
		for(int i = 0; i < enemies; i++)
		{
			difficulty = (r.nextInt(10)+ 1);
			if(difficulty == 1)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new EnemyZigZag(xpos, (ypos), tex));
				System.out.println("EZ1 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty == 2)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				c.addEntity(new EnemyZigZag2(xpos, (ypos), tex));
				System.out.println("EZ2 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty == 3)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy3(xpos, (ypos), tex));
				System.out.println("E3 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty == 4)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy4(xpos, (ypos), tex));
				System.out.println("E4 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 5 && difficulty <=6)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy5(xpos, (ypos), tex));
				System.out.println("E5 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 7 && difficulty <=10)
			{
				ypos = ((r.nextInt(128)) + 48) * - 1;
				xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy6(xpos, (ypos), tex));
				System.out.println("E6 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			currentEnemy = c.getEntityC().get(c.getEntityC().size()- 1);
			if(Physics.selfCollision(currentEnemy, c.getEntityC()))
			{
				System.out.println("Enemy Deleted at ( " + xpos + " , " + ypos + ")");
				c.removeEntity(currentEnemy);
				i--;
			}
		}
	}
	private void WaveFinal()
	{
		speed = (Points.getPoints() / 2600) + 1;
		if(spawner < 8)
		{
		spawner = ((Points.getPoints() /800) * 2) - 4;
		}
		enemies = (r.nextInt((int)spawner) + 5);
		wave = ( (int)(Points.getPoints() / 325));
		Game.setWaveDelay(2);
		for(int i = 0; i < enemies; i++)
		{
			difficulty = (r.nextInt(10)+ 1);
			if(difficulty == 1)
			{
				difficulty = (r.nextInt(10) + 1);
				if(difficulty == 1)
				{
					ypos = ((r.nextInt(128)) + 48 + antiglitch) * - 1;
					xpos = r.nextInt(356) + xOffsetEnemies;
				
				c.addEntity(new EnemyHuge(xpos, (ypos), tex));
				System.out.println("EH1 Spawned at ( " + xpos + " , " + ypos + ")");
				}
				else
				{
					ypos = ((r.nextInt(128)) + 48) * - 1;
					xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new EnemyZigZag(xpos, (ypos), tex));
				System.out.println("EZ1 Spawned at ( " + xpos + " , " + ypos + ")");
				}
			}
			if(difficulty >= 2 && difficulty <= 3)
			{
					ypos = ((r.nextInt(128)) + 48) * - 1;
					xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new EnemyZigZag2(xpos, (ypos), tex));
				System.out.println("E6 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			if(difficulty >= 4 && difficulty <= 10)
			{
					ypos = ((r.nextInt(128)) + 48) * - 1;
					xpos = r.nextInt(randomSpawnContainer) + xOffsetEnemies;
				
				c.addEntity(new Enemy6(xpos, (ypos), tex));
				System.out.println("E6 Spawned at ( " + xpos + " , " + ypos + ")");
			}
			currentEnemy = c.getEntityC().get(c.getEntityC().size()- 1);
			if(Physics.selfCollision(currentEnemy, c.getEntityC()) && antiglitch <= 8)
			{
				System.out.println("Enemy Deleted at ( " + xpos + " , " + ypos + ")");
				c.removeEntity(currentEnemy);
				antiglitch++;
				i--;
			}
			else
			{
				antiglitch = 0;
			}
		}
	}
	
	public void resetWaves()
	{
		speed = 1;
		wave = 1;
		antiglitch = 0;
		spawner = 1;
	}
	
	
}

package com.game.src.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JFrame;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;
import com.game.src.main.menu.MainMenuMouseInput;
import com.game.src.main.menu.MasteryButtonActionHandler;
import com.game.src.main.menu.Menu;
import com.game.src.main.menu.PostGame;
import com.game.src.main.menu.MasteryGUI;
import com.game.src.main.menu.TexturesMenu;
import com.game.src.main.menu.buttonPopUp;

public class Game extends Canvas implements Runnable {
	


	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "2D Space Game";

	private boolean running = false;
	private Thread thread;
	
	private FileHandler filehandler;
	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	private BufferedImage background = null;
	private BufferedImage rockwall = null;
	private BufferedImage side_menu = null;
	private BufferedImage menu_buttons = null;
	
	private long nextShot;
	private int nextWave;
	private static int nextWaveCounter;
	
	
	private EntityA p;
	private Controller c;
	private Textures tex;
	private TexturesMenu texmenu;
	private Menu menu;
	private PostGame postgame;
	private MasteryGUI masteryGUI;
	private Coins coins;
	private Experience exp;
	private Mastery mastery;
	private MasteryButtonActionHandler masterybuttonactionhandler;
	
	private Background back;
	private Points points;
	private Waves waves;
	private Upgrades upgrades;
	private PowerUps powerups;
	private powerUpFireRate powerupfirerate;
	private powerUpStopwatch powerupstopwatch;
	private powerUpSpeed powerupspeed;
	private powerUpShield powerupshield;
	private Font f2;
	
	public LinkedList<EntityA> ea;
	public LinkedList<EntityB> eb;
	public LinkedList<EntityC> ec;
	
	public static enum STATE
	{
		MENU,
		GAME,
		PAUSED,
		POSTGAME,
		MASTERY,
	};
	
	public static STATE State = STATE.MENU;
	
	private boolean moveLeft = false;
	private boolean moveRight = false;
	private boolean moveDown = false;
	private boolean moveUp = false;
	private boolean isShooting = false;
	private double playerSpeed = 1.5;
	
	
	private void  init()
	{
		requestFocus();
		BufferedImageLoader loader = new BufferedImageLoader();
		filehandler = new FileHandler();
		try{
			
			spriteSheet = loader.loadImage("/sprite_sheet.png");
			background = loader.loadImage("/background.png");
			rockwall = loader.loadImage("/rockwall.png");
			side_menu = loader.loadImage("/side_menu.png");
			menu_buttons = loader.loadImage("/menu_buttons.png");
			filehandler.initialize();
		}catch(IOException e){
			e.printStackTrace();
		}
		tex = new Textures(this);
		texmenu = new TexturesMenu(this);
		mastery = new Mastery(filehandler);
		masterybuttonactionhandler = new MasteryButtonActionHandler(mastery);
		masteryGUI = new MasteryGUI(mastery, tex, masterybuttonactionhandler);
		c = new Controller(tex);
		coins = new Coins(c, FileHandler.coins);
		mastery.addCoins(coins);
		this.addMouseListener(new MainMenuMouseInput(coins, this, masteryGUI));
		this.addMouseMotionListener(new MainMenuMouseInput(coins, this, masteryGUI));
		addKeyListener(new KeyInput(this));
		menu = new Menu(texmenu);
		postgame = new PostGame(tex);
		c.addEntity(new Player(240, 400, tex, coins));
		ea = c.getEntityA();
		p = ea.get(0);
		eb = c.getEntityB();
		ec = c.getEntityC();
		
		back = new Background();
		points = new Points();
		exp = new Experience(points, c, FileHandler.experience, FileHandler.level);
		mastery.updatePoints();
		mastery.savePoints();
		waves = new Waves(c, tex);
		upgrades = new Upgrades(c, tex);
		c.addUpgrades(upgrades);
		powerupfirerate = new powerUpFireRate(tex);
		powerupstopwatch = new powerUpStopwatch(tex);
		powerupspeed = new powerUpSpeed(tex);
		powerupshield = new powerUpShield(p, c, tex);
		powerups = new PowerUps(powerupfirerate, powerupstopwatch, powerupspeed, powerupshield);
		p.addPowerUps(powerupshield, powerupfirerate, powerupstopwatch, powerupspeed);
		p.addExperience(exp);
		nextWaveCounter = 2;
		upgrades.addPowerUps(powerups);
		this.updateMasteries();
		f2 = new Font(Font.SANS_SERIF, 10, 10);
		State = STATE.MENU;
		
	}
	
	private synchronized void start()
	{
		if(running)
		{
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop()
	{
		if(!running)
		{
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	public void run()
	{
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1)
			{
				tick(updates);
				updates++;
				delta--;;
				render();
				frames++;
			}
			/*
			render();
			frames++;
			*/
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println(updates + " Ticks, FPS " + frames);
				updates = 0;
				frames = 0;
			}
			
		}
		stop();
	}
	
	private void tick(int updates)
	{
		
		/////////////////////////////////////////////
		/////////////////////////////////////////////
		/////////////////////////////////////////////
		// GAME STATE
		if(State == STATE.GAME)
		{
		///////////////////////// KeyListener MOVEMENT
			if(moveRight)
			{
				p.moveRight(playerSpeed);
			}
			if(moveLeft)
			{
				p.moveLeft(playerSpeed * -1);
			}
			if(moveDown)
			{
				p.moveDown(playerSpeed);
			}
			if(moveUp)
			{
				p.moveUp(playerSpeed * -1);
			}
			if(isShooting && System.currentTimeMillis() >= nextShot)
			{
				nextShot = (System.currentTimeMillis()+upgrades.getFireRate());
				upgrades.shootProjectile((p.getX()),(p.getY()-12));
			}
		///////////////////////// And SHOOTING
			p.tick();
			c.tick();
			points.tick();
			back.tick();
			upgrades.tick();
			powerupfirerate.tick();
			powerupstopwatch.tick();
			powerupspeed.tick();
			powerupshield.tick();
			waves.tick2();
			if(updates >= 59)
			{
				nextWave++;
				if(nextWave == nextWaveCounter)
				{
				waves.tick();
				nextWave = 0;
				}
			}
		}
			
		/////////////////////////////////////////////
		/////////////////////////////////////////////
		/////////////////////////////////////////////
		// GAME STATE
		
		////////////////////////////////// POSTGAME STATE
		if(State == STATE.POSTGAME)
		{
			postgame.tick();
		}
		///////////////////////////////// POSTGAME STATE
		///////////////////////////////// MASTERY STATE
		if(State == STATE.MASTERY)
		{
			masteryGUI.tick();
		}
		///////////////////////////////// MASTERY STATE
		///////////////////////////////// MENU STATE
		if(State == STATE.MENU)
		{
		}
		///////////////////////////////// MENU STATE
	}
	
	private void render()
	{
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			
			createBufferStrategy(3);
			return;
			
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		////////////////////////////////// GAME STATE
		if(State == STATE.GAME)
		{
		g.drawImage(background, 0, back.getY(), this);
		g.drawImage(background, 0, back.getY2(), this);
		g.drawImage(rockwall, 0, back.getY3(), this);
		g.drawImage(rockwall, 0, back.getY4(), this);
		g.drawImage(side_menu, 0, 0, this);
		
		p.render(g);
		c.render(g);
		points.render(g);
		waves.render(g);
		powerupfirerate.render(g);
		powerupstopwatch.render(g);
		powerupspeed.render(g);
		powerupshield.render(g);
		upgrades.render(g);
		g.setFont(f2);
		g.drawString("Press [T]", 570, 390);
		
		}
		////////////////////////////////// GAME STATE
		
		///////////////////////////////// MENU STATE
		if(State == STATE.MENU)
		{
			g.drawImage(background, 0, back.getY(), this);
			g.drawImage(background, 0, back.getY2(), this);
			menu.render(g);

		}
		//////////////////////////////// MENU STATE
		//////////////////////////////// POST-GAME STATE
		if(State == STATE.POSTGAME)
		{
			g.drawImage(background, 0, back.getY(), this);
			g.drawImage(background, 0, back.getY2(), this);
			g.drawImage(rockwall, 0, back.getY3(), this);
			g.drawImage(rockwall, 0, back.getY4(), this);
			g.drawImage(side_menu, 0, 0, this);
			p.render(g);
			points.render(g);
			waves.render(g);
			
			postgame.render(g);
		}
		//////////////////////////////// POST-GAME STATE
		//////////////////////////////// MASTERY STATE
		if(State == STATE.MASTERY)
		{
			g.drawImage(background, 0, back.getY(), this);
			g.drawImage(background, 0, back.getY2(), this);
			masteryGUI.render(g);
		}
		//////////////////////////////// MASTERY STATE
		
		g.dispose();
		bs.show();
	}
	
	public void keyPressed(KeyEvent e)
	{
		
		///////////////////////////////// GAME STATE
		if(State == STATE.GAME)
		{
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT)
		{
			moveRight = true;
		}
		if(key == KeyEvent.VK_LEFT)
		{
			moveLeft = true;
		}
		if(key == KeyEvent.VK_DOWN)
		{
			moveDown = true;
		}
		if(key == KeyEvent.VK_UP)
		{
			moveUp = true;
		}
		if(key == KeyEvent.VK_SPACE)
		{
			isShooting = true;
		}
		if(key == KeyEvent.VK_D)
		{
			moveRight = true;
		}
		if(key == KeyEvent.VK_A)
		{
			moveLeft = true;
		}
		if(key == KeyEvent.VK_S)
		{
			moveDown = true;
		}
		if(key == KeyEvent.VK_W)
		{
			moveUp = true;
		}
		
		}
		
		////////////////////////////////////////////////// GAME STATE
	}
	
	public void keyReleased(KeyEvent e)
	{
		//////////////////////////////////////////////////GAME STATE
		if(State == STATE.GAME)
		{
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT)
		{
			moveRight = false;
			p.moveRight(0);
		}
		if(key == KeyEvent.VK_LEFT)
		{
			moveLeft = false;
			p.moveLeft(0);
		}
		if(key == KeyEvent.VK_DOWN)
		{
			moveDown = false;
			p.moveDown(0);
		}
		if(key == KeyEvent.VK_UP)
		{
			moveUp = false;
			p.moveUp(0);
		}
		if(key == KeyEvent.VK_SPACE)
		{
			isShooting = false;
		}
		if(key == KeyEvent.VK_D)
		{
			moveRight = false;
			p.moveRight(0);
		}
		if(key == KeyEvent.VK_A)
		{
			moveLeft = false;
			p.moveLeft(0);
		}
		if(key == KeyEvent.VK_S)
		{
			moveDown = false;
			p.moveDown(0);
		}
		if(key == KeyEvent.VK_W)
		{
			moveUp = false;
			p.moveUp(0);
		}
		if(key == KeyEvent.VK_T)
		{
			if(powerupfirerate.getAvailable() && powerupfirerate.getActive() == false && powerupstopwatch.getActive() == false && powerupspeed.getActive() == false && powerupshield.getActive() == false)
			{
				powerupfirerate.activatePowerUp();
			}
			if(powerupstopwatch.getAvailable() && powerupfirerate.getActive() == false && powerupstopwatch.getActive() == false && powerupspeed.getActive() == false && powerupshield.getActive() == false)
			{
				powerupstopwatch.activatePowerUp();
			}
			if(powerupspeed.getAvailable() && powerupfirerate.getActive() == false && powerupstopwatch.getActive() == false && powerupspeed.getActive() == false && powerupshield.getActive() == false)
			{
				powerupspeed.activatePowerUp();
			}
			if(powerupshield.getAvailable() && powerupfirerate.getActive() == false && powerupstopwatch.getActive() == false && powerupspeed.getActive() == false && powerupshield.getActive() == false)
			{
				powerupshield.activatePowerUp();
			}
		}
		}
		//////////////////////////////////////////////////GAME STATE
	}
	
	
	public static void main(String args[])
	{
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}

	public BufferedImage getSpriteSheet()
	{
		return spriteSheet;
	}
	public BufferedImage getMenuButtons()
	{
		return menu_buttons;
	}
	public static void setWaveDelay(int wave)
	{
		nextWaveCounter = wave;
	}
	public void reset()
	{
		c.resetEnemiesKilled();
		c.resetLives();
		coins.updateCoins();
		moveRight = false;
		moveLeft = false;
		moveUp = false;
		moveDown = false;
		isShooting = false;
		postgame.resetAdjuster();
		p.resetPlayer();
		points.resetPoints();
		waves.resetWaves();
		upgrades.resetUpgrades();
		powerupfirerate.resetPowerUpFireRate();
		powerupshield.resetPowerUpShield();
		powerupspeed.resetPowerUpSpeed();
		powerupstopwatch.resetPowerUpStopwatch();
		c.clearEntities();
		Experience.updateStoredVars();
		Coins.updateSavedCoins();
		mastery.updatePoints();
		mastery.updateBonuses();
		mastery.savePoints();
		try {
			filehandler.storeInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
	}
	public void updateMasteries()
	{
		playerSpeed = (playerSpeed * mastery.getSpeedMultiplier());
		upgrades.addMastery(mastery);
		powerupfirerate.addMastery(mastery);
		p.addMastery(mastery);
		powerupshield.addMastery(mastery);
		c.addMastery(mastery);
		powerupspeed.addMastery(mastery);
		coins.addMastery(mastery);
		
		powerupfirerate.implementMastery();
		powerupshield.implementMastery();
		powerupspeed.implementMastery();
		c.implementMastery();
	}
}

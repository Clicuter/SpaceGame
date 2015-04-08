package com.game.src.main.classes;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface EntityB {

	public void tick();
	public void render(Graphics g);
	public Rectangle getBounds();
	
	public int getDmg();
	public double getX();
	public double getY();
	
	
	
}

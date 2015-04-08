package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityE;

public class Shield implements EntityE {

	private EntityA p;
	
	private double x, y;
	
	public Shield(EntityA p)
	{
		this.p = p;
		x = p.getX();
		y = p.getY();
	}
	
	
	public void tick() {
		x = p.getX();
		y = p.getY();
	}

	public void render(Graphics g) {
		
	}


	public Rectangle getBounds() {

		return new Rectangle((int) (x - 4), (int) (y  - 4), 40, 40);
	}

	public double getX() {
		
		return x;
	}

	public double getY() {
		
		return y;
	}

	
	
}

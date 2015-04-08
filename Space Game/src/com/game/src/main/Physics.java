package com.game.src.main;

import java.util.LinkedList;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;
import com.game.src.main.classes.EntityD;
import com.game.src.main.classes.EntityE;

public class Physics {
	
	
	public Physics()
	{
		
	}
	// PLAYER AND ENEMY COLLISION
	public static boolean Collision(EntityA enta, LinkedList<EntityC> ec)
	{
		for(int i = 0; i <ec.size(); i++)
		{
			if(enta.getBounds().intersects(ec.get(i).getBounds()))
			{
				return true;
			}
		}
		
		return false;
	}
	// BULLET AND ENEMY COLLISION
	public static boolean Collision(EntityB entb, LinkedList<EntityC> ec)
	{
		for(int i = 0; i < ec.size(); i++)
		{
			if(entb.getBounds().intersects(ec.get(i).getBounds()))
			{
				return true;
			}
		}
			return false;
	}
	public static boolean Collision(EntityC entc, LinkedList<EntityB> eb)
	{
		for(int i = 0; i < eb.size(); i++)
		{
			if(entc.getBounds().intersects(eb.get(i).getBounds()))
			{
				return true;
			}
		}
			return false;
	}
	public static boolean Collision(EntityD entd, LinkedList<EntityA> ea)
	{
		for(int i = 0; i < ea.size(); i++)
		{
			if(entd.getBounds().intersects(ea.get(i).getBounds()))
			{
				return true;
			}
		}
			return false;
	}
	public static boolean selfCollision(EntityC entc, LinkedList<EntityC> ec)
	{
		for(int i = 0; i < ec.size(); i++)
		{
			if(entc.equals(ec.get(i)))
			{
			}
			else
			{
			if(entc.getBounds().intersects(ec.get(i).getBounds()))
			{
				return true;
			}
			}
		}
			return false;
	}
	public static boolean shieldCollision(EntityC entc, LinkedList<EntityE> ee)
	{
		for(int i = 0; i < ee.size(); i++)
		{
			if(entc.getBounds().intersects(ee.get(i).getBounds()))
			{
				return true;
			}
		}
			return false;
	}
	

	
}

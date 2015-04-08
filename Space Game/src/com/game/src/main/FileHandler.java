package com.game.src.main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {

	public static int coins, experience, level, mastery, fireRateCounter, fireRatePowerUpCounter, blastRadiusCounter, bonusDamageCounter, enemySpeedCounter, postDamageUnkillableCounter, shieldPowerUpCounter, gainLivesCounter, speedCounter, speedPowerUpCounter, powerUpDropRateCounter, extraCoinsCounter;
	private String[] storedVarList = {"Coins","Experience", "Level", "Mastery", "fireRateCounter", "fireRatePowerUpCounter", "blastRadiusCounter", "bonusDamageCounter", "enemySpeedCounter", "postDamageUnkillableCounter", "shieldPowerUpCounter", "gainLivesCounter", "speedCounter", "speedPowerUpCounter", "powerUpDropRateCounter", "extraCoinsCounter"};
	private int[] storedVarVals = new int[storedVarList.length];
	private Scanner s = null;
	private PrintWriter outputStream = null;
	private String resFile = "usnumbers.txt";
    private File f = new File(resFile);
    
    public void initialize() throws IOException
    {
	coins = experience = level = mastery = 0;
	if(f.exists() && !f.isDirectory())
	{
		System.out.println("EXISTS!");
		try
		{
			s = new Scanner(new BufferedReader(new FileReader(resFile)));
			while (s.hasNext())
			{
				for(int i = 0; i < storedVarVals.length; i++)
				{
				if(s.next().equals((storedVarList[i])))
				{
					storedVarVals[i] = s.nextInt();
				}
				}
			}
		} finally {
			s.close();
		}
		coins = storedVarVals[0];
		experience = storedVarVals[1];
		level = storedVarVals[2];
		mastery = storedVarVals[3];
		fireRateCounter = storedVarVals[4];
		fireRatePowerUpCounter = storedVarVals[5];
		blastRadiusCounter = storedVarVals[6];
		bonusDamageCounter = storedVarVals[7];
		enemySpeedCounter = storedVarVals[8];
		postDamageUnkillableCounter = storedVarVals[9];
		shieldPowerUpCounter = storedVarVals[10];
		gainLivesCounter = storedVarVals[11];
		speedCounter = storedVarVals[12];
		speedPowerUpCounter = storedVarVals[13];
		powerUpDropRateCounter = storedVarVals[14];
		extraCoinsCounter = storedVarVals[15];
	}
	else
	{
		System.out.println("FILE NOT FOUND! BEING CREATED!");
		try
		{
			outputStream = new PrintWriter(new FileWriter(resFile));
			
			outputStream.println("Coins 0\n");
			outputStream.println("Experience 0\n");
			outputStream.println("Level 1\n");
			outputStream.println("Mastery 0\n");
			outputStream.println("fireRateCounter 0\n");
			outputStream.println("fireRatePowerUpCounter 0\n");
			outputStream.println("blastRadiusCounter 0\n");
			outputStream.println("bonusDamageCounter 0\n");
			outputStream.println("enemySpeedCounter 0\n");
			outputStream.println("postDamageUnkillableCounter 0\n");
			outputStream.println("shieldPowerUpCounter 0\n");
			outputStream.println("gainLivesCounter 0\n");
			outputStream.println("speedCounter 0\n");
			outputStream.println("speedPowerUpCounter 0\n");
			outputStream.println("powerUpDropRateCounter 0\n");
			outputStream.println("extraCoinsCounter 0\n");
		} finally {
			if(outputStream != null)
			{
				outputStream.close();
			}
		}
	}
	System.out.println(coins + " " + experience + " " + level + " " + mastery);
	
}
    
    public void storeInfo() throws IOException
    {
    	System.out.println("SAVING DATA...");
		try
		{
			outputStream = new PrintWriter(new FileWriter(resFile));
			
			outputStream.println("Coins " + coins + "\n");
			outputStream.println("Experience " + experience + "\n");
			outputStream.println("Level " + level + "\n");
			outputStream.println("Mastery " + mastery + "\n");
			outputStream.println("fireRateCounter " + fireRateCounter + "\n");
			outputStream.println("fireRatePowerUpCounter " + fireRatePowerUpCounter + "\n");
			outputStream.println("blastRadiusCounter " + blastRadiusCounter + "\n");
			outputStream.println("bonusDamageCounter " + bonusDamageCounter + "\n");
			outputStream.println("enemySpeedCounter " + enemySpeedCounter + "\n");
			outputStream.println("postDamageUnkillableCounter " + postDamageUnkillableCounter + "\n");
			outputStream.println("shieldPowerUpCounter " + shieldPowerUpCounter + "\n");
			outputStream.println("gainLivesCounter " + gainLivesCounter + "\n");
			outputStream.println("speedCounter " + speedCounter + "\n");
			outputStream.println("speedPowerUpCounter " + speedPowerUpCounter + "\n");
			outputStream.println("powerUpDropRateCounter " + powerUpDropRateCounter + "\n");
			outputStream.println("extraCoinsCounter " + extraCoinsCounter + "\n");
		} finally {
			if(outputStream != null)
			{
				outputStream.close();
			}
		}
    	
    }
}
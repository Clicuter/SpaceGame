package com.game.src.main.menu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.game.src.main.Coins;
import com.game.src.main.Game;
import com.game.src.main.Game.STATE;

public class MainMenuMouseInput implements MouseListener, MouseMotionListener {

	private static boolean playbuttonclicked, multiplayerbuttonclicked, masteriesbuttonclicked, storebuttonclicked, quitbuttonclicked;
	private static boolean playbuttonhovered, multiplayerbuttonhovered, masteriesbuttonhovered, storebuttonhovered, quitbuttonhovered;
	private static boolean homebuttonclicked, homebuttonhovered, againbuttonclicked, againbuttonhovered;
	private Coins coins;
	private Game game;

	public MainMenuMouseInput(Coins coins, Game game)
	{
		this.coins = coins;
		this.game = game;
	}
	
	public void mousePressed(MouseEvent e) {

		int mx = e.getX();
		int my = e.getY();
		
		
		///////////////////////////// MENU STATE
		if(Game.State == STATE.MENU)
		{
			
		if(mx >= 224 && mx <= (416))
		{
			if(my >= 150 && my <= 198)
			{
				//Pressed PLAY BUTTON
				playbuttonclicked = true;
				
			}
		}
		if(mx >= 224 && mx <= (416))
		{
			if(my >= 210 && my <= 258)
			{
				//Pressed MULTIPLAYER BUTTON
				multiplayerbuttonclicked = true;
				
			}
		}
		if(mx >= 224 && mx <= (416))
		{
			if(my >= 270 && my <= 318)
			{
				//Pressed MASTERIES BUTTON
				masteriesbuttonclicked = true;
				
			}
		}
		if(mx >= 224 && mx <= (416))
		{
			if(my >= 330 && my <= 378)
			{
				//Pressed STORE BUTTON
				storebuttonclicked = true;
				
			}
		}
		if(mx >= 224 && mx <= (416))
		{
			if(my >= 390 && my <= 438)
			{
				//Pressed QUIT BUTTON
				quitbuttonclicked = true;
				
			}
		}
		}
		
		/////////////////////////////// MENU STATE
		
		/////////////////////////////// POSTGAME STATE
		if(Game.State == STATE.POSTGAME)
		{
			if(mx >=  310 && mx <= 358 && my >= 335 && my <= 383)
			{
				homebuttonclicked = true;
			}
			if(mx >=  195 && mx <= 295 && my >= 335 && my <= 383)
			{
				againbuttonclicked = true;
			}
		}
		/////////////////////////////// POSTGAME STATE
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int mx = e.getX();
		int my = e.getY();
		///////////////////////////////// MENU STATE
		if(Game.State == STATE.MENU)
		{
			
		if(mx >= 224 && mx <= (416) && my >= 150 && my <= 198)
		{
				//Entered PLAY BUTTON
				playbuttonhovered = true;
		}
		else
		{
			playbuttonhovered = false;
		}
		if(mx >= 224 && mx <= (416) && my >= 210 && my <= 258)
		{
				//Entered MULTIPLAYER BUTTON
				multiplayerbuttonhovered = true;
		}
		else
		{
			multiplayerbuttonhovered = false;
		}
		if(mx >= 224 && mx <= (416) && my >= 270 && my <= 318)
		{
				//Entered MASTERIES BUTTON
				masteriesbuttonhovered = true;
				
		}
		else
		{
			masteriesbuttonhovered = false;
		}
		if(mx >= 224 && mx <= (416) && my >= 330 && my <= 378)
		{
				//Entered SHOP BUTTON
				storebuttonhovered = true;
		}
		else
		{
			storebuttonhovered = false;
		}
		if(mx >= 224 && mx <= (416) && my >= 390 && my <= 438)
		{
				quitbuttonhovered = true;

		}
		else
		{
			quitbuttonhovered = false;
		}
		}
		////////////////////////////////////////// MENU STATE
		
		/////////////////////////////// POSTGAME STATE
		if(Game.State == STATE.POSTGAME)
		{
			if(mx >=  310 && mx <= 358 && my >= 335 && my <= 383)
			{
				homebuttonhovered = true;
			}
			else
			{
				homebuttonhovered = false;
			}
			if(mx >=  195 && mx <= 295 && my >= 335 && my <= 383)
			{
				againbuttonhovered = true;
			}
			else
			{
				againbuttonhovered = false;
			}
		}
		/////////////////////////////// POSTGAME STATE
	}


	public void mouseClicked(MouseEvent e) {

	}


	public void mouseEntered(MouseEvent e) {

	}


	public void mouseExited(MouseEvent e) {

	}


	public void mouseReleased(MouseEvent e) {

		int mx = e.getX();
		int my = e.getY();
		
		
		///////////////////////////// MENU STATE
		if(Game.State == STATE.MENU)
		{
			
		if(mx >= 224 && mx <= (416))
		{
			if(my >= 150 && my <= 198)
			{
				//Released PLAY BUTTON
				if(playbuttonclicked)
				{
					playbuttonclicked = false;
					Game.State = STATE.GAME;
				}
				
			}
		}
		if(mx >= 224 && mx <= (416))
		{
			if(my >= 210 && my <= 258)
			{
				//Released MULTIPLAYER BUTTON
				if(multiplayerbuttonclicked)
				{
					multiplayerbuttonclicked = false;
					//GO TO MULTIPLAYER
				}
				
			}
		}
		if(mx >= 224 && mx <= (416))
		{
			if(my >= 270 && my <= 318)
			{
				//Released MASTERIES BUTTON
				if(masteriesbuttonclicked)
				{
					masteriesbuttonclicked = false;
					// GO TO MASTERIES
				}
				
			}
		}
		if(mx >= 224 && mx <= (416))
		{
			if(my >= 330 && my <= 378)
			{
				//Released STORE BUTTON
				if(storebuttonclicked)
				{
					storebuttonclicked = false;
					//GO TO STORE
					
				}
				
			}
		}
		if(mx >= 224 && mx <= (416))
		{
			if(my >= 390 && my <= 438)
			{
				//Released QUIT BUTTON
				if(quitbuttonclicked)
				{
					quitbuttonclicked = false;
					System.exit(1);
				}
				
			}
		}
		
		quitbuttonclicked = false;
		storebuttonclicked = false;
		masteriesbuttonclicked = false;
		multiplayerbuttonclicked = false;
		playbuttonclicked = false;
		}
		
		/////////////////////////////// MENU STATE
		
		/////////////////////////////// POSTGAME STATE
		if(Game.State == STATE.POSTGAME)
		{
			if(mx >=  310 && mx <= 358 && my >= 335 && my <= 383)
			{
				if(homebuttonclicked)
				{
					homebuttonclicked = false;
					coins.updateCoins();
					resetBooleans();
					game.reset();
					Game.State = STATE.MENU;
				}
			}
			if(mx >=  195 && mx <= 295 && my >= 335 && my <= 383)
			{
				if(againbuttonclicked)
				{
					againbuttonclicked = false;
					resetBooleans();
					game.reset();
					Game.State = STATE.GAME;
				}
			}
			
			againbuttonclicked = false;
			homebuttonclicked = false;
		}
		/////////////////////////////// POSTGAME STATE		
		
	}



public static boolean getPlayButtonHovered()
{
	return playbuttonhovered;
}
public static boolean getMultiplayerButtonHovered()
{
	return multiplayerbuttonhovered;
}
public static boolean getMasteriesButtonHovered()
{
	return masteriesbuttonhovered;
}
public static boolean getStoreButtonHovered()
{
	return storebuttonhovered;
}
public static boolean getQuitButtonHovered()
{
	return quitbuttonhovered;
}
public static boolean getHomeButtonHovered()
{
	return homebuttonhovered;
}
public static boolean getAgainButtonHovered()
{
	return againbuttonhovered;
}

// CLICKED MOTHODS

public static boolean getPlayButtonClicked()
{
	return playbuttonclicked;
}
public static boolean getMultiplayerButtonClicked()
{
	return multiplayerbuttonclicked;
}
public static boolean getMasteriesButtonClicked()
{
	return masteriesbuttonclicked;
}
public static boolean getStoreButtonClicked()
{
	return storebuttonclicked;
}
public static boolean getQuitButtonClicked()
{
	return quitbuttonclicked;
}

public static boolean getHomeButtonClicked()
{
	return homebuttonclicked;
}
public static boolean getAgainButtonClicked()
{
	return againbuttonclicked;
}
public void resetBooleans()
{
	playbuttonclicked = playbuttonhovered = multiplayerbuttonclicked = multiplayerbuttonhovered = masteriesbuttonclicked = masteriesbuttonhovered = storebuttonclicked = storebuttonhovered = quitbuttonclicked = quitbuttonhovered = homebuttonclicked = homebuttonhovered = againbuttonclicked = againbuttonhovered = false;
}
}

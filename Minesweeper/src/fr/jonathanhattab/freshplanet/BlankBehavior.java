package fr.jonathanhattab.freshplanet;

import java.awt.Color;

import javax.swing.BorderFactory;

/**
 * This is an implementation of the square behavior by a blank square.
 * @author jonathanhattab
 *
 */
public class BlankBehavior implements SquareBehavior{
	public BlankBehavior(){}
	
	/**
	 * This is how a blank case reacts when it's clicked.
	 */
	public void onClick(Square square, GameBoard gb){
		// Set borders
		square.setBorder(BorderFactory.createLineBorder(Color.green));
		
		// Count around
		int nbAround = gb.countAround(square.getXPos(), square.getYPos());
		
		// Show number around
		if(nbAround>0) square.setText(""+nbAround);
		
		// Or click around if empty 
		else gb.clickAround(square.getXPos(), square.getYPos());
	}
}

package fr.jonathanhattab.freshplanet;

import java.awt.Color;

import javax.swing.BorderFactory;

/**
 * This is an implementation of the square behavior by a mine square.
 * @author jonathanhattab
 *
 */
public class MineBehavior implements SquareBehavior{
	public MineBehavior(){}
	
	/**
	 * This is how the mine reacts when it's clicked.
	 */
	public void onClick(Square square, GameBoard gb) {
		// Set borders.
		square.setBorder(BorderFactory.createLineBorder(Color.red));
		
		// Loose Game...
		gb.looseGame();
	}
}

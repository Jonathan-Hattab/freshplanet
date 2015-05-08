package fr.jonathanhattab.freshplanet;

import java.awt.Color;

import javax.swing.BorderFactory;

public class MineBehaviour implements SquareBehaviour{
	public MineBehaviour(){}

	public void onClick(Square square, GameBoard gb) {
		gb.looseGame();
	}
}

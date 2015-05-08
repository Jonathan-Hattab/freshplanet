package fr.jonathanhattab.freshplanet;

import java.awt.Color;

import javax.swing.BorderFactory;

public class BlankBehaviour implements SquareBehaviour{
	public BlankBehaviour(){}

	public void onClick(Square square, GameBoard gb){
		int nbAround = gb.countAround(square.getXPos(), square.getYPos());
		if(nbAround>0) square.setText(""+nbAround);
		else gb.clickAround(square.getXPos(), square.getYPos());
	}
}

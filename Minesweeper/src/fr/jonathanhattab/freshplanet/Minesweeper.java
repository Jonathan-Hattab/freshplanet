package fr.jonathanhattab.freshplanet;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Minesweeper {
	// ----- ATTRIBUTS -----
	private GameBoard gameBoard;
	
	// ----- CONSTRUCTOR -----
	public Minesweeper(){
		// Select difficulty
		String[] difficulties = {"Easy", "Medium", "Hard"};
		ArrayList<String> difficultiesArray = new ArrayList<String>();
		for(int i=0; i<difficulties.length; i++) difficultiesArray.add(difficulties[i]);
	    String difficulty = (String)JOptionPane.showInputDialog(
	    		null, 
	    		"Left-Click to reveal a case.\nRight-Click to mark a case.\nSelect a difficulty : ", 
	    		"Minesweeper", 
	    		JOptionPane.QUESTION_MESSAGE, 
	    		null, 
	    		difficulties, 
	    		difficulties[1]
	    );
	    
	    if(difficulty != null){
	    	// Start Game with the chosen difficulty
	    	int difficultyIndex = difficultiesArray.indexOf(difficulty);
	    	this.gameBoard = new GameBoard(GameBoard.LEVELS[difficultyIndex][0], GameBoard.LEVELS[difficultyIndex][1], GameBoard.LEVELS[difficultyIndex][2]);
	    }
	    else System.exit(0);
	}
}
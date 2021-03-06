package fr.jonathanhattab.freshplanet;

import javax.swing.JOptionPane;

/**
 * Minesweeper is the class representing the whole minesweeper game.
 * @author jonathanhattab
 *
 */
public class Minesweeper {
	/**
	 * gameBoard is the game board on which the game is played.
	 */
	@SuppressWarnings("unused")
	private GameBoard gameBoard;

	/**
	 * This is the constructor of the Minesweeper class. It takes no attribute.
	 */
	public Minesweeper(){
		// Select difficulty
		Object[] difficulties = GameBoard.LEVELS.keySet().toArray();
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
	    	this.gameBoard = new GameBoard(GameBoard.LEVELS.get(difficulty));
	    }
	    else System.exit(0);
	}
}

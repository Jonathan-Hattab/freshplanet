package fr.jonathanhattab.freshplanet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard extends JFrame{
	// ------- ATTRIBUTS ------
	private int nbLines;
	private int nbColumns;
	private int nbMines;
	private ArrayList<ArrayList<Square>> squares;
	
	// ------ CONSTRUCTOR ------
	public GameBoard(){
		this.setSize(500,494);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("FreshPlanet Minesweeper");
		
		this.nbLines = 10;
		this.nbColumns = 10;
		this.nbMines = 10;
		
		this.initComponent();
		this.setVisible(true);
	}
	public GameBoard(int nbLines, int nbColumns, int nbMines){
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("FreshPlanet Minesweeper");
		
		this.nbLines = nbLines;
		this.nbColumns = nbColumns;
		this.nbMines = nbMines;
		
		this.initComponent();
		this.setVisible(true);
	}

	// ------- INITIALIZE -----
	private void initComponent() {
		JPanel background = new JPanel();
		background.setLayout(new GridLayout(this.nbLines,this.nbColumns));
		
		// Random selection of mine indexes
		ArrayList<Integer> mines = new ArrayList<Integer>();
		for(int i=0; i<this.nbMines; i++){
			Integer index = 0;
			do{
				index = (int) Math.floor(this.nbLines*this.nbColumns*Math.random());
			}while(mines.contains(index));
			mines.add(index);
		}
		
		// Insertion of the squares
		this.squares = new ArrayList<ArrayList<Square>>();
		for(int i=0; i<this.nbLines; i++){
			ArrayList<Square> line = new ArrayList<Square>();
			for(int j=0; j<this.nbColumns; j++){
				// Defining type
				int type = 0;
				if(mines.contains(i*this.nbColumns+j)) type = Square.MINE_TYPE;
				else type = Square.BLANK_TYPE;
				
				Square square = new Square(this, i, j, type);
				line.add(square);
				background.add(square);
			}
			this.squares.add(line);
		}
		
		this.setContentPane(background);
	}
	
	public int countAround(int x, int y){
		int nbMines = 0;
		for(int i=Math.max(0, x-1); i<Math.min(this.nbColumns, x+2); i++){
			for(int j=Math.max(0, y-1); j<Math.min(this.nbColumns, y+2); j++){
				Square square = this.squares.get(i).get(j);
				if(square.getType() == Square.MINE_TYPE) nbMines++;
			}
		}
		return nbMines;
	}
	public int clickAround(int x, int y){
		int nbMines = 0;
		for(int i=Math.max(0, x-1); i<Math.min(this.nbColumns, x+2); i++){
			for(int j=Math.max(0, y-1); j<Math.min(this.nbColumns, y+2); j++){
				Square square = this.squares.get(i).get(j);
				if(!square.isShown()) square.click();
			}
		}
		return nbMines;
	}
	public void looseGame(){
		System.out.println("Looooost !!");
	}
}

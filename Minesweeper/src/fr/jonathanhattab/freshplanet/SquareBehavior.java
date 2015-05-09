package fr.jonathanhattab.freshplanet;

/**
 * This is the interface defining the functions a square behavior must contain. It enables an implementation of the Behavior Pattern.
 * @author jonathanhattab
 *
 */
public interface SquareBehavior {
	/**
	 * This method needs to define the behavior of the case when it is clicked.
	 * @param square
	 * @param gb
	 */
	public void onClick(Square square, GameBoard gb);
}

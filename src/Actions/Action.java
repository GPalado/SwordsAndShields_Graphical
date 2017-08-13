package Actions;

import Tiles.Reactables.Piece;

/**
 * This interface determines the actions needed to be applied by Actions in the Swords and Shields game
 */
public interface Action {

    /**
     * This method executes the action on the given board.
     * @param board
     */
    void execute(SnSGame.Board board);

    /**
     * This method undoes the action on the board.
     */
    void undo();

    /**
     * This method returns the piece involved in the action, when applicable
     * @return
     */
    Piece getPiece();
}

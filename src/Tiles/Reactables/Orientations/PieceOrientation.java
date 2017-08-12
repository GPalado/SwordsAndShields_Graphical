package Tiles.Reactables.Orientations;

import Tiles.Reactables.Piece;
import Tiles.Reactables.Symbol;

/**
 * This interface outlines the representation of  piece's orientation.
 */
public interface PieceOrientation {

    /**
     * This method rotates the given piece's orientation by the given amount and changes the piece's orientation state accordingly.
     * @param piece
     * @param amount
     */
    void rotate(Piece piece, int amount);

    /**
     * This method returns the piece's character representation based on it'sorientation state
     * @param piece
     * @return
     */
    Character[][] getRepresentation(Piece piece);

    /**
     * This method returns the piece's left symbol in it's current orientation
     * @return
     */
    Symbol getLeftSymbol(Piece piece);

    /**
     * This method returns the piece's right symbol in it's current orientation
     * @return
     */
    Symbol getRightSymbol(Piece piece);

    /**
     * This method returns the piece's top symbol in it's current orientation
     * @return
     */
    Symbol getTopSymbol(Piece piece);

    /**
     * This method returns the piece's bottom symbol in it's current orientation
     * @return
     */
    Symbol getBottomSymbol(Piece piece);
}

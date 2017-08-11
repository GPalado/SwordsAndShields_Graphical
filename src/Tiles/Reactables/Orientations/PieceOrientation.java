package Tiles.Reactables.Orientations;

import Tiles.Reactables.Piece;

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
}

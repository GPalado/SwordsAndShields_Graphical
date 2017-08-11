package Tiles.Reactables.Orientations;

import Tiles.Reactables.Piece;

/**
 * This class provides a representation of a '180' degree orientation for a piece.
 */
public class Orientation180 implements PieceOrientation {

    public Orientation180(){}

    @Override
    public void rotate(Piece piece, int amount) {

    }

    @Override
    public Character[][] getRepresentation(Piece piece) {
        return new Character[0][];
    }
}

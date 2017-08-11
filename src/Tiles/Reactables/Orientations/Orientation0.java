package Tiles.Reactables.Orientations;

import Tiles.Reactables.Piece;

/**
 * This class provides a representation of a '0' degree orientation for a piece.
 */
public class Orientation0 implements PieceOrientation {

    public Orientation0(){}

    @Override
    public void rotate(Piece piece, int amount) {

    }

    @Override
    public Character[][] getRepresentation(Piece piece) {
        return new Character[0][];
    }
}

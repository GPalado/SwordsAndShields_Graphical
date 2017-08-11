package Tiles.Reactables.Orientations;

import Tiles.Reactables.Piece;

/**
 * This class provides a representation of a '90' degree orientation for a piece.
 */
public class Orientation90 implements PieceOrientation {

    public Orientation90(){}

    @Override
    public void rotate(Piece piece, int amount) {

    }

    @Override
    public Character[][] getRepresentation(Piece piece) {
        return new Character[0][];
    }
}

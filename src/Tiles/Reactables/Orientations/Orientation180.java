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
        Character[][] rep = new Character[][]{
                {' ', ' ', ' '}, //first column
                {' ', piece.letter, ' '}, //second column
                {' ', ' ', ' '} //third column
        } ;
        return rep;
    }
}

package Tiles.Reactables.Orientations;

import Tiles.Reactables.Piece;

import static Tiles.Reactables.Piece.orientations;

/**
 * * This class provides a representation of a '270' degree orientation for a piece.
 */
public class Orientation270 implements PieceOrientation {
    private static final int currentOrientation = 270;

    public Orientation270(){}

    @Override
    public void rotate(Piece piece, int amount) {
        piece.setOrientation(orientations.get((currentOrientation+amount>=360) ? currentOrientation+amount-360 : amount+currentOrientation));
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

package Tiles.Reactables.Orientations;

import Tiles.Reactables.Piece;

import static Tiles.Reactables.Piece.orientations;
import static Tiles.Reactables.Piece.symbolCharacterMap;

/**
 * This class provides a representation of a '180' degree orientation for a piece.
 */
public class Orientation180 implements PieceOrientation {
    private static final int currentOrientation = 180;

    public Orientation180(){}

    @Override
    public void rotate(Piece piece, int amount) {
        piece.setOrientation(orientations.get((currentOrientation+amount>=360) ? currentOrientation+amount-360 : amount+currentOrientation));
    }

    @Override
    public Character[][] getRepresentation(Piece piece) {
        Character[][] rep = new Character[][]{
                {' ', symbolCharacterMap.get(piece.symbols[1]), ' '}, //first column
                {symbolCharacterMap.get(piece.symbols[2]), piece.letter, symbolCharacterMap.get(piece.symbols[0])}, //second column
                {' ', symbolCharacterMap.get(piece.symbols[3]), ' '} //third column
        } ;
        return rep;
    }
}

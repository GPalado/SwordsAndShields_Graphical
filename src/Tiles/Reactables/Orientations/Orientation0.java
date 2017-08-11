package Tiles.Reactables.Orientations;

import Tiles.Reactables.Piece;

import static Tiles.Reactables.Piece.orientations;
import static Tiles.Reactables.Piece.symbolCharacterMap;

/**
 * This class provides a representation of a '0' degree orientation for a piece.
 */
public class Orientation0 implements PieceOrientation {

    public Orientation0(){}

    @Override
    public void rotate(Piece piece, int amount) {
        piece.setOrientation(orientations.get(amount));
    }

    @Override
    public Character[][] getRepresentation(Piece piece) {
        Character[][] rep = new Character[][]{
                {' ', symbolCharacterMap.get(piece.symbols[1]), ' '}, //first column
                {symbolCharacterMap.get(piece.symbols[0]), piece.letter, symbolCharacterMap.get(piece.symbols[2])}, //second column
                {' ', symbolCharacterMap.get(piece.symbols[3]), ' '} //third column
        } ;
        return rep;
    }
}

package Tiles.Reactables.Orientations;

import Tiles.Reactables.Piece;
import Tiles.Reactables.Symbol;

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

    @Override
    public Symbol getLeftSymbol(Piece piece) {
        return piece.symbols[1];
    }

    @Override
    public Symbol getRightSymbol(Piece piece) {
        return piece.symbols[3];
    }

    @Override
    public Symbol getTopSymbol(Piece piece) {
        return piece.symbols[2];
    }

    @Override
    public Symbol getBottomSymbol(Piece piece) {
        return piece.symbols[0];
    }
}

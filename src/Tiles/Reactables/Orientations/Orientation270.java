package Tiles.Reactables.Orientations;

import Tiles.Reactables.Piece;
import Tiles.Reactables.Symbol;

import static Tiles.Reactables.Piece.orientations;
import static Tiles.Reactables.Piece.symbolCharacterMap;

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
                {' ', piece.symbols[0].name().equals("SWORD_VERTICAL") ? symbolCharacterMap.get(Symbol.SWORD_HORIZONTAL) : symbolCharacterMap.get(piece.symbols[0]), ' '}, //first column
                {piece.symbols[1].name().equals("SWORD_HORIZONTAL") ? symbolCharacterMap.get(Symbol.SWORD_VERTICAL) : symbolCharacterMap.get(piece.symbols[1]), piece.letter, piece.symbols[3].name().equals("SWORD_HORIZONTAL") ? symbolCharacterMap.get(Symbol.SWORD_VERTICAL) : symbolCharacterMap.get(piece.symbols[3])}, //second column
                {' ', piece.symbols[2].name().equals("SWORD_VERTICAL") ? symbolCharacterMap.get(Symbol.SWORD_HORIZONTAL) : symbolCharacterMap.get(piece.symbols[2]), ' '} //third column
        } ;
        return rep;
    }

    @Override
    public Symbol getLeftSymbol(Piece piece) {
        return piece.symbols[0].name().equals("SWORD_VERTICAL") ? Symbol.SWORD_HORIZONTAL : piece.symbols[0];
    }

    @Override
    public Symbol getRightSymbol(Piece piece) {
        return piece.symbols[2].name().equals("SWORD_VERTICAL") ? Symbol.SWORD_HORIZONTAL : piece.symbols[2];
    }

    @Override
    public Symbol getTopSymbol(Piece piece) {
        return piece.symbols[1].name().equals("SWORD_HORIZONTAL") ? Symbol.SWORD_VERTICAL : piece.symbols[1];
    }

    @Override
    public Symbol getBottomSymbol(Piece piece) {
        return piece.symbols[3].name().equals("SWORD_HORIZONTAL") ? Symbol.SWORD_VERTICAL : piece.symbols[3];
    }
}

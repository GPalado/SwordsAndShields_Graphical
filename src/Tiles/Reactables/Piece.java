package Tiles.Reactables;

import Actions.Visitors.Visitor;
import SnSGame.InvalidMoveException;
import Tiles.Reactables.Orientations.*;
import Tiles.Tile;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a representation of a Piece in the Swords and Shields game.
 */
public class Piece implements Tile, Reactable {

    public static final Map<Symbol, Character> symbolCharacterMap;
    public static final Map<Integer, PieceOrientation> orientations;
    public final Character letter;
    public final Symbol[] symbols;
    private Point position;
    private Status status;
    private PieceOrientation pieceOrientation;

    static {
        symbolCharacterMap = new HashMap<>();
        symbolCharacterMap.put(Symbol.SWORD_VERTICAL, '|');
        symbolCharacterMap.put(Symbol.SWORD_HORIZONTAL, '-');
        symbolCharacterMap.put(Symbol.SHIELD, '#');
        symbolCharacterMap.put(Symbol.NOTHING, ' ');
        orientations=new HashMap<>();
        orientations.put(0, new Orientation0());
        orientations.put(90, new Orientation90());
        orientations.put(180, new Orientation180());
        orientations.put(270, new Orientation270());
    }

    public enum Symbol{
        SWORD_VERTICAL,
        SWORD_HORIZONTAL,
        SHIELD,
        NOTHING
    }

    /**
     * The constructor takes a character array representation of the piece.
     * It sets initial values of moved to false, and status to unused.
     * Note, the Symbol array symbols are in order of NORTH, EAST, SOUTH, WEST
     */
    public Piece(Symbol[] symbols, char letter){
        if(symbols.length!=4){
            throw new IllegalArgumentException("There should be 4 symbols in the array");
        }
        status=Status.UNUSED;
        this.symbols=symbols;
        this.letter=letter;
        pieceOrientation=orientations.get(0);
    }

    /**
     * This method sets the piece's position to the given coordinates.
     * @param x
     * @param y
     */
    public void setPosition(int x, int y){
        position=new Point(x, y);
    }

    /**
     * This method rotates the piece by the given amount (0/90/180/270)
     * @param amount
     */
    public void rotate(int amount){
        //todo implement this
        if(!orientations.keySet().contains(amount)){
            throw new InvalidMoveException("That is an invalid orientation");
        }
        pieceOrientation.rotate(this, amount);
    }

    /**
     * This method sets the piece's orientation to the given orientation
     * @param o
     */
    public void setOrientation(PieceOrientation o){
        if(!orientations.values().contains(o)){
            throw new InvalidMoveException("That is an invalid orientation");
        }
        pieceOrientation=o;
    }

    /**
     * This method returns the piece's orientation
     * @return
     */
    public PieceOrientation getOrientation(){
        return pieceOrientation;
    }

    /**
     * This method reverts the piece back to the unused state.
     */
    public void backToUnused(){ status=Status.UNUSED; }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void kill() {
        status=Status.CEMETERY;
    }

    @Override
    public void toLife() {
        status=Status.ON_BOARD;
    }

    @Override
    public Character[][] getRepresentation() {
        return pieceOrientation.getRepresentation(this);
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPiece(this);
    }
}

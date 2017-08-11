package Tiles.Reactables;

import Actions.Visitors.Visitor;
import Tiles.Tile;
import java.awt.*;

/**
 * This class provides a representation of a Piece in the Swords and Shields game.
 */
public class Piece implements Tile, Reactable {

    private int orientation;
    private Character[][] representation;
    private Point position;
    private Status status;

    /**
     * The constructor takes a character array representation of the piece.
     * It sets initial values of moved to false, and status to unused.
     */
    public Piece(Character[][] pieceRep){
        status=Status.UNUSED;
        representation=pieceRep;
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
    }

    /**
     * This method sets the piece's orientation to the given orientation
     * @param o
     */
    public void setOrientation(int o){
        orientation=o;
        rotate(o);
    }

    /**
     * This method returns the piece's orientation
     * @return
     */
    public int getOrientation(){
        return orientation;
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
        return representation;
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

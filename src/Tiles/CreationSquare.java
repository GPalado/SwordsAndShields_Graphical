package Tiles;

import Actions.Visitors.Visitor;
import SnSGame.InvalidMoveException;
import Tiles.Reactables.Piece;
import Tiles.Reactables.Reactable;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class is a representation of a creation square on a Swords and Shields game's board.
 */
public class CreationSquare implements Tile {
    private Character[][] representation;
    private Point position;
    private Piece piece;

    /**
     * The constructor takes a point parameter which is the position at which the Creation square will be on the board
     * @param pos
     */
    public CreationSquare(Point pos){
        representation=new Character[][]{{'/', '|', '\\'}, {'-', ' ', '-'}, {'\\', '|', '/'}};
        position=pos;
    }

    /**
     * This method returns a boolean representing whether there is a piece on the creation square or not.
     */
    public boolean isOccupied(){
        return piece!=null;
    }

    /**
     * This method returns the piece on the creation square, if there is any, and throws and exception otherwise.
     * @return
     */
    public Piece getPiece(){
        if(piece==null) throw new InvalidMoveException("This CS doesn't have a piece");
        return piece;
    }

    /**
     * This method takes a piece as a parameter, to be set as the creation square's piece.
     * I.e. the player created a piece.
     * @param piece
     */
    public void setPiece(Piece piece){
        this.piece=piece;
        if(piece!=null) {
            this.piece.setPosition(position.x, position.y);
        }
    }

    @Override
    public Character[][] getRepresentation() {
        if(isOccupied()) return piece.getRepresentation();
        return representation;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCreation(this);
    }

    @Override
    public ArrayList<Reactable> accept(ArrayList<Reactable> reactableList) {
        return reactableList;
    }

}

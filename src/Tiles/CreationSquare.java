package Tiles;

import Actions.Action;
import Actions.Visitors.Visitor;
import SnSGame.InvalidMoveException;
import Tiles.Reactables.Piece;

import java.awt.*;
import java.util.Optional;

public class CreationSquare implements Tile {
    private boolean movable;
    private Character[][] representation;
    private Point position;
    private Piece piece; //todo use optional?

    public CreationSquare(Point pos){
        movable=false;
        representation=new Character[][]{{'/', '|', '\\'}, {'-', ' ', '-'}, {'\\', '|', '/'}};
        position=pos;
    }

    public boolean isOccupied(){
        return piece!=null;
    }

    public Piece getPiece(){
        if(piece==null) throw new InvalidMoveException("This CS doesn't have a piece");
        return piece;
    }

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
    public boolean isMovable() {
        return movable;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCreation(this);
    }

}

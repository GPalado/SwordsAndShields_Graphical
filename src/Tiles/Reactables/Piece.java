package Tiles.Reactables;

import Actions.Visitors.Visitor;
import Tiles.Tile;

import java.awt.*;

public class Piece implements Tile, Reactable {

    private int orientation;
    private char letter;
    private boolean moved;
    private boolean movable;
    private Character[][] representation;
    private Point position;
    private Status status;

    public Piece(Character[][] pieceRep){
        moved=false;
        movable=true;
        status=Status.UNUSED;
        representation=pieceRep;
        letter=representation[1][1];
    }

    public void setPosition(int x, int y){
        position=new Point(x, y);
    }

    public void rotate(int amount){
        //todo implement this
    }

    public boolean beenMoved(){
        return moved;
    }

    public void setMoved(boolean b){
        moved=b;
    }

    public void setOrientation(int o){
        orientation=o;
        rotate(o);
    }

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
    public boolean isMovable() {
        return movable;
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

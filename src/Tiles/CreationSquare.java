package Tiles;

import Tiles.Reactables.Piece;

import java.awt.*;
import java.util.Optional;

public class CreationSquare implements Tile {
    private boolean movable;
    private Character[][] representation;
    private Point position;
    private Optional<Piece> piece; //todo use this properly

    public CreationSquare(Point pos){
        movable=false;
        representation=new Character[][]{{'/', '|', '\\'}, {'-', ' ', '-'}, {'\\', '|', '/'}};
        position=pos;
    }

    public boolean isOccupied(){
        //todo implement this
        return false;
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
    public void accept(Action action) {

    }
}

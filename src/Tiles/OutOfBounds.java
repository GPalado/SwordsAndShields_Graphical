package Tiles;

import java.awt.*;

public class OutOfBounds implements Tile {

    private boolean movable;
    private Character[][] representation;
    private Point position;
    private Optional<Piece> piece;

    public OutOfBounds(Point pos){
        movable=false;
        representation=new Character[][]{{'x', 'x', 'x'},{'x', 'x', 'x'},{'x', 'x', 'x'}};;
        position=pos;
    }

    @Override
    public Character[][] getRepresentation() {
        return new Character[0][];
    }

    @Override
    public boolean isMovable() {
        return false;
    }

    @Override
    public Point getPosition() {
        return null;
    }

    @Override
    public void accept(Action action) {

    }
}

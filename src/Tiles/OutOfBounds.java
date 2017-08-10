package Tiles;

import Actions.Visitors.Visitor;

import java.awt.*;

public class OutOfBounds implements Tile {

    private boolean movable;
    private Character[][] representation;
    private Point position;

    public OutOfBounds(Point pos){
        movable=false;
        representation=new Character[][]{{'x', 'x', 'x'},{'x', 'x', 'x'},{'x', 'x', 'x'}};;
        position=pos;
    }

    @Override
    public Character[][] getRepresentation() { return representation; }

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
        visitor.visitOOB(this);
    }
}

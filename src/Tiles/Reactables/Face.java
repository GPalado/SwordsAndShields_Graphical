package Tiles.Reactables;

import Actions.Visitors.Visitor;
import Tiles.Tile;

import java.awt.*;

public class Face implements Tile, Reactable {

    private boolean movable;
    private Character[][] representation;
    private Point position;
    private Status status;

    public Face(char face, Point pos){
        movable=false;
        representation= new Character[][]{{' ', ' ', ' '}, {' ', face, ' '}, {' ', ' ', ' '}};
        position=pos;
        status = Status.ON_BOARD;
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
        visitor.visitFace(this);
    }

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
        status=Status.ON_BOARD;♦
    }
}

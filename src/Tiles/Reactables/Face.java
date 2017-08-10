package Tiles.Reactables;

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

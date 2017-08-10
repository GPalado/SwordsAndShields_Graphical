package Tiles;

import java.awt.*;

public class EmptySpace implements Tile {

    private boolean movable;
    private Character[][] representation;
    private Point position;

    public EmptySpace(Point pos){
        movable=false;
        representation=new Character[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        position=pos;
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

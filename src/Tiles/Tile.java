package Tiles;

import Actions.Visitors.Visitor;

import java.awt.*;

public interface Tile {
    //todo double check what you want to do here
//    boolean movable;
//    Character[][] representation;
//    Point position;

    public Character[][] getRepresentation();

    public boolean isMovable();

    public Point getPosition();

    public void accept(Visitor visitor);

}

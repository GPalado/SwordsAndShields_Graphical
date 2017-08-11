package Tiles;

import Actions.Visitors.Visitor;

import java.awt.*;

public interface Tile {

    Character[][] getRepresentation();

    boolean isMovable();

    Point getPosition();

    void accept(Visitor visitor);
}

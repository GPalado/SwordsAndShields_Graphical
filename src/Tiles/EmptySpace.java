package Tiles;

import Actions.Visitors.Visitor;
import Tiles.Reactables.Reactable;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class is a representation of an empty tile on the Swords and Shields board.
 */
public class EmptySpace implements Tile {
    private Character[][] representation;
    private Point position;

    /**
     * The constructor takes a point parameter which is the position at which the EmptySpace tile will be on the board
     * @param pos
     */
    public EmptySpace(Point pos){
        representation=new Character[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        position=pos;
    }

    @Override
    public Character[][] getRepresentation() {
        return representation;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEmpty(this);
    }

    @Override
    public ArrayList<Reactable> accept(ArrayList<Reactable> reactableList) {
        return reactableList;
    }
}

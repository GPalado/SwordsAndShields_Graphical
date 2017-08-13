package Tiles;

import Actions.Visitors.Visitor;
import Tiles.Reactables.Reactable;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class is a representation of an OutOfBounds tile on a Swords and Shields game's board.
 */
public class OutOfBounds implements Tile {

    private Character[][] representation;
    private Point position;

    /**
     * The constructor takes the position at which the OutOfBounds tile is on the board.
     * @param pos
     */
    public OutOfBounds(Point pos){
        representation=new Character[][]{{'x', 'x', 'x'},{'x', 'x', 'x'},{'x', 'x', 'x'}};;
        position=pos;
    }

    @Override
    public Character[][] getRepresentation() { return representation; }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitOOB(this);
    }

    @Override
    public ArrayList<Reactable> accept(ArrayList<Reactable> reactableList) {
        return reactableList;
    }
}

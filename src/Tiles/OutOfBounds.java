package Tiles;

import Actions.Visitors.Visitor;

import java.awt.*;

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
}

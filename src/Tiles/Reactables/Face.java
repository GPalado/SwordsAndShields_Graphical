package Tiles.Reactables;

import Actions.Visitors.Visitor;
import Tiles.Tile;

import java.awt.*;

/**
 * This class is a representation of the reactable face tile of a Swords and Shields game.
 */
public class Face implements Tile, Reactable {

    private Character[][] representation;
    private Point position;
    private Status status;

    /**
     * The constructor takes a face character and a point as parameters.
     * The former is used to construct the character representation, and the latter used to determine it's position on the board.
     * @param face
     * @param pos
     */
    public Face(char face, Point pos){
        representation= new Character[][]{{' ', ' ', ' '}, {' ', face, ' '}, {' ', ' ', ' '}};
        position=pos;
        status = Status.ON_BOARD;
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
        visitor.visitFace(this);
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void kill() { status=Status.CEMETERY; }

    @Override
    public void toLife() { status=Status.ON_BOARD; }
}

package Tiles.Reactables;

import Actions.Visitors.Visitor;
import Tiles.Tile;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class is a representation of the reactable face tile of a Swords and Shields game.
 */
public class Face implements Reactable {

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
    public ArrayList<Reactable> accept(ArrayList<Reactable> reactableList) {
        reactableList.add(this);
        return reactableList;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void kill() { status=Status.CEMETERY; }

    @Override
    public void toLife() { status=Status.ON_BOARD; }

    @Override
    public Symbol getLeftSymbol() {
        return Symbol.NOTHING;
    }

    @Override
    public Symbol getRightSymbol() {
        return Symbol.NOTHING;
    }

    @Override
    public Symbol getTopSymbol() {
        return Symbol.NOTHING;
    }

    @Override
    public Symbol getBottomSymbol() { return Symbol.NOTHING; }

    @Override
    public Character getLetter() {
        return representation[1][1];
    }
}

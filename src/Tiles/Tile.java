package Tiles;

import Actions.Visitors.Visitor;
import java.awt.*;

/**
 * This interface specifies the methods required to be implemented by the tiles on a Swords and Shields game's board
 */
public interface Tile {

    /**
     * This method returns the tile's representation
     * @return
     */
    Character[][] getRepresentation();

    /**
     * This method returns the tile's position
     * @return
     */
    Point getPosition();

    /**
     * This method accepts a visitor to apply actions determined by the tile's concrete type.
     * @param visitor
     */
    void accept(Visitor visitor);
}

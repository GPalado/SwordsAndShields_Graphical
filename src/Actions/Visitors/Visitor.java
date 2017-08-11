package Actions.Visitors;

import Tiles.*;
import Tiles.Reactables.*;

/**
 * This interface specifies the actions to be implemented by concrete visitors
 */
public interface Visitor {

    void visitPiece(Piece piece);

    void visitFace(Face face);

    void visitOOB(OutOfBounds oob);

    void visitEmpty(EmptySpace empty);

    void visitCreation(CreationSquare cs);

}

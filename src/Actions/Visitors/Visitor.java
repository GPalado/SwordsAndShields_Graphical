package Actions.Visitors;

import Tiles.*;
import Tiles.Reactables.*;

public interface Visitor {

    void visitPiece(Piece piece);

    void visitFace(Face face);

    void visitOOB(OutOfBounds oob);

    void visitEmpty(EmptySpace empty);

    void visitCreation(CreationSquare cs);

}

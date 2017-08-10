package Actions.Visitors;

import Tiles.*;
import Tiles.Reactables.*;

public interface Visitor {

    public void visitPiece(Piece piece);

    public void visitFace(Face face);

    public void visitOOB(OutOfBounds oob);

    public void visitEmpty(EmptySpace empty);

    public void visitCreation(CreationSquare cs);

}

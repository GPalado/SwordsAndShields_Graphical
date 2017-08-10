package Actions.Visitors;

import SnSGame.Board;
import SnSGame.Player;
import Tiles.CreationSquare;
import Tiles.EmptySpace;
import Tiles.OutOfBounds;
import Tiles.Reactables.Face;
import Tiles.Reactables.Piece;

public class MoveLeft extends MoveActionVisitor {

    private Board board;

    public MoveLeft(Piece p, Player pl){
        super(p, pl);
    }

    @Override
    public void execute(Board board) {
        //todo implement this
        this.board=board;
    }

    @Override
    public void undo() {
        //todo implement this
    }

    @Override
    public void visitPiece(Piece piece) {
        //todo implement this
    }

    @Override
    public void visitFace(Face face) {
        //todo implement this
    }

    @Override
    public void visitOOB(OutOfBounds oob) {
        //todo implement this
    }

    @Override
    public void visitEmpty(EmptySpace empty) {
        //todo implement this
    }

    @Override
    public void visitCreation(CreationSquare cs) {
        //todo implement this
    }
}

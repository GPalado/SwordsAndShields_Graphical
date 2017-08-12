package Actions.Visitors;

import Actions.Action;
import SnSGame.Board;
import SnSGame.Player;
import Tiles.EmptySpace;
import Tiles.OutOfBounds;
import Tiles.Reactables.Face;
import Tiles.Reactables.Piece;
import java.util.ArrayList;
import java.util.List;

/**
 * This abstract MOVE class provides general implementations of some of the methods specified by Action and Visitor interfaces.
 */
public abstract class MoveActionVisitor implements Action, Visitor{
    protected Piece pieceToPlace;
    protected Piece startingPiece;
    protected List<Piece> piecesPushed;
    protected Player player;
    protected Board board;

    /**
     * The constructor takes the piece to be moved and the player involved.
     * @param p
     * @param player
     */
    public MoveActionVisitor(Piece p, Player player){
        pieceToPlace=p;
        startingPiece=p;
        piecesPushed=new ArrayList<>();
        this.player=player;
    }

    @Override
    public void visitFace(Face face) {
        if(pieceToPlace!=startingPiece) piecesPushed.add(pieceToPlace);
        pieceToPlace.kill();
    }

    @Override
    public void visitOOB(OutOfBounds oob) {
        System.out.println("OOB");
        if(pieceToPlace!=startingPiece) piecesPushed.add(pieceToPlace);
        pieceToPlace.kill();
    }

    @Override
    public void visitEmpty(EmptySpace empty) {
        if(pieceToPlace!=startingPiece) piecesPushed.add(pieceToPlace);
        board.setPiece(pieceToPlace, empty.getPosition().x, empty.getPosition().y);
    }
}

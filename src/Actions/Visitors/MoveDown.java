package Actions.Visitors;

import SnSGame.Board;
import SnSGame.Player;
import Tiles.CreationSquare;
import Tiles.EmptySpace;
import Tiles.OutOfBounds;
import Tiles.Reactables.Face;
import Tiles.Reactables.Piece;
import Tiles.Tile;

import java.util.ArrayList;
import java.util.List;

public class MoveDown extends MoveActionVisitor {

    private Piece pieceToPlace;
    private Piece startingPiece;
    private List<Piece> piecesPushed;
    private Player player;
    private Board board;

    public MoveDown(Piece p, Player pl){
        super(p, pl);
        pieceToPlace=p;
        startingPiece=p;
        piecesPushed=new ArrayList<>();
        this.player=pl;
    }

    @Override
    public void execute(Board board) {
        //todo implement this
        this.board=board;
        Tile shift = board.getLeftOf(startingPiece);
        shift.accept(this);
    }

    @Override
    public void undo() {
        //todo implement this
    }

    @Override
    public void visitPiece(Piece piece) {
        board.setPiece(pieceToPlace, piece.getPosition().x, piece.getPosition().y);
        pieceToPlace = piece;
        piecesPushed.add(piece);
    }

    @Override
    public void visitFace(Face face) {
        pieceToPlace.kill();
    }

    @Override
    public void visitOOB(OutOfBounds oob) {
        pieceToPlace.kill();
    }

    @Override
    public void visitEmpty(EmptySpace empty) {
        board.setPiece(pieceToPlace, empty.getPosition().x, empty.getPosition().y);
    }

    @Override
    public void visitCreation(CreationSquare cs) {
        cs.setPiece(pieceToPlace);
    }
}

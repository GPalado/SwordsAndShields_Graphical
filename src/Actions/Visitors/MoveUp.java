package Actions.Visitors;

import SnSGame.Board;
import SnSGame.InvalidMoveException;
import SnSGame.Player;
import Tiles.CreationSquare;
import Tiles.Reactables.Piece;
import Tiles.Reactables.Reactable;
import Tiles.Tile;

/**
 * This class provides the full implementation of the move up action
 */
public class MoveUp extends MoveActionVisitor {

    public MoveUp(Piece p, Player pl){
        super(p, pl);
    }

    @Override
    public void execute(Board board) {
        if(player.getPiecesMoved().contains(startingPiece)){
            throw new InvalidMoveException("Cannot move a piece that has already been moved!");
        }
        player.pieceMoved(startingPiece);
        this.board=board;
        if(pieceToPlace.getPosition().equals(player.creationSquare.getPosition())){ //set creation square to no piece
            player.creationSquare.setPiece(null);
        } else { //set tile that had piece to new emptySpace
            board.setEmpty(pieceToPlace.getPosition().x, pieceToPlace.getPosition().y);
        }
        Tile shift = board.getAboveOf(startingPiece);
        shift.accept(this);
    }

    @Override
    public void visitPiece(Piece piece) {
        if(pieceToPlace!=startingPiece)piecesPushed.add(pieceToPlace);
        board.setPiece(pieceToPlace, piece.getPosition().x, piece.getPosition().y);
        pieceToPlace=piece;
        Tile shift = board.getAboveOf(pieceToPlace);
        shift.accept(this);
    }

    @Override
    public void visitCreation(CreationSquare cs) {
        if(pieceToPlace!=startingPiece) piecesPushed.add(pieceToPlace);
        if(cs.isOccupied()){
            Piece temp = cs.getPiece();
            cs.setPiece(pieceToPlace);
            pieceToPlace=temp;
            Tile shift = board.getAboveOf(pieceToPlace);
            shift.accept(this);
        } else {
            cs.setPiece(pieceToPlace);
        }
    }

    @Override
    public void undo() {
        player.pieceNotMoved(startingPiece);
        if(piecesPushed.isEmpty()){ //just move the one piece
            if(startingPiece.getStatus().equals(Reactable.Status.CEMETERY)){
                startingPiece.toLife();
                board.setPiece(startingPiece, startingPiece.getPosition().x, startingPiece.getPosition().y);
            } else {
                board.apply(new MoveDown(startingPiece, player));
            }
        } else if(startingPiece.getPosition().y-piecesPushed.size()<0) { //move all pushed pieces and bring other piece back to life
            if(piecesPushed.size()==1){
                board.apply(new MoveDown(startingPiece, player));
            } else {
                board.apply(new MoveDown(piecesPushed.get(piecesPushed.size() - 2), player));
            }
            piecesPushed.get(piecesPushed.size()-1).toLife();
            board.setPiece(piecesPushed.get(piecesPushed.size()-1), startingPiece.getPosition().x, 0);
        } else { //move all pushed pieces
            board.apply(new MoveDown(piecesPushed.get(piecesPushed.size()-1), player));
        }
    }
}

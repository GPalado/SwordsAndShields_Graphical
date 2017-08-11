package Actions.Visitors;

import SnSGame.Board;
import SnSGame.InvalidMoveException;
import SnSGame.Player;
import SnSGame.SnSGame;
import Tiles.Reactables.Piece;
import Tiles.Reactables.Reactable;
import Tiles.Tile;

/**
 * This class provides the full implementation of the move down action
 */
public class MoveDown extends MoveActionVisitor {

    public MoveDown(Piece p, Player pl){
        super(p, pl);
    }

    @Override
    public void execute(Board board) {
        //todo implement this
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
        Tile shift = board.getBelowOf(startingPiece);
        shift.accept(this);
    }

    @Override
    public void visitPiece(Piece piece) {
        if(pieceToPlace!=startingPiece)piecesPushed.add(pieceToPlace);
        board.setPiece(pieceToPlace, piece.getPosition().x, piece.getPosition().y);
        pieceToPlace=piece;
        Tile shift = board.getBelowOf(pieceToPlace);
        shift.accept(this);
    }

    @Override
    public void undo() {
        player.pieceNotMoved(startingPiece);
        if(piecesPushed.isEmpty()){ //just move the one piece
            if(startingPiece.getStatus().equals(Reactable.Status.CEMETERY)){
                startingPiece.toLife();
                board.setPiece(startingPiece, startingPiece.getPosition().x, startingPiece.getPosition().y);
            } else {
                board.apply(new MoveUp(startingPiece, player));
            }
        } else if(startingPiece.getPosition().y+piecesPushed.size()>SnSGame.BOARD_SIZE-1) { //move all pushed pieces and bring other piece back to life
            if(piecesPushed.size()==1){
                board.apply(new MoveUp(startingPiece, player));
            } else {
                board.apply(new MoveUp(piecesPushed.get(piecesPushed.size() - 2), player));
            }
            piecesPushed.get(piecesPushed.size()-1).toLife();
            board.setPiece(piecesPushed.get(piecesPushed.size()-1), startingPiece.getPosition().x, SnSGame.BOARD_SIZE-1);
        } else {
            board.apply(new MoveUp(piecesPushed.get(piecesPushed.size()-1), player));
        }
    }
}

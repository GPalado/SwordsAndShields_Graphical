package Actions.Visitors;

import SnSGame.Board;
import SnSGame.InvalidMoveException;
import SnSGame.Player;
import SnSGame.SnSGame;
import Tiles.CreationSquare;
import Tiles.Reactables.Piece;
import Tiles.Reactables.Reactable;
import Tiles.Tile;

/**
 * This class provides the full implementation of the move down action
 */
public class MoveDown extends MoveActionVisitor {

    public MoveDown(Piece p){
        super(p);
    }

    @Override
    public void execute(Board board) {
        this.board=board;
        board.setEmpty(pieceToPlace.getPosition().x, pieceToPlace.getPosition().y);
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
    public void visitCreation(CreationSquare cs) {
        if(pieceToPlace!=startingPiece) piecesPushed.add(pieceToPlace);
        if(cs.isOccupied()){
            Piece temp = cs.getPiece();
            cs.setPiece(pieceToPlace);
            pieceToPlace=temp;
            Tile shift = board.getBelowOf(pieceToPlace);
            shift.accept(this);
        } else {
            cs.setPiece(pieceToPlace);
        }
    }

    @Override
    public void undo() {
        if(piecesPushed.isEmpty()){ //just move the one piece
            if(startingPiece.getStatus().equals(Reactable.Status.CEMETERY)){
                startingPiece.toLife();
                board.setPiece(startingPiece, startingPiece.getPosition().x, startingPiece.getPosition().y);
            } else {
                board.apply(new MoveUp(startingPiece));
            }
        } else if(startingPiece.getPosition().y+piecesPushed.size()>SnSGame.BOARD_SIZE-1) { //move all pushed pieces and bring other piece back to life
            if(piecesPushed.size()==1){
                board.apply(new MoveUp(startingPiece));
            } else {
                board.apply(new MoveUp(piecesPushed.get(piecesPushed.size() - 2)));
            }
            piecesPushed.get(piecesPushed.size()-1).toLife();
            board.setPiece(piecesPushed.get(piecesPushed.size()-1), startingPiece.getPosition().x, SnSGame.BOARD_SIZE-1);
        } else { //push all pieces back
            board.apply(new MoveUp(piecesPushed.get(piecesPushed.size()-1)));
        }
    }
}

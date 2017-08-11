package Actions.Visitors;

import SnSGame.Board;
import SnSGame.InvalidMoveException;
import SnSGame.Player;
import SnSGame.SnSGame;
import Tiles.Reactables.Piece;
import Tiles.Reactables.Reactable;
import Tiles.Tile;

public class MoveDown extends MoveActionVisitor {

    public MoveDown(Piece p, Player pl){
        super(p, pl);
    }

    @Override
    public void execute(Board board) {
        //todo implement this
        if(getPlayer().getPiecesMoved().contains(getStartingPiece())){
            throw new InvalidMoveException("Cannot move a piece that has already been moved!");
        }
        getPlayer().pieceMoved(getStartingPiece());
        setBoard(board);
        if(getPieceToPlace().getPosition().equals(getPlayer().creationSquare.getPosition())){ //set creation square to no piece
            getPlayer().creationSquare.setPiece(null);
        } else { //set tile that had piece to new emptySpace
            getBoard().setEmpty(getPieceToPlace().getPosition().x, getPieceToPlace().getPosition().y);
        }
        Tile shift = getBoard().getBelowOf(getStartingPiece());
        shift.accept(this);
    }

    @Override
    public void visitPiece(Piece piece) {
        if(getPieceToPlace()!=getStartingPiece())getPiecesPushed().add(getPieceToPlace());
        getBoard().setPiece(getPieceToPlace(), piece.getPosition().x, piece.getPosition().y);
        setPieceToPlace(piece);
        Tile shift = getBoard().getBelowOf(getPieceToPlace());
        shift.accept(this);
    }

    @Override
    public void undo() {
        getPlayer().pieceNotMoved(getStartingPiece());
        if(getPiecesPushed().isEmpty()){ //just move the one piece
            if(getStartingPiece().getStatus().equals(Reactable.Status.CEMETERY)){
                getStartingPiece().toLife();
                getBoard().setPiece(getStartingPiece(), getStartingPiece().getPosition().x, getStartingPiece().getPosition().y);
            } else {
                getBoard().apply(new MoveUp(getStartingPiece(), getPlayer()));
            }
        } else if(getStartingPiece().getPosition().y+getPiecesPushed().size()>SnSGame.BOARD_SIZE-1) { //move all pushed pieces and bring other piece back to life
            if(getPiecesPushed().size()==1){
                getBoard().apply(new MoveUp(getStartingPiece(), getPlayer()));
            } else {
                getBoard().apply(new MoveUp(getPiecesPushed().get(getPiecesPushed().size() - 2), getPlayer()));
            }
            getPiecesPushed().get(getPiecesPushed().size()-1).toLife();
            getBoard().setPiece(getPiecesPushed().get(getPiecesPushed().size()-1), getStartingPiece().getPosition().x, SnSGame.BOARD_SIZE-1);
        } else {
            getBoard().apply(new MoveUp(getPiecesPushed().get(getPiecesPushed().size()-1), getPlayer()));
        }
    }
}

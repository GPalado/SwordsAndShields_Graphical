package Actions.Visitors;

import SnSGame.Board;
import SnSGame.InvalidMoveException;
import SnSGame.Player;
import Tiles.Reactables.Piece;
import Tiles.Reactables.Reactable;
import Tiles.Tile;

public class MoveUp extends MoveActionVisitor {

    public MoveUp(Piece p, Player pl){
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
        Tile shift = getBoard().getAboveOf(getStartingPiece());
        shift.accept(this);
    }

    @Override
    public void visitPiece(Piece piece) {
        if(getPieceToPlace()!=getStartingPiece())getPiecesPushed().add(getPieceToPlace());
        getBoard().setPiece(getPieceToPlace(), piece.getPosition().x, piece.getPosition().y);
        setPieceToPlace(piece);
        Tile shift = getBoard().getAboveOf(getPieceToPlace());
        shift.accept(this);
    }

    @Override
    public void undo() {
        //todo fix this
        System.out.println("undo up");
        getPlayer().pieceNotMoved(getStartingPiece());
        if(getPiecesPushed().isEmpty()){ //just move the one piece
            if(getStartingPiece().getStatus().equals(Reactable.Status.CEMETERY)){
                getStartingPiece().toLife();
                getBoard().setPiece(getStartingPiece(), getStartingPiece().getPosition().x, getStartingPiece().getPosition().y);
            } else {
                getBoard().apply(new MoveDown(getStartingPiece(), getPlayer()));
            }
        } else if(getStartingPiece().getPosition().y-getPiecesPushed().size()<0) { //move all pushed pieces and bring other piece back to life
            if(getPiecesPushed().size()==1){
                getBoard().apply(new MoveDown(getStartingPiece(), getPlayer()));
            } else {
                getBoard().apply(new MoveDown(getPiecesPushed().get(getPiecesPushed().size() - 2), getPlayer()));
            }
            getPiecesPushed().get(getPiecesPushed().size()-1).toLife();
            getBoard().setPiece(getPiecesPushed().get(getPiecesPushed().size()-1), getStartingPiece().getPosition().x, 0);
        } else {
            getBoard().apply(new MoveDown(getPiecesPushed().get(getPiecesPushed().size()-1), getPlayer()));
        }
    }
}

package Actions.Visitors;

import SnSGame.Board;
import SnSGame.InvalidMoveException;
import SnSGame.Player;
import Tiles.Reactables.Piece;
import Tiles.Tile;

public class MoveUp extends MoveActionVisitor {

    public MoveUp(Piece p, Player pl){
        super(p, pl);
    }

    @Override
    public void execute(Board board) {
        //todo implement this
        if(getPieceToPlace().beenMoved()){
            throw new InvalidMoveException("Cannot move a piece that has already been moved!");
        }
        getPieceToPlace().setMoved(true);
        getPlayer().setMoved(true);
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
        getBoard().setPiece(getPieceToPlace(), piece.getPosition().x, piece.getPosition().y);
        setPieceToPlace(piece);
        getPiecesPushed().add(piece);
        Tile shift = getBoard().getAboveOf(getPieceToPlace());
        shift.accept(this);
    }

    @Override
    public void undo() {
        //todo fix this
        if(getPiecesPushed().isEmpty()){ //just move the one piece
            getBoard().apply(new MoveDown(getStartingPiece(), getPlayer()));
        } else if(getStartingPiece().getPosition().y-getPiecesPushed().size()<0) { //move all pushed pieces and bring other piece back to life
            getBoard().apply(new MoveDown(getPiecesPushed().get(getPiecesPushed().size()-2), getPlayer()));
            getPiecesPushed().get(getPiecesPushed().size()-1).toLife();
            getBoard().setPiece(getPiecesPushed().get(getPiecesPushed().size()-1), getStartingPiece().getPosition().x, 0);
        } else {
            getBoard().apply(new MoveDown(getPiecesPushed().get(getPiecesPushed().size()-1), getPlayer()));
        }
    }
}

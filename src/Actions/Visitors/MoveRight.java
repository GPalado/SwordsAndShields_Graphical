package Actions.Visitors;

import SnSGame.Board;
import SnSGame.InvalidMoveException;
import SnSGame.Player;
import Tiles.Reactables.Piece;
import Tiles.Tile;

public class MoveRight extends MoveActionVisitor {

    public MoveRight(Piece p, Player pl){
        super(p, pl);
    }

    @Override
    public void execute(Board board) {
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
        Tile shift = getBoard().getRightOf(getStartingPiece());
        shift.accept(this);
    }

    @Override
    public void visitPiece(Piece piece) {
        getBoard().setPiece(getPieceToPlace(), piece.getPosition().x, piece.getPosition().y);
        setPieceToPlace(piece);
        getPiecesPushed().add(piece);
        Tile shift = getBoard().getRightOf(getPieceToPlace());
        shift.accept(this);
    }

    @Override
    public void undo() {
        //todo implement this
    }
}

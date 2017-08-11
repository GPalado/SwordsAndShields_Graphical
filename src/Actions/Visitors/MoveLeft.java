package Actions.Visitors;

import SnSGame.Board;
import SnSGame.InvalidMoveException;
import SnSGame.Player;
import Tiles.Reactables.Piece;
import Tiles.Reactables.Reactable;
import Tiles.Tile;

public class MoveLeft extends MoveActionVisitor {

    public MoveLeft(Piece p, Player pl){
        super(p, pl);
    }

    @Override
    public void execute(Board board) {
        if(getPlayer().getPiecesMoved().contains(getStartingPiece())){
            throw new InvalidMoveException("Cannot move a piece that has already been moved!");
        }
        getPlayer().pieceMoved(getStartingPiece());
        setBoard(board);
        if(getPieceToPlace().getPosition().equals(getPlayer().creationSquare.getPosition())){ //set creation square to no piece
            getPlayer().creationSquare.setPiece(null);
        } else { //set tile that had piece to new emptySpace
            board.setEmpty(getPieceToPlace().getPosition().x, getPieceToPlace().getPosition().y);
        }
        Tile shift = board.getLeftOf(getStartingPiece());
        shift.accept(this);
    }


    @Override
    public void visitPiece(Piece piece) {
        if(getPieceToPlace()!=getStartingPiece())getPiecesPushed().add(getPieceToPlace());
        getBoard().setPiece(getPieceToPlace(), piece.getPosition().x, piece.getPosition().y);
        setPieceToPlace(piece);
        Tile shift = getBoard().getLeftOf(getPieceToPlace());
        shift.accept(this);
    }

    @Override
    public void undo() {
        System.out.println("undo left");
        getPlayer().pieceNotMoved(getStartingPiece());
        if(getPiecesPushed().isEmpty()){ //just move the one piece
            System.out.println("just one");
            if(getStartingPiece().getStatus().equals(Reactable.Status.CEMETERY)){
                getStartingPiece().toLife();
                getBoard().setPiece(getStartingPiece(), getStartingPiece().getPosition().x, getStartingPiece().getPosition().y);
            } else {
                getBoard().apply(new MoveRight(getStartingPiece(), getPlayer()));
            }
        } else if(getStartingPiece().getPosition().x-getPiecesPushed().size()<0) { //move all pushed pieces and bring other piece back to life
            System.out.println("killed");
            if(getPiecesPushed().size()==1){
                getBoard().apply(new MoveRight(getStartingPiece(), getPlayer()));
            } else {
                getBoard().apply(new MoveRight(getPiecesPushed().get(getPiecesPushed().size() - 2), getPlayer()));
            }
            getPiecesPushed().get(getPiecesPushed().size()-1).toLife();
            getBoard().setPiece(getPiecesPushed().get(getPiecesPushed().size()-1), 0, getStartingPiece().getPosition().y);
        } else { //move all pushed pieces back
            System.out.println("shifted");
            getBoard().apply(new MoveRight(getPiecesPushed().get(getPiecesPushed().size()-1), getPlayer()));
        }
    }
}

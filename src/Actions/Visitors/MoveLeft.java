package Actions.Visitors;

import SnSGame.Board;
import SnSGame.InvalidMoveException;
import SnSGame.Player;
import Tiles.Reactables.Piece;
import Tiles.Tile;

public class MoveLeft extends MoveActionVisitor {

    public MoveLeft(Piece p, Player pl){
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
            board.setEmpty(getPieceToPlace().getPosition().x, getPieceToPlace().getPosition().y);
        }
        Tile shift = board.getLeftOf(getStartingPiece());
        System.out.println("executing");
        shift.accept(this);
    }


    @Override
    public void visitPiece(Piece piece) {
        System.out.println("Piece");
        getBoard().setPiece(getPieceToPlace(), piece.getPosition().x, piece.getPosition().y);
        setPieceToPlace(piece);
        getPiecesPushed().add(piece);
        Tile shift = getBoard().getLeftOf(getPieceToPlace());
        shift.accept(this);
    }

    @Override
    public void undo() {
        //todo fix this
        if(getPiecesPushed().isEmpty()){ //just move the one piece
            getBoard().apply(new MoveRight(getStartingPiece(), getPlayer()));
        } else if(getStartingPiece().getPosition().x-getPiecesPushed().size()<0) { //move all pushed pieces and bring other piece back to life
            getBoard().apply(new MoveRight(getPiecesPushed().get(getPiecesPushed().size()-2), getPlayer()));
            getPiecesPushed().get(getPiecesPushed().size()-1).toLife();
            getBoard().setPiece(getPiecesPushed().get(getPiecesPushed().size()-1), 0, getStartingPiece().getPosition().y);
        } else {
            getBoard().apply(new MoveRight(getPiecesPushed().get(getPiecesPushed().size()-1), getPlayer()));
        }
    }
}

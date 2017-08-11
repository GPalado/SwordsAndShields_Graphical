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
        Tile shift = board.getLeftOf(startingPiece);
        shift.accept(this);
    }


    @Override
    public void visitPiece(Piece piece) {
        if(pieceToPlace!=startingPiece)piecesPushed.add(pieceToPlace);
        board.setPiece(pieceToPlace, piece.getPosition().x, piece.getPosition().y);
        pieceToPlace=piece;
        Tile shift = board.getLeftOf(pieceToPlace);
        shift.accept(this);
    }

    @Override
    public void undo() {
        System.out.println("undo left");
        player.pieceNotMoved(startingPiece);
        if(piecesPushed.isEmpty()){ //just move the one piece
            System.out.println("just one");
            if(startingPiece.getStatus().equals(Reactable.Status.CEMETERY)){
                startingPiece.toLife();
                board.setPiece(startingPiece, startingPiece.getPosition().x, startingPiece.getPosition().y);
            } else {
                board.apply(new MoveRight(startingPiece, player));
            }
        } else if(startingPiece.getPosition().x-piecesPushed.size()<0) { //move all pushed pieces and bring other piece back to life
            System.out.println("killed");
            if(piecesPushed.size()==1){
                board.apply(new MoveRight(startingPiece, player));
            } else {
                board.apply(new MoveRight(piecesPushed.get(piecesPushed.size() - 2), player));
            }
            piecesPushed.get(piecesPushed.size()-1).toLife();
            board.setPiece(piecesPushed.get(piecesPushed.size()-1), 0, startingPiece.getPosition().y);
        } else { //move all pushed pieces back
            System.out.println("shifted");
            board.apply(new MoveRight(piecesPushed.get(piecesPushed.size()-1), player));
        }
    }
}

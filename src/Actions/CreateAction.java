package Actions;

import SnSGame.Board;
import SnSGame.InvalidMoveException;
import SnSGame.Player;
import Tiles.Reactables.Piece;
import Tiles.Reactables.Reactable;

import java.nio.InvalidMarkException;

public class CreateAction implements Action {

    private Player player;
    private int orientation;
    private Piece piece;
    private Board board;

    public CreateAction(Piece p, int o, Player pl){
        if(p==null) throw new InvalidMoveException("Cannot create null piece");
        orientation=o;
        piece=p;
        player=pl;
    }

    @Override
    public void execute(Board board) {
        //todo implement this
        if(player.creationSquare.isOccupied()){
            throw new InvalidMoveException("Your creation square is occupied");
        }
        if(player.hasCreated()){
            throw new InvalidMoveException("You cannot create twice in one move");
        }
        if(player.hasMoved()){
            throw new InvalidMoveException("You can only create at the start of your turn");
        }
        if(piece.getStatus().equals(Reactable.Status.CEMETERY)){
            throw new InvalidMoveException("Cannot create piece that is deado");
        }
        if(piece.getStatus().equals(Reactable.Status.ON_BOARD)){
            throw new InvalidMoveException("Cannot create a piece already on the board");
        }
        player.creationSquare.setPiece(piece);
        player.setCreated(true);
        piece.toLife();
    }

    @Override
    public void undo() {
        //todo implement this
        player.creationSquare.setPiece(null);
        piece.backToUnused();
    }
}

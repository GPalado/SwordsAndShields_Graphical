package Actions;

import SnSGame.Board;
import SnSGame.InvalidMoveException;
import SnSGame.Player;
import Tiles.Reactables.Piece;

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

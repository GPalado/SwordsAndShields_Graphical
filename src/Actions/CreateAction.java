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
        if(piece==null) throw new InvalidMoveException("Cannot create null piece");
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
        player.creationSquare.setPiece(piece);
        piece.toLife();
    }

    @Override
    public void undo() {
        //todo implement this
        player.creationSquare.setPiece(null);
        piece.backToUnused();
    }
}

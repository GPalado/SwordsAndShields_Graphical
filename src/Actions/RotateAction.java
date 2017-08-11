package Actions;

import SnSGame.Board;
import SnSGame.InvalidMoveException;
import SnSGame.Player;
import Tiles.Reactables.Piece;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RotateAction implements Action {

    private Set<Integer> validAmounts = new HashSet<>(Arrays.asList(new Integer[] { 0, 90, 180, 270 }));
    private Player player;
    private Piece piece;
    private int amount;

    public RotateAction(Piece p, int amt, Player pl){
        if(!validAmounts.contains(amt)) throw new InvalidMoveException("Invalid rotation amount given");
        amount = amt;
        piece=p;
        player=pl;
    }

    @Override
    public void execute(Board board) {
        piece.setOrientation((piece.getOrientation()+amount>360) ? piece.getOrientation()+amount-360 : amount+piece.getOrientation());
        player.pieceMoved(piece);
    }

    @Override
    public void undo() {
        piece.setOrientation((piece.getOrientation()-amount<0) ? piece.getOrientation()-amount+360 : piece.getOrientation()-amount);
        player.pieceNotMoved(piece);
    }
}

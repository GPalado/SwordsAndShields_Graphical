package Actions;

import SnSGame.Board;
import SnSGame.Player;
import Tiles.Reactables.Piece;

public class RotateAction implements Action {

    private Player player;
    private Piece piece;
    private Board board;
    private int amount;

    public RotateAction(Piece p, int amt, Player pl){
        amount=amt;
        piece=p;
        player=pl;
    }

    @Override
    public void execute(Board board) {
        //todo implement this
    }

    @Override
    public void undo() {
        //todo implement this
    }
}

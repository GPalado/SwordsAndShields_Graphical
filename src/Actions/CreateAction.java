package Actions;

import SnSGame.Board;
import SnSGame.Player;
import Tiles.Reactables.Piece;

public class CreateAction implements Action {

    private Player player;
    private int orientation;
    private Piece piece;
    private Board board;

    public CreateAction(Piece p, int o, Player pl){
        orientation=o;
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

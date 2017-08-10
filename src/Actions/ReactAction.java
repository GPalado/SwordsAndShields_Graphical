package Actions;

import SnSGame.Board;
import SnSGame.Player;
import Tiles.Reactables.Reactable;

public class ReactAction implements Action {

    private Player player;
    private Reactable r1;
    private Reactable r2;
    private Board board;

    public ReactAction(Reactable re1, Reactable re2, Player p){
        r1=re1;
        r2=re2;
        player=p;
    }

    @Override
    public void execute(Board board) {

    }

    @Override
    public void undo() {

    }
}

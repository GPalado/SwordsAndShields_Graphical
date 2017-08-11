package Actions;

import SnSGame.Board;
import SnSGame.Player;
import Tiles.Reactables.Reactable;

/**
 * This class provides the concrete implementation of a React action (reaction)
 */
public class ReactAction implements Action {

    private Player player;
    private Reactable r1;
    private Reactable r2;
    private Board board;

    /**
     * The constructor takes the two reactables to react, and the player involved in the reaction.
     * @param re1
     * @param re2
     * @param p
     */
    public ReactAction(Reactable re1, Reactable re2, Player p){
        r1=re1;
        r2=re2;
        player=p;
    }

    @Override
    public void execute(Board board) {
        this.board=board;
    }

    @Override
    public void undo() {

    }
}

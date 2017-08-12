package Actions;

import SnSGame.Board;
import SnSGame.Player;
import Tiles.Reactables.Reactable;
import Tiles.Reactables.Reaction;
import Tiles.Reactables.ReactionVisitor;

/**
 * This class provides the concrete implementation of a React action (reaction)
 */
public class ReactAction implements Action {

    private Player player;
    private Reactable r1;
    private Reactable r2;
    private Board board;
    private ReactionVisitor rv = new ReactionVisitor();
    private Reaction reaction1, reaction2;

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
        //todo get symbols that will react

        //todo find the reactions for each piece
        this.board=board;
    }

    @Override
    public void undo() {

    }
}

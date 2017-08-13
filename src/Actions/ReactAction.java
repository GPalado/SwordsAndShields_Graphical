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
        player.addAction(this);
        this.board=board;
        //get symbols that will react and use them to find the reactions for each piece
        if(r1.getPosition().x<r2.getPosition().x){
            //find reaction of first reactable
            reaction1 = r2.getLeftSymbol().causes(r1.getRightSymbol());
            //find reaction of second piece
            reaction2 = r1.getRightSymbol().causes(r2.getLeftSymbol());
        } else if(r1.getPosition().x>r2.getPosition().x){
            reaction1 = r2.getRightSymbol().causes(r1.getLeftSymbol());
            reaction2 = r1.getLeftSymbol().causes(r2.getRightSymbol());
        } else if(r1.getPosition().y>r2.getPosition().y){
            reaction1 = r2.getBottomSymbol().causes(r1.getTopSymbol());
            reaction2 = r1.getTopSymbol().causes(r2.getBottomSymbol());
        } else { //if(r1.getPosition().y<r2.getPosition().y)
            reaction1 = r2.getTopSymbol().causes(r1.getBottomSymbol());
            reaction2 = r1.getBottomSymbol().causes(r2.getTopSymbol());
        }
        reaction1.accept(rv, r1);
        reaction2.accept(rv, r2);
    }

    @Override
    public void undo() {

    }
}

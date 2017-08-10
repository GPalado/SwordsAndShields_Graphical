package Actions.Visitors;

import Actions.Action;
import SnSGame.Player;
import Tiles.Reactables.Piece;

import java.util.ArrayList;
import java.util.List;

public abstract class MoveActionVisitor implements Action, Visitor{

    private Piece pieceToPlace;
    private Piece startingPiece;
    private List<Piece> piecesPushed;
    private Player player;

    public MoveActionVisitor(Piece p, Player player){
        pieceToPlace=p;
        startingPiece=p;
        piecesPushed=new ArrayList<>();
        this.player=player;
    }
}

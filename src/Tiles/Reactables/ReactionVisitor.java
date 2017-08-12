package Tiles.Reactables;

public class ReactionVisitor {

    public ReactionVisitor(){}

    public void visitKilled(Piece piece){
        piece.kill();
    }

    public void visitPushed(Piece piece){
        //todo pushed in which direction?
    }

    public void visitNone(Piece piece){}

}

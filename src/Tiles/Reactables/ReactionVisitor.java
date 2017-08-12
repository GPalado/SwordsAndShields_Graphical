package Tiles.Reactables;

public class ReactionVisitor {

    public ReactionVisitor(){}

    public void visitKilled(Reactable r){
        r.kill();
    }

    public void visitPushed(Reactable r){
        //todo pushed in which direction?
    }

    public void visitNone(Reactable r){}

}

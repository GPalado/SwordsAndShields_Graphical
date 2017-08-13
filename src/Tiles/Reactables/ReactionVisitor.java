package Tiles.Reactables;

import Actions.Visitors.*;
import SnSGame.Board;

public class ReactionVisitor {

    private Board board;

    public ReactionVisitor(Board b){
        board=b;
    }

    public void visitKilled(Reactable r){
        board.setEmpty(r.getPosition().x, r.getPosition().y);
        r.kill();
    }

    public MoveActionVisitor visitPushedRight(Reactable r){
        MoveActionVisitor move = new MoveRight(r);
        board.apply(move);
        return move;
    }

    public MoveActionVisitor visitPushedLeft(Reactable r){
        MoveActionVisitor move = new MoveLeft(r);
        board.apply(move);
        return move;
    }

    public MoveActionVisitor visitPushedUp(Reactable r){
        MoveActionVisitor move = new MoveUp(r);
        board.apply(move);
        return move;
    }

    public MoveActionVisitor visitPushedDown(Reactable r){
        MoveActionVisitor move = new MoveDown(r);
        board.apply(move);
        return move;
    }

    public void visitNone(Reactable r){}

    public void reverseKilled(Reactable r){
        r.toLife();
    }

    public void reversePush(MoveActionVisitor move){
        board.reverse(move);
    }

}

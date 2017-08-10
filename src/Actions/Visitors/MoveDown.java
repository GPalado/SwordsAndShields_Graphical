package Actions.Visitors;

import SnSGame.Board;
import SnSGame.Player;
import Tiles.CreationSquare;
import Tiles.EmptySpace;
import Tiles.OutOfBounds;
import Tiles.Reactables.Face;
import Tiles.Reactables.Piece;
import Tiles.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoveDown extends MoveActionVisitor {

    private Piece pieceToPlace;
    private Piece startingPiece;
    private List<Piece> piecesPushed;
    private Player player;
    private Board board;

    public MoveDown(Piece p, Player pl){
        super(p, pl);
        pieceToPlace=p;
        startingPiece=p;
        piecesPushed=new ArrayList<>();
        this.player=pl;
    }

    @Override
    public void execute(Board board) {
        //todo implement this
        this.board=board;
        if(pieceToPlace.getPosition().equals(player.creationSquare.getPosition())){ //set creation square to no piece
            player.creationSquare.setPiece(null);
        } else { //set tile that had piece to new emptySpace
            board.setEmpty(pieceToPlace.getPosition().x, pieceToPlace.getPosition().y);
        }
        Tile shift = board.getLeftOf(startingPiece);
        shift.accept(this);
    }

    @Override
    public void undo() {
        //todo implement this
        if(piecesPushed.isEmpty()){ //just move the one piece
            board.apply(new MoveRight(startingPiece, player));
        } else if(startingPiece.getPosition().x-piecesPushed.size()<0) { //move all pushed pieces and bring other piece back to life
            board.apply(new MoveRight(piecesPushed.get(piecesPushed.size()-2), player));
            piecesPushed.get(piecesPushed.size()-1).toLife();
            board.setPiece(piecesPushed.get(piecesPushed.size()-1), 0, startingPiece.getPosition().y);
        } else {
            board.apply(new MoveRight(piecesPushed.get(piecesPushed.size()-1), player));
        }
    }

    @Override
    public void visitPiece(Piece piece) {
        board.setPiece(pieceToPlace, piece.getPosition().x, piece.getPosition().y);
        pieceToPlace = piece;
        piecesPushed.add(piece);
    }

    @Override
    public void visitFace(Face face) {
        piecesPushed.add(pieceToPlace);
        pieceToPlace.kill();
    }

    @Override
    public void visitOOB(OutOfBounds oob) {
        piecesPushed.add(pieceToPlace);
        pieceToPlace.kill();
    }

    @Override
    public void visitEmpty(EmptySpace empty) {
        piecesPushed.add(pieceToPlace);
        board.setPiece(pieceToPlace, empty.getPosition().x, empty.getPosition().y);
    }

    @Override
    public void visitCreation(CreationSquare cs) {
        piecesPushed.add(pieceToPlace);
        if(cs.isOccupied()){
            Piece temp = cs.getPiece();
            cs.setPiece(pieceToPlace);
            pieceToPlace=temp;
        } else {
            cs.setPiece(pieceToPlace);
        }
    }
}

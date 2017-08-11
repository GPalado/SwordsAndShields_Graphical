package Actions.Visitors;

import Actions.Action;
import SnSGame.Board;
import SnSGame.Player;
import Tiles.CreationSquare;
import Tiles.EmptySpace;
import Tiles.OutOfBounds;
import Tiles.Reactables.Face;
import Tiles.Reactables.Piece;
import Tiles.Tile;

import java.util.ArrayList;
import java.util.List;

public abstract class MoveActionVisitor implements Action, Visitor{
    private Piece pieceToPlace;
    private Piece startingPiece;
    private List<Piece> piecesPushed;
    private Player player;
    private Board board;

    public MoveActionVisitor(Piece p, Player player){
        pieceToPlace=p;
        startingPiece=p;
        piecesPushed=new ArrayList<>();
        this.player=player;
    }

    public void setBoard(Board b){
        board=b;
    }

    public Piece getPieceToPlace() {
        return pieceToPlace;
    }

    public Piece getStartingPiece() {
        return startingPiece;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Piece> getPiecesPushed() {
        return piecesPushed;
    }

    public Board getBoard(){ return board;}

    public void setPieceToPlace(Piece p){ pieceToPlace=p; }

    @Override
    public void visitFace(Face face) {
        System.out.println("Face");
        piecesPushed.add(pieceToPlace);
        pieceToPlace.kill();
    }

    @Override
    public void visitOOB(OutOfBounds oob) {
        System.out.println("OOB");
        piecesPushed.add(pieceToPlace);
        pieceToPlace.kill();
    }

    @Override
    public void visitEmpty(EmptySpace empty) {
        System.out.println("Empty");
        piecesPushed.add(pieceToPlace);
        board.setPiece(pieceToPlace, empty.getPosition().x, empty.getPosition().y);
    }

    @Override
    public void visitCreation(CreationSquare cs) {
        System.out.println("Creation");
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

package SnSGame;

import Actions.Action;
import Tiles.CreationSquare;
import Tiles.Reactables.Face;
import Tiles.Reactables.Piece;
import Tiles.Reactables.Reactable;

import java.awt.*;
import java.util.*;

public class Player {
    public final Color color;
    public final Face face;
    public final CreationSquare creationSquare;
    public final boolean isCaps;
    private Map<Character, Piece> pieces = new HashMap<>();
    private Deque<Action> actions = new ArrayDeque<>();
    private Set<Piece> piecesMoved = new HashSet<>();
    private boolean hasCreated;

    public Player(Color c, boolean caps, char faceChar, Point facePos, CreationSquare cs){
        color=c;
        isCaps=caps;
        hasCreated = false;
        face=new Face(faceChar, facePos);
        creationSquare=cs;
        initializePieces();
    }

    public Set<Piece> getPiecesMoved(){
        return piecesMoved;
    }

    public void pieceMoved(Piece p){
        piecesMoved.add(p);
    }

    public void pieceNotMoved(Piece p){
        if(piecesMoved.contains(p)) piecesMoved.remove(p);
    }

    public void addAction(Action action){
        actions.add(action);
    }

    public Action undo(){
        if(actions.isEmpty()){
            throw new InvalidMoveException("Cannot undo any further");
        }
        return actions.pollLast();
    }

    public boolean hasCreated(){
        return hasCreated;
    }

    public void setCreated(boolean b){
        hasCreated=b;
    }

    public boolean hasMoved(){ return !piecesMoved.isEmpty(); }

    public void drawUnusedPieces(){
        //todo implement this
    }

    public void pass(){
        actions=new ArrayDeque<>();
        hasCreated=false;
        piecesMoved.clear();
//        for(Piece p:pieces.values()){
//            p.setMoved(false);
//        }
    }

    public Piece getPiece(char c){
        if(isCaps){
            c=Character.toUpperCase(c);
        } else {
            c=Character.toLowerCase(c);
        }
        if(pieces.get(c)==null) throw new IllegalArgumentException("That piece does not exist");
        return pieces.get(c);
    }

    public boolean hasMovesLeft(){
        boolean pieceNotMoved=false;
        boolean hasMovedAPiece=false;
        for(Piece p : pieces.values()){
            if(!p.getStatus().equals(Reactable.Status.ON_BOARD)) continue;
            if(!piecesMoved.contains(p)){
                pieceNotMoved=true;
            } else {
                hasMovedAPiece=true;
            }
        }
        return (!hasCreated && !hasMovedAPiece) || pieceNotMoved;
    }

    private void initializePieces() {
        if (isCaps) {
            char c = 'A';
            pieces.put(c, new Piece(new Character[][]{{' ', '-', ' '}, {'|', c++, '|'}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '-', ' '}, {'|', c++, '|'}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {'#', c++, '#'}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {'|', c++, '#'}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {' ', c++, ' '}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '-', ' '}, {'|', c++, '#'}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '-', ' '}, {'|', c++, '|'}, {' ', '-', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {'|', c++, '#'}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {' ', c++, ' '}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {'|', c++, '|'}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '-', ' '}, {'|', c++, ' '}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {'|', c++, ' '}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {'|', c++, '#'}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {' ', c++, '#'}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {'|', c++, '|'}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '-', ' '}, {'|', c++, '#'}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {'|', c++, ' '}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {'|', c++, ' '}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {' ', c++, ' '}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {'|', c++, '|'}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '-', ' '}, {'|', c++, ' '}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {'|', c++, ' '}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {'|', c++, '#'}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {' ', c++, '#'}, {' ', '#', ' '}}));
        } else {
            char c = 'a';
            pieces.put(c, new Piece(new Character[][]{{' ', '-', ' '}, {'|', c++, '|'}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '-', ' '}, {'|', c++, '|'}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {'#', c++, '#'}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {'|', c++, '#'}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {' ', c++, ' '}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '-', ' '}, {'|', c++, '#'}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '-', ' '}, {'|', c++, '|'}, {' ', '-', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {'|', c++, '#'}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {' ', c++, ' '}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {'|', c++, '|'}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '-', ' '}, {'|', c++, ' '}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {'|', c++, ' '}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {'|', c++, '#'}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {' ', c++, '#'}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {'|', c++, '|'}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '-', ' '}, {'|', c++, '#'}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {'|', c++, ' '}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {'|', c++, ' '}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {' ', c++, ' '}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {'|', c++, '|'}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '-', ' '}, {'|', c++, ' '}, {' ', ' ', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', ' ', ' '}, {'|', c++, ' '}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {'|', c++, '#'}, {' ', '#', ' '}}));
            pieces.put(c, new Piece(new Character[][]{{' ', '#', ' '}, {' ', c++, '#'}, {' ', '#', ' '}}));
        }
    }
}

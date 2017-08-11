package SnSGame;

import Actions.Action;
import Tiles.CreationSquare;
import Tiles.Reactables.Face;
import Tiles.Reactables.Piece;
import Tiles.Reactables.Reactable;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Player {
    public final Color color;
    public final Face face;
    public final CreationSquare creationSquare;
    public final boolean isCaps;
    private Map<Character, Piece> pieces = new HashMap<>();
    private Deque<Action> actions = new ArrayDeque<>();
    private boolean hasCreated;
    private boolean hasMoved;

    public Player(Color c, boolean caps, char faceChar, Point facePos, CreationSquare cs){
        color=c;
        isCaps=caps;
        hasCreated = false;
        hasMoved=false;
        face=new Face(faceChar, facePos);
        creationSquare=cs;
        initializePieces();
    }

    public void addAction(Action action){
        //todo implement this
        actions.push(action);
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

    public boolean hasMoved(){ return hasMoved; }

    public void setMoved(boolean b){
        hasMoved=b;
    }

    public void drawUnusedPieces(){
        //todo implement this
    }

    public void pass(){
        actions=new ArrayDeque<>();
        hasCreated=false;
        hasMoved=false;
        for(Piece p:pieces.values()){
            p.setMoved(false);
        }
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
            if(!p.beenMoved()){
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

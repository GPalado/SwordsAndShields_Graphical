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

    public Player(Color c, boolean caps, char faceChar, Point facePos, CreationSquare cs){
        color=c;
        isCaps=caps;
        hasCreated = false;
        face=new Face(faceChar, facePos);
        creationSquare=cs;
        initializePieces();
    }

    public void addAction(Action action){
        //todo implement this
    }

    public Action undo(){
        if(actions.isEmpty()){
            //todo throw exception
        }
        //todo implement this
        return null;
    }

    public void drawUnusedPieces(){
        //todo implement this
    }

    public void pass(){
        //todo implement this
    }

    public Piece getPiece(char c){
        //todo implement this
        return null;
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
//        for(Character c:pieces.keySet()){
//            System.out.println(c+"->"+pieces.get(c).getRepresentation().toString());
//        }
    }
}

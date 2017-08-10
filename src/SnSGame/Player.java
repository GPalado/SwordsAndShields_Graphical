package SnSGame;

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

    public Player(Color c, boolean caps, char faceChar){
        color=c;
        isCaps=caps;
        hasCreated = false;
        Character[][] faceRep = {{' ', ' ', ' '},{' ', faceChar, ' '},{' ', ' ', ' '}};
        face=new Face(faceRep);
        initializePieces();
    }

    public void addAction(Action action){
        //todo implement this
    }

    public Action undo(){
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
        if(!hasCreated) return true;
        for(Piece p : placedPieces.values()){
            if(!p.beenMoved()){
                return true;
            }
        }
        return false;
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

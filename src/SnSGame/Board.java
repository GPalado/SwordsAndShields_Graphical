package SnSGame;

import Actions.Action;
import Tiles.*;
import Tiles.Reactables.Piece;

import java.awt.*;
import java.util.ArrayList;

public class Board {

    private Tile[][] tiles;

    public Board(Player p1, Player p2){
        assert p1!=null&&p2!=null;
        //initialize tiles and contents
        tiles = new Tile[SnSGame.BOARD_SIZE][SnSGame.BOARD_SIZE];
        for(int x=0; x<tiles.length; x++){
            for(int y=0; y<tiles[0].length; y++) {
                if(x+y<=1||x+y>=17){ //out of bounds corners
                    tiles[x][y] = new OutOfBounds(new Point(x, y));
                } else if(x==SnSGame.p1CreationCoords.x&&y==SnSGame.p1CreationCoords.y){
                    tiles[x][y] = p1.creationSquare;
                } else if(x==SnSGame.p2CreationCoords.x&&y==SnSGame.p2CreationCoords.y){
                    tiles[x][y] = p2.creationSquare;
                } else if(x==SnSGame.p1FaceCoords.x&&y==SnSGame.p1FaceCoords.y){
                    tiles[x][y] = p1.face;
                } else if(x==SnSGame.p2FaceCoords.x&&y==SnSGame.p2FaceCoords.y){
                    tiles[x][y] = p2.face;
                } else {
                    tiles[x][y] = new EmptySpace(new Point(x, y));
                }
            }
        }
    }

    /**
     * This method draws the board and the pieces on it.
     */
    public void draw(){
        //generate character grid representation of cell grid
        System.out.print(toString());
    }

    public void apply(Action action){
        //todo implement this
    }

    public void reverse(Action action){
        //todo implement this
    }

    public void setPiece(Piece piece, int x, int y){
        //todo implement this
    }

    public Tile getLeftOf(Tile tile){
        //todo implement this
        return null;
    }

    public Tile getRightOf(Tile tile){
        //todo implement this
        return null;
    }

    public Tile getAboveOf(Tile tile){
        //todo implement this
        return null;
    }

    public Tile getBelowOf(Tile tile){
        //todo implement this
        return null;
    }

    public ArrayList<Piece> offerReactions(Piece piece){
        //todo implement this
        return null;
    }

    @Override
    public String toString() {
        Character[][] boardOfChars = new Character[SnSGame.PIECE_SIZE*SnSGame.BOARD_SIZE][SnSGame.PIECE_SIZE*SnSGame.BOARD_SIZE];
        for(int x=0; x<boardOfChars.length; x+=SnSGame.PIECE_SIZE){
            for(int y=0; y<boardOfChars[0].length; y+=SnSGame.PIECE_SIZE){
                Character[][] rep = tiles[x / SnSGame.PIECE_SIZE][y / SnSGame.PIECE_SIZE].getRepresentation();
                for(int i=0; i<rep.length; i++){
                    for(int j=0; j<rep[0].length; j++){
                        boardOfChars[x+i][y+j]=rep[i][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        //print char grid
        for(int y=0; y<boardOfChars[0].length; y++){
            for(int x=0; x<boardOfChars.length; x++){
                sb.append(boardOfChars[x][y]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}

package SnSGame;

import Actions.Action;
import Tiles.*;
import Tiles.Reactables.Piece;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class is a representation of the board in a Swords and Shields game.
 */
public class Board {

    private Tile[][] tiles;

    /**
     * The constructor takes two players as parameters to set up their faces and creation squares on the board.
     * It also initializes the out of bounds tiles and empty spaces on the board.
     * @param p1
     * @param p2
     */
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
        System.out.print(toString());
    }

    /**
     * This method applies the given action to the board.
     * @param action
     */
    public void apply(Action action){
        action.execute(this);
    }

    /**
     * This method reverses the given reaction on the board.
     * @param action
     */
    public void reverse(Action action){ action.undo(); }

    /**
     * This method sets the given pieces at the given coordinates on the board.
     * @param piece
     * @param x
     * @param y
     */
    public void setPiece(Piece piece, int x, int y){
        if(x<0||x>SnSGame.BOARD_SIZE-1||y<0||y>SnSGame.BOARD_SIZE-1){
            throw new IndexOutOfBoundsException();
        }
        piece.setPosition(x, y);
        tiles[x][y] = piece;
    }

    /**
     * This method sets the position set by the given coordinates to an empty square on the board.
     * @param x
     * @param y
     */
    public void setEmpty(int x, int y){
        tiles[x][y]=new EmptySpace(new Point(x, y));
    }

    /**
     * This method returns the contents of the tile to the left of the given tile. OutOfBounds returned if it goes off the board.
     * @param tile
     * @return
     */
    public Tile getLeftOf(Tile tile){
        if(tile.getPosition().x>SnSGame.BOARD_SIZE-1||tile.getPosition().y<0||tile.getPosition().y>SnSGame.BOARD_SIZE-1){
            throw new IndexOutOfBoundsException();
        } else if(tile.getPosition().x==0){
            System.out.println("POSx=0");
            return new OutOfBounds(new Point(-1, tile.getPosition().y));
        }
        System.out.println(tiles[tile.getPosition().x-1][tile.getPosition().y].getClass());
        return tiles[tile.getPosition().x-1][tile.getPosition().y];
    }

    /**
     * This method returns the contents of the tile to the right of the given tile.  OutOfBounds returned if it goes off the board.
     * @param tile
     * @return
     */
    public Tile getRightOf(Tile tile){
        if(tile.getPosition().x<0||tile.getPosition().y<0||tile.getPosition().y>SnSGame.BOARD_SIZE-1){
            throw new IndexOutOfBoundsException();
        } else if(tile.getPosition().x==SnSGame.BOARD_SIZE-1){
            return new OutOfBounds(new Point(SnSGame.BOARD_SIZE, tile.getPosition().y));
        }
        return tiles[tile.getPosition().x+1][tile.getPosition().y];
    }

    /**
     * This method returns the contents of the tile above the given tile.  OutOfBounds returned if it goes off the board.
     * @param tile
     * @return
     */
    public Tile getAboveOf(Tile tile){
        if(tile.getPosition().x>SnSGame.BOARD_SIZE-1||tile.getPosition().x<0||tile.getPosition().y>SnSGame.BOARD_SIZE-1){
            throw new IndexOutOfBoundsException();
        } else if(tile.getPosition().y==0){
            return new OutOfBounds(new Point(tile.getPosition().x, -1));
        }
        return tiles[tile.getPosition().x][tile.getPosition().y-1];
    }

    /**
     * * This method returns the contents of the tile below the given tile.  OutOfBounds returned if it goes off the board.
     * @param tile
     * @return
     */
    public Tile getBelowOf(Tile tile){
        if(tile.getPosition().x>SnSGame.BOARD_SIZE-1||tile.getPosition().x<0||tile.getPosition().y<0){
            throw new IndexOutOfBoundsException();
        } else if(tile.getPosition().y==SnSGame.BOARD_SIZE-1){
            return new OutOfBounds(new Point(tile.getPosition().x, SnSGame.BOARD_SIZE));
        }
        return tiles[tile.getPosition().x][tile.getPosition().y+1];
    }

    /**
     * This methods offers possible reactions for the given piece i.e. neighbours that are pieces.
     * @param piece
     * @return
     */
    public ArrayList<Piece> offerReactions(Piece piece){
        //todo how to do w/out casting
        ArrayList<Piece> neighbours = new ArrayList<>();
        if(tiles[piece.getPosition().x][piece.getPosition().y+1].getClass().equals(Piece.class)){
            neighbours.add((Piece)tiles[piece.getPosition().x][piece.getPosition().y+1]);
        }
        if(tiles[piece.getPosition().x][piece.getPosition().y-1].getClass().equals(Piece.class)){

        }
        if(tiles[piece.getPosition().x+1][piece.getPosition().y].getClass().equals(Piece.class)){

        }
        if(tiles[piece.getPosition().x-1][piece.getPosition().y].getClass().equals(Piece.class)){

        }
        return neighbours;
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

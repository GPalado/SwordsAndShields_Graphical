package SnSGame;

import Actions.CreateAction;
import Actions.ReactAction;
import Actions.RotateAction;
import Actions.Visitors.MoveDown;
import Actions.Visitors.MoveLeft;
import Actions.Visitors.MoveRight;
import Actions.Visitors.MoveUp;
import Tiles.CreationSquare;
import Tiles.Reactables.Face;
import Tiles.Reactables.Piece;
import Tiles.Reactables.Reactable;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.awt.*;
import java.util.*;

/**
 * This class is a representation of the Swords and Shields game.
 */
public class SnSGame {

    public static final int BOARD_SIZE = 10;
    public static final int PIECE_SIZE = 3;
    public static final Point p1CreationCoords = new Point(7, 7);
    public static final Point p2CreationCoords = new Point(2, 2);
    public static final Point p1FaceCoords = new Point(8, 8);
    public static final Point p2FaceCoords = new Point(1, 1);
    public static final Color[] colors = new Color[]{Color.yellow, Color.green};
    private Player player1, player2;
    private Player currentPlayer;
    private Board board;
    private boolean passed=false;

    /**
     * The constructor initializes the two players and their faces and creation squares.
     * It also initializes the board.
     */
    public SnSGame() {
        player1 = new Player(colors[0], false, new Face('0', p1FaceCoords), new CreationSquare(p1CreationCoords));
        player2 = new Player(colors[1], true, new Face('1', p2FaceCoords), new CreationSquare(p2CreationCoords));
        board = new Board(player1, player2);
        currentPlayer = player1;
        redrawGame();
    }

    /**
     * This method is invoked to play the game until someone wins.
     * It repeatedly asks for user inputs and passes the input to the playerMove method which parses the commands.
     */
    public void playGame(){
        //loop while game is not won
        while(!isGameOver()){
            System.out.print((currentPlayer.equals(player1)? "Yellow" : "Green") + " Player's Turn!\n");
            while(currentPlayer.hasMovesLeft()&&!passed) {
                if(currentPlayer.hasCreated() || currentPlayer.hasMoved()) {
                    System.out.print("What would you like to do (Rotate, Move): ");
                } else {
                    System.out.print("Your unused pieces are...\n");
                    printTiles(currentPlayer.getUnusedPieces());
                    System.out.print("What would you like to do (Create, Rotate, Move): ");
                }
                Scanner scanner = new Scanner(System.in);  // read from System.in
                String input = scanner.nextLine();
                playerMove(input);
            }
            if(!passed){ //force pass when no moves possible
                System.out.println((currentPlayer.equals(player1)? "Yellow" : "Green") + " Player, your turn is over. (No move possible moves)");
                currentPlayer.pass();
                swapPlayers();
            }
            passed=false;
        }
    }

    /**
     * This method retrieves and translates user input into player moves and triggers the relevant actions.
     */
    public void playerMove(String in) {
        String[] input = in.split(" ");
        if (input.length > 3) {
            System.out.println("Input too long!");
            return;
        }
        if (input[0].toLowerCase().equals("create")) {
            try {
                char c = parseChar(input[1]);
                int i = parseInt(input[2]);
                CreateAction create = new CreateAction(currentPlayer.getPiece(c), i, currentPlayer);
                board.apply(create);
            } catch (InvalidMoveException e){
                System.out.println(e.getMessage());
                return;
            }
            //todo if successful, check for reactions

        } else if (input[0].toLowerCase().equals("rotate")) {
            try {
                char c = parseChar(input[1]);
                int i = parseInt(input[2]);
                RotateAction rotate = new RotateAction(currentPlayer.getPiece(c), i, currentPlayer);
                board.apply(rotate);
            } catch (InvalidMoveException e){
                System.out.println(e.getMessage());
                return;
            }
            //todo if successful, check for reactions
        } else if (input[0].toLowerCase().equals("move")) {
            try {
                char c = parseChar(input[1]);
                String direction = input[2];
                if (direction.toLowerCase().equals("up")) {
                    MoveUp up = new MoveUp(currentPlayer.getPiece(c), currentPlayer);
                    board.apply(up);
                } else if (direction.toLowerCase().equals("down")) {
                    MoveDown down = new MoveDown(currentPlayer.getPiece(c), currentPlayer);
                    board.apply(down);
                } else if (direction.toLowerCase().equals("left")) {
                    MoveLeft left = new MoveLeft(currentPlayer.getPiece(c), currentPlayer);
                    board.apply(left);
                } else if (direction.toLowerCase().equals("right")) {
                    MoveRight right = new MoveRight(currentPlayer.getPiece(c), currentPlayer);
                    board.apply(right);
                } else {
                    throw new InvalidMoveException("Invalid direction");
                }
            } catch (InvalidMoveException e){
                System.out.println(e.getMessage());
                return;
            }
            //todo if successful, check for reactions
        } else if (input[0].toLowerCase().equals("undo")) {
            if(input.length>1){
                System.out.println("Input too long for undo command");
                return;
            }
            try {
                board.reverse(currentPlayer.undo());
            } catch (InvalidMoveException e){
                System.out.println(e.getMessage());
                return;
            }
            //todo if successful, check for reactions
        } else if (input[0].toLowerCase().equals("pass")) {
            if(input.length>1){
                System.out.println("Input too long for pass command");
                return;
            }
            if(currentPlayer.hasCreated()||currentPlayer.hasMoved()) {
                passed = true;
                currentPlayer.pass();
                swapPlayers();
            } else {
                currentPlayer.setCreated(true);
            }
        } else {
            System.out.println("Unrecognizable command");
            return;
        }
        redrawGame();
    }

    public void reactionCheck(Piece piece){
        //todo complete
        if(!board.offerReactions(piece).isEmpty()){
            System.out.println("Choose a reaction: (enter a character)");
            printTiles(board.offerReactions(piece));
            Map<Character, Reactable> chars = new HashMap<>();
            for(Reactable r : board.offerReactions(piece)){
                chars.put(r.getLetter(), r);
            }
            Scanner scanner = new Scanner(System.in);  // read from System.in
            char input = scanner.next().charAt(0);
            scanner.nextLine();
            while(!chars.keySet().contains(input)){
                System.out.println("Sorry, that wasn't one of the options. Choose again. (Case Sensitive)");
                printTiles(board.offerReactions(piece));
                input = scanner.next().charAt(0);
                scanner.nextLine();
            }
            board.apply(new ReactAction(piece, chars.get(input), currentPlayer));
        }
    }

    private void printTiles(ArrayList<? extends Reactable> tiles){
        Character[][] toPrint = new Character[SnSGame.PIECE_SIZE*tiles.size()][SnSGame.PIECE_SIZE];
        for(int x=0; x<toPrint.length; x+=SnSGame.PIECE_SIZE){
            Character[][] rep = tiles.get(x/SnSGame.PIECE_SIZE).getRepresentation();
            for(int i=0; i<rep.length; i++){
                for(int j=0; j<rep[0].length; j++){
                    toPrint[x+i][j]=rep[i][j];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        //print char grid
        for(int y=0; y<toPrint[0].length; y++){
            for(int x=0; x<toPrint.length; x++){
                sb.append(toPrint[x][y]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    /**
     * This method redraws the game's board
     */
    public void redrawGame() {
        board.draw();
    }

    /**
     * This method checks the "faces" of each player to determine if the game has been won.
     * @return boolean [true if game won, false otherwise]
     */
    private boolean isGameOver(){
        return player1.face.getStatus().equals(Reactable.Status.CEMETERY) || player2.face.getStatus().equals(Reactable.Status.CEMETERY);
    }

    /**
     * This method returns the game's board
     * @return SnSGame.Board
     */
    public Board getBoard(){
        return board;
    }

    /**
     * This is a helper method that swaps the current player after each turn
     */
    private void swapPlayers(){
        if (currentPlayer == player2) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }
    }

    /**
     * This is a helper method for parsing user input. It checks whether the player entered a character where necessary
     * @param token
     * @return char
     * @throws InvalidMoveException
     */
    private char parseChar(String token) throws InvalidMoveException {
        char[] cArray = token.toCharArray();
        if (cArray.length==1){
            return cArray[0];
        }
        throw new InvalidMoveException("Letter not valid");
    }

    /**
     * This is a helper method for parsing user input. It checks whether the player entered an integer where necessary
     * @param token
     * @return int
     * @throws InvalidMoveException
     */
    private int parseInt(String token) throws InvalidMoveException {
        try {
            int i = Integer.parseInt(token);
            return i;
        } catch(NumberFormatException e){
            throw new InvalidMoveException(e);
        }
    }

    public static void main(String[] args){
        SnSGame game = new SnSGame();
        game.playGame();
    }

}

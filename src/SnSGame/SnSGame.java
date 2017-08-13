package SnSGame;

import Actions.Action;
import Actions.CreateAction;
import Actions.ReactAction;
import Actions.RotateAction;
import Actions.Visitors.*;
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
    private Scanner scanner;

    /**
     * The constructor initializes the two players and their faces and creation squares.
     * It also initializes the board.
     */
    public SnSGame(Scanner scanner) {
        player1 = new Player(colors[0], false, new Face('0', p1FaceCoords), new CreationSquare(p1CreationCoords));
        player2 = new Player(colors[1], true, new Face('1', p2FaceCoords), new CreationSquare(p2CreationCoords));
        board = new Board(player1, player2);
        currentPlayer = player1;
        this.scanner=scanner;
        redrawGame();
        playGame();
    }

    /**
     * This method is invoked to play the game until someone wins.
     * It repeatedly asks for user inputs and passes the input to the playerMove method which parses the commands.
     */
    public void playGame() {
        //loop while game is not won
        while (!isGameOver()&&scanner.hasNext()) {
            System.out.print((currentPlayer.equals(player1) ? "Player 1's" : "Player 2's") + " Turn!\n");
            while (!passed && !isGameOver()&&scanner.hasNext()) {
                if(!currentPlayer.hasMovesLeft()){
                    System.out.print("You have no move possible moves left this turn! You need to pass!");
                } else if (currentPlayer.hasCreated() || currentPlayer.hasMoved()) {
                    System.out.print("What would you like to do (Rotate, Move): ");
                } else {
                    System.out.print("Your unused pieces are...\n");
                    printTiles(currentPlayer.getUnusedPieces());
                    System.out.print("What would you like to do (Create, Rotate, Move): ");
                }
                String input = scanner.nextLine();
                playerMove(input);
            }
            if (isGameOver()) break;
            passed = false;
        }
        if(player1.face.getStatus().equals(Reactable.Status.CEMETERY)) {
            System.out.println("Player 2 won!");
        } else if(player2.face.getStatus().equals(Reactable.Status.CEMETERY)){
            System.out.println("Player 1 won!");
        } else {
            System.out.println("No more input! Game over!");
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
            if (input.length < 3) {
                System.out.println("Input too short!");
                return;
            }
            try {
                char c = parseChar(input[1]);
                int i = parseInt(input[2]);
                CreateAction create = new CreateAction(currentPlayer.getPiece(c), i, currentPlayer);
                board.apply(create);
                //check for reactions
                reactionCheck(currentPlayer.getPiece(c));
            } catch (InvalidMoveException e){
                System.out.println(e.getMessage());
                return;
            }
        } else if (input[0].toLowerCase().equals("rotate")) {
            if (input.length < 3) {
                System.out.println("Input too short!");
                return;
            }
            try {
                char c = parseChar(input[1]);
                int i = parseInt(input[2]);
                RotateAction rotate = new RotateAction(currentPlayer.getPiece(c), i, currentPlayer);
                board.apply(rotate);
                //todo check for reactions
                reactionCheck(currentPlayer.getPiece(c));
            } catch (InvalidMoveException e){
                System.out.println(e.getMessage());
                return;
            }
        } else if (input[0].toLowerCase().equals("move")) {
            if (input.length < 3) {
                System.out.println("Input too short!");
                return;
            }
            try {
                MoveActionVisitor move;
                char c = parseChar(input[1]);
                String direction = input[2];
                if (direction.toLowerCase().equals("up")) {
                    move = new MoveUp(currentPlayer.getPiece(c));

                } else if (direction.toLowerCase().equals("down")) {
                    move = new MoveDown(currentPlayer.getPiece(c));
                } else if (direction.toLowerCase().equals("left")) {
                    move = new MoveLeft(currentPlayer.getPiece(c));
                } else if (direction.toLowerCase().equals("right")) {
                    move = new MoveRight(currentPlayer.getPiece(c));
                } else {
                    throw new InvalidMoveException("Invalid direction");
                }
                if(currentPlayer.getPiecesMoved().contains(currentPlayer.getPiece(c))){
                    throw new InvalidMoveException("Cannot move a piece that has already been moved!");
                }
                board.apply(move);
                currentPlayer.addAction(move);
                currentPlayer.pieceMoved(currentPlayer.getPiece(c));
                //check for reactions
                reactionCheck(currentPlayer.getPiece(c));
            } catch (InvalidMoveException e){
                System.out.println(e.getMessage());
                return;
            }
        } else if (input[0].toLowerCase().equals("undo")) {
            if(input.length>1){
                System.out.println("Input too long for undo command");
                return;
            }
            try {
                Action toReverse = currentPlayer.undo();
                board.reverse(toReverse);
                //todo check for reactions if the piece involved is still on the board
                if(toReverse.getPiece().getStatus().equals(Reactable.Status.ON_BOARD)) {
                    reactionCheck(toReverse.getPiece());
                }
            } catch (InvalidMoveException e){
                System.out.println(e.getMessage());
                return;
            }
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
            System.out.println("Unrecognizable command: '"+in+"'");
            return;
        }
        redrawGame();
    }

    public void reactionCheck(Piece piece){
        //todo complete
        if(!board.offerReactions(piece).isEmpty()){
            redrawGame();
            System.out.println("Choose a reaction for "+piece.letter+": (enter a character)");
            printTiles(board.offerReactions(piece));
            Map<Character, Reactable> chars = new HashMap<>();
            for(Reactable r : board.offerReactions(piece)){
                chars.put(r.getLetter(), r);
            }
            String input = scanner.next();
            char c = input.charAt(0);
            scanner.nextLine();
            while(!input.equals("undo") && !chars.keySet().contains(c)){
                System.out.println("Sorry, that wasn't one of the options. Choose again. (Case Sensitive)");
                printTiles(board.offerReactions(piece));
                input = scanner.next();
                c = input.charAt(0);
                scanner.nextLine();
            }
            if(input.equals("undo")){
                playerMove(input);
            } else {
                board.apply(new ReactAction(piece, chars.get(c), currentPlayer));
                //todo offer chain reaction
            }
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
        SnSGame game = new SnSGame(new Scanner(System.in));
    }

}

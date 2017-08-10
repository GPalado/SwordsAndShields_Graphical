package SnSGame;

import Tiles.CreationSquare;
import Tiles.Reactables.Reactable;

import java.awt.*;

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

    public SnSGame() {
        player1 = new Player(colors[0], false, '0', p1FaceCoords, new CreationSquare(p1CreationCoords));
        player2 = new Player(colors[1], true, '1', p2FaceCoords, new CreationSquare(p2CreationCoords));
        board = new Board(player1, player2);
        currentPlayer = player1;
        redrawGame();
    }

    public void playGame(){
        //loop while game is not won
        while(!isGameOver()){
            System.out.print((currentPlayer.equals(player1)? "Yellow" : "Green") + " SnSGame.Player's Turn!\nYour unplayed pieces are:\n");
            currentPlayer.drawUnusedPieces();
            try {
                while(currentPlayer.hasMovesLeft()) {
                    System.out.print("What would you like to do (Create, Rotate, Move): ");
                    String input = System.in.toString();
                    playerMove(input);
                }
            } catch (InvalidMoveException e){
                System.out.println(e.getMessage());
            }
            swapPlayers();
        }
    }

    /**
     * This method retrieves and translates user input into player moves and applies the relevant actions.
     */
    public void playerMove(String in) throws InvalidMoveException {
        String[] input = in.split(" ");
        if (input.length > 3) {
            throw new InvalidMoveException("Input too long");
        }
        if (input[0].toLowerCase().equals("create")) {
            char c = parseChar(input[1]);
            int i = parseInt(input[2]);
        } else if (input[0].toLowerCase().equals("rotate")) {
            char c = parseChar(input[1]);
            int i = parseInt(input[2]);
        } else if (input[0].toLowerCase().equals("move")) {
            char c = parseChar(input[1]);
        } else if (input[0].toLowerCase().equals("undo")) {
            currentPlayer.undo();
        } else if (input[0].toLowerCase().equals("pass")) {
            currentPlayer.pass();
            swapPlayers();
        } else {
            throw new InvalidMoveException("Unrecognizable command");
        }
        redrawGame();
    }

    /**
     * This method redraws the game's board
     */
    public void redrawGame() {
        //clear current board from console
//        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
     * @param s
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
     * @param s
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
    }

}
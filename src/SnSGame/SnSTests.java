package SnSGame; /**
 * Created by gabrielle palado on 6/08/2017.
 */

import org.junit.*;
import static org.junit.Assert.*;

public class SnSTests {

    String emptyBoard = "xxxxxx                        \n" +
            "xxxxxx                        \n" +
            "xxxxxx                        \n" +
            "xxx                           \n" +
            "xxx 1                         \n" +
            "xxx                           \n" +
            "      /-\\                     \n" +
            "      | |                     \n" +
            "      \\-/                     \n" +
            "                              \n" +
            "                              \n" +
            "                              \n" +
            "                              \n" +
            "                              \n" +
            "                              \n" +
            "                              \n" +
            "                              \n" +
            "                              \n" +
            "                              \n" +
            "                              \n" +
            "                              \n" +
            "                     /-\\      \n" +
            "                     | |      \n" +
            "                     \\-/      \n" +
            "                           xxx\n" +
            "                         0 xxx\n" +
            "                           xxx\n" +
            "                        xxxxxx\n" +
            "                        xxxxxx\n" +
            "                        xxxxxx\n";

    @Test
    public void test_create_board(){
        SnSGame game = new SnSGame();
        assertEquals(emptyBoard, game.getBoard().toString());
    }

//    @Test
//    public void get_piece(){
//        //todo fix this test
//        Player p1 = new Player(Color.yellow, true, '0');
//        Character[][] pieceRep = {{' ', '-', ' '},{'|', 'A', '|'},{' ', '#', ' '}};
//        try {
//            assertEquals(pieceRep, p1.getPiece('A').getRepresentation());
//            assertEquals("unused", p1.getPiece('A').getStatus());
//        } catch (InvalidMoveException e){
//            fail(e.getMessage());
//        }
//    }

    @Test
    public void player_place_new_piece() {
        SnSGame game = new SnSGame();
        try {
            game.playerMove("Create a 0");
            String createBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                      |       \n" +
                    "                     -a#      \n" +
                    "                      |       \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(createBoard, game.getBoard().toString());
        } catch (InvalidMoveException e) {
            fail(e.getMessage());
        }
    }

    //test creation square occupied
    @Test
    public void test_creation_square_occupied(){
        SnSGame game = new SnSGame();
        try {
            game.playerMove("Create a 0");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create b 0");
            //should catch error and print message
        } catch (InvalidMoveException e) {
            fail(e.getMessage());
        }
    }

    //test move
    @Test
    public void test_move_down(){
        SnSGame game = new SnSGame();
        try {
            game.playerMove("pass"); //yellow player pass create
            game.playerMove("pass"); //yellow player pass turn
            game.playerMove("Create a 0");
            game.playerMove("Move a down");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "       |                      \n" +
                    "      -A#                     \n" +
                    "       |                      \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test_move_right(){
        SnSGame game = new SnSGame();
        try {
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create a 0");
            game.playerMove("Move a right");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\ |                   \n" +
                    "      | |-A#                  \n" +
                    "      \\-/ |                   \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test_move_left(){
        SnSGame game = new SnSGame();
        try {
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create a 0");
            game.playerMove("Move a left");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "    | /-\\                     \n" +
                    "   -A#| |                     \n" +
                    "    | \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e) {
            fail(e.getMessage());
        }
    }

    //test move up
    @Test
    public void test_move_up(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("Create a 0");
            game.playerMove("Move a up");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                      |       \n" +
                    "                     -a#      \n" +
                    "                      |       \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_move_twice(){
        SnSGame game = new SnSGame();
        try {
            game.playerMove("Create a 0");
            game.playerMove("Move a right");
            game.playerMove("Move a left");
            fail("Cannot move a piece twice in one go");
        } catch (InvalidMoveException e) {
            //good. Supposed to happen
            System.out.println(e.getMessage());
        }
    }

    //test creating twice in one move
    @Test
    public void test_create_twice(){
        SnSGame game = new SnSGame();
        try {
            game.playerMove("Create a 0");
            game.playerMove("Move a right");
            game.playerMove("Create b 0");
            //should catch error and print message
        } catch (InvalidMoveException e) {
            fail(e.getMessage());
        }
    }

    //test move off board
    @Test
    public void test_OOB(){
        SnSGame game = new SnSGame();
        try {
            //also test caps/non caps
            game.playerMove("Create A 0"); //should be lower case
            game.playerMove("Move A right"); //^
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0"); //should be upper case
            game.playerMove("Move e up"); //^
            game.playerMove("pass"); //pass turn
            game.playerMove("move a RIGHT");
            game.playerMove("pass"); //pass turn
            game.playerMove("move e UP");
            game.playerMove("pass"); //pass turn
            game.playerMove("move a Right");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx E                      \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
            game.playerMove("pass");//pass turn
            game.playerMove("move e left");

            moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    //test place dead piece
    @Test
    public void test_place_dead(){
        SnSGame game = new SnSGame();
        try {
            //also test caps/non caps
            game.playerMove("Create A 0"); //should be lower case
            game.playerMove("Move A right"); //^
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0"); //should be upper case
            game.playerMove("Move e up"); //^
            game.playerMove("pass"); //pass turn
            game.playerMove("move a right");
            game.playerMove("pass"); //pass turn
            game.playerMove("move e up");
            game.playerMove("pass"); //pass turn
            game.playerMove("move a right");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass move
            game.playerMove("create a 0");
            //should catch error and print message
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    //test pushing pieces
    @Test
    public void test_push_left(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("Create a 0");
            game.playerMove("Move a left");
            game.playerMove("pass"); //pass move
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0");
            game.playerMove("move e left");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                |    /-\\      \n" +
                    "               -a# e | |      \n" +
                    "                |    \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_push_left_dead(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("Create a 0");
            game.playerMove("Move a left");
            game.playerMove("pass"); //pass move
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0");
            game.playerMove("move e left");
            game.playerMove("pass"); //pass move
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move e left");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    " E    | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_push_right_dead(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("Create e 0");
            game.playerMove("Move e right");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create a 0");
            game.playerMove("move a right");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move a right");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\    | \n" +
                    "                     | |   -a#\n" +
                    "                     \\-/    | \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_push_right(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0");
            game.playerMove("Move e right");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create a 0");
            game.playerMove("move a right");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\ |                   \n" +
                    "      | |-A# E                \n" +
                    "      \\-/ |                   \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_push_up(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0");
            game.playerMove("Move e up");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create c 0");
            game.playerMove("move c up");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx E                      \n" +
                    "xxxxxx                        \n" +
                    "xxx    #                      \n" +
                    "xxx 1 #C#                     \n" +
                    "xxx    #                      \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_push_down(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0");
            game.playerMove("Move e down");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create c 0");
            game.playerMove("move c down");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "       #                      \n" +
                    "      #C#                     \n" +
                    "       #                      \n" +
                    "                              \n" +
                    "       E                      \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_push_off_creation_1(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0");
            game.playerMove("Move e down");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create c 0");
            game.playerMove("move e up");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx    #                      \n" +
                    "xxx 1 #C#                     \n" +
                    "xxx    #                      \n" +
                    "                              \n" +
                    "       E                      \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_push_off_creation_2(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0");
            game.playerMove("Move e up");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create c 0");
            game.playerMove("move e down");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "                              \n" +
                    "       E                      \n" +
                    "                              \n" +
                    "       #                      \n" +
                    "      #C#                     \n" +
                    "       #                      \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_push_off_creation_3(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0");
            game.playerMove("Move e right");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create c 0");
            game.playerMove("move e left");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "    #                         \n" +
                    "   #C# E                      \n" +
                    "    #                         \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_push_off_creation_4(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0");
            game.playerMove("Move e left");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create c 0");
            game.playerMove("move e right");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "          #                   \n" +
                    "       E #C#                  \n" +
                    "          #                   \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_push_onto_face_1(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0");
            game.playerMove("Move e up");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create c 0");
            game.playerMove("move c right");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move c up");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move c left");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx    #                      \n" +
                    "xxx 1 #C#                     \n" +
                    "xxx    #                      \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_push_onto_face_2(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0");
            game.playerMove("Move e left");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create c 0");
            game.playerMove("move c down");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move c left");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move c up");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "    # /-\\                     \n" +
                    "   #C#| |                     \n" +
                    "    # \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_push_onto_face_3(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("Create e 0");
            game.playerMove("Move e down");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create c 0");
            game.playerMove("move c left");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move c down");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move c right");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                      #    xxx\n" +
                    "                     #c# 0 xxx\n" +
                    "                      #    xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_push_onto_face_4(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("Create e 0");
            game.playerMove("Move e right");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create c 0");
            game.playerMove("move c up");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move c right");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move c down");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\ #    \n" +
                    "                     | |#c#   \n" +
                    "                     \\-/ #    \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    //test placing piece already on board
    @Test
    public void test_create_onboard(){
        SnSGame game = new SnSGame();
        try {
            game.playerMove("Create a 0");
            game.playerMove("Move a right");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("Create a 0");
            //should catch and print message
        } catch (InvalidMoveException e) {
            fail(e.getMessage());
        }
    }

    //test undo
    @Test
    public void test_undo_1(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("Create a 0");
            game.playerMove("undo");
            assertEquals(game.getBoard().toString(), emptyBoard);
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_2(){
        SnSGame game = new SnSGame();
        String undoBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                      |       \n" +
                "                     -a#      \n" +
                "                      |       \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("Create a 0");
            game.playerMove("move a left");
            game.playerMove("undo");
            assertEquals(undoBoard, game.getBoard().toString());
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    //todo not throw this exception
    @Test
    public void test_undo_3(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("undo");
            //good should catch and say error
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_4(){
        SnSGame game = new SnSGame();
        String undoBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                         #    \n" +
                "                      i##c# e \n" +
                "                         #    \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("create e 0");
            game.playerMove("move e right");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("create c 0");
            game.playerMove("move c right");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("create i 0");
            game.playerMove("move i right");
            game.playerMove("undo");
            assertEquals(undoBoard, game.getBoard().toString());
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_5(){
        SnSGame game = new SnSGame();
        String undoBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                   #          \n" +
                "                e #c# i#      \n" +
                "                   #          \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("create e 0");
            game.playerMove("move e left");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("create c 0");
            game.playerMove("move c left");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("create i 0");
            game.playerMove("move i left");
            game.playerMove("undo");
            assertEquals(undoBoard, game.getBoard().toString());
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_6(){
        SnSGame game = new SnSGame();
        String undoBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                      e       \n" +
                "                              \n" +
                "                      #       \n" +
                "                     #c#      \n" +
                "                      #       \n" +
                "                              \n" +
                "                      i#      \n" +
                "                              \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("create e 0");
            game.playerMove("move e up");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("create c 0");
            game.playerMove("move c up");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("create i 0");
            game.playerMove("move i up");
            game.playerMove("undo");
            assertEquals(undoBoard, game.getBoard().toString());
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_7(){
        SnSGame game = new SnSGame();
        String undoBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                      i#      \n" +
                "                              \n" +
                "                      #    xxx\n" +
                "                     #c# 0 xxx\n" +
                "                      #    xxx\n" +
                "                        xxxxxx\n" +
                "                      e xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("create e 0");
            game.playerMove("move e down");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("create c 0");
            game.playerMove("move c down");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("create i 0");
            game.playerMove("move i down");
            game.playerMove("undo");
            assertEquals(undoBoard, game.getBoard().toString());
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_8(){
        SnSGame game = new SnSGame();
        String undoBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                     /-\\      \n" +
                "                     | |      \n" +
                "                     \\-/      \n" +
                "                      #    xxx\n" +
                "                     #c# 0 xxx\n" +
                "                      #    xxx\n" +
                "                        xxxxxx\n" +
                "                      e xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("create e 0");
            game.playerMove("move e down");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("create c 0");
            game.playerMove("move c down");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("move c down");
            game.playerMove("undo");
            assertEquals(undoBoard, game.getBoard().toString());
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_9(){
        SnSGame game = new SnSGame();
        String undoBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                     /-\\      \n" +
                "                     | |      \n" +
                "                     \\-/      \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                      e xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("create e 0");
            game.playerMove("move e down");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("move e down");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("move e down");
            game.playerMove("undo");
            assertEquals(undoBoard, game.getBoard().toString());
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

//test undo rotations
    @Test
    public void test_undo_10(){
        SnSGame game = new SnSGame();
        String rotateBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                     /-\\      \n" +
                "                     | |      \n" +
                "                     \\-/      \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try {
            game.playerMove("create u 90");
            game.playerMove("undo");
            assertEquals(game.getBoard().toString(), rotateBoard);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_11(){
        SnSGame game = new SnSGame();
        String rotateBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                      |       \n" +
                "                      u-      \n" +
                "                              \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try {
            game.playerMove("create u 90");
            game.playerMove("rotate u 90");
            game.playerMove("undo");
            assertEquals(game.getBoard().toString(), rotateBoard);
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

        @Test
    public void test_undo_12(){
        SnSGame game = new SnSGame();
            String rotateBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                      |       \n" +
                    "                     -u       \n" +
                    "                              \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            try {
                game.playerMove("create u 0");
                game.playerMove("rotate u 180");
                game.playerMove("undo");
                assertEquals(game.getBoard().toString(), rotateBoard);
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

        @Test
    public void test_undo_13(){
        SnSGame game = new SnSGame();
            String rotateBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                      |       \n" +
                    "                     -u       \n" +
                    "                              \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            try {
                game.playerMove("create u 0");
                game.playerMove("rotate u 270");
                game.playerMove("undo");
                assertEquals(game.getBoard().toString(), rotateBoard);
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_14(){
        SnSGame game = new SnSGame();
        String undoBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                      |       \n" +
                "                     -a#      \n" +
                "                      |       \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("Create a 0");
            game.playerMove("move a right");
            game.playerMove("undo");
            assertEquals(undoBoard, game.getBoard().toString());
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_15(){
        SnSGame game = new SnSGame();
        String undoBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                      |       \n" +
                "                     -a#      \n" +
                "                      |       \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("Create a 0");
            game.playerMove("move a up");
            game.playerMove("undo");
            assertEquals(undoBoard, game.getBoard().toString());
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_16(){
        SnSGame game = new SnSGame();
        String undoBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                      |       \n" +
                "                     -a#      \n" +
                "                      |       \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("Create a 0");
            game.playerMove("move a down");
            game.playerMove("undo");
            assertEquals(undoBoard, game.getBoard().toString());
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_17(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("Create e 0");
            game.playerMove("Move e right");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create a 0");
            game.playerMove("move a right");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move a right");
            game.playerMove("undo");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\ |    \n" +
                    "                     | |-a# e \n" +
                    "                     \\-/ |    \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_18(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("Create e 0");
            game.playerMove("Move e right");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move e right");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move e right");
            game.playerMove("undo");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |    e \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_19(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0");
            game.playerMove("Move e up");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create c 0");
            game.playerMove("move c up");
            game.playerMove("pass");
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move c up");
            game.playerMove("undo");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx E                      \n" +
                    "xxxxxx                        \n" +
                    "xxx    #                      \n" +
                    "xxx 1 #C#                     \n" +
                    "xxx    #                      \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_20(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0");
            game.playerMove("Move e up");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move e up");
            game.playerMove("pass");
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move e up");
            game.playerMove("undo");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx E                      \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_undo_21(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("Create a 0");
            game.playerMove("Move a left");
            game.playerMove("pass"); //pass move
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 0");
            game.playerMove("move e left");
            game.playerMove("pass"); //pass move
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("move e left");
            game.playerMove("undo");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    " |    /-\\                     \n" +
                    "-A# E | |                     \n" +
                    " |    \\-/                     \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    //test rotations
    @Test
    public void test_rotation_1(){
        SnSGame game = new SnSGame();
        String rotateBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                      #       \n" +
                "                     #x       \n" +
                "                      #       \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("create x 0");
            game.playerMove("rotate x 90");
            assertEquals(game.getBoard().toString(), rotateBoard);
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_rotation_2(){
        SnSGame game = new SnSGame();
        String rotateBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                      |       \n" +
                "                     #a-      \n" +
                "                      |       \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("create a 0");
            game.playerMove("rotate a 180");
            assertEquals(game.getBoard().toString(), rotateBoard);
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_rotation_3(){
        SnSGame game = new SnSGame();
        String rotateBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                     -u       \n" +
                "                      |       \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("create u 0");
            game.playerMove("rotate u 270");
            assertEquals(game.getBoard().toString(), rotateBoard);
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_rotation_4(){
        SnSGame game = new SnSGame();
        String rotateBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                      u-      \n" +
                "                      |       \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("create u 90");
            game.playerMove("rotate u 90");
            assertEquals(game.getBoard().toString(), rotateBoard);
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_rotation_5(){
        SnSGame game = new SnSGame();
        String rotateBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                      |       \n" +
                "                      u-      \n" +
                "                              \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("create u 90");
            assertEquals(game.getBoard().toString(), rotateBoard);
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_rotation_6(){
        SnSGame game = new SnSGame();
        String rotateBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                      u-      \n" +
                "                      |       \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("create u 180");
            assertEquals(game.getBoard().toString(), rotateBoard);
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void test_rotation_7(){
        SnSGame game = new SnSGame();
        String rotateBoard = "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxxxxx                        \n" +
                "xxx                           \n" +
                "xxx 1                         \n" +
                "xxx                           \n" +
                "      /-\\                     \n" +
                "      | |                     \n" +
                "      \\-/                     \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                     -u       \n" +
                "                      |       \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        try{
            game.playerMove("create u 270");
            assertEquals(game.getBoard().toString(), rotateBoard);
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    //test reactions

    //test kill face

    //test invalid inputs
}

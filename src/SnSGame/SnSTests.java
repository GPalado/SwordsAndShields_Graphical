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
            game.playerMove("Create a 90");
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
            game.playerMove("Create a 90");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create b 180");
            fail("Cannot create when creation square occupied");
        } catch (InvalidMoveException e) {
            //good. Supposed to happen
            System.out.println(e.getMessage());
        }
    }

    //test move
    @Test
    public void test_move_down(){
        SnSGame game = new SnSGame();
        try {
            game.playerMove("pass"); //yellow player pass create
            game.playerMove("pass"); //yellow player pass turn
            game.playerMove("Create a 90");
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
            game.playerMove("Create a 90");
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
            game.playerMove("Create a 90");
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
            game.playerMove("Create a 90");
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
            game.playerMove("Create a 90");
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
            game.playerMove("Create a 90");
            game.playerMove("Move a right");
            game.playerMove("Create b 180");
            fail("Cannot create twice in one go");
        } catch (InvalidMoveException e) {
            //good. Supposed to happen
            System.out.println(e.getMessage());
        }
    }

    //test move off board
    @Test
    public void test_OOB(){
        SnSGame game = new SnSGame();
        try {
            //also test caps/non caps
            game.playerMove("Create A 90"); //should be lower case
            game.playerMove("Move A right"); //^
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 180"); //should be upper case
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
            game.playerMove("Create A 90"); //should be lower case
            game.playerMove("Move A right"); //^
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 180"); //should be upper case
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
            game.playerMove("create a 90");
            fail("cannot create a dead piece");
        } catch (InvalidMoveException e){
            //good
            System.out.println(e.getMessage());
        }
    }

    //test pushing pieces
    @Test
    public void test_push_left(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("Create a 90");
            game.playerMove("Move a left");
            game.playerMove("pass"); //pass move
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 180");
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
    public void test_push_right(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create e 90");
            game.playerMove("Move e right");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create a 180");
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
            game.playerMove("Create e 90");
            game.playerMove("Move e up");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create c 180");
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
            game.playerMove("Create e 90");
            game.playerMove("Move e down");
            game.playerMove("pass"); //pass turn
            game.playerMove("pass"); //pass create
            game.playerMove("pass"); //pass turn
            game.playerMove("Create c 180");
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

    //test undo

    //test reactions

    //test kill face

    //test placing piece already on board
    @Test
    public void test_create_onboard(){
        SnSGame game = new SnSGame();
        try {
            game.playerMove("Create a 90");
            game.playerMove("Move a right");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("Create a 180");
            fail("Cannot create a piece already on the board");
        } catch (InvalidMoveException e) {
            //good. Supposed to happen
            System.out.println(e.getMessage());
        }
    }
    //test invalid inputs
}

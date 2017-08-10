package SnSGame; /**
 * Created by gabrielle palado on 6/08/2017.
 */


import SnSGame.InvalidMoveException;
import org.junit.*;

import java.awt.*;

import static org.junit.Assert.*;

public class SnSTests {

    String emptyBoard = "xxxxxx                        \n" +
            "xxxxxx                        \n" +
            "xxxxxx                        \n" +
            "xxx                           \n" +
            "xxx 0                         \n" +
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
            "                         1 xxx\n" +
            "                           xxx\n" +
            "                        xxxxxx\n" +
            "                        xxxxxx\n" +
            "                        xxxxxx\n";

    @Test
    public void test_create_board(){
        SnSGame game = new SnSGame();
        assertEquals(emptyBoard, game.getBoard().toString());
    }

    @Test
    public void get_piece(){
        //todo fix this test
        Player p1 = new Player(Color.yellow, true, '0');
        Character[][] pieceRep = {{' ', '-', ' '},{'|', 'A', '|'},{' ', '#', ' '}};
        try {
            assertEquals(pieceRep, p1.getPiece('A').getRepresentation());
            assertEquals("unused", p1.getPiece('A').getStatus());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    @Test
    public void player_place_new_piece() {
        SnSGame game = new SnSGame();
        try {
            game.playerMove("Create a 90");
            String createBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 0                         \n" +
                    "xxx                           \n" +
                    "       |                      \n" +
                    "      -a#                     \n" +
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
                    "                              \n" +
                    "                              \n" +
                    "                              \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         1 xxx\n" +
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
            game.playerMove("pass");
            game.playerMove("pass");
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
            game.playerMove("Create a 90");
            game.playerMove("Move a down");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 0                         \n" +
                    "xxx                           \n" +
                    "      /-\\                     \n" +
                    "      | |                     \n" +
                    "      \\-/                     \n" +
                    "       |                      \n" +
                    "      -a#                     \n" +
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
                    "                         1 xxx\n" +
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
            game.playerMove("Create a 90");
            game.playerMove("Move a right");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 0                         \n" +
                    "xxx                           \n" +
                    "      /-\\ |                   \n" +
                    "      | |-a#                  \n" +
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
                    "                         1 xxx\n" +
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
            game.playerMove("Create a 90");
            game.playerMove("Move a left");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 0                         \n" +
                    "xxx                           \n" +
                    "    | /-\\                     \n" +
                    "   -a#| |                     \n" +
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
                    "                         1 xxx\n" +
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
            game.playerMove("pass"); //green player turn
            game.playerMove("Create a 90");
            game.playerMove("Move a up");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 0                         \n" +
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
                    "                     -A#      \n" +
                    "                      |       \n" +
                    "                     /-\\      \n" +
                    "                     | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         1 xxx\n" +
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
            game.playerMove("Move A left"); //^
            game.playerMove("pass");
            game.playerMove("Create e 180"); //should be upper case
            game.playerMove("Move e down"); //^
            game.playerMove("pass");
            game.playerMove("move a Left");
            game.playerMove("pass");
            game.playerMove("move e down");
            game.playerMove("pass");
            game.playerMove("move a left");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 0                         \n" +
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
                    "                         1 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                      E xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
            game.playerMove("pass");
            game.playerMove("move e right");

            moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 0                         \n" +
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
                    "                         1 xxx\n" +
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
            game.playerMove("Move A left"); //^
            game.playerMove("pass");
            game.playerMove("Create e 180"); //should be upper case
            game.playerMove("Move e down"); //^
            game.playerMove("pass");
            game.playerMove("move a Left");
            game.playerMove("pass");
            game.playerMove("move e down");
            game.playerMove("pass");
            game.playerMove("move a left");
            game.playerMove("pass");
        } catch (InvalidMoveException e){
            //good
            System.out.println(e.getMessage());
        }
    }

    //test pushing pieces
    @Test
    public void test_push(){
        SnSGame game = new SnSGame();
        try{
            game.playerMove("Create a 90");
            game.playerMove("Move a left");
            game.playerMove("pass");
            game.playerMove("pass");
            game.playerMove("Create e 180");
            game.playerMove("move e left");
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 0                         \n" +
                    "xxx                           \n" +
                    " |    /-\\                     \n" +
                    "-a# e | |                     \n" +
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
                    "                         1 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
        } catch (InvalidMoveException e){
            fail(e.getMessage());
        }
    }

    //test kill face

    //test placing piece already on board

    //test invalid inputs
}

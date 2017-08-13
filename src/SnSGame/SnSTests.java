package SnSGame; /**
 * Created by gabrielle palado on 6/08/2017.
 */

import org.junit.*;

import java.io.StringReader;
import java.util.Scanner;

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
        SnSGame game = new SnSGame(new Scanner(new StringReader("")));
        assertEquals(emptyBoard, game.getBoard().toString());
    }

    @Test
    public void player_place_new_piece() {
        SnSGame game = new SnSGame(new Scanner(new StringReader("Create a 0\npass\n")));
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
    }

    //test creation square occupied
    @Test
    public void test_creation_square_occupied(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("Create a 0\npass\npass\ncreate b 0\n")));
        //should catch error and print message
    }

    //test move
    @Test
    public void test_move_down(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("pass\npass\ncreate a 0\nmove a down\n")));
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
    }

    @Test
    public void test_move_right(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("pass\npass\ncreate a 0\nmove a right\n")));
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
    }

    @Test
    public void test_move_left(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create a 0\nmove a left\n")));
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
                "                   | /-\\      \n" +
                "                  -a#| |      \n" +
                "                   | \\-/      \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        assertEquals(moveBoard, game.getBoard().toString());
    }

    //test move up
    @Test
    public void test_move_up(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create a 0\nmove a up\n")));
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
    }

    //test moving a piece twice
    @Test
    public void test_move_twice(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("Create C 0\nMove c right\npass\npass\npass\ncreate e 0\n" +
                "move c up\nmove c Left\n")));
//          ok, should catch and print output
    }

    //test creating twice in one move
    @Test
    public void test_create_twice(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create c 0\nmove c right\npass\ncreate e 0\nmove e left\ncreate b 90\n")));
            //should catch error and print message
    }

    //test move off board
    @Test
    public void test_OOB(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create a 90\nmove a right\npass\ncreate e 0\nmove e up\npass\n" +
                "move a right\npass\nmove e up\npass\nmove a right\npass\nmove e left\n")));

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
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
        assertEquals(moveBoard, game.getBoard().toString());
    }

    //test place dead piece
    @Test
    public void test_place_dead(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create c 0\nmove c right\npass\ncreate e 0\nmove e up\n" +
                "pass\nmove c right\npass\nmove e up\npass\nmove c right\npass\npass\npass\ncreate c 0\n")));
            //should catch error and print message
    }

    //test pushing pieces
    @Test
    public void test_push_left(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create a 0\nmove a left\npass\npass\npass\ncreate e 0\nmove e left\n")));
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
    }

    @Test
    public void test_push_left_dead(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("pass\npass\ncreate c 0\nmove c left\npass\n" +
                "pass\npass\ncreate e 0\nmove e left\n" +
                "pass\npass\npass\nmove e left\n")));
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
    }

    @Test
    public void test_push_right_dead(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create e 0\nmove e right\npass\npass\npass\ncreate c 0\n" +
                "move c right\npass\npass\npass\nmove c right\n")));
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
                    "                     /-\\    # \n" +
                    "                     | |   #c#\n" +
                    "                     \\-/    # \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
    }

    @Test
    public void test_push_right(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("pass\npass\ncreate e 0\nmove e right\n" +
                "pass\npass\npass\ncreate a 0\nmove a right\n")));
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
    }

    @Test
    public void test_push_up(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("pass\npass\ncreate e 0\nmove e up\npass\n" +
                "pass\npass\ncreate c 0\nmove c up\n")));
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
    }

    @Test
    public void test_push_down(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("pass\npass\ncreate e 0\nmove e down\n" +
                "pass\npass\npass\ncreate c 0\nmove c down\n")));
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
    }

    @Test
    public void test_push_off_creation_1(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("pass\npass\ncreate e 0\nmove e down\n" +
                "pass\npass\npass\ncreate c 0\nmove e up\n")));
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
    }

    @Test
    public void test_push_off_creation_2(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("pass\npass\ncreate e 0\nmove e up\npass\npass\npass\ncreate c 0\nmove e down\n")));
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
    }

    @Test
    public void test_push_off_creation_3(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("pass\npass\n\ncreate e 0\nmove e right\npass\npass\npass\ncreate c 0\nmove e left\n")));
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
    }

    @Test
    public void test_push_off_creation_4(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("pass\npass\ncreate e 0\nmove e left\npass\n" +
                "pass\npass\ncreate c 0\nmove e right\n")));
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
    }

    @Test
    public void test_push_onto_face_1(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("pass\npass\ncreate e 0\nmove e up\npass\npass\npass\ncreate c 0\nmove c right\n" +
                "pass\npass\npass\nmove c up\npass\npass\npass\nmove c left\n")));
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
    }

    @Test
    public void test_push_onto_face_2(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("pass\npass\ncreate e 0\nmove e left\npass\npass\npass\ncreate c 0\nmove c down\n" +
                "pass\npass\npass\nmove c left\npass\npass\npass\nmove c up\n")));
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
    }

    @Test
    public void test_push_onto_face_3(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create e 0\nmove e down\npass\npass\npass\ncreate c 0\nmove c left\n" +
                "pass\npass\npass\nmove c down\npass\npass\npass\nmove c right\n")));
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
    }

    @Test
    public void test_push_onto_face_4(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create e 0\nmove e right\npass\npass\npass\ncreate c 0\nmove c up\n" +
                "pass\npass\npass\nmove c right\npass\npass\npass\nmove c down\n")));
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
    }

    //test placing piece already on board
    @Test
    public void test_create_onboard(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create a 90\nmove a right\npass\ncreate a 0\n")));
            //should catch and print message
    }

    //test undo
    @Test
    public void test_undo_1(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create a 0\nundo\n")));
        assertEquals(game.getBoard().toString(), emptyBoard);
    }

    @Test
    public void test_undo_2(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create a 0\nmove a left\nundo\n")));
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
        assertEquals(undoBoard, game.getBoard().toString());
    }

    //not throw this exception
    @Test
    public void test_undo_3(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("undo")));
        //good should catch and say error
    }

    @Test
    public void test_undo_4(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create e 0\nmove e right\npass\npass\npass\ncreate c 0\nmove c right\n" +
                "pass\npass\npass\ncreate i 0\nmove i right\nundo\n")));
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
        assertEquals(undoBoard, game.getBoard().toString());
    }

    @Test
    public void test_undo_5(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create e 0\nmove e left\npass\npass\npass\ncreate c 0\nmove c left\n" +
                "pass\npass\npass\ncreate i 0\nmove i left\nundo\n")));
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

            assertEquals(undoBoard, game.getBoard().toString());
    }

    @Test
    public void test_undo_6(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create e 0\nmove e up\npass\npass\npass\ncreate c 0\nmove c up\n" +
                "pass\npass\npass\ncreate i 0\nmove i up\nundo")));
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

            assertEquals(undoBoard, game.getBoard().toString());
    }

    @Test
    public void test_undo_7(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create e 0\nmove e down\npass\npass\npass\ncreate c 0\nmove c down\n" +
                "pass\npass\npass\ncreate i 0\nmove i down\nundo\n")));
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

            assertEquals(undoBoard, game.getBoard().toString());
    }

    @Test
    public void test_undo_8(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create e 0\nmove e down\npass\npass\npass\ncreate c 0\nmove c down\n" +
                "pass\npass\npass\nmove c down\nundo\n")));
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

            assertEquals(undoBoard, game.getBoard().toString());
    }

    @Test
    public void test_undo_9(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create e 0\nmove e down\npass\npass\npass\nmove e down\n" +
                "pass\npass\npass\nmove e down\nundo\n")));
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

            assertEquals(undoBoard, game.getBoard().toString());
    }

//test undo rotations
    @Test
    public void test_undo_10(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create u 90\nundo\n")));
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
            assertEquals(game.getBoard().toString(), rotateBoard);
    }

    @Test
    public void test_undo_11(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create u 90\npass\npass\npass\nrotate u 90\nundo\n")));
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
            assertEquals(game.getBoard().toString(), rotateBoard);
    }

        @Test
    public void test_undo_12(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create u 90\npass\npass\npass\nrotate u 180\nundo\n")));
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
                assertEquals(game.getBoard().toString(), rotateBoard);
    }

        @Test
    public void test_undo_13(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create u 0\npass\npass\npass\nrotate u 270\nundo\n")));
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
                assertEquals(game.getBoard().toString(), rotateBoard);
    }

    @Test
    public void test_undo_14(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create a 90\npass\npass\npass\nmove a right\nundo\n")));
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
                "                     -a-      \n" +
                "                      #       \n" +
                "                           xxx\n" +
                "                         0 xxx\n" +
                "                           xxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n" +
                "                        xxxxxx\n";
            assertEquals(undoBoard, game.getBoard().toString());
    }

    @Test
    public void test_undo_15(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create a 0\npass\npass\npass\nmove a up\nundo\n")));
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
            assertEquals(undoBoard, game.getBoard().toString());
    }

    @Test
    public void test_undo_16(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create a 0\npass\npass\npass\nmove a down\nundo\n")));
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
            assertEquals(undoBoard, game.getBoard().toString());
    }

    @Test
    public void test_undo_17(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create e 0\nmove e right\npass\npass\npass\ncreate c 0\nmove c right\n" +
                "pass\npass\npass\nmove c right\nundo\n")));
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
                    "                     | |#c# e \n" +
                    "                     \\-/ #    \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
            assertEquals(moveBoard, game.getBoard().toString());
    }

    @Test
    public void test_undo_18(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create e 0\nmove e right\npass\npass\npass\nmove e right\npass\npass\npass\nmove e right\nundo\n")));
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
    }

    @Test
    public void test_undo_19(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("pass\npass\ncreate e 0\nmove e up\npass\npass\npass\ncreate c 0\nmove c up\n" +
                "pass\npass\npass\nmove c up\nundo\n")));
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
    }

    @Test
    public void test_undo_20(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("pass\npass\ncreate e 0\nmove e up\npass\npass\npass\nmove e up\n" +
                "pass\npass\npass\nmove e up\nundo\n")));
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
    }

    @Test
    public void test_undo_21(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("pass\npass\ncreate c 270\nmove c left\npass\npass\npass\ncreate e 0\nmove e left\n" +
                "pass\npass\npass\nmove e left\nundo\n")));
            String moveBoard = "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxxxxx                        \n" +
                    "xxx                           \n" +
                    "xxx 1                         \n" +
                    "xxx                           \n" +
                    " #    /-\\                     \n" +
                    "#C# E | |                     \n" +
                    " #    \\-/                     \n" +
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
    }

    //test rotations
    @Test
    public void test_rotation_1(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create x 0\nrotate x 90\n")));
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
            assertEquals(game.getBoard().toString(), rotateBoard);
    }

    @Test
    public void test_rotation_2(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create a 0\nrotate a 180\n")));
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
            assertEquals(game.getBoard().toString(), rotateBoard);
    }

    @Test
    public void test_rotation_3(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create u 0\nrotate u 270\n")));
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
            assertEquals(game.getBoard().toString(), rotateBoard);
    }

    @Test
    public void test_rotation_4(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create u 90\nrotate u 90\n")));
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
            assertEquals(game.getBoard().toString(), rotateBoard);
    }

    @Test
    public void test_rotation_5(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create u 90\n")));
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
            assertEquals(game.getBoard().toString(), rotateBoard);
    }

    @Test
    public void test_rotation_6(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create u 180\n")));
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
            assertEquals(game.getBoard().toString(), rotateBoard);
    }

    @Test
    public void test_rotation_7(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create u 270\n")));
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
            assertEquals(game.getBoard().toString(), rotateBoard);
    }

    //test cannot move AND rotate a piece
    @Test
    public void test_move_and_rotate_invalid(){
        SnSGame game = new SnSGame(new Scanner(new StringReader("create u 0\nmove u left\nrotate u 90\n")));
            String mrBoard = "xxxxxx                        \n" +
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
                    "                   | /-\\      \n" +
                    "                  -u | |      \n" +
                    "                     \\-/      \n" +
                    "                           xxx\n" +
                    "                         0 xxx\n" +
                    "                           xxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n" +
                    "                        xxxxxx\n";
        assertEquals(game.getBoard().toString(), mrBoard);
    }

    //test reactions

    //test kill face

    //test invalid inputs
}

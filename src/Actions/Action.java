package Actions;

public interface Action {

    void execute(SnSGame.Board board);

    void undo();
}

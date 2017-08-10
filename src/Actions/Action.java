package Actions;

public interface Action {

    public void execute(SnSGame.Board board);

    public void undo();
}

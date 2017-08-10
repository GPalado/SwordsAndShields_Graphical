package Actions;

public interface Action {

    public void execute(Board board);

    public void undo();
}

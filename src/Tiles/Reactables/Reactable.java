package Tiles.Reactables;

public interface Reactable {

    public enum Status{
        UNUSED,
        ON_BOARD,
        CEMETERY
    }

    public Status getStatus();

    public void kill();
    public void toLife();
}

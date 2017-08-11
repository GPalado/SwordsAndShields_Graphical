package Tiles.Reactables;

/**
 * This interface determines the actions required by reactable tiles in the swords and shields game.
 */
public interface Reactable {

    /**
     * The reactable tiles have statuses:
     * Unused, on the board, and dead (cemetery)
     */
    enum Status{
        UNUSED,
        ON_BOARD,
        CEMETERY
    }

    /**
     * This method returns the reactable tile's status
     * @return
     */
    Status getStatus();

    /**
     * This method sets the reactable tile's status to the appropriate "dead" status for that tile
     */
    void kill();

    /**
     * This method revives/reactivates a reactable tile.
     */
    void toLife();
}

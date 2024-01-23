package fr.nicoGames.tictactoe;

/**
 * This class represents one cell of the board game.
 */
public class Cell {

    private String representation = "|   ";
    private boolean isEmpt = true;

    /**
     * Returns the representation of the cell.
     *
     * @return A string representing the cell's current representation.
     */
    public String getRepresentation() {
        return representation;
    }

    /**
     * Checks if the cell is empty.
     *
     * @return True if the cell is empty, false otherwise.
     */
    public boolean isEmpt() {
        return isEmpt;
    }

    /**
     * Sets the emptiness status of the cell.
     *
     * @param empt A boolean indicating whether the cell is empty or not.
     */
    public void setEmpt(boolean empt) {
        isEmpt = empt;
    }

    public void setRepresentation(String representationPlayer) {
        this.representation = representationPlayer;
    }
}

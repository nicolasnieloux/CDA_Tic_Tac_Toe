/**
 * This abstract class represents a player
 */
public abstract class Player {

    // Attributs
    private String representation;

    /**
     * Constructs a player with the specified representation symbol.
     *
     * @param representation Symbol of the player. Should be either "| X" or "| O".
     * @throws IllegalArgumentException If the representation is not "| X" or "| O".
     */
    public Player(String representation) {
        if (representation.equals("X") || representation.equals("O")) {
            this.representation = "|  " + representation;
        } else {
            throw new IllegalArgumentException("La représentation doit être \"| X\" ou \"| O\"");
        }
    }

    /**
     * Returns the representation of the player.
     *
     * @return A string representing the player's current representation.
     */
    public String getRepresentation() {
        return representation;
    }

    /**
     * Sets the representation of the player.
     *
     * @param representation The new representation of the player.
     */
    public void setRepresentation(String representation) {
        this.representation = representation;
    }
}
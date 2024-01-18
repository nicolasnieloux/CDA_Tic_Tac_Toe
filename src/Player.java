public abstract class Player {

    // Attributs
    private String representation;


    // Constructor

    public Player(String representation) {
        if (representation.equals("X") || representation.equals("O")) {
            this.representation = "|  " + representation;
        } else {
            throw new IllegalArgumentException("La représentation doit être \"| X\" ou \"| O\"");
        }
    }

// Getter Setter

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }
}




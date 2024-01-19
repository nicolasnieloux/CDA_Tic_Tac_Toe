import java.util.Random;


/**
 * This class represents an AI player.
 */
public class ArtificialPlayer extends Player {

    /**
     * Constructs an AI player with the specified representation symbol.
     *
     * @param representation Symbol of the player.
     */
    public ArtificialPlayer(String representation) {
        super(representation);
    }

    /**
     * Returns one coordinate of the Artificial Player randomly.
     *
     * @return An integer representing the randomly chosen coordinate.
     */
    public int PlayArtificialPlayer(){
        Random random = new Random();
        return random.nextInt(3);
    }
}

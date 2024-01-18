import java.util.Random;

public class ArtificialPlayer extends Player {
    public ArtificialPlayer(String representation) {
        super(representation);
    }

    public int PlayArtificialPlayer(){
        Random random = new Random();
        return random.nextInt(3);
    }
}

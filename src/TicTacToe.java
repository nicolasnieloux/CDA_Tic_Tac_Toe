/**
 * This class represents TicTacToe game
 * with H vs H, H vs AI or AI vs AI
 */
public class TicTacToe {

    private final int size;
    private Cell[] board;

    private InterractionUser interractionUser = new InterractionUser();
    private View view = new View();

    private Player currentPlayer;
    private int count = 0;
    Player player1;
    Player player2;

    /**
     * Constructs a TicTacToe game with a default size of 3x3.
     */
    public TicTacToe() {
        this.size = 3;
        this.board = new Cell[size * size];
        for (int i = 0; i < size * size; i++) {
            this.board[i] = new Cell();
        }
    }

    /**
     * Return the coordonates if they are corrects
     * @return int[] coordonates
     */
    public int[] getMoveFromPlayer() {
        int[] coordinates = new int[2];
        boolean validMove = false;

        while (!validMove) {
            view.displayCoordonateX();
            int X = interractionUser.getInputUser();
            X = verifyInputUser(X);
            coordinates[0] = X;

            view.displayCoordonateY();
            int Y = interractionUser.getInputUser();
            Y = verifyInputUser(Y);
            coordinates[1] = Y;

            int index = coordinates[0] * size + coordinates[1];

            if (!board[index].isEmpt()) {
                view.displayMessageCellIsNotEmpty();
            } else {
                validMove = true;  // Sortir de la boucle si la case est valide
            }
        }
        return coordinates;
    }

    /**
     * Return the coordonate of the AI if they are
     * @return int[] coordonate
     */
    public int[] getMoveFromArtificialPlayer() {
        int[] coordinates = new int[2];
        boolean validMove = false;

        while (!validMove) {
            coordinates[0] = (int) (Math.random() * 3);
            coordinates[1] = (int) (Math.random() * 3);
            view.getCoordonatesAi(coordinates);
            int index = coordinates[0] * size + coordinates[1];

            if (!board[index].isEmpt()) {
                view.displayMessageCellIsNotEmpty();
            } else {
                validMove = true;  // Sortir de la boucle si la case est valide
            }
        }
        return coordinates;
    }

    /**
     * Verifies and corrects the user input.
     *
     * @param InputUser The user input to be verified.
     * @return Corrected user input.
     */
    public int verifyInputUser(int InputUser) {
        while (InputUser > size - 1 || InputUser < 0) {
            view.displayCorrectXy();
            InputUser = interractionUser.getInputUser();
        }
        return InputUser;
    }

    /**
     * Sets the owner of a cell on the board.
     *
     * @param coordonates The coordinates on the board.
     * @param player      The player to set as the owner.
     */
    public void setOwner(int[] coordonates, Player player) {

        String representationPlayer = player.getRepresentation();
        int index = coordonates[0] * size + coordonates[1];
        board[index].representation = representationPlayer;
        board[index].setEmpt(false);
        count++;
        view.display(size, board);
    }

    /**
     * Checks if the board is full.
     *
     * @return True if the board is full, false otherwise.
     */
    public boolean boardIsFull() {
        return count >= size * size;
    }

    /**
     * Checks if the game is over.
     *
     * @return True if the game is over, false otherwise.
     */
    public boolean isOver() {
        String symbol = player1.getRepresentation();

        for (int i = 0; i < size; i++) {
            // Vérifier l'alignement horizontal
            if (board[i * size].representation.equals(symbol) &&
                    board[i * size + 1].representation.equals(symbol) &&
                    board[i * size + 2].representation.equals(symbol)) {
                return true;
            }

            // Vérifier l'alignement vertical
            if (board[i].representation.equals(symbol) &&
                    board[i + size].representation.equals(symbol) &&
                    board[i + size * 2].representation.equals(symbol)) {
                return true;
            }
        }

        // Vérifier la diagonale de gauche à droite
        if (board[0].representation.equals(symbol) &&
                board[4].representation.equals(symbol) &&
                board[8].representation.equals(symbol)) {
            return true;
        }

        // Vérifier la diagonale de droite à gauche
        if (board[2].representation.equals(symbol) &&
                board[4].representation.equals(symbol) &&
                board[6].representation.equals(symbol)) {
            return true;
        }

        return false;
    }

    /**
     * Initiates a new game based on the user's choice.
     *
     * @param choice The user's choice for the new game.
     */
    public void getNewGame(int choice) {

        if (choice == 0) {
            player1 = new HumanPlayer("X");
            currentPlayer = player1;
            player2 = new HumanPlayer("O");
        }
        if (choice == 1) {

            player1 = new HumanPlayer("X");
            currentPlayer = player1;
            player2 = new ArtificialPlayer("O");
        }
        if (choice == 2) {
            player1 = new ArtificialPlayer("X");
            currentPlayer = player1;
            player2 = new ArtificialPlayer("O");
        }
    }

    /**
     * Initiates and plays the Tic Tac Toe game.
     */
    public void play() {
        view.display(size, board);
        view.chooseNewGame();
        getNewGame(interractionUser.getInputUser());

        do {
            if (!isOver()) {
                if (currentPlayer instanceof HumanPlayer) {
                    int[] coordonates = getMoveFromPlayer();
                    setOwner(coordonates, currentPlayer);
                } else {
                    int[] coordonates = getMoveFromArtificialPlayer();
                    setOwner(coordonates, currentPlayer);
                }
                nextPlayer();

            }

        } while (!boardIsFull() && !isOver());

        if (isOver()) {
            nextPlayer();
            view.getWinner(currentPlayer);
        }

        view.getGameOverMessage();
    }

    /**
     * Switches to the next player.
     */
    public void nextPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

}
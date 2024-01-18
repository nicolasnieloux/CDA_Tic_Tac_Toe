public class TicTacToe {

    private final int size;
    private Cell[] board;

    private InterractionUser interractionUser = new InterractionUser();
    private View view = new View();

    private Player currentPlayer;
    private int count = 0;
    Player player1;
    Player player2;

    // Construct pour 1 joueur humain
    public TicTacToe() {
        this.size = 3;
        this.board = new Cell[size * size];
        for (int i = 0; i < size * size; i++) {
            this.board[i] = new Cell();
        }
    }

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


    public int[] getMoveFromArtificialPlayer() {
        int[] coordinates = new int[2];
        boolean validMove = false;

        while (!validMove) {
            coordinates[0] = (int) (Math.random() * 3);
            coordinates[1] = (int) (Math.random() * 3);
            view.getCoordonatesAi(coordinates);
            int index = coordinates[0] * size + coordinates[1];

            if (!board[index].isEmpt()) {
                view.caseIsNotEmpty();
            } else {
                validMove = true;  // Sortir de la boucle si la case est valide
            }
        }
        return coordinates;
    }

    public int verifyInputUser(int InputUser) {
        while (InputUser > size - 1 || InputUser < 0) {
            view.displayCorrectXy();
            InputUser = interractionUser.getInputUser();
        }
        return InputUser;
    }

    public void setOwner(int[] coordonates, Player player) {

        String representationPlayer = player.getRepresentation();
        int index = coordonates[0] * size + coordonates[1];
        board[index].representation = representationPlayer;
        board[index].setEmpt(false);
        count++;
        view.display(size, board);
    }

    public boolean boardIsFull() {
        return count >= size * size;
    }

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

    public void nextPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

}
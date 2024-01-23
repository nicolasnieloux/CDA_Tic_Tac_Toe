package fr.nicoGames.tictactoe;

/**
 * This class represent all displays
 */
public class View {

    /**
     * Display the Tic Tac Toe board.
     * This method displays the Tic Tac Toe board with the representation symbols
     * of the cells. Each row and column is separated by delimiter lines.
     *
     * @param size  The size of the board (square).
     * @param board The game board constructed with the fr.nicoGames.tictactoe.Cell class.
     * @see Cell#getRepresentation()
     */
    public void display(int size, Cell[] board) {
        for (int i = 0; i < size; i++) {
            System.out.println("-------------");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i * size + j].getRepresentation());
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    /**
     * Displays the options for choosing a new game.
     */
    public void chooseNewGame() {
        System.out.println("Choississez une partie");
        System.out.println("0- Human Vs Human");
        System.out.println("1- Human Vs AI");
        System.out.println("2- AI Vs AI");
    }

    /**
     * Displays the coordinates of the AI player.
     *
     * @param coordonnate Array of the player's coordinates.
     */
    public void getCoordonatesAi(int[] coordonnate) {
        System.out.println("Coordonnée X " + coordonnate[0]);
        System.out.println("Coordonnée Y " + coordonnate[1]);
    }

    /**
     * Displays the winner of the game.
     *
     * @param currentPlayer The winning player.
     */
    public void getWinner(Player currentPlayer){
        System.out.println(" Le vainqueur est : " + currentPlayer.getRepresentation());
    }

    /**
     * Displays a message when the game is over.
     */
    public void getGameOverMessage(){
        System.out.println("GAME OVER");
    }

    /**
     * Displays a message prompting the player to enter the X coordinate.
     */
    public void displayCoordonateX(){
        System.out.println("Veuillez entrer la coordonnée X");
    }

    /**
     * Displays a message prompting the player to enter the Y coordinate.
     */
    public void displayCoordonateY(){
        System.out.println("Veuillez entrer la coordonnée Y");
    }

    /**
     * Displays a message when the cell is not empty.
     */
    public void displayMessageCellIsNotEmpty(){
        System.out.println("La case est déjà prise");
    }

    /**
     * Displays a message when the entered coordinate is not correct.
     */
    public void displayCorrectXy(){
        System.out.println("Veuillez rentrer une coordonnée exacte");
    }
}
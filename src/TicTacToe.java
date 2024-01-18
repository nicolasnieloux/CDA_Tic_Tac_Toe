import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    private int size;
    private Cell[] board;

    private Player currentPlayer;
    private int count = 0;
    Player player = new Player("X");
    Player player2 = new Player("O");

    public TicTacToe() {
        this.currentPlayer = player;
        this.size = 3;
        this.board = new Cell[size * size];
        for (int i = 0; i < size * size; i++) {
            this.board[i] = new Cell();
        }
    }

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.println("-------------");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i * size + j].getRepresentation());
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    public int[] getMoveFromPlayer() {
        int[] coordinates = new int[2];
        boolean validMove = false;

        while (!validMove) {
            System.out.println("Veuillez entrer la coordonnée X");
            int X = getInputUser();
            X = verifyInputUser(X);
            coordinates[0] = X;

            System.out.println("Veuillez entrer la coordonnée Y");
            int Y = getInputUser();
            Y = verifyInputUser(Y);
            coordinates[1] = Y;

            int index = coordinates[0] * size + coordinates[1];

            if (!board[index].isEmpt()) {
                System.out.println("La case est déjà prise");
            } else {
                validMove = true;  // Sortir de la boucle si la case est valide
            }
        }
        return coordinates;
    }


    static int getInputUser() {

        Scanner inputUser = new Scanner(System.in);
        System.out.println("Entrer un chiffre entre 0 et 2");
        if (inputUser.hasNextInt()) {
            return inputUser.nextInt();
        } else {
            System.out.println("Vous avez saisi une chaîne de caractère");
            return getInputUser();
        }
    }

    public int verifyInputUser(int InputUser) {
        while (InputUser > size - 1 || InputUser < 0) {
            System.out.println("Veuillez rentrer une coordonnée exacte");
            InputUser = getInputUser();
        }
        return InputUser;
    }

    public void setOwner(int[] coordonates, Player player) {

        String representationPlayer = player.getRepresentation();
        int index = coordonates[0] * size + coordonates[1];
        board[index].representation = representationPlayer;
        board[index].setEmpt(false);
        count++;
        display();
    }

    public boolean boardIsFull() {
        return count >= size * size;
    }

    public boolean isOver() {
        String symbol = player.getRepresentation();

        for (int i = 0; i < size; i++) {
            // Vérifier l'alignement horizontal
            if (    board[i * size].representation.equals(symbol) &&
                    board[i * size + 1].representation.equals(symbol) &&
                    board[i * size + 2].representation.equals(symbol)) {
                return true;
            }

            // Vérifier l'alignement vertical
            if (    board[i].representation.equals(symbol) &&
                    board[i + size].representation.equals(symbol) &&
                    board[i + size * 2].representation.equals(symbol)) {
                return true;
            }
        }

        // Vérifier la diagonale de gauche à droite
        if (    board[0].representation.equals(symbol) &&
                board[4].representation.equals(symbol) &&
                board[8].representation.equals(symbol)) {
            return true;
        }

        // Vérifier la diagonale de droite à gauche
        if (    board[2].representation.equals(symbol) &&
                board[4].representation.equals(symbol) &&
                board[6].representation.equals(symbol)) {
            return true;
        }

        return false;
    }

    public void play() {
        display();
        do {
            if (!isOver()) {
                int[] coordonates = getMoveFromPlayer();
                setOwner(coordonates, currentPlayer);
                nextPlayer();
            }

        } while (!boardIsFull() && !isOver());

        System.out.println("GAME OVER");

    }

    public void nextPlayer() {
        currentPlayer = (currentPlayer == player) ? player2 : player;
    }
}
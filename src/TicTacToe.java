import java.util.Arrays;

public class TicTacToe {

    int size;
    Cell[] board;

    public TicTacToe() {
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
}
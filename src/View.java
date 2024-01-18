public class View {


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


    public void chooseNewGame() {
        System.out.println("Choississez une partie");
        System.out.println("0- Human Vs Human");
        System.out.println("1- Human Vs AI");
        System.out.println("2- AI Vs AI");
    }

    public void getCoordonatesAi(int[] coordonnate) {
        System.out.println("Coordonnée X " + coordonnate[0]);
        System.out.println("Coordonnée Y " + coordonnate[1]);
    }

    public void caseIsNotEmpty(){
        System.out.println("La case est déjà prise");
    }

    public void getWinner(Player currentPlayer){
        System.out.println(" Le vainqueur est : " + currentPlayer.getRepresentation());
    }

    public void getGameOverMessage(){
        System.out.println("GAME OVER");
    }

    public void displayCoordonateX(){
        System.out.println("Veuillez entrer la coordonnée X");
    }

    public void displayCoordonateY(){
        System.out.println("Veuillez entrer la coordonnée Y");
    }

    public void displayMessageCellIsNotEmpty(){
        System.out.println("La case est déjà prise");
    }

    public void displayCorrectXy(){
        System.out.println("Veuillez rentrer une coordonnée exacte");
    }
}
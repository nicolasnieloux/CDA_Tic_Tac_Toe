package fr.nicoGames.tictactoe;

import java.util.Scanner;

/**
 * This class represents all user interactions.
 */
public class InterractionUser {

    /**
     * Get user input to obtain coordinates between 0 and 2.
     * <p>
     * This method prompts the user to enter a number between 0 and 2.
     * If the user enters a string, it displays a message and prompts
     * the user again until a valid number is entered.
     *
     * @return The user's input as an integer between 0 and 2.
     */
    public int getInputUser() {
        Scanner inputUser = new Scanner(System.in);
        System.out.println("Entrer un chiffre entre 0 et 2");

        if (inputUser.hasNextInt()) {
            int num = inputUser.nextInt();
            if (num >= 0 && num <= 2) {
                return num;
            } else {
                System.out.println("Le chiffre doit être entre 0 et 2. Réessayez :");
                return getInputUser();
            }
        } else {
            System.out.println("Vous avez saisi une chaîne de caractère");
            inputUser.next();
            return getInputUser();
        }
    }
}


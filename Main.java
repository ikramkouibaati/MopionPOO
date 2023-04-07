package MopionPOO;
import java.util.Scanner;

import Plateau;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        System.out.println("********************************************");
        System.out.println("*            MORPION BY IKRAM              *");
        System.out.println("********************************************");

        // Demande le nombre de cases pour le plateau
        System.out.println("Bienvenue sur le jeu du Morpion.");
        System.out.println("Entrez le nombre de cases pour le plateau : ");
        int nbCases = input.nextInt();

        Plateau plateau = new Plateau(nbCases);
        boolean placeDispo = false;
        int ligne = 0;
        int colonne = 0;
        int J = 1;
        System.out.println(plateau);

        while (plateau.gagne() == 0) {
            // Les coordonnées de la case jouée 
            System.out.println("Entrez la ligne: ");
            ligne = input.nextInt();
            System.out.println("Entrez la colonne: ");
            colonne = input.nextInt();

            do {
                // Test pour savoir si une case est occupée.
                if (plateau.getCase(ligne, colonne).GetX() == 0) {
                    placeDispo = true;
                } else {
                    System.out.println("Case déjà jouée. Réessayez");
                    System.out.println("Entrez la ligne: ");
                    ligne = input.nextInt();
                    System.out.println("Entrez la colonne: ");
                    colonne = input.nextInt();

                }
            } while (!placeDispo);

            if (placeDispo) {
                plateau.getCase(ligne, colonne).SetX(J);
            }

            System.out.println(plateau);

            // Passer d'un joueur à un autre.
            if (J == 1) {
                J = 2;
            } else {
                J = 1;
            }

            System.out.println("Joueur suivant:");

        }

        if (plateau.gagne() == 1) {
            System.out.println("Le joueur 1 a gagné !");
        } else if (plateau.gagne() == 2) {
            System.out.println("Le joueur 2 a gagné !");
        } else {
            System.out.println("Match nul !");
        }
    }
}
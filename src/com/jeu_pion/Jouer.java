package com.jeu_pion;

import java.util.Scanner;

public class Jouer {

    /**
     * Le main est le moteur de Jeu qui permet de choisir à quel jeu les joueurs peuvent jouer,
     * de définir les joueurs (Prénom, caractère choisi) et la taille du plateau
     * @param args
     */
    public static void main(String[] args) {

        int choixJeu;
        int nbrJoueur;
        Jeu jeu = null;
        String caractere;
        String prenom;
        String str;
        int replay;
        Scanner scanner = new Scanner(System.in);

        String [] listeJeux = {
                "Morpion",
                "Puissance 4",
        };

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        do {

            do {
                for (int i = 0; i < listeJeux.length; i++) {
                    System.out.println((i + 1) + " - " + listeJeux[i]);
                }
                System.out.println("Veuillez saisir le numéro du jeu auquel vous voulez jouer :");
                choixJeu = scanner.nextInt();
                scanner.nextLine();
            } while ((choixJeu > listeJeux.length) || (choixJeu <= 0));

            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            switch (choixJeu) {
                case 1:
                    jeu = new Morpion();
                    break;
                case 2:
                    jeu = new Puissance4();
                    break;
                default:
                    break;
            }

            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            do {
                System.out.println("Veuillez saisir le nombre de joueur qui vont jouer :");
                nbrJoueur = scanner.nextInt();
                scanner.nextLine();
            } while (nbrJoueur <= 0);

            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            jeu.listeJoueurs = new Joueur[nbrJoueur];

            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            for (int i = 0; i < jeu.listeJoueurs.length; i++) {
                System.out.println("Veuillez saisir le prénom du joueur " + (i + 1));
                prenom = scanner.nextLine();

                System.out.println("Veuillez saisir le caractère du joueur " + (i + 1));
                caractere = scanner.nextLine();

                jeu.listeJoueurs[i] = new Joueur(prenom, caractere);
            }

            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            System.out.println("Vous allez jouer au " + listeJeux[choixJeu - 1] + " avec " + jeu.listeJoueurs.length + " joueurs. Les joueurs sont :");
            for (int i = 0; i < jeu.listeJoueurs.length; i++) {
                System.out.print(jeu.listeJoueurs[i].getPrenom() + " (" + jeu.listeJoueurs[i].getCaractere() + ")" + "\n");
            }

            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//        for (int i = 0; i < jeu.listeJoueurs.length ; i++)
//        {
//            jeu.jouer(jeu.listeJoueurs[i]);
//            if ((i % (jeu.listeJoueurs.length - 1)) == 0) { i}
//        }
//

            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            do {
                System.out.println("Voulez-vous rejouter à un jeu ? (0 = Non / 1 = Oui)");
                replay = scanner.nextInt();
                scanner.nextLine();
            } while((replay != 0) && (replay != 1));
        } while (replay == 1);
    }
}

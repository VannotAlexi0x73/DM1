package com.jeu_pion;

import java.util.ArrayList;
import java.util.Scanner;

public class Jouer {

    /**
     * Le main est le moteur de Jeu qui permet de choisir à quel jeu l'utilisateur peut jouer,
     * de définir les joueurs (Prénom, caractère choisi) et la taille du plateau
     * Il doit être agrémenté par les futurs jeux, notamment pour la liste des jeux -> String [] listeJeux
     * et pour la création du jeu -> switch (choixJeu) l.52
     */
    public static void main (String[] args) {

        Jeu jeu = null;

        int choixJeu;
        int nbrJoueur;
        int replay;

        ArrayList listCaractere;

        String caractere;
        String prenom;
        String str;
        // A compléter avec le nom des futurs jeux possible
        String [] listeJeux = {
                "Morpion",
                "Puissance 4",
        };

        Scanner scanner = new Scanner(System.in);

        do {

            // Choix du jeu auquel l'utilissateur souhaite jouer
            do {
                str = "";
                for (int i = 0; i < listeJeux.length; i++)
                {
                    str += String.format("%d - %s%n", i+1, listeJeux[i]);
                }
                str += String.format("Veuillez saisir le numéro du jeu auquel vous voulez jouer :%n");
                Jeu.affichable.affichageElement(str);
                choixJeu = scanner.nextInt();
                scanner.nextLine();
            } while ((choixJeu > listeJeux.length) || (choixJeu <= 0));


            // Création du jeu en fonction du choix de l'utilisateur, on ne commence pas à zéro
            // car on affiche le premier jeu comme étant le jeu 1
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


            // Demande du nombre de joueurs qui vont jouer au jeu
            do {
                Jeu.affichable.affichageElement("Veuillez saisir le nombre de joueur qui vont jouer :\n");
                nbrJoueur = scanner.nextInt();
                scanner.nextLine();
            } while (nbrJoueur <= 0);


            // Création de la liste des joueurs et de la liste des caractère
            // des joueurs pour vérifier si un caractère n'est pas présent 2 fois
            jeu.listeJoueurs = new Joueur[nbrJoueur];
            listCaractere = new ArrayList(nbrJoueur);


            // Création des joueurs en demandant Prénom / Caractère
            for (int i = 0; i < jeu.listeJoueurs.length; i++) {
                str = String.format("Veuillez saisir le prénom du joueur %d%n", i + 1);
                Jeu.affichable.affichageElement(str);
                prenom = scanner.nextLine();

                do {
                    str = String.format("Veuillez saisir le caractère du joueur %d%n", i + 1);
                    Jeu.affichable.affichageElement(str);
                    caractere = scanner.nextLine();
                } while (listCaractere.contains(caractere)); // Vérification que les caractères ne sont pas présents 2 fois
                listCaractere.add(caractere); // On ajoute le caractère à la liste des caractères des joueurs
                jeu.listeJoueurs[i] = new Joueur(prenom, caractere);
            }

            // Récupitulation des informations du jeu
            str = String.format("Vous allez jouer au %s avec %d joueurs. Les joueurs sont :%n", listeJeux[choixJeu - 1], jeu.listeJoueurs.length);
            for (int i = 0; i < jeu.listeJoueurs.length; i++) {
                str += String.format("%s (%s)%n",jeu.listeJoueurs[i].getPrenom(), jeu.listeJoueurs[i].getCaractere());
            }
            Jeu.affichable.affichageElement(str);

//            // Moteur de jeu
//        for (int i = 0; i < jeu.listeJoueurs.length ; i++)
//        {
//            jeu.jouer(jeu.listeJoueurs[i]);
//            if ((i % (jeu.listeJoueurs.length - 1)) == 0) { i}
//        }

            // Boucle pour demander si l'utilisateur veut rejouer à un jeu et si le résultat est correct
            do {
                Jeu.affichable.affichageElement("Voulez-vous rejouter à un jeu ? (0 = Non / 1 = Oui)");
                replay = scanner.nextInt();
                scanner.nextLine();
            } while((replay != 0) && (replay != 1));

        } while (replay == 1);
    }
}

package com.jeu_pion;

import java.util.Scanner;

abstract class Jeu {

	protected Plateau plateau;
	protected Joueur [] listeJoueurs;
	protected Affichable affichable = new AffichageConsole();

	abstract void jouer (Joueur joueur);
	abstract void gestionPosition ();
	abstract int verification (Joueur joueur);

	public static void main(String[] args) {

		int nbrJoueur;
		int choixJeu;

		Jeu jeu;

		String caractere;
		String prenom;
		Scanner scanner = new Scanner(System.in);

		String [] listeJeux = {
			"Morpion",
			"Puissance 4",
		};

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		do {
			System.out.println("Veuillez saisir le nombre de joueur qui vont jouer :");
			nbrJoueur = scanner.nextInt();
			scanner.nextLine();
		} while (nbrJoueur <= 0);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		listeJoueurs = new Joueur[nbrJoueur];

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		for (int i = 0; i < nbrJoueur; i++)
		{
			System.out.println("Veuillez saisir le prénom du joueur " + (i + 1));
			prenom = scanner.nextLine();

			System.out.println("Veuillez saisir le caractère du joueur " + (i + 1));
			caractere = scanner.nextLine();

			listeJoueurs[i] = new Joueur(prenom, caractere);
		}
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		do {
			for (int i = 0; i < listeJeux.length ; i++)
			{
				System.out.println((i+1) + " - " +listeJeux[i]);
			}
			System.out.println("Veuillez saisir le numéro du jeu auquel vous voulez jouer :");
			choixJeu = scanner.nextInt();
			scanner.nextLine();
		} while ((choixJeu > listeJeux.length) || (choixJeu <= 0));

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		switch(choixJeu) {
			case 1:
				jeu = new Morpion();
				break;
			case 2:
				jeu = new Puissance4();
				break;
			default:
				// default code block
				break;
		}

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		for (int i = 0; i < listeJoueurs.length; i++)
		{
			listeJoueurs[i]
		}

	}
}

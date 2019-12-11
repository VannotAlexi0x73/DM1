package com.jeu_pion;

import java.util.Scanner;

abstract class Jeu {

	protected Plateau plateau;
	protected Scanner scanner = new Scanner(System.in);
	protected Joueur [] listeJoueurs;
	protected static Affichable affichable = new AffichageConsole();

	abstract void initialisation ();
	abstract void jouer (Joueur joueur);
	abstract int verification (Joueur joueur);
}

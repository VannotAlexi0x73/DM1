package com.jeu_pion;

abstract class Jeu {

	protected Plateau plateau;
	protected Joueur [] listeJoueurs;
	protected static Affichable affichable = new AffichageConsole();

	abstract void jouer (Joueur joueur);
	abstract void gestionPosition ();
	abstract int verification (Joueur joueur);
}
